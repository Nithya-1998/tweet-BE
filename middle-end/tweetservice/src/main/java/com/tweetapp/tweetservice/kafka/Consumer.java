package com.tweetapp.tweetservice.kafka;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Nithya T
 *
 */
@Service
public class Consumer {
	
	private final Logger logger = LoggerFactory.getLogger(Producer.class);

//	@KafkaListener(topics = "tweetApp", groupId = "group_id")
	public void consume(String message) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", message));
	}

}
