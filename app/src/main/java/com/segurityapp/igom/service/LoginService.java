package com.segurityapp.igom.service;

import com.segurityapp.igom.entity.em.EntityManager;
import com.segurityapp.igom.entity.repository.OAuthRepository;
import com.segurityapp.igom.entity.repository.RepositoryInterface;

import org.json.JSONException;

public class LoginService {

    public boolean login(String username, String password) throws IllegalAccessException, InstantiationException, ClassNotFoundException, JSONException {

        EntityManager em = new EntityManager("OAuth");
        OAuthRepository repository = (OAuthRepository) em.getRepositiry();

        return repository.login(username, password);
    }
}
