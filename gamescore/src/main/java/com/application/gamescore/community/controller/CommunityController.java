package com.application.gamescore.community.controller;

import java.io.IOException;
import java.util.List;

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

import com.application.gamescore.community.dto.PostDTO;
import com.application.gamescore.community.service.CommunityService;

@Controller
@RequestMapping("/community")
public class CommunityController {

	@Autowired
	private CommunityService communityService;
	
	
	@GetMapping("/main")
	public String community(Model model) {
		
		List<PostDTO> postList = communityService.getPostList();
		model.addAttribute("postList", postList);
		
		return "gamescore/community";
	}
	
	@GetMapping("/post")
	public String postDetail(Model model, @RequestParam("postId") long postId) {
		
		model.addAttribute("postDTO", communityService.getPostDetail(postId));
		model.addAttribute("userDTO", communityService.getUserDetail(postId));
		
		return "gamescore/post";
	}
	
	@GetMapping("/insertPost")
	public String insertPost() {
		
		return "gamescore/insertPost";
	}
	
	@PostMapping("/insertPost")
	@ResponseBody
	public String insertPost(@ModelAttribute PostDTO postDTO, @RequestParam("upFile") MultipartFile upFile) throws IllegalStateException, IOException {
		
		communityService.insertPost(postDTO, upFile);
		
		String jsScript = """
				<script>
					 alert('게시글이 등록되었습니다.');
					location.href='/community/main';
				</script>""";	
		
		return jsScript;
	}
	
	
	
	
	
}
