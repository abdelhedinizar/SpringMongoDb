package com.nizar.back.demo.dao.user;

import com.nizar.back.demo.dao.CustomizedRepoManager;
import com.nizar.back.demo.entities.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User, String>, CustomizedRepoManager<User> {

    public List<User> findByUsername(String username);

}
