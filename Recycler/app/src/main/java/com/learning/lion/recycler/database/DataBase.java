package com.learning.lion.recycler.database;

/**
 * Created by lion on 11/28/14.
 */
public class DataBase {

    public static final String DATABASE_NAME = "ArticlesManager.db";
    public static final String TABLE_NAME = "technology";
    public static final String KEYS[] = {"date", "title", "content", "autor"};

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEYS[0] +
            " TEXT NOT NULL, " + KEYS[1] + " TEXT NOT NULL, " + KEYS[2] + " TEXT NOT NULL, " +
            KEYS[3] + " TEXT NOT NULL);";

    public static final int VERSION = 1;
}
