package com.application.gamescore.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
	
	@GetMapping("/gameDetail")
	public String gameDetail() {
		return "/gamescore/gameDetail";
	}
	
}
