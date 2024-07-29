package com.application.gamescore.game.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.game.dto.RateDTO;
import com.application.gamescore.game.dto.ReviewDTO;

@Mapper
public interface GameDAO {
	
	public List<GameDTO> getGameList();
	public List<GameDTO> getGameListOrderByPop();
	public List<GameDTO> getGameListDesc();
	public List<GameDTO> searchGame(String searchKeyword);
	public GameDTO getGameDetail(long gameId);
	public void createGameRating(RateDTO rateDTO);
	public int getGameRating(long gameId);
	public int getReviewCnt(long gameId);
	public List<ReviewDTO> getGameReview(long gameId);
	
}
