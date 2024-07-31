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

import com.application.gamescore.community.dto.CommentDTO;
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
		
		List<PostDTO> postListDesc = communityService.getPostListDesc();
		model.addAttribute("postListDesc", postListDesc);
		
		return "gamescore/community";
	}

	@GetMapping("/post")
	public String postDetail(Model model, @RequestParam("postId") long postId) {

		model.addAttribute("postDTO", communityService.getPostDetail(postId));
		model.addAttribute("userDTO", communityService.getUserDetail(postId));
		model.addAttribute("previousPostId", communityService.getPreviousPostId(postId));
		model.addAttribute("nextPostId", communityService.getNextPostId(postId));
		model.addAttribute("comment", communityService.getCommentList(postId));
		
		return "gamescore/post";
	}

	@GetMapping("/insertPost")
	public String insertPost() {

		return "gamescore/insertPost";
	}

	@PostMapping("/insertPost")
	@ResponseBody
	public String insertPost(@ModelAttribute PostDTO postDTO, @RequestParam("upFile") MultipartFile upFile)
			throws IllegalStateException, IOException {

		communityService.insertPost(postDTO, upFile);
		String jsScript = """
				<script>
					 alert('게시글이 등록되었습니다.');
					location.href='/community/main';
				</script>""";

		return jsScript;
	}

	@GetMapping("/deletePost")
	@ResponseBody
	public String deletePost(@RequestParam("postId") long postId) {

		String jsScript = """
				<script>
					 alert('게시글이 삭제되었습니다.');
					location.href='/community/main';
				</script>
				""";
		communityService.deleteComment(postId);
		communityService.deletePost(postId);

		return jsScript;
	}

	@GetMapping("/updatePost")
	public String updatePost(@RequestParam("postId") long postId, Model model) {
		
		model.addAttribute("postDTO", communityService.getPostDTO(postId));
		return "gamescore/updatePost";
	}
	
	@PostMapping("/updatePost")
	@ResponseBody
	public String updatePost(@ModelAttribute PostDTO postDTO, @RequestParam("upFile") MultipartFile upFile) throws IllegalStateException, IOException {
		
		communityService.updatePost(postDTO, upFile);
		String jsScript = """
				<script>
					 alert('게시글이 수정되었습니다.');
					location.href='/community/main';
				</script>
				""";
		
		
		return jsScript;
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("searchKeyword") String searchKeyword, Model model) {
		
		model.addAttribute("postList", communityService.searchPost(searchKeyword));
		return "gamescore/community";
	}
	
	@PostMapping("/insertComment")
	@ResponseBody
	public String insertComment(@ModelAttribute CommentDTO commentDTO) {
		
		communityService.createComment(commentDTO);
		long postId = commentDTO.getPostId();
		String jsScript = String.format( """
				<script>
					 alert('댓글이 등록되었습니다.');
					location.href='/community/post?postId=%d';
				</script>
				""", postId);
		
		return jsScript;
	}
	
	
	
	
	
}
