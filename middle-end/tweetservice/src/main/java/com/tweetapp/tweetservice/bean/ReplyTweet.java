package com.tweetapp.tweetservice.bean;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Nithya T
 *
 */
@Document(collection = "tweet")
public class ReplyTweet {
	
	private String id;
	private String loginId;
	private String repliedMessage;
	private LocalDateTime repliedDTTM;
	private Long replyMsglike;
	private boolean liked;
	
	
	public ReplyTweet() {
		super();
	}


	public ReplyTweet(String id, String loginId, String repliedMessage, LocalDateTime repliedDTTM, Long replyMsglike,
			boolean liked) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.repliedMessage = repliedMessage;
		this.repliedDTTM = repliedDTTM;
		this.replyMsglike = replyMsglike;
		this.liked = liked;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getRepliedMessage() {
		return repliedMessage;
	}

	public void setRepliedMessage(String repliedMessage) {
		this.repliedMessage = repliedMessage;
	}

	public LocalDateTime getRepliedDTTM() {
		return repliedDTTM;
	}

	public void setRepliedDTTM(LocalDateTime repliedDTTM) {
		this.repliedDTTM = repliedDTTM;
	}

	public Long getReplyMsglike() {
		return replyMsglike;
	}

	public void setReplyMsglike(Long replyMsglike) {
		this.replyMsglike = replyMsglike;
	}

	@Override
	public String toString() {
		return "ReplyTweet [id=" + id + ", loginId=" + loginId + ", repliedMessage=" + repliedMessage + ", repliedDTTM="
				+ repliedDTTM + ", replyMsglike=" + replyMsglike + ", liked=" + liked + "]";
	}


}
