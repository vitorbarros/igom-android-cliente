package com.segurityapp.igom.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.segurityapp.igom.db.contract.ClientContract;

public class ClientDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "clientDB";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ClientContract.ClientEntry.TABLE_NAME + " (" +
                    ClientContract.ClientEntry.COLUMN_NAME_ID + " TEXT_TYPE PRIMARY KEY," +
                    ClientContract.ClientEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    ClientContract.ClientEntry.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    ClientContract.ClientEntry.COLUMN_NAME_USERNAME + TEXT_TYPE + COMMA_SEP +
                    ClientContract.ClientEntry.COLUMN_NAME_PASSWORD + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ClientContract.ClientEntry.TABLE_NAME;


    public ClientDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
