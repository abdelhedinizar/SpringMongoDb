package com.nizar.back.demo.dao;

import com.nizar.back.demo.entities.MyProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MyProductRepository extends MongoRepository<MyProduct,String> {

  /*  @Query(value="{'name' : $0}", delete = true)
    public List<MyProduct> deleteByName (String name);
*/
    List<MyProduct> findByName(List<String> names);
}
