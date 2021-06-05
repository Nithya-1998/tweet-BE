package com.tweetapp.tweetservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweetservice.bean.ReplyTweet;
import com.tweetapp.tweetservice.bean.Tweet;
import com.tweetapp.tweetservice.dto.LikeCountDto;
import com.tweetapp.tweetservice.dto.TweetDto;
import com.tweetapp.tweetservice.exception.Message;
import com.tweetapp.tweetservice.kafka.Producer;
import com.tweetapp.tweetservice.service.TweetService;


/**
 * @author Nithya T
 *
 */
@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins = "http://localhost:3000")
public class TweetController {

	public static final Logger LOGGER = LoggerFactory.getLogger(TweetController.class);
	@Autowired
	public TweetService tweetService;

//	@Autowired
	public Producer producer;

	public TweetController(TweetService tweetService, Producer producer) {
		super();
		this.tweetService = tweetService;
		this.producer = producer;
	}

	@GetMapping("/all")
	public List<Tweet> getAllTweets() {
		LOGGER.info("Inside All Tweets");
		return tweetService.getAllTweets();
	}

	@GetMapping("/find/{loginId}")
	public List<Tweet> getAllTweetsById(@PathVariable String loginId) {
		LOGGER.info("Inside Find Tweet By User");
		return tweetService.getAllTweetsById(loginId);
	}

	@GetMapping("/{id}")
	public Tweet getTweetById(@PathVariable String id) {
		LOGGER.info("Inside Find Tweet By Id");
		return tweetService.getTweetById(id);
	}

	@PostMapping("/add")
	public TweetDto postTweet(@RequestBody Tweet tweet) {
//		producer.sendMessage(tweet.getMessage());
		LOGGER.info("Inside Post Tweet By User");
		return tweetService.postTweet(tweet);
	}

	@PutMapping("/{loginId}/like/{id}")
	public LikeCountDto likeTweetUpdate(@RequestBody LikeCountDto likeCount, @PathVariable("loginId") String loginId,
			@PathVariable("id") String id) {
		LOGGER.info("Inside Put like By User");
		return tweetService.likeTweetUpdate(likeCount, loginId, id);
	}

	@PutMapping("/{loginId}/update/{id}")
	public TweetDto updateTweet(@RequestBody Tweet tweet, @PathVariable("loginId") String loginId,
			@PathVariable("id") String id) {
//		producer.sendMessage(tweet.getMessage());
		LOGGER.info("Inside Update Tweet Msg By User");
		return tweetService.updateTweet(tweet, loginId, id);
	}

	@PostMapping("/reply/{id}")
	public TweetDto replyPostTweet(@RequestBody ReplyTweet replytweet, @PathVariable("id") String id) {
//		producer.sendMessage(replytweet.getRepliedMessage());
		LOGGER.info("Inside Reply Tweet By Other User");
		return tweetService.replyPostTweet(replytweet, replytweet.getLoginId(), id);
	}

	@DeleteMapping("/{loginId}/delete/{id}")
	public Message deleteTweet(@PathVariable("loginId") String loginId, @PathVariable("id") String id) {
		LOGGER.info("Inside Delete Tweet: {}",id);
		return tweetService.deleteTweet(loginId, id);
	}

}
