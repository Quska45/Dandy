package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MemberDAO;

public class IndexAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "index.jsp";
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.test();
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
