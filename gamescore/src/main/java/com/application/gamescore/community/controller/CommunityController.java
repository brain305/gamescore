package com.application.gamescore.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {
	
	@GetMapping("/community")
	public String blog() {
		return "gamescore/community";
	}
	
}
