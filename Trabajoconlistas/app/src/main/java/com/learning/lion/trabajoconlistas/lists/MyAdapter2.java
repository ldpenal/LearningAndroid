package com.learning.lion.trabajoconlistas.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.lion.trabajoconlistas.R;

import java.util.Stack;

/**
 * Created by lion on 11/19/14.
 */
public class MyAdapter2 extends BaseAdapter {

    private Stack<Model> elements;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter2(Context context, Stack<Model> elements) {
        this.context = context;
        this.elements = elements;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.elements.size();
    }

    @Override
    public Object getItem(int i) {
        return elements.peek();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mView;
        ViewHolder holder;

        if(view == null) {
            mView = (View) inflater.inflate(R.layout.my_item_two, viewGroup, false);
            holder = new ViewHolder();
            holder.imagen = (ImageView) mView.findViewById(R.id.imageView2);
            holder.title = (TextView) mView.findViewById(R.id.text);
            holder.counter = (TextView) mView.findViewById(R.id.counter);

            // Le asignamos el ViewHolder;
            mView.setTag(holder);
        } else {
            mView = view;
            holder = (ViewHolder) mView.getTag();
        }

        Model element = elements.pop();
        holder.imagen.setImageResource(element.getIcon());
        holder.title.setText(element.getText());
        holder.counter.setText(element.getCounter());
        return mView;
    }
}