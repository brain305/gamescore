package com.application.gamescore.admin.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.application.gamescore.admin.dto.AdminDTO;
import com.application.gamescore.admin.dto.GameDTO;

public interface AdminService {
	public void insertGame(MultipartFile upFile, GameDTO gameDTO) throws IllegalStateException, IOException;
	public GameDTO getGameDetail(long gameId);
	public boolean adminLogin(AdminDTO adminDTO);
}
