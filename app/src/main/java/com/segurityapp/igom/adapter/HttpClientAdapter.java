package com.segurityapp.igom.adapter;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpClientAdapter {

    private OkHttpClient http;
    private RequestBody requestBody;
    private String baseURI;
    private String endPoint;
    private String method;
    private String authorization;

    public HttpClientAdapter(MediaType mediaType, String json, String baseURI, String endPoint, String method, String authorization) {
        if (this.http == null) {
            this.http = new OkHttpClient();
        }

        if (this.requestBody == null) {
            this.requestBody = RequestBody.create(mediaType, json);
        }

        this.baseURI = baseURI;
        this.endPoint = endPoint;
        this.method = method;
        this.authorization = authorization;
    }

    public Request getAdapter() {

        switch (this.method) {
            case "POST":

                if (this.authorization != null) {
                    return new Request
                            .Builder()
                            .addHeader("Content-type", "application/json")
                            .addHeader("Authorization", "Bearer " + this.authorization)
                            .url(this.baseURI + this.endPoint)
                            .post(this.requestBody)
                            .build();
                } else {
                    return new Request
                            .Builder()
                            .addHeader("Content-type", "application/json")
                            .url(this.baseURI + this.endPoint)
                            .post(this.requestBody)
                            .build();
                }

            case "GET":
                //TODO IMPLEMENTAR
                break;
            case "PUT":
                //TODO IMPLEMENTAR
                break;
            case "DELETE":
                //TODO IMPLEMENTAR
                break;
        }
        return null;
    }

    public OkHttpClient getHttp() {
        return this.http;
    }
}
