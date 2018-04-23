package com.segurityapp.igom.db.contract;

import android.provider.BaseColumns;

public class AccessTokenContract {

    private AccessTokenContract() {}

    public static class AccessTokenEntry implements BaseColumns {

        public static final String TABLE_NAME = "accessToken";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_USER_ID = "userId";
        public static final String COLUMN_NAME_ACCESS_TOKEN = "accessToken";
        public static final String COLUMN_NAME_REFRESH_TOKEN = "refreshToken";
        public static final String COLUMN_NAME_ACCESS_TOKEN_EXPIRE_AT = "accessTokenExpireAt";
        public static final String COLUMN_NAME_REFRESH_TOKEN_EXPIRE_AT = "refreshTokenExpireAt";
        public static final String COLUMN_NAME_UPDATED_AT = "updatedAt";
        public static final String COLUMN_NAME_CREATED_AT = "createdAt";

    }
}
