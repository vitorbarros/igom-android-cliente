package com.segurityapp.igom.entity.em;

import com.segurityapp.igom.entity.repository.RepositoryInterface;

public class EntityManager {

    private String entity;

    private static RepositoryInterface instance;

    public EntityManager(String entity)
    {
        this.entity = entity;
    }

    public RepositoryInterface getRepositiry() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(instance == null){
            instance = (RepositoryInterface) Class.forName("com.segurityapp.igom.entity.repository."+this.entity+"Repository").newInstance();
        }
        return instance;
    }
}
