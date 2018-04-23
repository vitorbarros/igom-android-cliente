package com.segurityapp.igom.entity.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.segurityapp.igom.MyApp;
import com.segurityapp.igom.adapter.HttpClientAdapter;
import com.segurityapp.igom.adapter.JSONAdapter;
import com.segurityapp.igom.db.contract.AccessTokenContract;
import com.segurityapp.igom.db.helper.AccessTokenDbHelper;
import com.segurityapp.igom.entity.AccessToken;
import com.segurityapp.igom.entity.OAuth;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class AbstractRepository<T> implements RepositoryInterface<T>, RepositoryInterface.CallbackHandler{

    protected void verifyAccessToken(final CallbackHandler<AbstractRepository> callbackHandler)
    {
        OAuth oauth = new OAuth();
        HttpClientAdapter adapter = new HttpClientAdapter(
                OAuth.getJSON(),
                oauth.toJson(),
                oauth.getBaseURI(),
                oauth.getEndPoint(),
                "POST"
        );

        adapter.getHttp().newCall(adapter.getAdapter()).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //TODO implementar
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                AccessToken accessToken = new AccessToken();

                //verificando se a ultima token armazenada na base de dados ainda esta valida
                AccessTokenDbHelper accessTokenDbHelper = new AccessTokenDbHelper(MyApp.getAppContext());
                SQLiteDatabase readable = accessTokenDbHelper.getReadableDatabase();

                String[] projection = {
                        AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ID,
                        AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN,
                        AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN_EXPIRE_AT
                };

                Cursor c = readable.query(
                        AccessTokenContract.AccessTokenEntry.TABLE_NAME,
                        projection,
                        null,
                        null,
                        null,
                        null,
                        null
                );

                c.moveToLast();

                String id = c.getString(c.getColumnIndex(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ID));
                String accessTokenStr = c.getString(c.getColumnIndex(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN));
                String expiresAt = c.getString(c.getColumnIndex(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN_EXPIRE_AT));

                if(id != null && accessTokenStr != null && expiresAt != null){

                    accessToken.set_id(id);
                    accessToken.setAccessToken(accessTokenStr);
                    accessToken.setAccessTokenExpireAt(expiresAt);

                    try {

                        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
                        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
                        String localStringDate = new SimpleDateFormat(dateFormat).format(new Date());

                        Date dt = format.parse(accessToken.getAccessTokenExpireAt().replace(".000Z",""));
                        Date localDate = format.parse(localStringDate);

                        //verificando se a token ainda e valida

                        if(localDate.after(dt)){

                            //buscando os dados da token na API
                            JSONAdapter jsonAdapter = new JSONAdapter(response, new AccessToken(), "object");
                            accessToken = (AccessToken) jsonAdapter.parseToEntityObject();

                            //Armazenando a token na base de dados
                            SQLiteDatabase db = accessTokenDbHelper.getWritableDatabase();

                            ContentValues values = new ContentValues();
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ID,accessToken.get_id());
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_USER_ID,accessToken.getUserId());
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN,accessToken.getAccessToken());
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_REFRESH_TOKEN,accessToken.getRefreshToken());
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN_EXPIRE_AT,accessToken.getAccessTokenExpireAt());
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_REFRESH_TOKEN_EXPIRE_AT,accessToken.getRefreshTokenExpireAt());
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_UPDATED_AT,accessToken.getUpdatedAt());
                            values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_CREATED_AT,accessToken.getCreatedAt());

                            db.insert(AccessTokenContract.AccessTokenEntry.TABLE_NAME, null, values);

                            //populando a variavel da classe abstrata com a token valida
                            callbackHandler.single(accessToken);
                        }

                        callbackHandler.single(accessToken);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                //buscando os dados da token na API
                JSONAdapter jsonAdapter = new JSONAdapter(response, new AccessToken(), "object");
                accessToken = (AccessToken) jsonAdapter.parseToEntityObject();

                //Armazenando a token na base de dados
                SQLiteDatabase db = accessTokenDbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ID,accessToken.get_id());
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_USER_ID,accessToken.getUserId());
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN,accessToken.getAccessToken());
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_REFRESH_TOKEN,accessToken.getRefreshToken());
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_ACCESS_TOKEN_EXPIRE_AT,accessToken.getAccessTokenExpireAt());
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_REFRESH_TOKEN_EXPIRE_AT,accessToken.getRefreshTokenExpireAt());
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_UPDATED_AT,accessToken.getUpdatedAt());
                values.put(AccessTokenContract.AccessTokenEntry.COLUMN_NAME_CREATED_AT,accessToken.getCreatedAt());

                db.insert(AccessTokenContract.AccessTokenEntry.TABLE_NAME, null, values);

                callbackHandler.single(accessToken);
            }
        });
    }

}
