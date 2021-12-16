package com.nizar.back.demo.dao;

public interface ExistsInDatabaseRepository<T extends Object> {

    <T> Long countItemByFieldValue(T fieldValue, String elementName, Class entityClass);
}
