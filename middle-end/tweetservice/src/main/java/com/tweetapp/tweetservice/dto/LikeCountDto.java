package com.tweetapp.tweetservice.dto;

/**
 * @author Nithya T
 *
 */
public class LikeCountDto {
	
	private String id;
	private Long count;
	private boolean liked;
	public LikeCountDto(String id, Long count, boolean liked) {
		super();
		this.id = id;
		this.count = count;
		this.liked = liked;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public boolean isLiked() {
		return liked;
	}
	public void setIsLiked(boolean liked) {
		this.liked = liked;
	}
	@Override
	public String toString() {
		return "LikeCountDto [id=" + id + ", count=" + count + ", liked=" + liked + "]";
	}
	
	

}
