package com.learning.lion.trabajoconlistas.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import com.learning.lion.trabajoconlistas.R;

/**
 * Created by lion on 11/19/14.
 */
public class MyAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Item> elements;

    public MyAdapter(Context context, ArrayList<Item> elements) {
        super(context, R.layout.my_item, elements);

        this.context = context;
        this.elements = elements;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.my_item, parent, false);

        TextView title = (TextView) rowView.findViewById(R.id.titulo);
        TextView content = (TextView) rowView.findViewById(R.id.contenido);

        title.setText(elements.get(position).getTitulo());
        content.setText(elements.get(position).getContenido());

        return rowView;
    }
}
