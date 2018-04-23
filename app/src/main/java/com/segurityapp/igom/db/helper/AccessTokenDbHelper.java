package com.segurityapp.igom.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.segurityapp.igom.db.contract.AccessTokenContract;

public class AccessTokenDbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "IGOM.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AccessTokenContract.AccessTokenEntry.TABLE_NAME + " (" +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ID + " TEXT_TYPE PRIMARY KEY," +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_USER_ID + TEXT_TYPE + COMMA_SEP +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN + TEXT_TYPE + COMMA_SEP +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_REFRESH_TOKEN + TEXT_TYPE + COMMA_SEP +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN_EXPIRE_AT + TEXT_TYPE + COMMA_SEP +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_REFRESH_TOKEN_EXPIRE_AT + TEXT_TYPE + COMMA_SEP +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_UPDATED_AT + TEXT_TYPE + COMMA_SEP +
                    AccessTokenContract.AccessTokenEntry.COLUMN_NAME_CREATED_AT + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AccessTokenContract.AccessTokenEntry.TABLE_NAME;

    public AccessTokenDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onUpgrade(sqLiteDatabase, i, i1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
