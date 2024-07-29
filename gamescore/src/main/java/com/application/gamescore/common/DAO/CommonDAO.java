package com.application.gamescore.common.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.gamescore.admin.dto.GameDTO;

@Mapper
public interface CommonDAO {
	List<GameDTO> getGameList();
}
