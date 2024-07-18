package com.application.gamescore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping
	public String main() {
		return "gamescore/index";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "gamescore/layout";
	}
	
	
	@GetMapping("/cart")
	public String cart() {
		return "gamescore/cart";
	}
	
	
	@GetMapping("/confirmation")
	public String confirmation() {
		return "gamescore/confirmation";
	}
	
}
