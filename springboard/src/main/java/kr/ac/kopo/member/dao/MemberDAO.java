package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//sqlsessiontemplate 만들어서 나에게 생성자로 넣어줘라! 이런 맏릉리 생략된 셈임. 
	
	public MemberVO selectUser(MemberVO memberVO) {
		MemberVO authMember = sqlSessionTemplate.selectOne("member.dao.memberDAO.selectUser",memberVO);
		
		
		return authMember;
	}

}
