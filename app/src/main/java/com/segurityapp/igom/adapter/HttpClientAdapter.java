package com.segurityapp.igom.adapter;

import com.segurityapp.igom.entity.repository.AbstractRepository;

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
    private String headers;

    public HttpClientAdapter(MediaType mediaType, String json, String baseURI, String endPoint, String method)
    {
        if(this.http == null){
            this.http = new OkHttpClient();
        }

        if(this.requestBody == null){
            this.requestBody = RequestBody.create(mediaType, json);
        }

        this.baseURI = baseURI;
        this.endPoint = endPoint;
        this.method = method;
    }

    public Request getAdapter(){

        switch (this.method){
            case "POST" :

                return new Request
                        .Builder()
                        .addHeader("Content-type", "application/json")
                        .url(this.baseURI + this.endPoint)
                        .post(this.requestBody)
                        .build();

            case "GET" :
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
