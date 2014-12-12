package com.learning.lion.recycler.model;

/**
 * Created by lion on 11/26/14.
 */
public class Article {

    private String title;
    private String text;
    private String autor;

    public Article() {
    }

    public Article(String title, String text, String autor) {
        setTitle(title);
        setText(text);
        setAutor(autor);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
