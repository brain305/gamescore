package com.application.gamescore.community.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentDTO {
	private long commentId;
	private long postId;
	private long userId;
	private String userNm;
	private String content;
	private Date createdAt;
	private Date updatedAt;
}
