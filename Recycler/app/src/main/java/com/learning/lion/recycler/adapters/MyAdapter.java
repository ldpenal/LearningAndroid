package com.learning.lion.recycler.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.lion.recycler.ArticlesManager;
import com.learning.lion.recycler.R;
import com.learning.lion.recycler.fragments.WatchArticle;
import com.learning.lion.recycler.model.Article;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Article> articles;
    private WatchArticle context;

    public MyAdapter(ArrayList<Article> articles, WatchArticle context) {
        setArticles(articles);
        this.context = (WatchArticle) context;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.getTvTitle().setText(getArticles().get(i).getTitle());
        viewHolder.getTvText().setText(getArticles().get(i).getText());
        viewHolder.getTvAuthor().setText(getArticles().get(i).getAutor());
    }

    @Override
    public int getItemCount() {
        return getArticles().size();
    }
}