package com.flutter.apiriva.service;

import java.util.List;

public interface InterfaceService<T> {
    List<T> readAll();
    public T create(T t);
    T update(T t);
    T read(int id);
    void delete(int id);
}
