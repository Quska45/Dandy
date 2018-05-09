package com.dandy.DTO;

import java.util.Date;

public class MemberDTO {

	private String mid;
	private String mpw;
	private String mname;
	private String msex;
	private String mbirth;
	private String memail;
	private String mphone;
	private String filename;
	private int filesize;
	private Date regdate;
	
	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String mid, String mpw) {
		super();
		this.mid = mid;
		this.mpw = mpw;
	}

	public MemberDTO(String mid, String mpw, String mname, String msex, String mbirth, String memail, String mphone,
			String filename, int filesize, Date regdate) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.msex = msex;
		this.mbirth = mbirth;
		this.memail = memail;
		this.mphone = mphone;
		this.filename = filename;
		this.filesize = filesize;
		this.regdate = regdate;
	}


	public MemberDTO(String mid, String mpw, String mname, String msex, String mbirth, String memail, String mphone) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.msex = msex;
		this.mbirth = mbirth;
		this.memail = memail;
		this.mphone = mphone;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMpw() {
		return mpw;
	}


	public void setMpw(String mpw) {
		this.mpw = mpw;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getMsex() {
		return msex;
	}


	public void setMsex(String msex) {
		this.msex = msex;
	}


	public String getMbirth() {
		return mbirth;
	}


	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getMphone() {
		return mphone;
	}


	public void setMphone(String mphone) {
		this.mphone = mphone;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public int getFilesize() {
		return filesize;
	}


	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	
	
	
}
