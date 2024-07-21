package com.application.gamescore.community.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {
	
	private long postId;
	private long userId;
	private String userNm;
	private String title;
	private String content;
	private long readCnt;
	private String postImgNm;
	private Date createdAt;
	private Date updatedAt;
	
}
