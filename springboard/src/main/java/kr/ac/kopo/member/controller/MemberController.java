package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//밑의 sessionattribute로 등록했으면은 session.setcomplete로 세션을 만료시켜야 함.  
@SessionAttributes("loginVO")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//GET /LOGIN /MEMBER/LOGIN.JSP
	
	//로그인
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		//spring form tag에서 사용할 memberVO를 공유영역에 등록시킨다.
		request.setAttribute("memberVO", new MemberVO());
		
		//WEB-INF/jsp/member/login.jsp
		return "member/login";
	}
	//요청은 post로 들어올 것임. 
	
	
	@PostMapping("/login")
	public String loginPost(@Valid MemberVO memberVO, BindingResult result, Model model,HttpSession session) {
		//spring form tag에서 사용할 memberVO를 공유영역에 등록시킨다.
		
		
		/*1. MemberVO의 member가 null값이 아닌 valid 한 값이 들어왔는가 확인 
			->BindingResult를 가지고 화깅ㄴ 
			2.1 null값을 가진 error값이 들어온 경우 
			2.2 정상값이 들어온 경우 id/password가 유효한지 select 문으로 체크,
				2.2.1 유효한 id/password -db 존재 
				welcome!!! 홍길동님 반가워요 
				session에 해당 유효한 memberVO 등록 
				2.2.2 유효하지 않을 때, db에 존재 
				-사용자에게 메세지 id/password유효하지 않으니 다시 입력하세요 
				forward memeber/login.jsp
			
			3.interceptor  
		

		*/
		System.out.println(result);
		System.out.println(memberVO);
		if(result.hasErrors()) {
			//null값이 존재. -> 다시 입력하세요
			
			//WEB-INF/jsp/member/login.jsp
			return "member/login";
			
		}else {
			//null값이 존재하지 않음 -> db작업 id/password가 유효한 사용자인지 확인 
			//db 작업 
			MemberVO authMember = memberService.login(memberVO);
			System.out.println("authMember:"+ authMember);
			if(authMember == null) {
				//id 랑 password가 유효하지 않은 경우 
				model.addAttribute("loginmsg","id와 password가 유효하지 않습니다");
				return "member/login";
			}else {
				//session.setAttribute("loginVO",authMember);
				model.addAttribute("loginVO",authMember);
				//위에 annotation보면은 session에 등록하라고 붙어 있음. 
			}		
			//나쁜 사용자가 들어오면 null이 들어오게 됨 -> id 패스워드 잘못 들어왔다고 login.jsp로 넘기는 작업이 필요함
			
			
			String dest = (String)session.getAttribute("dest");
			
			//interceptor를 거칠 일이 없으니 dest가 null이 되어버림. 로그인 먼저 한 선량한 유저에게 그런 에러가 발생하게 됨
			
			System.out.println("dest는 뭘까"+dest);
			if(dest == null) {
				return "redirect:/";
			}else{
				return "redirect:"+dest;
			}
			
			
			//return "redirect:/board";
			
			
			
		}
	}
	
	
	
		//원래는 이렇게 했었음 
		@RequestMapping("/logout")
		public String logout(HttpSession session, SessionStatus sessionStatus) {
			
			
			session.invalidate();
			
			//spring에서는 이렇게 하도록 하자~! 
			
			sessionStatus.setComplete();
			return "redirect:/";
		}
		
		

	
	
	

}
