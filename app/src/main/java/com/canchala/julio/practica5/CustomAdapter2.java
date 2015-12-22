package com.canchala.julio.practica5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter2 extends BaseAdapter {

	Context context;
	List<RowItem2> rowItem2;

	public CustomAdapter2(Context context, List<RowItem2> rowItem2) {
		this.context = context;
		this.rowItem2 = rowItem2;
	}

	@Override
	public int getCount() {

		return rowItem2.size();
	}

	@Override
	public Object getItem(int position) {

		return rowItem2.get(position);
	}

	@Override
	public long getItemId(int position) {

		return rowItem2.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.list_item2, null);
		}

		TextView txt1 = (TextView) convertView.findViewById(R.id.ltext1);
		TextView txt2 = (TextView) convertView.findViewById(R.id.ltext2);
		TextView txt3 = (TextView) convertView.findViewById(R.id.ltext3);
		TextView txt4 = (TextView) convertView.findViewById(R.id.ltext4);
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.licon);
		ImageView imgIcon2 = (ImageView) convertView.findViewById(R.id.licon2);

		RowItem2 row_pos = rowItem2.get(position);
		// setting the image resource and title

		txt1.setText(row_pos.getText1());
		txt2.setText(row_pos.getText2());
		txt3.setText(row_pos.getText3());
		txt4.setText(row_pos.getText4());
		imgIcon.setImageResource(row_pos.getIcon());
		imgIcon2.setImageResource(row_pos.getIcon2());



		return convertView;

	}

}
