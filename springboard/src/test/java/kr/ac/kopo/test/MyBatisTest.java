package kr.ac.kopo.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.reply.vo.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MyBatisTest {
	
	//new 를 하는 과정임과 동시에 내가 아는 생성자 주입과 같은 역할 	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	//new를 해서 집어넣는다고 생각해도 됨! 
	
	//public MybatisTest(SqlSessionTemplate sqlSessionTemplate) {
		//this.sqlSessionTemplate = sqlSessionTemplate;
	//}
	
	
	
	
	@Test
	public void mybatisT() {
		assertNotNull(sqlSessionTemplate);	
	}
	
	@Test
	public void boardSelectAllTest() {
		List<BoardVO> boardlist=sqlSessionTemplate.selectList("board.dao.boardDAO.selectAll");
		for(BoardVO board:boardlist) {
			System.out.println(board);
		}
	}
	
	@Test
	public void boardSelectByNo() {
		BoardVO board = sqlSessionTemplate.selectOne("board.dao.boardDAO.selectByNo",3);
		System.out.println(board);
	}
	
	@Test
	public void boardInsertTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setContent("hihi");
		boardVO.setNo(1);
		boardVO.setTitle("Hhh");
		boardVO.setWriter("chopilyeon");
		sqlSessionTemplate.insert("board.dao.boardDAO.insert",boardVO);
	}
	
	@Test
	public void selectUser() {
		MemberVO member = new MemberVO();
		member.setId("user");
		member.setPassword("user");
		MemberVO authMember = sqlSessionTemplate.selectOne("member.dao.memberDAO.selectUser",member);
		
		System.out.println(authMember);
	}
	@Test
	public void insertReply() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBoardNo(10);
		replyVO.setContent("hhh");
		replyVO.setWriter("jaehee");
		replyVO.setNo(11);
		sqlSessionTemplate.insert("reply.dao.replyDAO.insert",replyVO);
	}
	
	
	
}
