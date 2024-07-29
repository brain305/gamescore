package com.application.gamescore.game.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewDTO {
	
	private long reviewId;
	private long gameId;
	private long userId;
	private int rating;
	private String reviewText;
	private Date reviewDt;
	private String userNm;
}
