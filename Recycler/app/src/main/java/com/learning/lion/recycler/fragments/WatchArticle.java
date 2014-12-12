package com.learning.lion.recycler.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learning.lion.recycler.ArticlesManager;
import com.learning.lion.recycler.R;
import com.learning.lion.recycler.adapters.MyAdapter;
import com.learning.lion.recycler.callbacks.RemoveCallback;
import com.learning.lion.recycler.database.DataBase;
import com.learning.lion.recycler.database.DataBaseHelper;
import com.learning.lion.recycler.model.Article;

import java.util.ArrayList;

public class WatchArticle extends Fragment implements RemoveCallback {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Article> articles;
    private ArticlesManager articlesManager;

    public WatchArticle() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.watch_article, container, false);
        if (view != null) {
            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
            mRecyclerView.setHasFixedSize(true);

            mLayoutManager = new LinearLayoutManager(view.getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);

            loadData();
            mAdapter = new MyAdapter(articles, this);
            mRecyclerView.setAdapter(mAdapter);
        }
        return view;
    }

    public void loadData() {
        DataBaseHelper helper = new DataBaseHelper(articlesManager, DataBase.DATABASE_NAME, null, DataBase.VERSION);
        articles = helper.getArticles();
        mAdapter.notifyDataSetChanged();
        helper.close();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        articlesManager = (ArticlesManager) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void removeItem(String title) {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(articlesManager, DataBase.DATABASE_NAME, null, DataBase.VERSION);
        dataBaseHelper.deleteArticle(title);
        loadData();
    }
}
