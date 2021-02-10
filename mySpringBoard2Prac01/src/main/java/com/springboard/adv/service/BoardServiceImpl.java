package com.springboard.adv.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.springboard.adv.dao.BoardDAO;
import com.springboard.adv.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	@Override
	public List<BoardDTO> listAllSimple() throws Exception {
		return dao.getAllSimpleBoard();
	}

	@Override
	public void insertBoard(BoardDTO bdto) throws Exception {
		dao.insertBoard(bdto);
	}

	@Override
	public BoardDTO getOneBoard(int num) throws Exception {
		dao.increaseReadCount(num);
		return dao.getOneBoard(num);
	}

}
