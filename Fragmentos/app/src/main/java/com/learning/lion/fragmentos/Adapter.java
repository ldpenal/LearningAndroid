package com.learning.lion.fragmentos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lion on 11/12/14.
 */
public class Adapter extends ArrayAdapter<String> {

    Context context;
    String datos[];

    public Adapter(Context context, String datos[]) {
        super(context, R.layout.items, datos);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenemos el inflador.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        // Inflamos la vista con la que usaremos el adapter.
        View vista = inflater.inflate(R.layout.items, null);

        ImageView imageView =  (ImageView) vista.findViewById(R.id.icon);
        TextView textView = (TextView) vista.findViewById(R.id.nameText);

        imageView.setImageResource(R.drawable.ic_whats_hot);
        textView.setText(datos[position]);


        return vista;
    }

    public Bundle toBundle() {
        Bundle nuevo = new Bundle();
        nuevo.putString("name", "cating");
        return nuevo;
    }
}
