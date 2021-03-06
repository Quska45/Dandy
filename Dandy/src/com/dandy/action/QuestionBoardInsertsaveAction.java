package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.QuestionBoardDTO;
import com.dandy.action.ActionForward;

public class QuestionBoardInsertsaveAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "questionBoardList.dandy";
		
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String flag = request.getParameter("flag");
		String question_type = request.getParameter("select");
		
		System.out.println(title+ "," + writer+ "," + content+ "," + flag+ "," + question_type);
		QuestionBoardDTO qDto = new QuestionBoardDTO(title, content, writer ,question_type, flag);
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		qDao.questionInsert(qDto);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
