package com.nizar.back.demo.dao;

import com.nizar.back.demo.entities.MyProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MyProductRepository extends MongoRepository<MyProduct,String>, CustomizedProductManager {
}
