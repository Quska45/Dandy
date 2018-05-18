package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dandy.DAO.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		
		
		System.out.println(mid + "님의 회원탈퇴 요청!!!!!");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.memberDelete(mid);
		int flag = 0;
		HttpSession session = request.getSession(false);
		
		
		
		System.out.println("result : " + result);
		
		if(result > 0) {
			System.out.println("회원탈퇴 성공");
			if(session != null) { 
				session.invalidate();
				flag = 1;
			}
		} else {
			System.out.println("회원탈퇴 실패");
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("flag", flag);
		jObj.put("result", result);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jObj);
		
		return null;
	}

}
