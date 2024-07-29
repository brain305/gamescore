package com.application.gamescore.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.game.dao.GameDAO;
import com.application.gamescore.game.dto.RateDTO;
import com.application.gamescore.game.dto.ReviewDTO;

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

	@Override
	public int getGameRating(long gameId) {
		return gameDAO.getGameRating(gameId);
	}

	@Override
	public int getReviewCnt(long gameId) {
		return gameDAO.getReviewCnt(gameId);
	}

	@Override
	public List<GameDTO> getGameListOrderByPop() {
		return gameDAO.getGameListOrderByPop();
	}

	@Override
	public List<GameDTO> getGameListDesc() {
		return gameDAO.getGameListDesc();
	}

	@Override
	public List<GameDTO> searchGame(String searchKeyword) {
		return gameDAO.searchGame(searchKeyword);
	}

	@Override
	public List<ReviewDTO> getGameReview(long gameId) {
		return gameDAO.getGameReview(gameId);
	}

}
