package com.dandy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.ReplyDAO;
import com.dandy.DTO.ReplyDTO;



public class QuestionCommentListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//댓글 등록시 댓글을 띄워주는 jsp로 이동한다.
		String url = "board_commentlist2.jsp";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno:" + bno);
		
		//댓글의 리스트를 가져오는 DAO메소드를 통해 댓글 리스트를 가져와 변수에 담았다.
		ReplyDAO rDao = ReplyDAO.getInstance();
		List<ReplyDTO> replylist = rDao.questionReplyList(bno);
	
		//댓글리스트가 담긴 list를 replyview라는 이름으로 상세게시글 jsp로 보내줬
		request.setAttribute("replyview", replylist);
		
		int listCount = replylist.size();
		request.setAttribute("replycount", listCount);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
	
}
