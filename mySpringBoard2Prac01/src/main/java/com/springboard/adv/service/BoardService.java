package com.springboard.adv.service;

import java.util.List;

import com.springboard.adv.dto.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> listAllSimple() throws Exception;
	
	public void insertBoard(BoardDTO bdto) throws Exception;

}
