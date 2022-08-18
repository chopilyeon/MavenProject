package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectAll();
	BoardVO selectByNo(int boardNo);
	void insert(BoardVO boardVO);
	void increaseReplyCount(int boardNo);
	void decreaseReplyCount(int boardNo);
}
