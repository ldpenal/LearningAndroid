package com.learning.lion.trabajoconlistas.lists;

/**
 * Created by lion on 11/19/14.
 */
public class Model {
    
    private int icon;
    private String text;
    private String counter;

    public Model(int icon, String text, String counter) {
        super();
        this.icon = icon;
        this.text = text;
        this.counter = counter;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }
}
