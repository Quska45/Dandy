package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dandy.DAO.BoardDAO;
import com.dandy.DTO.BoardDTO;

public class FreeBoardDetailAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "dandy_contents_free_board_detail.jsp";	// 게시글 상세페이지 출력
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("게시글 번호 = " + bno);
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		// ---조회수 1 증가---
		// ***조회수 증가 방지*** (1. IP, 2. Cookie, 3. Session-server)
		// * Session을 이용한 방법
		HttpSession session = request.getSession();
		bDao.boardViewCnt(bno, session);
		
		
		// 상세 게시글 출력
		BoardDTO bDto = bDao.boardDetailView(bno);
		request.setAttribute("boardview", bDto);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}
	

}