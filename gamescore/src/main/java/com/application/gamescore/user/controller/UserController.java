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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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

	@PostMapping("/login")
	@ResponseBody
	public String login(UserDTO userDTO, HttpServletRequest request) {

		String jsScript = "";

		if (userService.login(userDTO)) {
			
			long userId = userService.getUserId(userDTO.getUserNm());
			
			HttpSession session = request.getSession();
			session.setAttribute("userNm", userDTO.getUserNm());
			session.setAttribute("userId", userId);
			session.setMaxInactiveInterval(60 * 30);

			jsScript = """
					<script>
						alert('로그인에 성공하였습니다.');
						location.href='/';
					</script>""";

		} else {

			jsScript = """
					<script>
						alert('로그인에 실패하였습니다. 아이디와 비밀번호를 확인하세요.');
						 history.go(-1);
					</script>""";

		}

		return jsScript;

	}
	
	@GetMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		String jsScript = """
				<script>
					 alert('로그아웃 되었습니다.');
					location.href='/';
				</script>""";	
		
		return jsScript;
		
	}
	
	
	
	
	
	
	
}