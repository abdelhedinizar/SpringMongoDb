package com.nizar.back.demo.dao;

import com.nizar.back.demo.entities.MyProduct;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyProductQueryService {

    private final MongoTemplate mongoTemplate;

    public MyProductQueryService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<MyProduct> getProductByName(List<String> names) {
        Query query = new Query().addCriteria(Criteria.where("name").in(names));
        return mongoTemplate.find(query, MyProduct.class);
    }
}
