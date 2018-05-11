package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DTO.FreeBoardDTO;

public class FreeBoardUpdateViewAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "updateqna.jsp";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno =" + bno);
		
		FreeBoardDAO fDao = FreeBoardDAO.getInstance();
		FreeBoardDTO fDto = fDao.boardDetailView(bno);
		
		request.setAttribute("boardupdate", fDto);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
				
		return forward;
		
	}

}
