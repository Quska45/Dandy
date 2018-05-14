package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dandy.DAO.DiyDAO;

public class DiyCompleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "diy_complete.jsp";
		String title2 = request.getParameter("title");
		String text2 = request.getParameter("text");
		
		String title1 = title2.replaceAll("\"", "");
		String title = title1.replaceAll("'", "");
		
		String text1 = text2.replaceAll("\"", "");
		String text = text1.replaceAll("'", "");
		
		
		System.out.println(title + ", " + text);
		
		
		DiyDAO mDao = DiyDAO.getInstance();
		mDao.textMining(title, text);
		
		
		
		
		
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
