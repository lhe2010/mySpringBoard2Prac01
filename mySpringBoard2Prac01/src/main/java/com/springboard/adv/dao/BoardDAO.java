package com.springboard.adv.dao;

import java.util.List;
import java.util.Map;

import com.springboard.adv.dto.BoardDTO;

public interface BoardDAO {
	
	public List<BoardDTO> getAllSimpleBoard() throws Exception;

	public void insertBoard(BoardDTO bdto) throws Exception;
	
	public BoardDTO getOneBoard(int num) throws Exception;
	public void increaseReadCount(int num) throws Exception;
	
	public BoardDTO validateUserCheck(BoardDTO bdto) throws Exception;
	public void updateBoard(BoardDTO bdto) throws Exception;
	public void deleteBoard(BoardDTO bdto) throws Exception;
	
	public void insertReplyBoard(BoardDTO bdto) throws Exception;
	public void updateBoardReplyStep(BoardDTO bdto) throws Exception;
	
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	public List<BoardDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
	
}
