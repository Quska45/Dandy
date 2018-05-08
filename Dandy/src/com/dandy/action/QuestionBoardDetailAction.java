package com.dandy.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DAO.ReplyDAO;
import com.dandy.DTO.QuestionBoardDTO;
import com.dandy.DTO.ReplyDTO;

public class QuestionBoardDetailAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "dandy_contents_question_board_detail.jsp";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno" + bno);
		
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		QuestionBoardDTO qDto = qDao.questionDetail(bno);
		
		request.setAttribute("boardview", qDto);
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
