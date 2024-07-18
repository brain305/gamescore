package com.application.gamescore.admin.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GameDTO {
	private long gameId;
	private String title;
	private int price;
	private String description;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date releaseDt;
	private String developer;
	private String publisher;
	private String purchaseLk;
	private String steamdeckCompatibility;
	private String genre;
	private String modes;
	private String player;
	private String gameImgName;
	
}
