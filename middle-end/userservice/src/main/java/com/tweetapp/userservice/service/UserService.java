package com.tweetapp.userservice.service;

import java.util.List;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tweetapp.userservice.bean.User;
import com.tweetapp.userservice.dto.UserDto;
import com.tweetapp.userservice.exception.Message;
import com.tweetapp.userservice.exception.UserExistException;
import com.tweetapp.userservice.exception.UserNotFoundException;
import com.tweetapp.userservice.repository.UserRepository;

/**
 * @author Nithya T
 *
 */
@Service
public class UserService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	private User user;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Transactional
	public List<User> getAllUsers(){
		Query query = new Query(Criteria.where("isLogIn").is(true));
		List<User> users = mongoTemplate.find(query, User.class, "user");
		return users;
	}
	
	@Transactional
	public User getUser(UserDto userDto) throws UserNotFoundException {
		Query query = new Query(Criteria.where("loginId").is(userDto.getLoginId()).andOperator(Criteria.where("password").is(userDto.getPassword())));
		user = mongoTemplate.findOne(query, User.class, "user");
		if(user != null) {
			user.setLoggedIn(userDto.isLogIn());
			userRepository.save(user);
			return user;
		}else {
			throw new UserNotFoundException("User Unauthorized");
		}
	}
	
	@Transactional
	public User getUserById(String loginId) throws UserNotFoundException {
		Query query = new Query(Criteria.where("loginId").is(loginId));
		user = mongoTemplate.findOne(query, User.class, "user");
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("User not found");
		}
	}
	@Transactional
	public Message logOutUser(String loginId)  throws UserNotFoundException {
		Query query = new Query(Criteria.where("loginId").is(loginId));
		user = mongoTemplate.findOne(query, User.class, "user");
		if(user != null) {
			user.setLoggedIn(false);
			userRepository.save(user);
			return new Message("Logged out Successfully");
		}else {
			return new Message("User not found");
		}
		
	}
	
	
	@Transactional
	public Message updateUser(UserDto userDto) throws UserNotFoundException {
		Query query = new Query(Criteria.where("loginId").is(userDto.getLoginId()));
		user = mongoTemplate.findOne(query, User.class, "user");
		if(user != null) {
//			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//			boolean isPwdMatches = bcrypt.matches(userDto.getPassword(), user.getPassword());
//			LOGGER.info("Password Matches?: {}",isPwdMatches);
			boolean isPwdMatches = userDto.getPassword().equals(user.getPassword()) ? true : false;
			if(isPwdMatches) {
				return new Message("New Password should not be same as old password");
			}else {
				user.setLoggedIn(userDto.isLogIn());
				user.setPassword(userDto.getPassword());
				userRepository.save(user);	
				return new Message("New Password updated");
			}
		}else {
			throw new UserNotFoundException("User not found");
		}
		
	}
	
	@Transactional
	public Message insertUser(User user1) throws UserExistException {
		Query query = new Query(Criteria.where("loginId").is(user1.getLoginId()));
		user = mongoTemplate.findOne(query, User.class, "user");
		if(user == null) {
			UUID uuid = UUID.randomUUID();
		    String uuidAsString = uuid.toString();
		    user1.set_id(uuidAsString);
		    user1.setPassword(user1.getPassword());
		    LOGGER.info("Password: {}",user1.getPassword());
			userRepository.save(user1);	
			return new Message("User details inserted successfully");
		}else {
			throw new UserExistException("User Alreday Exist");
		}
	}
	
	
}
