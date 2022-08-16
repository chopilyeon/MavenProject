package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getAllBoard();
	BoardVO getOneBoard(int boardNo);
	void write(BoardVO boardVO);
	//사람이 작업하는 느낌으로 써주자! 
}
