package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.QuestionBoardDTO;

public class QuestionBoardUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="board_question_write_update.jsp";
		Integer bno = Integer.parseInt(request.getParameter("bno"));

		
		System.out.println(bno);
		
		QuestionBoardDTO qDto = new QuestionBoardDTO();
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		qDto = qDao.questionSelectOne(bno);
		
		request.setAttribute("boardview", qDto);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
