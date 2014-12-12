package com.learning.lion.recycler.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.learning.lion.recycler.ArticlesManager;
import com.learning.lion.recycler.R;
import com.learning.lion.recycler.model.Article;

public class AddArticle extends Fragment implements View.OnClickListener {

    private final String WRONG = "The article can not be saved";
    private final String OK = "The article was saved";
    private Toast toastMensaje;
    private ArticlesManager articlesManager;
    private EditText etTitle;
    private EditText etContent;
    private EditText etAuthor;
    private Button btnAdd;

    public AddArticle() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_article, container, false);
        if (view != null) {
            etTitle = (EditText) view.findViewById(R.id.etTitle);
            etContent = (EditText) view.findViewById(R.id.etContent);
            etAuthor = (EditText) view.findViewById(R.id.etAuthor);

            btnAdd = (Button) view.findViewById(R.id.btnAdd);
            btnAdd.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.articlesManager = (ArticlesManager) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        Article article = new Article();

        article.setTitle(etTitle.getText().toString());
        article.setText(etContent.getText().toString());
        article.setAutor(etAuthor.getText().toString());

        boolean result = this.articlesManager.insertArticle(article);

        if (toastMensaje != null) {
            toastMensaje.cancel();
        }

        if (result) {
            toastMensaje = Toast.makeText(articlesManager, OK, Toast.LENGTH_LONG);
        } else {
            toastMensaje = Toast.makeText(articlesManager, WRONG, Toast.LENGTH_LONG);
        }
        toastMensaje.show();
    }
}
