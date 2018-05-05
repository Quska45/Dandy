package com.dandy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.QuestionBoardDTO;

public class BoardList2Action implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "board_list2.jsp";
		
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		List<QuestionBoardDTO> list = qDao.boardlist2();
		
		request.setAttribute("boardlist", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}
	
}
