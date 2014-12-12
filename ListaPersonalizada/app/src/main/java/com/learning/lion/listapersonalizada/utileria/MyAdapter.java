package com.learning.lion.listapersonalizada.utileria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.learning.lion.listapersonalizada.R;

import java.util.LinkedList;

/**
 * Created by lion on 11/19/14.
 */
public class MyAdapter extends BaseAdapter implements View.OnClickListener {

    private LinkedList<Contacto> elementos;
    private Context contexto;
    private LayoutInflater inflater;
    private int pos;

    public MyAdapter(Context contexto, LinkedList<Contacto> elementos) {
        this.contexto = contexto;
        this.elementos = elementos;
        this.inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        pos = i;
        View myView;
        ViewHolder holder;

        if(view == null) {
            myView = inflater.inflate(R.layout.list_item, viewGroup, false);
            holder = new ViewHolder();
            holder.fullName = (TextView) myView.findViewById(R.id.fullNameText);
            holder.telephoneNumber = (TextView) myView.findViewById(R.id.telephoneText);
            holder.picture = (ImageView) myView.findViewById(R.id.picture);
            holder.button = (Button) myView.findViewById(R.id.buttonAction);
            holder.button.setOnClickListener(this);
            myView.setTag(holder);
        } else {
            myView = view;
            holder = (ViewHolder) myView.getTag();
        }

        Contacto contacto = elementos.get(i);
        holder.fullName.setText(contacto.getFullName());
        holder.telephoneNumber.setText(Long.toString(contacto.getTelephoneNumber()));
        holder.picture.setImageResource(R.drawable.ic_launcher);

        return myView;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(contexto.getApplicationContext(), "POS: " + ((Contacto)this.getItem(this.pos)).getFullName(), Toast.LENGTH_LONG).show();
    }
}
