package com.canchala.julio.practica5;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Comida extends ListFragment implements OnItemClickListener {

	String[] nombre;
	String[] tipo;
	String[] ubicacion;
	String[] telefono;

	TypedArray menuIcons;

	CustomAdapter adapter;
	private List<RowItem> rowItems;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.list_fragment, null, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

		nombre = getResources().getStringArray(R.array.restaurantes);
		tipo = getResources().getStringArray(R.array.tiporestaurantes);
		ubicacion = getResources().getStringArray(R.array.direccionrestaurantes);
		telefono = getResources().getStringArray(R.array.telefonorestaurantes);
		menuIcons = getResources().obtainTypedArray(R.array.icons);

		rowItems = new ArrayList<RowItem>();

		for (int i = 0; i < nombre.length; i++) {
			RowItem items = new RowItem(nombre[i],tipo[i],ubicacion[i],telefono[i], menuIcons.getResourceId(i, -1));

			rowItems.add(items);
		}

		adapter = new CustomAdapter(getActivity(), rowItems);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Toast.makeText(getActivity(), nombre[position], Toast.LENGTH_SHORT)
				.show();

	}

}
