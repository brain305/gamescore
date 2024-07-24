package com.application.gamescore.game.service;

import java.util.List;

import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.game.dto.RateDTO;

public interface GameService {
	public List<GameDTO> getGameList();
	public List<GameDTO> getGameListOrderByPop();
	public List<GameDTO> getGameListDesc();
	public GameDTO getGameDetail(long gameId);
	public void createGameRating(RateDTO rateDTO);
	public int getGameRating(long gameId);
	public int getReviewCnt(long gameId);
	
}
