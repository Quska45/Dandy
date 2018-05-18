package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardWriteAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String url = "dandy_contents_free_board_write.jsp";
				
			ActionForward forward = new ActionForward();
			forward.setPath(url);
			forward.setRedirect(false);

			return forward;
		}

}
