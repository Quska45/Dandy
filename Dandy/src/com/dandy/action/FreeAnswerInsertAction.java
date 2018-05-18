package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.FreeBoardDTO;
import com.dandy.DTO.QuestionBoardDTO;

public class FreeAnswerInsertAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "freeBoardList.dandy";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println(bno + ", " + title  + ", " + content  + ", " + writer);
		
		FreeBoardDAO ffDao = FreeBoardDAO.getInstance();
		FreeBoardDTO ffDto = ffDao.boardDetailView(bno);
		
		int ref = ffDto.getRef();
		int re_step = ffDto.getRe_step() + 1;
		int re_level = ffDto.getRe_level() + 1;
		
		ffDao.updateStep(ref, re_step);
		
		FreeBoardDAO fDao = FreeBoardDAO.getInstance();
		FreeBoardDTO fDto = new FreeBoardDTO(title, content, writer, ref, re_step, re_level);
		fDao.answerInsert(fDto);
		
		System.out.println("bno" + bno + "title" + title + " content" + content + "writer" + writer);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
	

}
