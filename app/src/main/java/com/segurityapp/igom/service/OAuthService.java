package com.segurityapp.igom.service;

import com.segurityapp.igom.entity.em.EntityManager;
import com.segurityapp.igom.entity.repository.OAuthRepository;
import com.segurityapp.igom.entity.repository.RepositoryInterface;

public class OAuthService {

    public void OAuth() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        EntityManager em = new EntityManager("OAuth");

            RepositoryInterface<OAuthRepository> oAuthRepository = em.getRepositiry();


    }
}
