package com.example.some_service;

import android.provider.BaseColumns;

public final class DbContractClass {
    private DbContractClass() {}

    public static final class MemoriesEntry implements BaseColumns {
        public static final String TABLE_NAME = "memories_text";
        public static final String COLUMN_MEMORY_TITLE = "memory_title";
        public static final String COLUMN_MEMORY_DETAILS = "memory_details";

        //create table index.
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_MEMORY_TITLE + ")";

        //Create table statement
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_MEMORY_TITLE + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_MEMORY_DETAILS + " TEXT NOT NULL)";
    }
}
