package com.springboard.adv.service;

import java.util.List;
import java.util.Map;

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

	@Override
	public boolean updateBoard(BoardDTO bdto) throws Exception {
		boolean isSucceed = false;
		if(dao.validateUserCheck(bdto) != null) { // null이 아니면 select된 것이 있다 = 비밀번호가 맞음
			dao.updateBoard(bdto);
			isSucceed = true;
		}
		return isSucceed;
	}

	@Override
	public boolean deleteBoard(BoardDTO bdto) throws Exception {
		boolean isSucceed = false;
		if(dao.validateUserCheck(bdto) != null) { // null이 아니면 select된 것이 있다 = 비밀번호가 맞음
			dao.deleteBoard(bdto);
			isSucceed = true;
		}
		return isSucceed;
	}

	@Override
	public void insertReplyBoard(BoardDTO bdto) throws Exception {
		// restep후 insert
		dao.updateBoardReplyStep(bdto);
		dao.insertReplyBoard(bdto);
	}

	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		// 게시글의 개수를 반환하는 쿼리 1. 특정 키워드가 없을 경우
		return dao.getAllBoardCount(searchCountInfo);
	}

	@Override
	public List<BoardDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception {
		// 게시글의 내용을 반환하는 쿼리 
		return dao.getSearchBoard(searchInfo);
	}
	
	

}
