package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rosuda.REngine.Rserve.RserveException;

import com.dandy.DAO.DiyDAO;

public class DiyCompleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "diy_complete.jsp";
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		
		System.out.println(title + ", " + text);
		
		
		DiyDAO mDao = DiyDAO.getInstance();
		mDao.textMining(title, text);
		
		
		
		
		
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
