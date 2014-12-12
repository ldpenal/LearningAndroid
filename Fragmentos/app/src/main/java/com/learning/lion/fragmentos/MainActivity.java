package com.learning.lion.fragmentos;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements  MyFirstFragment.CallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();

        // Fragment 1
        MyFirstFragment myFirstFragment = new MyFirstFragment();
        manager.beginTransaction().add(R.id.container1, myFirstFragment).commit();

        // Fragment 2
        MySecondFragment mySecondFragment = new MySecondFragment();
        manager.beginTransaction().add(R.id.container2, mySecondFragment).commit();

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            UtilidadPantalla utilidadPantalla = new UtilidadPantalla(this);
            Log.w("-----leonplondon-----", utilidadPantalla.getDpAlto() + " -- " + utilidadPantalla.getDpAncho());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemSeleccionado(Adapter ada) {
        Bundle bundle = ada.toBundle();
        Intent newIntent = new Intent(this, UtilidadPantalla.class);
        newIntent.putExtra("name", bundle);
    }
}
