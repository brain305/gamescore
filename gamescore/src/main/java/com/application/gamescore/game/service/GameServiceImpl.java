package com.application.gamescore.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.game.dao.GameDAO;
import com.application.gamescore.game.dto.RateDTO;

@Service
public class GameServiceImpl implements GameService {

	
	@Autowired
	private GameDAO gameDAO;
	
	@Override
	public List<GameDTO> getGameList() {
		
		return gameDAO.getGameList();
		
	}

	@Override
	public GameDTO getGameDetail(long gameId) {
		
		GameDTO gameDetail = gameDAO.getGameDetail(gameId);
		
		return gameDetail;
	}

	@Override
	public void createGameRating(RateDTO rateDTO) {
		
		gameDAO.createGameRating(rateDTO);
		
	}

}
