package com.obdurat.carshop.services;

import java.util.List;

public interface IService<T> {
    T create(T request);
    List<T> findAll();
    T findOne(String id);
    T update(String id, T request);
    Boolean delete(String id);
}
