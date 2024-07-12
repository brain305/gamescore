package com.application.gamescore.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.application.gamescore.user.dto.UserDTO;

@Mapper
public interface UserDAO {
	public String checkDuplicatedId(String memberId);
	public void register(UserDTO userDTO);
}
