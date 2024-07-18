package com.application.gamescore.admin.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.admin.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/insertGame")
	public String insertGame() {
		return "admin/insertGame";
	}
	
	@PostMapping("/insertGame")
	@ResponseBody
	public String insertGame(@RequestParam("upFile") MultipartFile upFile, @ModelAttribute GameDTO gameDTO) throws IllegalStateException, IOException {
		
		adminService.insertGame(upFile, gameDTO);
		
		String jsScript = """
				<script>
					alert('게임이 추가되었습니다');
					location.href='/admin/insertGame';
				</script>""";	   
			   
	return jsScript;
	}
	
	@GetMapping("/updateGame")
	public String updateGame(Model model, @RequestParam("gameId") long gameId) {
		
		model.addAttribute("gameDTO", adminService.getGameDetail(gameId));
		return "admin/updateGame";
	}
	
	
}
