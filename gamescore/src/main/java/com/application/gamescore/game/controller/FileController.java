package com.application.gamescore.game.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.gamescore.community.dao.CommunityDAO;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	public CommunityDAO communityDAO;
	
	@Value("${file.repo.path}")
	private String fileRepositoryPath;
	
	@GetMapping("/thumbnails")
	@ResponseBody
	public Resource thumbnails(@RequestParam("gameImgName") String gameImgName) throws MalformedURLException {
		
		return new UrlResource("file:" + fileRepositoryPath + gameImgName);
	}
	
	@GetMapping("/postImg")
	@ResponseBody
	public Resource postImg(@RequestParam("postImgNm") String postImgNm) throws MalformedURLException {
		return new UrlResource("file:" + fileRepositoryPath + postImgNm);
	}
	
	@GetMapping("/postThumbnails")
	@ResponseBody
	public Resource postThumbnails(@RequestParam("postId") long postId) throws MalformedURLException {
		
		return new UrlResource("file:" + fileRepositoryPath + communityDAO.getPostImgNm(postId));
	}
	
	
	
	
}
