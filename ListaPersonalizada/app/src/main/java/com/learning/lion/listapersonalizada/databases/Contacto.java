package com.learning.lion.listapersonalizada.databases;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by lion on 11/19/14.
 */
public class Contacto {
    private String fullName;
    private long telephoneNumber;
    private int picture;

    public Contacto(String fullName, long telephoneNumber, int picture) {
        setFullName(fullName);
        setTelephoneNumber(telephoneNumber);
        setPicture(picture);
    }

    public Contacto(String fullName, long telephoneNumber) {
        setFullName(fullName);
        setTelephoneNumber(telephoneNumber);
        setPicture(0);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getFullName() {
        return this.fullName;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public int getPicture() {
        return this.picture;
    }

    public void mostrarContacto(Context context) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage("Name: " + this.getFullName());
        dialog.show();
    }
}
