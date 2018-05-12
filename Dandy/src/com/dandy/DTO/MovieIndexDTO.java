package com.dandy.DTO;

public class MovieIndexDTO {

	private int mno;
	private String indexchar;
	private String title;
	private int createyear;
	private String img;
	private int manview;
	private int womanview;
	private int view_10;
	private int view_20;
	private int view_30;
	private int view_40;
	private int view_50;
	
	
	public MovieIndexDTO() {
		super();
	}


	public MovieIndexDTO(int mno, String indexchar, String title, int createyear, String img, int manview,
			int womanview, int view_10, int view_20, int view_30, int view_40, int view_50) {
		super();
		this.mno = mno;
		this.indexchar = indexchar;
		this.title = title;
		this.createyear = createyear;
		this.img = img;
		this.manview = manview;
		this.womanview = womanview;
		this.view_10 = view_10;
		this.view_20 = view_20;
		this.view_30 = view_30;
		this.view_40 = view_40;
		this.view_50 = view_50;
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


	public int getManview() {
		return manview;
	}


	public void setManview(int manview) {
		this.manview = manview;
	}


	public int getWomanview() {
		return womanview;
	}


	public void setWomanview(int womanview) {
		this.womanview = womanview;
	}


	public int getView_10() {
		return view_10;
	}


	public void setView_10(int view_10) {
		this.view_10 = view_10;
	}


	public int getView_20() {
		return view_20;
	}


	public void setView_20(int view_20) {
		this.view_20 = view_20;
	}


	public int getView_30() {
		return view_30;
	}


	public void setView_30(int view_30) {
		this.view_30 = view_30;
	}


	public int getView_40() {
		return view_40;
	}


	public void setView_40(int view_40) {
		this.view_40 = view_40;
	}


	public int getView_50() {
		return view_50;
	}


	public void setView_50(int view_50) {
		this.view_50 = view_50;
	}
	
	
	
	
	
	
	
}
