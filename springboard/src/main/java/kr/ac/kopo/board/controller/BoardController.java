package kr.ac.kopo.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//@Autowired
	 //public BoardController(BoardService boardService){ 
		//  this.boardService =boardService;
     //}
	 
	//localhost:8080/springboard/board
	@RequestMapping("/board")
	public String allboard(HttpServletRequest request) {
		//여기서의 string은 사용자가 보는 url을 의미함
		
		List<BoardVO> boardlist = new ArrayList<>();
		boardlist =boardService.getAllBoard();
		
		request.setAttribute("boardlist", boardlist);
		
		
		//WEB-INF/jsp/board/list.jsp
		return "board/list";
	}
	
	//상세게시글 조회 /board/detail?boardNo=3
	
	@RequestMapping("/board/detail")
	public String detail(HttpServletRequest request, @RequestParam("boardNo") int boardNo, Model model) {
		
		//해당 번호에 맞는 게시글을 가져온다.
		//String boardNo = request.getParameter("boardNo");
		
		
		//model을 사용하게 되면은 -> String으로 반환을 못하고 ModelAndView로 반환을 해야 함. 그래서 model parameter로 받자! 
		
		
		BoardVO board = boardService.getOneBoard(boardNo);
		
		model.addAttribute("board",board);
		//model and view는 view 에는 화면단까지도 넣을 수 있음. 
		
		//WEB-INF/jsp/board/detail.jsp
		return "board/detail";
	}
	
	@RequestMapping("/board/detail/{boardNo}")
	public String detail(@PathVariable("boardNo") int boardNo, Model model) {
		
		//해당 번호에 맞는 게시글을 가져온다.
		//String boardNo = request.getParameter("boardNo");
		
		
		//model을 사용하게 되면은 -> String으로 반환을 못하고 ModelAndView로 반환을 해야 함. 그래서 model parameter로 받자! 
		
		
		BoardVO board = boardService.getOneBoard(boardNo);
		
		model.addAttribute("board",board);
		//model and view는 view 에는 화면단까지도 넣을 수 있음. 
		
		//WEB-INF/jsp/board/detail.jsp
		return "board/detail";
	}
	
	//새글 쓰기 
	//board/write
	//retrun을 board/write로 하면 됨
	//localhost:8080/springboard/board.write
	//@RequestMapping(value =  "/board/write" , method = RequestMethod.GET) 밑에꺼랑 똑같은 작업 
	//@GetMapping("/board/wirte")
	//public String writeGet() {
		
		
		//return "board/write";
		
	//}
	//나 리턴 안해도 동작하게 좀 해줘봐! 
	//요청이랑 동일하면 그냥 글로 보내버림 
	
//	@GetMapping("/board/write")
//	public void writeGet() {
		
//		BoardVO boardVO1 = new BoardVO();
		
//	}

	//자 이제 아무것도 안들어온 null값을 제거해보자! 
	@GetMapping("/board/write")
	public void writeGet(Model model) {
		
		BoardVO boardVO1 = new BoardVO();
		model.addAttribute("boardVO1",boardVO1);
	}

	
	
	
	//객체로 받아오는 방법도 있음! 
	@PostMapping("/board/write")
	public String writePost(@Valid @ModelAttribute("boardVO1") BoardVO boardVO,BindingResult result) {
		
		
		//0. 입력받은 board가 null값이 포함안되어 있는지 확인한다 BindingResult를 활용함
		//1. DB insert 작업하기 
		//2. 다 완료 후에는 전체 게시글로 이동 
		//3. board 여기로 redirect 를 하자! 	
		
		//valid한지 체크할 수 있음 
		System.out.println(result);
		//이러면 result가 어떤지 알수가 있음.
		
		if(result.hasErrors()) {
			//error가 존재하는 경우 null이 있는 경우 
			
			return "board/write";
			
		}else {
			//error가 존재하지 않는 경우
			//insert DB -> 전체 게시글 리스트로 redirect
			boardService.write(boardVO);
			return "board/write";
		}
		

		//너 틀렸어 다시 돌아가! 
		
		//boardService.write(boardVO);
		//return "redirect:/board";
	}	
}
