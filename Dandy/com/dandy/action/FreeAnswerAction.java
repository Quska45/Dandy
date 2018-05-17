package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DTO.FreeBoardDTO;


public class FreeAnswerAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "dandy_contents_free_board_answer.jsp";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno"+bno);
		
		FreeBoardDAO fDao = FreeBoardDAO.getInstance();
		FreeBoardDTO fDto = fDao.boardDetailView(bno);
		
		fDto.setContent("=======게시물의 내용=======\n\n" + fDto.getContent());
		
		request.setAttribute("boardview", fDto);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
