package kr.ac.kopo.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	
	@Override
	public List<BoardVO> getAllBoard() {
		
		
		List<BoardVO> list = new ArrayList<>();
		
		list = boardDAO.selectAll();
		System.out.println(list);
		return list;
	}
	@Override
	public BoardVO getOneBoard(int boardNo) {
		BoardVO board = boardDAO.selectByNo(boardNo);	
		return board;
	}
	
	@Override
	public void write(BoardVO boardVO) {
		boardDAO.insert(boardVO);
	}
	
	
}
