package com.application.gamescore.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.gamescore.user.dao.UserDAO;
import com.application.gamescore.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String checkDuplicatedId(String userNm) {
		if (userDAO.checkDuplicatedId(userNm) == null) {
			return "duplicate";
		} else {
			return "notDuplicate";
		}
	}

	@Override
	public void addUser(UserDTO userDTO) {
		userDTO.setUserPw(passwordEncoder.encode(userDTO.getUserPw()));
		userDAO.register(userDTO);
	}

	@Override
	public boolean login(UserDTO userDTO) {
		UserDTO checkExsistId = userDAO.login(userDTO);
		if (checkExsistId != null) {
			if (passwordEncoder.matches(userDTO.getUserPw() ,checkExsistId.getUserPw())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public long getUserId(String userNm) {
		return userDAO.getUserId(userNm);
	}

	

}
