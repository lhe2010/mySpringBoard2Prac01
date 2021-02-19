package com.springboard.adv.service;

import java.util.List;
import java.util.Map;

import com.springboard.adv.dto.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> listAllSimple() throws Exception;
	
	public void insertBoard(BoardDTO bdto) throws Exception;
	
	public BoardDTO getOneBoard(int num) throws Exception;

	public boolean updateBoard(BoardDTO bdto) throws Exception;
	
	public boolean deleteBoard(BoardDTO bdto) throws Exception;
	
	public void insertReplyBoard(BoardDTO bdto) throws Exception;
	
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	public List<BoardDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception;

}
