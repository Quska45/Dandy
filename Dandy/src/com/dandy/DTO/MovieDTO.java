package com.dandy.DTO;

public class MovieDTO {

	private int mno;
	private String indexchar;
	private String title;
	private int createyear;
	private String img;
	
	
	public MovieDTO() {
		super();
	}


	public MovieDTO(int mno, String indexchar, String title, int createyear, String img) {
		super();
		this.mno = mno;
		this.indexchar = indexchar;
		this.title = title;
		this.createyear = createyear;
		this.img = img;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getIndexchar() {
		return indexchar;
	}


	public void setIndexchar(String indexchar) {
		this.indexchar = indexchar;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getCreateyear() {
		return createyear;
	}


	public void setCreateyear(int createyear) {
		this.createyear = createyear;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
}
