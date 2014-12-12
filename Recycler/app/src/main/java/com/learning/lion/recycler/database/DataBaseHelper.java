package com.learning.lion.recycler.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.learning.lion.recycler.model.Article;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lion on 11/28/14.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBase.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
    }

    public boolean addArticle(String title, String content, String autor) {
        SQLiteDatabase database = this.getWritableDatabase();
        Date fecha = new Date();

        ContentValues values = new ContentValues();
        values.put(DataBase.KEYS[0], fecha.getDay() + "-" + fecha.getMonth() + "-" + fecha.getYear());
        values.put(DataBase.KEYS[1], title);
        values.put(DataBase.KEYS[2], content);
        values.put(DataBase.KEYS[3], autor);

        long result = database.insert(DataBase.TABLE_NAME, null, values);

        if (result != -1) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Article> getArticles() {
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<Article> elements = new ArrayList<Article>();

        Cursor cursor = database.rawQuery("select * from " + DataBase.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Article article = new Article();
                article.setTitle(cursor.getString(1));
                article.setText(cursor.getString(2));
                elements.add(article);
            } while (cursor.moveToNext());
        }
        return elements;
    }

    public boolean deleteArticle(String title) {
        SQLiteDatabase database = this.getWritableDatabase();

        database.execSQL("delete from " + DataBase.TABLE_NAME + " where " + DataBase.KEYS[1]  + "='" + title+ "'");

        return true;
    }
}
