package com.tweetapp.tweetservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweetservice.bean.ReplyTweet;

/**
 * @author Nithya T
 *
 */
@EnableMongoRepositories
@Repository
public interface ReplyTweetRepository extends MongoRepository<ReplyTweet, String> {

}
