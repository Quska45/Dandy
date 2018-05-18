package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dandy.DAO.MemberDAO;
import com.dandy.DTO.MemberDTO;

public class MemberPWChangeAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("pw1");
		String mname = request.getParameter("mname");
		String msex = request.getParameter("mgender");
		String mbirth = request.getParameter("mbirth");
		String memail = request.getParameter("memail");
		String mphone = request.getParameter("mphone");
		
		System.out.println(mid +"의 비밀번호 변경 : "+ mpw);
		HttpSession session = request.getSession();
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = new MemberDTO(mid, mpw, mname, msex, mbirth, memail, mphone);
		
		int result = mDao.memberPWChange(mDto);
		
		mDto = mDao.memberpwchangeselect(mid);
		
		if(result > 0) {
			System.out.println("비밀번호 변경 성공");
			session.setAttribute("loginUser", mDto);
			System.out.println("세션값에 담아주기 성공");
		} else{
			System.out.println("비밀번호 변경 실패");
		}
		JSONObject jObj = new JSONObject();
		jObj.put("result", result);
		
		response.setContentType("application/x-json); charset=UTF-8");
		response.getWriter().println(jObj);
		
		
		return null;
		
	}

}