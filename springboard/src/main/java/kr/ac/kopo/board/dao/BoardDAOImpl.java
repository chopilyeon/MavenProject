package kr.ac.kopo.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList("board.dao.boardDAO.selectAll");
		System.out.println(list);
		return list;
		
	}
	@Override
	public BoardVO selectByNo(int boardNo) {
		BoardVO board = sqlSessionTemplate.selectOne("board.dao.boardDAO.selectByNo",boardNo);
		return board;
	}
	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("board.dao.boardDAO.insert",boardVO);
	}
	@Override
	public void increaseReplyCount(int boardNo) {
		sqlSessionTemplate.update("board.dao.boardDAO.increaseReplyCount",boardNo);
		
	}
	@Override
	public void decreaseReplyCount(int boardNo) {
		sqlSessionTemplate.update("board.dao.boardDAO.decreaseReplyCount",boardNo);
		
	}

}
