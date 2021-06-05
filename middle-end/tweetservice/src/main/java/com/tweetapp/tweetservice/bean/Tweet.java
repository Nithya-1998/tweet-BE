package com.tweetapp.tweetservice.bean;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author Nithya T
 *
 */
@Document(collection = "tweet")
public class Tweet {
	
	@Id
	@JsonAlias("id")
	private String _id;
	private String message;
	private String loginId;
	private String emailId;
	private List<ReplyTweet> replyTweets;
	private LocalDateTime postDTTM;
	private Long postLikeCount;
	
	public Tweet() {
		super();
	}

	public Tweet(String _id, String message, String loginId, String emailId, List<ReplyTweet> replyTweets,
			LocalDateTime postDTTM, Long postLikeCount) {
		this._id = _id;
		this.message = message;
		this.loginId = loginId;
		this.emailId = emailId;
		this.replyTweets = replyTweets;
		this.postDTTM = postDTTM;
		this.postLikeCount = postLikeCount;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<ReplyTweet> getReplyTweets() {
		return replyTweets;
	}

	public void setReplyTweets(List<ReplyTweet> replyTweets) {
		this.replyTweets = replyTweets;
	}

	public LocalDateTime getPostDTTM() {
		return postDTTM;
	}

	public void setPostDTTM(LocalDateTime postDTTM) {
		this.postDTTM = postDTTM;
	}

	public Long getPostLikeCount() {
		return postLikeCount;
	}

	public void setPostLikeCount(Long postLikeCount) {
		this.postLikeCount = postLikeCount;
	}

	@Override
	public String toString() {
		return "Tweet [_id=" + _id + ", message=" + message + ", loginId=" + loginId + ", emailId=" + emailId
				+ ", replyTweets=" + replyTweets + ", postDTTM=" + postDTTM + ", postLikeCount=" + postLikeCount + "]";
	}
	
	

}
