package com.learning.lion.listapersonalizada.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.learning.lion.listapersonalizada.R;

import java.util.LinkedList;

/**
 * Created by lion on 11/21/14.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "informacion";
    public static final String TABLE_NAME = "contactos";
    private final String CREATE_TABLE = "create table if not exists " + TABLE_NAME +
            "(fullname varchar(200), telephone integer);";

    private final String fullname = "fullname";
    private final String telephone = "telephone";

    public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
    }

    public void addContact(Contacto contact) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(fullname, contact.getFullName());
        values.put(telephone, contact.getTelephoneNumber());

        database.insert(TABLE_NAME, null, values);
        database.close();
    }

    public Contacto getContact(long telephone) {
        Contacto contacto;

        SQLiteDatabase database = this.getReadableDatabase();
        /*
        Orden de los parametros:
        Nombre de la tabla;
        Columnas a consultar;
        Campo de busqueda;
        Group by;
        Having;
        Order by;
        Limit;
         */
        Cursor cursor = database.query(TABLE_NAME, new String[]{fullname, this.telephone},
                this.telephone + " = " + String.valueOf(telephone), null, null, null, null);

        if(cursor != null) {
            cursor.moveToFirst();
        }

        contacto = new Contacto(cursor.getString(0), cursor.getLong(1));
        return contacto;
    }

    public LinkedList<Contacto> getContactos() {
        LinkedList<Contacto> elements = new LinkedList<Contacto>();

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from " + TABLE_NAME, null);
        if(cursor.moveToFirst()) {
            do {
                elements.add(new Contacto(cursor.getString(0), cursor.getLong(1), R.drawable.contacts));
            } while (cursor.moveToNext());
        }

        return elements;
    }
}
