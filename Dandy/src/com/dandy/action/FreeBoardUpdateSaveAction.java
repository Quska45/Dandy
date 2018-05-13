package com.dandy.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DTO.FreeBoardDTO;

public class FreeBoardUpdateSaveAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		System.out.println("action도착");
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		
		System.out.println("bno : " + bno );
		
		String title = request.getParameter("title");

		System.out.println("title : " + title );
		
		String content = request.getParameter("content");

		System.out.println("content : " + content );
		
		String writer = request.getParameter("writer");

		System.out.println("writer : " + writer );
		
		System.out.println(bno + ", " + title + ", " + content + ", " + writer);
		
		FreeBoardDAO fDao = FreeBoardDAO.getInstance();
		FreeBoardDTO fDto = new FreeBoardDTO();
		fDto.setBno(bno);
		fDto.setTitle(title);
		fDto.setContent(content);
		fDto.setWriter(writer);
				
		int result = fDao.boardUpdate(fDto);
		// 게시글을 실제로 등록하고, 게시글 등록 후 게시글 목록 페이지로 이동
		if(result > 0) {
			System.out.println("게시글 수정 성공");
			url = "freeBoardList.dandy";
		} else {
			System.out.println("게시글 수정 실패");
			url = "index.dandy";
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
				
		return forward;
	}
	
}
