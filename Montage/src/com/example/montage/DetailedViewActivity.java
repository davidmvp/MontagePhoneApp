package com.example.montage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import edu.jhu.cs.oose.montage.model.iface.media.Photo;

public class DetailedViewActivity extends Activity{
	
	//Like Button Variables
    private Button LikeButton;
    private int LikeCounter;
    private TextView LikeDisplay;
    private boolean ButtonStart = true;
    
	//Dislike Button Variables
    private Button DislikeButton;
    private int DislikeCounter;
    private TextView DislikeDisplay;
    
    private boolean userLiked = false;
    private boolean userDisliked = false;
    
    //Post Button Variables
    private Button PostButton;
    private String comment = "";
    private TextView CommentDisplay;
    private EditText CommentInput;
	
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	System.out.println("GOT TO BEGINNING");
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_detailed_view);
	        // get the details when you click on an item
	        Bundle bundle = getIntent().getExtras();
	        String test = bundle.getString("helloDetail");
    		final Intent intent = new Intent(DetailedViewActivity.this, MainActivity.class);


	        TextView t = (TextView)findViewById(R.id.textView1);
	        if (test!=null) {

	        	t.setTextSize(30);
	        	//t.setText("Detailed view");
	        	t.setText(test);
	        	
	        }

	        //ItemDetails itemDetails = bundle.getParcelable("helloDetail");
	        
	        //Like Button Counter
	        LikeButton = (Button)findViewById(R.id.button1);
	        LikeDisplay = (TextView)findViewById(R.id.textView2);
	        LikeCounter = 0;
	        int liked = bundle.getInt("liked");
	        LikeCounter = liked;
	        
	        
	        LikeButton.setOnClickListener(new View.OnClickListener ()
	        {
	        	@Override
	        	public void onClick(View v)
	        	{
	        		userLiked = true;
	        		userDisliked = false;
		        	if(ButtonStart == true) {
		        		LikeCounter++;
			        	LikeDisplay.setText("Like Count:" + LikeCounter);
			        	LikeButton.setEnabled(false);
			        	ButtonStart = false;
		        	} else if(ButtonStart == false) {
		        		LikeCounter++;
		        		DislikeCounter--;
			        	LikeDisplay.setText("Like Count:" + LikeCounter);
			        	DislikeDisplay.setText("Dislike Count:" + DislikeCounter);
			        	LikeButton.setEnabled(false);
			        	DislikeButton.setEnabled(true);
		        	}
	        	}
	        });
	        
	        //Dislike Button Counter
	        DislikeButton = (Button)findViewById(R.id.DislikeButton);
	        DislikeDisplay = (TextView)findViewById(R.id.DislikeCountView);
	        DislikeCounter = 0;
	        int disliked = bundle.getInt("disliked");
	        DislikeCounter = disliked;
	        
	        DislikeButton.setOnClickListener(new View.OnClickListener ()
	        {
	        	@Override
	        	public void onClick(View v)
	        	{
		        	userDisliked = true;
		        	userLiked = false;
		        	if(ButtonStart == true) {
			        	DislikeCounter++;
			        	DislikeDisplay.setText("Dislike Count:" + DislikeCounter);
			        	DislikeButton.setEnabled(false);
			        	ButtonStart = false;
		        	} else if(ButtonStart == false) {
			        	DislikeCounter++;
			        	LikeCounter--;
			        	DislikeDisplay.setText("Dislike Count:" + DislikeCounter);
			        	LikeDisplay.setText("Like Count:" + LikeCounter);
			        	DislikeButton.setEnabled(false);
			        	LikeButton.setEnabled(true);
		        	}
	        	}
	        });
	        
        	intent.putExtra("likedBoolean", userLiked);
        	intent.putExtra("dislikedBoolean", userDisliked);

        	intent.putExtra("resume", "true");
        	
	        //Post Button
	        PostButton = (Button)findViewById(R.id.button2);
	        CommentDisplay = (TextView)findViewById(R.id.textView3);
	        CommentInput = (EditText)findViewById(R.id.editText2);
	        PostButton.setOnClickListener(new View.OnClickListener ()
	        {
	        	@Override
	        	public void onClick(View v)
	        	{
	        		CommentDisplay.setTextSize(25);
	        		comment = CommentInput.getText().toString()+"\n"+comment;
	        		CommentDisplay.setText("Comment:\n" + comment);
	        		CommentInput.setText("");
	        	}
	        });
	    }
	    
	    /*
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_detailed_view, menu);
	        return true;
	    }
	    */
	}

