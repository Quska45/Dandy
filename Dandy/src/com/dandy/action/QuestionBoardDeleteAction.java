package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.QuestionBoardDAO;

public class QuestionBoardDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "dandy_contents_question_board.jsp";
		System.out.println("왜 안타는 거야?");
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno" + bno);
		
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		qDao.questionDelete(bno);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	
	
	
	}
	
}
