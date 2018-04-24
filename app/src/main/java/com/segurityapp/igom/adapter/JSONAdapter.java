package com.segurityapp.igom.adapter;

import com.google.gson.Gson;
import com.segurityapp.igom.entity.Entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Response;

public class JSONAdapter {

    private Response response;
    private Entity entity;
    private String type;
    private Gson gson;

    public JSONAdapter(Response response, Entity entity, String type) {
        this.response = response;
        this.entity = entity;
        this.type = type;
        this.gson = new Gson();
    }

    public Entity parseToEntityObject() throws IOException {
        if (this.type.equals("object")) {
            return this.toObject();
        }
        return null;
    }

    private Entity toObject() throws IOException {

        Entity e = null;

        try {

            String json = this.response.body().string();

            if (json != null) {

                JSONObject obj = new JSONObject(json);

                if (obj.get("data") != null) {
                    e = this.gson.fromJson(obj.get("data").toString(), this.entity.getClass());
                } else {
                    e = this.gson.fromJson(obj.toString(), this.entity.getClass());
                }
            }


        } catch (JSONException exception) {
            //TODO IMPLEMENTAR
        }

        return e;
    }
}
