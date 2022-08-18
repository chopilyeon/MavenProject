package kr.ac.kopo.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDao;
	@Autowired
	private BoardDAO boardDao;
	
	
	@Transactional
	public void insert(ReplyVO replyVO) {
		boardDao.increaseReplyCount(replyVO.getBoardNo());
		replyDao.insert(replyVO);	
		
	}
	
	public List<ReplyVO> selectAll(int boardNo){
		List<ReplyVO> list = replyDao.selectAll(boardNo);
		return list;
	}
	
	@Transactional
	public void delete(int boardNo,int replyNo) {
		replyDao.delete(replyNo);
		//t_board boardNo인 게시글 reply_cnt를 1 감소시키자
		boardDao.decreaseReplyCount(boardNo);
	}
	


}
