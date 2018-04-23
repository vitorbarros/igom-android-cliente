package com.segurityapp.igom.entity.repository;

import com.segurityapp.igom.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public interface RepositoryInterface<T> {

    public void store(CallbackHandler<T> callbackHandler, Entity entity);

    public void findAll(CallbackHandler<T> callbackHandler);

    public void find(CallbackHandler<T> callbackHandler);

    public void update(CallbackHandler<T> callbackHandler, Entity entity);

    interface CallbackHandler<T> {

        /**
         * Handles an error
         */
        void error();

        /**
         * Handles a single-object result
         * @param result the result
         */
        void single(Entity result);

        /**
         * Handles a multi-object result
         * @param result the result
         */
        void multiple(List<Entity> result);

    }
}
