package com.nizar.back.demo.dao.country;

import com.nizar.back.demo.dao.CustomizedRepoManager;
import com.nizar.back.demo.entities.country.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountriesRepo extends MongoRepository<Country, String>, CustomizedRepoManager<Country> {

}
