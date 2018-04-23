package com.segurityapp.igom.entity;

import com.google.gson.annotations.SerializedName;
import com.segurityapp.igom.config.Config;

import org.json.JSONException;
import org.json.JSONObject;

public class OAuth extends Entity{

    @SerializedName("username")
    private String username = Config.username;

    @SerializedName("password")
    private String password = Config.password;

    @SerializedName("secret")
    private String secret = Config.secret;

    @SerializedName("appId")
    private String appId = Config.appId;

    @SerializedName("grantType")
    private String grantType = Config.grantType;

    public OAuth()
    {
        this.endPoint = "/api/V1/oauth2/oauth/access_token";
    }

    public String toJson()
    {
        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("username", this.username);
            jsonObject.put("password", this.password);
            jsonObject.put("secret", this.secret);
            jsonObject.put("appId", this.appId);
            jsonObject.put("grantType", this.grantType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }
}
