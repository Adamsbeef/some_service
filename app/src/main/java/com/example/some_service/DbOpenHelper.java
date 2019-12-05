package com.example.some_service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.some_service.DbContractClass.*;

public class DbOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Memories.db";
    public static final int DATABASE_VERSION = 2;

    public DbOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MemoriesEntry.SQL_CREATE_TABLE);
        sqLiteDatabase.execSQL(MemoriesEntry.SQL_CREATE_INDEX1);
        DatabaseDataWorker dataWorker = new DatabaseDataWorker(sqLiteDatabase);
        dataWorker.insertSampleMemories();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(oldVersion < 2) {
            //create index on the subsequent versions of the database..
            sqLiteDatabase.execSQL(MemoriesEntry.SQL_CREATE_INDEX1);
        }

    }
}
