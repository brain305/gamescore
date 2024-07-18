package com.application.gamescore.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommunityController {
	
	@GetMapping("/community")
	public String community() {
		return "gamescore/community";
	}
	
}
