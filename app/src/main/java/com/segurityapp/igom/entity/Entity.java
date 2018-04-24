package com.segurityapp.igom.entity;

import com.segurityapp.igom.config.Config;

import okhttp3.MediaType;

public class Entity {

    protected String endPoint = "/api/V1/";

    protected String baseURI = Config.baseApiURI;

    protected static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public String getEndPoint() {
        return endPoint;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public static MediaType getJSON() {
        return JSON;
    }
}
