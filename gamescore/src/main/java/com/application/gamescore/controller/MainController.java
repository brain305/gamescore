package com.application.gamescore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.gamescore.common.Service.CommonService;

@Controller
public class MainController {
	
	@Autowired
	public CommonService commonService;
	
	@GetMapping
	public String main(Model model) {
		
		model.addAttribute("gameList", commonService.getGameList());
		
		return "gamescore/index";
	}
	
}
