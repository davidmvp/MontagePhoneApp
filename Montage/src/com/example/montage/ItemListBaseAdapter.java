package com.example.montage;

import java.util.ArrayList;

import com.example.montage.R;

import edu.jhu.cs.oose.montage.model.iface.media.Media;
import edu.jhu.cs.oose.montage.model.iface.media.Photo;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemListBaseAdapter extends BaseAdapter {
	private static ArrayList<Media> itemDetailsrrayList;
	
	private Integer[] imgid = {
			R.drawable.p1,
			R.drawable.bb2,
			R.drawable.p2,
			R.drawable.bb5,
			R.drawable.bb6,
			R.drawable.d1,
			R.drawable.p1,
			R.drawable.bb2
			};
	
	private LayoutInflater l_Inflater;

	public ItemListBaseAdapter(Context context, ArrayList<Media> results) {
		itemDetailsrrayList = results;
		l_Inflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return itemDetailsrrayList.size();
	}

	public Object getItem(int position) {
		return itemDetailsrrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = l_Inflater.inflate(R.layout.item_details_view, null);
			holder = new ViewHolder();
			//holder.txt_itemName = (TextView) convertView.findViewById(R.id.name);
			//holder.txt_itemDescription = (TextView) convertView.findViewById(R.id.itemDescription);
			//holder.txt_itemPrice = (TextView) convertView.findViewById(R.id.price);
			holder.itemText = (TextView) convertView.findViewById(R.id.text);
			holder.itemImage = (ImageView) convertView.findViewById(R.id.photo);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		//holder.txt_itemName.setText(itemDetailsrrayList.get(position).getName());
		//holder.txt_itemDescription.setText(itemDetailsrrayList.get(position).getItemDescription());
		//holder.txt_itemPrice.setText(itemDetailsrrayList.get(position).getPrice());
		//holder.itemImage.setImageResource(imgid[itemDetailsrrayList.get(position).getImageNumber() - 1]);
		
		/*
		int resourceID = getResources().getIdentifier(item, "drawable", context.getPackageName());
		System.out.println("adapter resource id: " + resourceID);

		holder.text.setText(item);
		holder.photo.setImageResource(resourceID);
		*/
		//if (itemDetailsrrayList.get(position) instanceof Bitmap) {
		if (itemDetailsrrayList.get(position).toString().equals("photo")) {
			byte[] bitmapdata = ((Photo) itemDetailsrrayList.get(position)).getPhoto();
			Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata , 0, bitmapdata.length);
			holder.itemImage.setImageBitmap(bitmap);
		} else {
			holder.itemText.setTextSize(40);
			holder.itemText.setText(itemDetailsrrayList.get(position).toString());
		}
		//holder.itemImage.setImageResource(R.drawable.bb1);
		return convertView;
	}

	static class ViewHolder {
		TextView itemText;
		//TextView txt_itemDescription;
		//TextView txt_itemPrice;
		ImageView itemImage;
	}
}
