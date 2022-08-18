package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO login(MemberVO memberVO) {
		MemberVO authMember = memberDAO.selectUser(memberVO);
		return authMember;
	}

//	@Scheduled(fixedDelay = 3000)
//	public void printSchedule() {
//		System.out.println("스케줄러에 의한 메세지");
//		
//	}
	
//	@Scheduled(cron=" */5 * * * * *")
//	public void printSchedule1() {
//		System.out.println("스케줄러에 의한 메세지1");
//		
//	}
	
}
