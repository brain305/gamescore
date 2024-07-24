package com.application.gamescore.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.application.gamescore.admin.dto.AdminDTO;
import com.application.gamescore.admin.dto.GameDTO;

@Mapper
public interface AdminDAO {

	public void addGame(GameDTO gameDTO);
	public GameDTO getGameDetail(long gameId);
	public AdminDTO adminLogin(AdminDTO adminDTO);

}
