package com.application.gamescore.user.service;

import com.application.gamescore.user.dto.UserDTO;

public interface UserService {
	
	public String checkDuplicatedId(String userNm);
	public void addUser(UserDTO userDTO);
	public boolean login(UserDTO userDTO);
}
