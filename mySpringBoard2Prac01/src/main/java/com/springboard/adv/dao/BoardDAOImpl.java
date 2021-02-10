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

}
