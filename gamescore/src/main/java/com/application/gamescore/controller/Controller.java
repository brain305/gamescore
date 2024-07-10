package com.application.gamescore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/main")
public class Controller {

	
	
	
	@GetMapping("/index")
	public String index() {
		return "gamescore/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "gamescore/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "gamescore/register";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "gamescore/blog";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "gamescore/cart";
	}
	
	@GetMapping("/single-blog")
	public String singleBlog() {
		return "gamescore/single-blog";
	}
	
	@GetMapping("/single-product")
	public String singleProduct() {
		return "gamescore/single-product";
	}
	
	@GetMapping("/checkout")
	public String checkout() {
		return "gamescore/checkout";
	}
	
	@GetMapping("/confirmation")
	public String confirmation() {
		return "gamescore/confirmation";
	}
	
	
}
