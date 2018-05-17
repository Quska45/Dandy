package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.ReplyDAO;

public class FreeReplyDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer rno = Integer.parseInt(request.getParameter("rno"));
		System.out.println("rno" + rno);
		
		//DAO를 통해 댓글을 삭제 한다.
		ReplyDAO rDao = ReplyDAO.getInstance();
		rDao.freeReplyDelete(rno);
		
		JSONObject jobj = new JSONObject();
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jobj);
		
		return null;
}
}
