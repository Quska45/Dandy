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
      private int mno1;
      private int mno2;
      private int mno3;
      private int mno4;
      private int mno5;
      private int mno6;
      private int mno7;
      private int mno8;
      private int mno9;
      private int mno10;
      private int i;
      private Integer mno;
     
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
	public Integer getMno() {
            return mno;
      }
      public void setMno(Integer mno) {
            this.mno = mno;
      }
      public int getI() {
            return i;
      }
      public void setI(int i) {
            this.i = i;
      }
      public int getMno1() {
            return mno1;
      }
      public void setMno1(int mno1) {
            this.mno1 = mno1;
      }
      public int getMno2() {
            return mno2;
      }
      public void setMno2(int mno2) {
            this.mno2 = mno2;
      }
      public int getMno3() {
            return mno3;
      }
      public void setMno3(int mno3) {
            this.mno3 = mno3;
      }
      public int getMno4() {
            return mno4;
      }
      public void setMno4(int mno4) {
            this.mno4 = mno4;
      }
      public int getMno5() {
            return mno5;
      }
      public void setMno5(int mno5) {
            this.mno5 = mno5;
      }
      public int getMno6() {
            return mno6;
      }
      public void setMno6(int mno6) {
            this.mno6 = mno6;
      }
      public int getMno7() {
            return mno7;
      }
      public void setMno7(int mno7) {
            this.mno7 = mno7;
      }
      public int getMno8() {
            return mno8;
      }
      public void setMno8(int mno8) {
            this.mno8 = mno8;
      }
      public int getMno9() {
            return mno9;
      }
      public void setMno9(int mno9) {
            this.mno9 = mno9;
      }
      public int getMno10() {
            return mno10;
      }
      public void setMno10(int mno10) {
            this.mno10 = mno10;
      }
      public MemberDTO() {
            super();
      }
     
      public MemberDTO(String mid, String mpw) {
            super();
            this.mid = mid;
            this.mpw = mpw;
      }
     
      public MemberDTO(String mid, Integer mno,int i) {
            super();
            this.mid = mid;
            this.i = i;
            this.mno = mno;
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