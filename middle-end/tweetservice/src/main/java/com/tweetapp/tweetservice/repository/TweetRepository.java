package com.tweetapp.tweetservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweetservice.bean.Tweet;

/**
 * @author Nithya T
 *
 */
@Repository
@EnableMongoRepositories
public interface TweetRepository extends MongoRepository<Tweet,String> {

}
