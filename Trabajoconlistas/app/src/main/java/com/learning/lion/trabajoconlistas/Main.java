package com.learning.lion.trabajoconlistas;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.learning.lion.trabajoconlistas.lists.Item;
import com.learning.lion.trabajoconlistas.lists.Model;
import com.learning.lion.trabajoconlistas.lists.MyAdapter;
import com.learning.lion.trabajoconlistas.lists.MyAdapter2;

import java.util.ArrayList;
import java.util.Stack;

public class Main extends Activity {

    private String listItems[] = {"Item 1", "Item 2", "Item 3", "Item 4 "};
    private ListView listView;
    private Stack<Model> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    public void initComponents() {
        generateElements();

        listView = (ListView) findViewById(R.id.listView2);

        MyAdapter2 adapter2 = new MyAdapter2(this, elements);
        listView.setAdapter(adapter2);
    }

    public void generateElements() {
        elements = new Stack<Model>();
        elements.push(new Model(R.drawable.ic_action_edit, "Element 1", "1"));
        elements.push(new Model(R.drawable.ic_action_overflow, "Element 2", "2"));
        elements.push(new Model(R.drawable.ic_action_search, "Element 3", "3"));

        /*
        elements = new ArrayList<Item>();

        elements.add(new Item("Titulo 1", "Contenido 1"));
        elements.add(new Item("Titulo 2", "Contenido 2"));
        elements.add(new Item("Titulo 3", "Contenido 3"));
        elements.add(new Item("Titulo 4", "Contenido 4"));
        elements.add(new Item("Titulo 5", "Contenido 5"));
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
