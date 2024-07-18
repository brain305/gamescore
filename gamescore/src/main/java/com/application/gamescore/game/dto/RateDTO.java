package com.application.gamescore.game.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RateDTO {
	
	private long reviewId;
	private long gameId;
	private long userId;
	private int rating;
	private String reviewText;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reviewDt;
	
}
