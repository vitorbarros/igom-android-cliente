package com.segurityapp.igom.entity.repository;

import android.support.annotation.NonNull;

import com.segurityapp.igom.adapter.HttpClientAdapter;
import com.segurityapp.igom.adapter.JSONAdapter;
import com.segurityapp.igom.config.Config;
import com.segurityapp.igom.entity.AccessToken;
import com.segurityapp.igom.entity.Client;
import com.segurityapp.igom.entity.Entity;
import com.segurityapp.igom.entity.OAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OAuthRepository extends AbstractRepository<OAuth>{

    public boolean login(String username, String password) throws JSONException {

        //this.verifyAccessToken();

//        JSONObject jsonObject = new JSONObject();
//
//        jsonObject.put("username", username);
//        jsonObject.put("password", password);
//        jsonObject.put("type", "clients");
//
//        HttpClientAdapter httpClientAdapter = new HttpClientAdapter(
//                OAuth.getJSON(),
//                jsonObject.toString(),
//                Config.baseApiURI,
//                "/api/V1/people/login",
//                "POST"
//
//        );
//
//        httpClientAdapter.getHttp()
//                .newCall(httpClientAdapter.getAdapter())
//                .enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                //TODO implementar
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//
//                JSONAdapter jsonAdapter = new JSONAdapter(response, new Client(), "object");
//                Client client = (Client) jsonAdapter.parseToEntityObject();
//
//                System.out.println(client);
//
//            }
//        });

        return true;
    }

    @Override
    public void store(CallbackHandler<OAuth> callbackHandler, Entity entity) {

    }

    @Override
    public void findAll(CallbackHandler<OAuth> callbackHandler) {

    }

    @Override
    public void find(CallbackHandler<OAuth> callbackHandler) {

    }

    @Override
    public void update(CallbackHandler<OAuth> callbackHandler, Entity entity) {

    }

    @Override
    public void error() {

    }

    @Override
    public void single(Entity result) {

    }

    @Override
    public void multiple(List result) {

    }
}
