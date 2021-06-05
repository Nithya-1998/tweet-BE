package com.tweetapp.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.tweetapp.userservice.bean.User;

/**
 * @author Nithya T
 *
 */
@EnableMongoRepositories
@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

}
