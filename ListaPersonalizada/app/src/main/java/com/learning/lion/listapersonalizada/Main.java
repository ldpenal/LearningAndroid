package com.learning.lion.listapersonalizada;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.learning.lion.listapersonalizada.utileria.Contacto;
import com.learning.lion.listapersonalizada.utileria.MyAdapter;

import java.util.LinkedList;


public class Main extends ActionBarActivity {

    private LinkedList<Contacto> contactList;
    private ListView elementsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarElementosGraficos();
        cargarLista();
        alimentarLista();
    }

    public void cargarLista() {
        contactList = new LinkedList<Contacto>();

        contactList.add(new Contacto("León Darío Peña Londoño", 3128204422l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Juan David Agudelo", 3147992263l, R.drawable.ic_launcher));
        contactList.add(new Contacto("James Cardona", 3006735230l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Mauricio Henao", 3218743438l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Hernán Dario Vanegas", 3128655843l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Sebastian Pino Sanchez", 3135713686l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Jose Aldemar Londoño", 3148330437l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Oscar Ovidio Peña Herrera", 3133031457l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Alba Ruby Peña Londoño", 3215591784l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Bertha Ligia Londoño Rios", 3116306250l, R.drawable.ic_launcher));
        contactList.add(new Contacto("Victor Tobón", 3148961001l, R.drawable.ic_launcher));
    }

    public void cargarElementosGraficos() {
        elementsList = (ListView) findViewById(R.id.contactListView);
    }

    public void alimentarLista() {
        MyAdapter adapter = new MyAdapter(getApplicationContext(), contactList);
        elementsList.setAdapter(adapter);
    }
}
