package com.canchala.julio.practica5;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	Context context;
	List<RowItem> rowItem;

	CustomAdapter(Context context, List<RowItem> rowItem) {
		this.context = context;
		this.rowItem = rowItem;

	}

	@Override
	public int getCount() {

		return rowItem.size();
	}

	@Override
	public Object getItem(int position) {

		return rowItem.get(position);
	}

	@Override
	public long getItemId(int position) {

		return rowItem.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.list_item, null);
		}

		TextView txt1 = (TextView) convertView.findViewById(R.id.text1);
		TextView txt2 = (TextView) convertView.findViewById(R.id.text2);
		TextView txt3 = (TextView) convertView.findViewById(R.id.text3);
		TextView txt4 = (TextView) convertView.findViewById(R.id.text4);
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);

		RowItem row_pos = rowItem.get(position);
		// setting the image resource and title

		txt1.setText(row_pos.getText1());
		txt2.setText(row_pos.getText2());
		txt3.setText(row_pos.getText3());
		txt4.setText(row_pos.getText4());
		imgIcon.setImageResource(row_pos.getIcon());


		return convertView;

	}

}
