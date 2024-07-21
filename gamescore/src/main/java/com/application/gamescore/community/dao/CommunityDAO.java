package com.application.gamescore.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.application.gamescore.community.dto.PostDTO;
import com.application.gamescore.user.dto.UserDTO;

@Mapper
public interface CommunityDAO {
	
	public List<PostDTO> getPostList();
	public void insertPost(PostDTO postDTO, MultipartFile upFile);
	public PostDTO getPostDetail(long postId);
	public UserDTO getUserDTO(long userId);
}
