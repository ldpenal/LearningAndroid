package com.learning.lion.trabajoconlistas.lists;

/**
 * Created by lion on 11/19/14.
 */
public class Item {
    private String titulo;
    private String contenido;

    public Item(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getContenido() {
        return this.contenido;
    }

    public String getTitulo() {
        return this.titulo;
    }
}
