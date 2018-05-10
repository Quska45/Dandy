package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.BoardDTO;
import com.dandy.DTO.QuestionBoardDTO;
import com.dandy.action.ActionForward;

public class QuestionAnswerAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "dandy_contents_question_board_answer.jsp";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno"+bno);
		
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		QuestionBoardDTO qDto = qDao.questionDetail(bno);
		
		qDto.setContent("=======게시물의 내용=======\n\n" + qDto.getContent());
		
		request.setAttribute("boardview", qDto);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
