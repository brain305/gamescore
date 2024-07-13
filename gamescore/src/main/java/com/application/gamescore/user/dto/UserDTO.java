package com.application.gamescore.user.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
	private int userId;
	private String userNm;
	private String userPw;
	private String email;
	private String zipcode;
	private String roadAddress;
	private String address;
	private Date createdAt;

}
