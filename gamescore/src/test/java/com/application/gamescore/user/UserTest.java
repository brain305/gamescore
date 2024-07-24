package com.application.gamescore.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.application.gamescore.user.dao.UserDAO;
import com.application.gamescore.user.dto.UserDTO;


@SpringBootTest
public class UserTest {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserDAO userDAO;
	
	@DisplayName("register")
	@Test
	public void register() {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(100);
		userDTO.setUserNm("test");
		userDTO.setUserPw("sssss");
		userDTO.setAddress("test");
		userDTO.setZipcode("000000");
		userDTO.setRoadAddress("111-111");
		userDTO.setEmail("test@test.com");
		
		userDAO.register(userDTO);
		
	}
	
	
	@DisplayName("checkDuplicatedId")
	@Test
	public void checkDuplicatedId() {
		
		String userNm = "testNm";
		
		String result = userDAO.checkDuplicatedId(userNm);
		System.out.println(result);
		
	}
	
	@DisplayName("login")
	@Test
	public void login() {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserNm("brain305");
		userDTO.setUserPw("wnsgus305");
		
		UserDTO checkExsistId = userDAO.login(userDTO);
		if (checkExsistId != null) {
			if (passwordEncoder.matches(userDTO.getUserPw() ,checkExsistId.getUserPw())) {
				
				System.out.println("성공");
				
			}
		}
	}
}
