package kr.ac.kopo.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;




//@RestController라고 써도 됨 아예 각각 responseBody 안쓰더라도

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	
	
	@ResponseBody
	@PostMapping("/reply")
	public void insert(ReplyVO replyVO) {
		System.out.println("들어오냐? reply");
		System.out.println(replyVO);
		replyService.insert(replyVO);
		//t_board replycnt = replycnt + 1; 
	}
	
	
	
	//reply/{boardNo} get
	@ResponseBody
	@GetMapping("/reply/{boardNo}")
	public List<ReplyVO> getAllReply(@PathVariable("boardNo") int boardNo) {
		
		List<ReplyVO> replylist = replyService.selectAll(boardNo);
		//db 작업
		return replylist;
	}
	
	@ResponseBody
	@DeleteMapping("/reply/{boardNo}/{replyNo}")
	public void delete(@PathVariable("boardNo") int boardNo, @PathVariable("replyNo") int replyNo) {
		System.out.println("들어오나?");
		replyService.delete(boardNo,replyNo);
	}
	
	
	
	

}
