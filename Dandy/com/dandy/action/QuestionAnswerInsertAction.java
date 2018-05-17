package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.QuestionBoardDTO;
import com.dandy.action.ActionForward;

public class QuestionAnswerInsertAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "questionBoardList.dandy";
		
		//게시글 등록 페이지 에서 입력한 내용들을 변수에 저장했다.
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println(bno + ", " + title  + ", " + content  + ", " + writer);
		
		QuestionBoardDAO qqDao = QuestionBoardDAO.getInstance();
		//상위 상세 게시글의 내용
		QuestionBoardDTO qqDto = qqDao.questionDetail(bno);
		
		//ref : 기존 게시글 bno
		//re_step : 기존 게시글의 re_step + 1
		//re_level : 기존 답변 단계 re_level + 1 
		int ref = qqDto.getRef();
		int re_step = qqDto.getRe_step() + 1;
		int re_level = qqDto.getRe_level() + 1;
		
		
		//답글 순서 조정(re_step)
		qqDao.updateStep(ref, re_step);
		
		
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		QuestionBoardDTO qDto = new QuestionBoardDTO(title, content, writer, ref, re_step, re_level);
		qDao.answerInsert(qDto);
		
		
		
		System.out.println("bno" + bno + "title" + title + " content" + content + "writer" + writer);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
	
}
