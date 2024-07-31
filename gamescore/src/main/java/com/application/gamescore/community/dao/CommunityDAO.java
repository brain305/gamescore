package com.application.gamescore.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.gamescore.community.dto.CommentDTO;
import com.application.gamescore.community.dto.PostDTO;
import com.application.gamescore.user.dto.UserDTO;

@Mapper
public interface CommunityDAO {
	
	public List<PostDTO> getPostList();
	public List<PostDTO> getPostListDesc();
	public void insertPost(PostDTO postDTO);
	public PostDTO getPostDetail(long postId);
	public UserDTO getUserDTO(long userId);
	public UserDTO getUserDetail(long postId);
	public String getPostImgNm(long postId);
	public void deletePost(long postId);
	public PostDTO getPostDTO(long postId);
	public long getPreviousPostId(long postId);
	public long getNextPostId(long postId);
	public List<PostDTO> searchPost(String searchKeyword);
	public void createComment(CommentDTO commentDTO);
	public List<CommentDTO> getCommentList(long postId);
	public void deleteComment(long postId);
	public void updatePost(PostDTO postDTO);
}
