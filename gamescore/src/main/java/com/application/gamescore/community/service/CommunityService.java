package com.application.gamescore.community.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.application.gamescore.community.dto.CommentDTO;
import com.application.gamescore.community.dto.PostDTO;
import com.application.gamescore.user.dto.UserDTO;

public interface CommunityService {
	public List<PostDTO> getPostList();
	public List<PostDTO> getPostListDesc();
	public void insertPost(PostDTO postDTO, MultipartFile upFile) throws IllegalStateException, IOException;
	public PostDTO getPostDetail(long postId);
	public UserDTO getUserDTO(long userId);
	public UserDTO getUserDetail(long postId);
	public void deletePost(long postId);
	public PostDTO getPostDTO(long postId);
	public long getPreviousPostId(long postId);
	public long getNextPostId(long postId);
	public List<PostDTO> searchPost(String searchKeyword);
	public void createComment(CommentDTO commentDTO);
	public List<CommentDTO> getCommentList(long postId);
	public void deleteComment(long postId);
	public void updatePost(PostDTO postDTO, MultipartFile upFile) throws IllegalStateException, IOException;
}
