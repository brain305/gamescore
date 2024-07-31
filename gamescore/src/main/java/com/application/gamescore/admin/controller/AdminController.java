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

import com.application.gamescore.admin.dto.AdminDTO;
import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.admin.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@PostMapping("/login")
	@ResponseBody
	public String login(AdminDTO adminDTO, HttpServletRequest request) {

		String jsScript = "";

		if (adminService.adminLogin(adminDTO)) {

			HttpSession session = request.getSession();

			session.setAttribute("adminId", adminDTO.getAdminId());
			session.setAttribute("role", "admin");
			session.setMaxInactiveInterval(60 * 30);

			jsScript = """
					<script>
						alert('관리자 계정으로 로그인되었습니다.');
						location.href='/';
					</script>""";

		} 
		else {

			jsScript = """
					<script>
						alert('로그인에 실패하였습니다. 아이디와 비밀번호를 확인하세요.');
						history.go(-1);
						</script>
					""";
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
					alert('관리자 계정 로그아웃되었습니다');
					location.href='/';
				</script>""";
		
		return jsScript;
	}
	

	@GetMapping("/insertGame")
	public String insertGame() {
		return "admin/insertGame";
	}

	@PostMapping("/insertGame")
	@ResponseBody
	public String insertGame(@RequestParam("upFile") MultipartFile upFile, @ModelAttribute GameDTO gameDTO)
			throws IllegalStateException, IOException {

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
		System.out.println(gameId);
		System.out.println(adminService.getGameDetail(gameId));
		model.addAttribute("gameDTO", adminService.getGameDetail(gameId));
		return "admin/updateGame";
	}

}
