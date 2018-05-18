package com.dandy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.ReplyDAO;
import com.dandy.DTO.ReplyDTO;

public class FreeCommentListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "dandy_contents_free_board_commentlist.jsp";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno:" + bno);
		
		ReplyDAO rDao = ReplyDAO.getInstance();
		List<ReplyDTO> replylist = rDao.freeReplyList(bno);
	
		request.setAttribute("replyview", replylist);
		
		int listCount = replylist.size();
		request.setAttribute("re_count", listCount);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
}
