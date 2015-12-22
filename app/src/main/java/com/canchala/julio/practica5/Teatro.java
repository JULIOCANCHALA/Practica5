package com.canchala.julio.practica5;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Teatro extends ListFragment implements AdapterView.OnItemClickListener {

    String[] nombre;
    String[] tipo;
    String[] ubicacion;
    String[] telefono;
    String[] latitud;
    String[] longitud;
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

        nombre = getResources().getStringArray(R.array.teatro);
        tipo = getResources().getStringArray(R.array.tipoteatro);
        ubicacion = getResources().getStringArray(R.array.direccionteatro);
        telefono = getResources().getStringArray(R.array.telefonoteatro);
        latitud = getResources().getStringArray(R.array.lat_teatro);
        longitud = getResources().getStringArray(R.array.lon_teatro);
        menuIcons = getResources().obtainTypedArray(R.array.iconsteatro);

        rowItems = new ArrayList<RowItem>();

        for (int i = 0; i < nombre.length; i++) {
            RowItem items = new RowItem(nombre[i],tipo[i],ubicacion[i],telefono[i],menuIcons.getResourceId(i, -1));
            rowItems.add(items);
        }

        adapter = new CustomAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), nombre[position], Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(getContext(),MapsActivity.class);

        intent.putExtra("lat",latitud[position]);
        intent.putExtra("lon",longitud[position]);
        intent.putExtra("nombre",nombre[position]);

        startActivity(intent);
    }

}