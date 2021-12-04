package com.nizar.back.demo.dao;

import com.nizar.back.demo.entities.MyProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomizedProductManagerImpl implements CustomizedProductManager {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MyProduct> findByName(List<String> names) {
        Query query = new Query().addCriteria(Criteria.where("name").in(names));
        return mongoTemplate.find(query, MyProduct.class);
    }
}
