package com.nizar.back.demo.dao;

import java.util.List;

public interface CustomizedRepoManager<T> extends ExistsInDatabaseRepository{
    public List<T> findByElement(List<String> names, String elementName, Class<T> entityClass);
}
