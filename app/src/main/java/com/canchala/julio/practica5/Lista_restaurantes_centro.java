package com.canchala.julio.practica5;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista_restaurantes_centro extends ListFragment {

	private String[] restaurantes = {"360 Bistró","Café de Alejandría","California Burrito",};
	private String[] info = {"Carrera 43A No.1-50 Local 360\n57(4) 326 21 30\nCocina Internacional",
			"Carrera 36 No.2Sur-60\n57(4) 318 20 00\nClásica e Internacional",
			"Carrera 43A No.6Sur-15 Local 2370\n57(4) 352 64 47\nComida Tex Mex",};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.layout_listarespoblado, container, false);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(getActivity(),info[position],Toast.LENGTH_LONG).show();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, restaurantes));
	}
}
