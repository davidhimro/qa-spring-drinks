package com.qa.wine.service;

import java.util.List;

public interface ServiceMethods<T> {

    //Create (T t);
    T create (T j);
    //Read All
    List<T> getAll();
    //Read By Id
    T getById(long id);
    //Update
    T update(long id, T t);
    //Delete
    boolean delete (long id);
}
