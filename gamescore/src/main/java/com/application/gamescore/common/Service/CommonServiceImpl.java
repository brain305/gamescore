package com.application.gamescore.common.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gamescore.admin.dto.GameDTO;
import com.application.gamescore.common.DAO.CommonDAO;

@Service
public class CommonServiceImpl implements CommonService {

	
	@Autowired
	public CommonDAO commonDAO;
	
	@Override
	public List<GameDTO> getGameList() {
		
		return commonDAO.getGameList();
	}

}
