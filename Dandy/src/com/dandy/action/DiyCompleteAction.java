package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiyCompleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "constract.jsp";
		String title = request.getParameter("diy_title");
		String text = request.getParameter("diy_text");
		
		System.out.println(title + ", " + text);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
