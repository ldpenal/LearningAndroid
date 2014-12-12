package com.learning.lion.callbacks;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import callbacks.CallBacks;
import fragments.Fragmento1;
import fragments.Fragmento2;
import fragments.Fragmento3;

// Mis elementos importados.

public class MyActivity extends Activity implements CallBacks {

    private int direccion;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        fragmentManager = getFragmentManager();

        fragment = new Fragmento1();
        fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void makeOperations(int posicion) {
        direccion = posicion;

        if (posicion == 1) {
            fragment = new Fragmento2();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (posicion == 2) {
            fragment = new Fragmento3();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }

//        if (posicion == 0) {
//            getFragmentManager().beginTransaction().replace(R.id.container, new Fragmento1()).commit();
//        }
//        if (posicion == 1) {
//            getFragmentManager().beginTransaction().replace(R.id.container, new Fragmento2()).commit();
//            //Toast.makeText(getApplicationContext(), "Se presiono hacia 2", Toast.LENGTH_LONG).show();
//        }
//        if (posicion == 2) {
//            //Toast.makeText(getApplicationContext(), "Se presiono hacia 3", Toast.LENGTH_LONG).show();
//            getFragmentManager().beginTransaction().replace(R.id.container, new Fragmento3()).commit();
//        }
    }

    @Override
    public void onBackPressed() {
        if(!(fragment instanceof Fragmento1)){
            fragment = new Fragmento1();
            fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();
        } else {
            finish();
        }
    }
}