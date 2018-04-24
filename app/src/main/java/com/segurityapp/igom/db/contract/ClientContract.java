package com.segurityapp.igom.db.contract;

import android.provider.BaseColumns;

public class ClientContract {

    private ClientContract() {
    }

    public static class ClientEntry implements BaseColumns {

        public static final String TABLE_NAME = "client";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_CREDIT_CARD = "creditCard";
        public static final String COLUMN_NAME_ADDRESS = "address";
    }
}
