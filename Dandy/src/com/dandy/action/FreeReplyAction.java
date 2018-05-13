package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.ReplyDAO;
import com.dandy.DTO.ReplyDTO;

public class FreeReplyAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		String content = request.getParameter("re_input");
		String writer = request.getParameter("rn_input");
		Integer bno = Integer.parseInt(request.getParameter("re_bno"));
		System.out.println(content + ", " + writer + ", " + bno);
		
		ReplyDTO rDto = new ReplyDTO(content, writer, bno);
		ReplyDAO rDao = ReplyDAO.getInstance();
		int result = rDao.freeReplyInsert(rDto);
		
		if(result > 0) {
			System.out.println("댓글 등록 성공");
		} else {
			System.out.println("댓글 등록 실패");
		}
		
		JSONObject jObj = new JSONObject();

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jObj);
		
		return null;
	}

}
