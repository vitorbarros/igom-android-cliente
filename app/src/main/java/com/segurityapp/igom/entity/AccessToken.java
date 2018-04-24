package com.segurityapp.igom.entity;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class AccessToken extends Entity{

    @SerializedName("_id")
    private String _id;

    @SerializedName("userId")
    private String userId;

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("refreshToken")
    private String refreshToken;

    @SerializedName("accessTokenExpireAt")
    private String accessTokenExpireAt;

    @SerializedName("refreshTokenExpireAt")
    private String refreshTokenExpireAt;

    @SerializedName("updatedAt")
    private String updatedAt;

    @SerializedName("createdAt")
    private String createdAt;


    public String toJson()
    {
        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("_id", this._id);
            jsonObject.put("accessToken", this.accessToken);
            jsonObject.put("userId", this.userId);
            jsonObject.put("refreshToken", this.refreshToken);
            jsonObject.put("accessTokenExpireAt", this.accessTokenExpireAt);
            jsonObject.put("refreshTokenExpireAt", this.refreshTokenExpireAt);
            jsonObject.put("updatedAt", this.updatedAt);
            jsonObject.put("createdAt", this.createdAt);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessTokenExpireAt() {
        return accessTokenExpireAt;
    }

    public void setAccessTokenExpireAt(String accessTokenExpireAt) {
        this.accessTokenExpireAt = accessTokenExpireAt;
    }

    public String getRefreshTokenExpireAt() {
        return refreshTokenExpireAt;
    }

    public void setRefreshTokenExpireAt(String refreshTokenExpireAt) {
        this.refreshTokenExpireAt = refreshTokenExpireAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
