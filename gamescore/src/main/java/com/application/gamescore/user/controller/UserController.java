package com.application.gamescore.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.gamescore.user.dto.UserDTO;
import com.application.gamescore.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "gamescore/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "gamescore/register";
	}
	
	@PostMapping("/checkDuplicatedId")
	@ResponseBody
	public String checkDuplicatedId(@RequestParam("userNm") String userNm) {
		return userService.checkDuplicatedId(userNm);
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String register(UserDTO userDTO) {
		userService.addUser(userDTO);
		
		String jsScript = """
				<script>
					alert('회원가입되었습니다.');
					location.href='/';
				</script>""";	   
			   
		return jsScript;
	}
	
	
}
