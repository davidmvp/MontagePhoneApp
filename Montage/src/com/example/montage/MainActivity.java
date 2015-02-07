package com.example.montage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import edu.jhu.cs.oose.montage.client.kryonet.ClientThread;
import edu.jhu.cs.oose.montage.client.kryonet.KryoClient;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.model.iface.media.Media;
import edu.jhu.cs.oose.montage.model.impl.CoordinatesImpl;
import edu.jhu.cs.oose.montage.model.impl.NewsfeedImpl;
import edu.jhu.cs.oose.montage.model.impl.UninitializedFieldException;
import edu.jhu.cs.oose.montage.model.impl.media.PhotoImpl;
import edu.jhu.cs.oose.montage.model.impl.media.TextPostImpl;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	
	// upload text button variables
	private Button uploadTextButton;
	private Button refreshButton;
	private EditText TextInput;
	private String uploadText;
	
	private boolean running = false;
	
	// upload image button variables
	private static final int SELECTED_PICTURE=1;
	
	// camera button variables
	private Button camera;
	
	// server variables
    private KryoClient myClient;
    
    private GPSTracker g;
    
    //private Newsfeed currentNewsfeedImpl = new NewsfeedImpl();
    
    private ItemListBaseAdapter adapter;
    private ArrayList<Media> currentFeed;
    private Newsfeed currentFeedImpl = new NewsfeedImpl(0);
    
    private Media m;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        g = new GPSTracker(MainActivity.this);
        
        setContentView(R.layout.main);

        setUpServer();
        
        myClient.getUser().setCoordinates(
    			new CoordinatesImpl(g.getLatitude(), g.getLongitude()));
		currentFeed = new ArrayList<Media>();
		boolean nfReceived = false;
		
		while (!nfReceived) {
			try {
				currentFeed = (ArrayList<Media>) myClient.getUser().getNewsfeed().getCurrentNewsFeed();
				nfReceived = true;
			} catch (UninitializedFieldException u) {
				//System.out.println("Uninitialized field");
			} catch (NullPointerException n) {
				//System.out.println("Client is not connected");
			}
		}
		
		currentFeedImpl.clear();
		
		for (Media m : currentFeed) {
			currentFeedImpl.addToNewsfeed(m);
		}
		currentFeed = (ArrayList<Media>) currentFeedImpl.getCurrentNewsFeed();
       
        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        
        adapter = new ItemListBaseAdapter(this, currentFeed);
        lv1.setAdapter(adapter); 
        
        lv1.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
        		Object o = lv1.getItemAtPosition(position);
        		m = (Media) o;
        		
            	// go into the detailed view activity
        		Intent intent = new Intent(MainActivity.this, DetailedViewActivity.class);
        		
        		//put the toString of the post into key helloDetail
        		intent.putExtra("helloDetail", o.toString());
        		
        		//put the number of likes into 'liked'
        		intent.putExtra("liked", m.getUserUpVotes().size());
        		
        		//put the number of dislikes into 'disliked'
        		intent.putExtra("disliked", m.getUserDownVotes().size());

        		startActivity(intent);
        		
        		
        		/*Bundle b = getIntent().getExtras();

        		boolean hitLike = b.getBoolean("likedBoolean");

        		boolean hitDislike = b.getBoolean("dislikedBoolean");
        		if (hitLike) {
        			m.addToUpVotes(myClient.getUser());
        		}
        		
        		if (hitDislike) {
        			m.addToDownVotes(myClient.getUser());
        		}
        		
        		String comment = b.getString("comments");
        		//todo
        		
        		myClient.updateMedia(m);
        		*/
        	}  
        });
        
        // button for the camera
        camera = (Button) findViewById(R.id.button1);
        camera.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        		startActivity(intent);
			}
		});
        
        // text upload button
        uploadTextButton = (Button) findViewById(R.id.uploadTextButton);
        TextInput = (EditText)findViewById(R.id.uploadTextBox);
        uploadTextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				uploadText = TextInput.getText().toString();
				TextInput.setText("");
				Media textPost = new TextPostImpl(uploadText, myClient.getUser().getCoordinates());
				
				myClient.storeMedia(textPost);
			}
		});
        
        // refresh button
        refreshButton = (Button) findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				myClient.askForNewsfeed();
				myClient.getUser().setNewsfeed(null);
				boolean receivedNewsfeed = false;
				
				while (! receivedNewsfeed) {
				
					try {
						
						currentFeed = (ArrayList<Media>) myClient.getUser().getNewsfeed().getCurrentNewsFeed();
						receivedNewsfeed = true;
					} catch (UninitializedFieldException u) {
					}
				}
				
				currentFeedImpl.clear();
				
				for (Media m : currentFeed) {
					currentFeedImpl.addToNewsfeed(m);
				}
				
				adapter.notifyDataSetChanged();

			}
		});
    }

	private void setUpServer() {
		if (!running) {
			// connect to server
			try {
				myClient = new KryoClient("10.188.167.150");
				ClientThread thread = new ClientThread();
		        thread.start();
		        running = true;
			} catch (IOException e) {
	    		Intent intent = new Intent(MainActivity.this, ErrorViewActivity.class);
	    		startActivity(intent);
				e.printStackTrace();
				running = false;
			}
		}
	}
    
    // onClick method for upload image button
    public void btnClick(View v) {
    	Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

    	startActivityForResult(i, SELECTED_PICTURE);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	
    	switch(requestCode) {
    	case SELECTED_PICTURE:
    		if (resultCode == RESULT_OK) {
    			Uri uri = data.getData();
    			String[] projection = {MediaStore.Images.Media.DATA};
    			Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
    			cursor.moveToFirst();
    			int columnIndex = cursor.getColumnIndex(projection[0]);
    			String filePath = cursor.getString(columnIndex);
    			cursor.close();
    			Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
    			ByteArrayOutputStream stream = new ByteArrayOutputStream();
    			yourSelectedImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
    	        
    	        byte[] photoByteArray = stream.toByteArray();
    			Media photoMedia = new PhotoImpl(myClient.getUser().getCoordinates(), photoByteArray);
    	        myClient.storeMedia(photoMedia);
    		}
    	}
    }
    
}