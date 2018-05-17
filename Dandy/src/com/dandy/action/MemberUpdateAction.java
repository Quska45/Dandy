package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MemberDAO;

public class MemberUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = null;
		
		String mid = request.getParameter("mid");
		System.out.println(mid);
		
		MemberDAO mDao = MemberDAO.getInstance();
		//mDao.memberUpdate(mid);
		
		
		return null;
	}

}
