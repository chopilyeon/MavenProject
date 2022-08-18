package kr.ac.kopo.board.vo;

import javax.validation.constraints.NotEmpty;

public class BoardVO {
	private int no;
	private int replyCnt;
	
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}


	@NotEmpty(message="필수사항입니다")
	private String title;
	
	@NotEmpty(message="필수사항입니다")
	private String content;
	
	@NotEmpty(message="필수사항입니다")
	private String writer;
	private String regDate;
	private int viewCnt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", replyCnt=" + replyCnt + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}
	


}
