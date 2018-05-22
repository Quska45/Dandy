package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.QuestionBoardDAO;


public class QuestionBoardGoodcntAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		
		System.out.println(bno);
		
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		int gpoint = qDao.questionGoodcnt(bno);
		
		request.setAttribute("gpoint", gpoint);
		JSONObject jObj = new JSONObject();
		jObj.put("gpoint", gpoint);

		response.setContentType("application/x-json); charset=UTF-8");
		response.getWriter().println(jObj);
		
		return null;
	}

}
