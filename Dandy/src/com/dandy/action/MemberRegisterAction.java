package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MemberDAO;
import com.dandy.DTO.MemberDTO;

public class MemberRegisterAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = null;
		
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		String mname = request.getParameter("name");
		String sex = request.getParameter("sex");
		String msex = null;
		if(sex.equals("1")) {
			msex = "남성";
		} else if (sex.equals("2")) {
			msex = "여성";
		}
		String yy = request.getParameter("yy");
		String mm = request.getParameter("mm");
		String dd = request.getParameter("dd");
		String mbirth = yy + mm + dd;
		String memail1 = request.getParameter("email1");
		String memail2 = request.getParameter("email2");
		String memail = memail1 + "@" + memail2;
		String mphone = request.getParameter("phone");
		
		System.out.println(mid + ", " + mpw + ", " + mname + ", " + msex + ", " + mbirth + ", " + memail + ", " + ", " + mphone);
		
		
		MemberDTO mDto = new MemberDTO(mid, mpw, mname, msex, mbirth, memail, mphone);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.registerMember(mDto);
		
		if(result > 0) {
			System.out.println("등록 성공");
			url = "index.dandy";
		} else {
			System.out.println("등록 실패");
			url = "member.dandy";
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
		
	}

}
