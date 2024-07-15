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
	
	@GetMapping("/checkout")
	public String checkout() {
		return "gamescore/checkout";
	}
	
	@GetMapping("/confirmation")
	public String confirmation() {
		return "gamescore/confirmation";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "gamescore/community";
	}
	
	
	
}
