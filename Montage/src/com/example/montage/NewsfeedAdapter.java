package com.example.montage;

import java.util.ArrayList;
import android.app.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

public class NewsfeedAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private static ArrayList<Media> newsfeed;

	  public NewsfeedAdapter(Context context, ArrayList<Media> newsfeed) {
	    super(context, R.layout.item_details_view);
	    this.context = context;
	    this.newsfeed = newsfeed;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_details_view, null);
			holder = new ViewHolder();
	    //View rowView = inflater.inflate(R.layout.item_details_view, parent, false);
	    //TextView textView = (TextView) rowView.findViewById(R.id.text);
	    //ImageView imageView = (ImageView) rowView.findViewById(R.id.photo);
		holder.text = (TextView) convertView.findViewById(R.id.text);
		holder.photo = (ImageView) convertView.findViewById(R.id.photo);
			convertView.setTag(holder);
		System.out.println("finished convert view");
		} else {
			holder = (ViewHolder) convertView.getTag();
			System.out.println("finished convert view2");

		}
		
		String item = newsfeed.get(position).toString();
		
		if (item!=null) {
			int resourceID = context.getResources().getIdentifier(item, "drawable", context.getPackageName());
			System.out.println("adapter resource id: " + resourceID);

			holder.text.setText(item);
			holder.photo.setImageResource(resourceID);
			System.out.println("set the item in the listview");
		}

		/*
		if (newsfeed.get(position).equals(getClass())) {
		    holder.text.setText(newsfeed.get(position).toString());
		}
		*/
		/*
	    newsfeed.get(position);
	    holder.text.setText(newsfeed.get(position).toString());
	    // change the icon for Windows and iPhone
	    String s = newsfeed.get(position).toString();
	    if (s.startsWith("iPhone")) {
	      holder.photo.setImageResource(R.drawable.p1);
	    } else {
	      holder.photo.setImageResource(R.drawable.p2);
	    }
		 */
	    return convertView;
	    
	  }
	  
		static class ViewHolder {
			TextView text;
			ImageView photo;
		}
}
