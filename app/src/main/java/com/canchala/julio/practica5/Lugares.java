package com.canchala.julio.practica5;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Lugares extends ListFragment implements OnItemClickListener {

    String[] nombre;
    String[] info;
    String[] ubicacion;
    String[] telefono;
    String[] latitud;
    String[] longitud;
    TypedArray menuIcons;
    TypedArray menuIcons2;


    CustomAdapter2 adapter2;
    private List<RowItem2> rowItems2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        nombre = getResources().getStringArray(R.array.lugar);
        info = getResources().getStringArray(R.array.infolugar);
        ubicacion = getResources().getStringArray(R.array.direccionlugar);
        telefono = getResources().getStringArray(R.array.telefonolugar);
        latitud = getResources().getStringArray(R.array.lat_lugar);
        longitud = getResources().getStringArray(R.array.lon_lugar);
        menuIcons = getResources().obtainTypedArray(R.array.iconslugar);
        menuIcons2 = getResources().obtainTypedArray(R.array.iconslugart);

        rowItems2 = new ArrayList<RowItem2>();

        for (int i = 0; i < nombre.length; i++) {
            RowItem2 items = new RowItem2(nombre[i],info[i],ubicacion[i],telefono[i],menuIcons.getResourceId(i, -1),menuIcons2.getResourceId(i, -1));
            rowItems2.add(items);
        }

        adapter2 = new CustomAdapter2(getActivity(), rowItems2);
        setListAdapter(adapter2);
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
