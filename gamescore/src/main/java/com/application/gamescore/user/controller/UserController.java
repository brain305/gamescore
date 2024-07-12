package com.application.gamescore.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String login() {
		return "gamescore/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "gamescore/register";
	}
	
}
