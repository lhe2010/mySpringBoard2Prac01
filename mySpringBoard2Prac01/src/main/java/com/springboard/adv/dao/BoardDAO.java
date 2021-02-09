package com.springboard.adv.dao;

import java.util.List;

import com.springboard.adv.dto.BoardDTO;

public interface BoardDAO {
	
	public List<BoardDTO> getAllSimpleBoard() throws Exception;

	public void insertBoard(BoardDTO bdto) throws Exception;
	
}
