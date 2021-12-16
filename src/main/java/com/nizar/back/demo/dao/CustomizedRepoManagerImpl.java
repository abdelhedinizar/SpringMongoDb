package com.nizar.back.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomizedRepoManagerImpl implements CustomizedRepoManager {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List findByElement(List elements, String elementName, Class entityClass) {
        Query query = new Query().addCriteria(Criteria.where(elementName).in(elements));
        /*Interfaces()).collect(Collectors.toList()).get(0);*/
        return mongoTemplate.find(query, entityClass);
    }

    @Override
    public Long countItemByFieldValue(Object fieldValue, String elementName, Class entityClass) {
        Query query = new Query().addCriteria(Criteria.where(elementName).in(fieldValue));
        return mongoTemplate.count(query, entityClass);
    }
}
