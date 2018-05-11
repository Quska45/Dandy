package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;

public class FreeBoardDeleteAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		
		System.out.println("******************************NO. "+ bno + "삭제");
		
		// *** 글이 지워지기 전에 해당 글 번호의 리플 먼저 삭제
		// 1. 잔업 : 해당 게시글의 리플 삭제 (cascadeReplyDel)
		//ReplyDAO rDao = ReplyDAO.getInstance();
		//int rd_result = rDao.replyDeleteWithBoard(bno);
		
		// 본래 실행 명령
		// 2.명령 : 게시글 삭제 실행
		FreeBoardDAO fDao = FreeBoardDAO.getInstance();
		int result = fDao.boardDelete(bno);
		
		if(result > 0) {
			System.out.println("게시글 삭제 성공");
			url = "freeBoardList.dandy";
		} else {
			System.out.println("게시글 삭제 실패");
			url = "index.dandy";
		}
		
		/*if(rd_result > 0) {
			System.out.println("Action단에서 리플 삭제 확인 완료 : " + bno);
		} else {
			System.out.println("Action단에서 리플 삭제 확인 실패 : " + bno);
		}*/
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
				
		return forward;
		
	}

}
