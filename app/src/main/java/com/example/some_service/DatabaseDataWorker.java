package com.example.some_service;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    //Constructor
    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertSampleMemories() {
        insertMemory("first_day","First day at the Beach", "Went Fishing, Surfing and skiing  was a lot of fun i met with a lot of cool dudes");
        insertMemory("second_day","Second day at the Uni", "Went studying and learning about Android Programming with Intents");
        insertMemory("third_day","third day at the cafeteria", "We had the best burritos ever");
        insertMemory("fourth_day","fourth day at the movies", "Jacob proposed to her");
    }


    private void insertMemory(String memoryId, String memoryTitle, String memoryText) {
        ContentValues values = new ContentValues();
        values.put(DbContractClass.MemoriesEntry.COLUMN_MEMORY_TITLE, memoryId);
        values.put(DbContractClass.MemoriesEntry.COLUMN_MEMORY_DETAILS, memoryTitle);
        values.put(DbContractClass.MemoriesEntry.COLUMN_MEMORY_DETAILS, memoryText);

        long newRowId = mDb.insert(DbContractClass.MemoriesEntry.TABLE_NAME, null, values);
    }

}
