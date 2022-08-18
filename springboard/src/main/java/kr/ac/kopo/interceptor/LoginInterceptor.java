package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.vo.MemberVO;

public class LoginInterceptor implements HandlerInterceptor{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("prehandle동작");
		System.out.println(handler);
		
		System.out.println("contextPath: "+request.getContextPath());
		System.out.println("uri: "+ request.getRequestURI());
		System.out.println("queryString:"+request.getQueryString());
		
		HttpSession session = request.getSession();
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		
		
		String dest = request.getRequestURI(); // "/springboard/ board/write/3 이런거 였었음. -> destination을 한 결과는 board/write/3 + queryString 이런 것임. 
		dest = dest.substring(request.getContextPath().length());
		
		session.setAttribute("dest",dest);
		
		if(loginVO == null) {
			//로그인이 안 되어있는 경우 
			
			response.sendRedirect(request.getContextPath()+"/login");			
			//방금 어떤 요청이 들어왔는지 알 수 있음. 
			return false;
		}else {
			//로그인이 되어 있는 경우 
			return true;
		}
		
		//false로 하면은 어떤것도 넘겨주지 않게 됨 어떤 요청을 하더라도 요청이 마비됨 return false 이거 쓰면 다 작살남. -> 로고도 사라짐 -> resources가서 png 가져와야 되는데 그게 차단이 되는 것임. 
		
		//response.sendRedirect(request.getContextPath()+"/member/login"); // 이러면 false여도 false하기 전에 redirect 하므로 넘어가게 됨 대신 prehandle 계속 불리니까 무한 반복
		//return false
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		System.out.println("posthandle 동작");
		System.out.println(handler);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("aftercompletion 동작");
		System.out.println("after"+ handler);
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	

}
