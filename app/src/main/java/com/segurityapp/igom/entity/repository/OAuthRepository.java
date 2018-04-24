package com.segurityapp.igom.entity.repository;
import com.segurityapp.igom.entity.Entity;

public class OAuthRepository extends AbstractRepository {

    public OAuthRepository() {
        this.verifyAccessToken();
    }

    public String getAccessToken() {
        return this.ACCESS_TOKEN;
    }

    @Override
    public void store(CallbackHandler callbackHandler, Entity entity) {

    }

    @Override
    public void findAll(CallbackHandler callbackHandler) {

    }

    @Override
    public void find(CallbackHandler callbackHandler) {

    }

    @Override
    public void update(CallbackHandler callbackHandler, Entity entity) {

    }
}
