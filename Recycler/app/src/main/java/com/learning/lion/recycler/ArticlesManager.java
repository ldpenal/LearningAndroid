package com.learning.lion.recycler;

// Android imports;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.learning.lion.recycler.callbacks.InsertCallback;
import com.learning.lion.recycler.callbacks.RemoveCallback;
import com.learning.lion.recycler.database.DataBase;
import com.learning.lion.recycler.database.DataBaseHelper;
import com.learning.lion.recycler.fragments.AddArticle;
import com.learning.lion.recycler.fragments.WatchArticle;
import com.learning.lion.recycler.model.Article;


public class ArticlesManager extends Activity implements InsertCallback {

    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new AddArticle();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.itAdd) {
            fragment = new AddArticle();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
        if(id==R.id.itView) {
            fragment = new WatchArticle();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean insertArticle(Article article) {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, DataBase.DATABASE_NAME, null, DataBase.VERSION);
        return dataBaseHelper.addArticle(article.getTitle(), article.getText(), article.getAutor());
    }
}