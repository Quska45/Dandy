package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dandy.DAO.MemberDAO;
import com.dandy.DTO.MemberDTO;

public class MemberUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String msex = request.getParameter("mgender");
		String mbirth = request.getParameter("mbirth");
		String memail = request.getParameter("memail");
		String mphone = request.getParameter("mphone");
		
		System.out.println(mid + ", "+ mname + ", "+  msex + ", "+ mbirth + ", "+ memail + ", "+ mphone);
		
		HttpSession session = request.getSession();
		
		
		// 데이터베이스 데이터: ID: stopline PW:1234
		// SESSION: ID: stopline PW:1234
		
		// update하기위한 데이터는 ID:stopline2 PW:5678
		// 수정 성공 하면 ->
		// 데이터베이스 데이터: ID:stopline2 PW:5678
		// SESSION을 수정된 데이터로 변환해줘야함
		// 데이터베이스 데이터를 조회해서 가지고와서 SESSION 넣어준다.(DB 또탐)
		// SESSION <- 데이터베이스 데이터: ID:stopline2 PW:5678
		// session 데이터를 View단 출력
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		// Update 성공하면 -> SESSION 수정하려고 VIEW단에서 가지고 온 데이터를 그대로 넣어주면 된다.
		MemberDTO mDto = new MemberDTO(mid, mpw, mname, msex, mbirth, memail, mphone); // 수정하려고 가져온 데이터

		int result = mDao.memberUpdate(mDto);
		
		
		if (result > 0 ) {
			System.out.println("Update 성공");
			System.out.println("View단 데이터를 Session에 추가");
			session.setAttribute("loginUser", mDto);
		} else {
			System.out.println("Update 실패");
		}
		
		
		System.out.println("git version reset commit!!!");
		
		JSONObject jObj = new JSONObject();
		jObj.put("result", result);
		
		response.setContentType("application/x-json); charset=UTF-8");
		response.getWriter().println(jObj);
		
		
		return null;
	}

}
