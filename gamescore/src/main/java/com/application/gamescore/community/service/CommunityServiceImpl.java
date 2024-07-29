package com.application.gamescore.community.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.gamescore.community.dao.CommunityDAO;
import com.application.gamescore.community.dto.CommentDTO;
import com.application.gamescore.community.dto.PostDTO;
import com.application.gamescore.user.dto.UserDTO;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Value("${file.repo.path}") 
	private String fileRepositoryPath;
	
	@Autowired
	private CommunityDAO communityDAO;
	
	@Override
	public List<PostDTO> getPostList() {
		
		return communityDAO.getPostList();
	}

	@Override
	public void insertPost(PostDTO postDTO, MultipartFile upFile) throws IllegalStateException, IOException {
		
		if(!upFile.isEmpty()) {
			String uploadFileName = UUID.randomUUID() + "_" + upFile.getOriginalFilename();
			upFile.transferTo(new File(fileRepositoryPath + uploadFileName));
			postDTO.setPostImgNm(uploadFileName);
		}
		communityDAO.insertPost(postDTO);
	
	}

	@Override
	public PostDTO getPostDetail(long postId) {
		return communityDAO.getPostDetail(postId);
	}

	@Override
	public UserDTO getUserDTO(long userId) {
		return communityDAO.getUserDTO(userId);
	}

	@Override
	public UserDTO getUserDetail(long postId) {
		return communityDAO.getUserDetail(postId);
	}

	@Override
	public void deletePost(long postId) {
		communityDAO.deletePost(postId);
	}

	@Override
	public PostDTO getPostDTO(long postId) {
		return communityDAO.getPostDTO(postId);
	}

	@Override
	public long getPreviousPostId(long postId) {
		return communityDAO.getPreviousPostId(postId);
	}

	@Override
	public long getNextPostId(long postId) {
		return communityDAO.getNextPostId(postId);
	}

	@Override
	public List<PostDTO> searchPost(String searchKeyword) {
		return communityDAO.searchPost(searchKeyword);
	}

	@Override
	public void createComment(CommentDTO commentDTO) {
		communityDAO.createComment(commentDTO);
	}

	@Override
	public List<CommentDTO> getCommentList(long postId) {
		return communityDAO.getCommentList(postId);
	}

}
