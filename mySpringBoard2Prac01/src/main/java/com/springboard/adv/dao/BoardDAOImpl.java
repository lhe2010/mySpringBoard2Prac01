package com.springboard.adv.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springboard.adv.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	@Override
	public List<BoardDTO> getAllSimpleBoard() throws Exception {
		return session.selectList("com.spring.mapper.BoardMapper.getAllSimpleBoard");
	}

	@Override
	public void insertBoard(BoardDTO bdto) throws Exception {
		session.insert("com.spring.mapper.BoardMapper.insertBoard", bdto);
	}

	@Override
	public BoardDTO getOneBoard(int num) throws Exception {
		return session.selectOne("com.spring.mapper.BoardMapper.getOneBoard", num);
	}

	@Override
	public void increaseReadCount(int num) throws Exception {
		session.update("com.spring.mapper.BoardMapper.increaseReadCount", num);
	}

	@Override
	public BoardDTO validateUserCheck(BoardDTO bdto) throws Exception {
		return session.selectOne("com.spring.mapper.BoardMapper.validateUserCheck", bdto);
	}

	@Override
	public void updateBoard(BoardDTO bdto) throws Exception {
		session.update("com.spring.mapper.BoardMapper.updateBoard", bdto);		
	}

	@Override
	public void deleteBoard(BoardDTO bdto) throws Exception {
		session.delete("com.spring.mapper.BoardMapper.deleteBoard", bdto);
	}

	@Override
	public void insertReplyBoard(BoardDTO bdto) throws Exception {
		session.insert("com.spring.mapper.BoardMapper.insertReplyBoard", bdto);
	}

	@Override
	public void updateBoardReplyStep(BoardDTO bdto) throws Exception {
		session.insert("com.spring.mapper.BoardMapper.updateBoardReplyStep", bdto);
	}

	@Override
	public List<BoardDTO> getSearchBoard() throws Exception {
		return session.selectList("com.spring.mapper.BoardMapper.getSearchBoard");
	}

	@Override
	public int getAllBoardCount() throws Exception {
		// 게시글의 개수를 반환하는 쿼리 1. 특정 키워드가 없을 경우
		return session.selectOne("com.spring.mapper.BoardMapper.getAllBoardCount");
	}

}
