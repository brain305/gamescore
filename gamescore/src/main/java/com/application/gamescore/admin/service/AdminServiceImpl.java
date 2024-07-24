package com.application.gamescore.admin.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.gamescore.admin.dao.AdminDAO;
import com.application.gamescore.admin.dto.AdminDTO;
import com.application.gamescore.admin.dto.GameDTO;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Value("${file.repo.path}") 
	private String fileRepositoryPath;
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public void insertGame(MultipartFile upFile,GameDTO gameDTO) throws IllegalStateException, IOException {
		
		if(!upFile.isEmpty()) {
			String uploadFileName = UUID.randomUUID() + "_" + upFile.getOriginalFilename();
			upFile.transferTo(new File(fileRepositoryPath + uploadFileName));
			gameDTO.setGameImgName(uploadFileName);
		}
		
		adminDAO.addGame(gameDTO);
	}

	@Override
	public GameDTO getGameDetail(long gameId) {
		adminDAO.getGameDetail(gameId);
		return null;
	}

	@Override
	public boolean adminLogin(AdminDTO adminDTO) {
		
		if(adminDAO.adminLogin(adminDTO) != null) {
			return true;
		}
		
		return false;
	}
	
	
}
