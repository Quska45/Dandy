package com.dandy.DTO;

import java.util.Date;

public class QuestionBoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private int goodcnt;
	private int ref;
	private int re_step;
	private int re_level;
	private String question_type;
	private String flag;
	private int replycnt;
	private String sort;
	
	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	public int getReplycnt() {
		return replycnt;
	}


	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}


	public QuestionBoardDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public QuestionBoardDTO(String title, String content, String writer, int ref, int re_step, int re_level) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
	}
	
	

	public QuestionBoardDTO(int bno, String title, String content, String writer) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public QuestionBoardDTO(int bno, String title, String content, String writer, String question_type, String flag) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.question_type = question_type;
		this.flag = flag;
	}
	
	public QuestionBoardDTO(String title, String content, String writer, String question_type, String flag) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.question_type = question_type;
		this.flag = flag;
	}

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getGoodcnt() {
		return goodcnt;
	}
	public void setGoodcnt(int goodcnt) {
		this.goodcnt = goodcnt;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
