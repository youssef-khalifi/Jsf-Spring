package com.dao;

import java.util.List;

public interface IDAO<T> {

    boolean saveOrUpdate(T t);
    boolean delete(T t);
    T getById(int id);
    List<T> getAll();
}
