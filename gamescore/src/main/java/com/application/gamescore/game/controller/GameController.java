package com.application.gamescore.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.game.dto.RateDTO;
import com.application.gamescore.game.dto.ReviewDTO;
import com.application.gamescore.game.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("/gameDetail")
	public String gameDetail(Model model, @RequestParam("gameId") long gameId) {

		GameDTO gameDTO = gameService.getGameDetail(gameId);
		int gameReviewCnt = gameService.getReviewCnt(gameId);
		int rating = gameService.getGameRating(gameId);
		List<ReviewDTO> reviewList = gameService.getGameReview(gameId);
		
		
		model.addAttribute("gameDTO", gameDTO);
		model.addAttribute("rating", rating);
		model.addAttribute("reviewCnt", gameReviewCnt);
		model.addAttribute("reviewList", reviewList);
		
		return "gamescore/gameDetail";
	}

	@GetMapping("/gameList")
	public String gameList(Model model, @RequestParam(name="sort" ,defaultValue = "default") String sort) {

		if (sort.equals("default")) {
			List<GameDTO> gameList = gameService.getGameList();

			model.addAttribute("gameList", gameList);

		}

		else if (sort.equals("popular")) {
			List<GameDTO> gameList = gameService.getGameListOrderByPop();

			model.addAttribute("gameList", gameList);
		}

		else if (sort.equals("latest")) {
			List<GameDTO> gameList = gameService.getGameListDesc();

			model.addAttribute("gameList", gameList);
		}

		return "gamescore/gameList";
	}

	@PostMapping("/gameDetail")
	@ResponseBody
	public String gameDetail(@ModelAttribute RateDTO rateDTO) {

		gameService.createGameRating(rateDTO);
		String jsScript = """
				<script>
					 alert('평점이 등록되었습니다.');
					location.href='/gameList';
				</script>""";

		return jsScript;
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam("searchKeyword") String searchKeyword, Model model) {
		
		model.addAttribute("gameList", gameService.searchGame(searchKeyword));
		
		return "gamescore/gameList";
	}
	
	
}
