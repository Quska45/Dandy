package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DTO.FreeBoardDTO;

public class FreeBoardUpdateViewAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "dandy_contents_free_board_update.jsp";
		System.out.println("게시글 수정 페이지");
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		
		System.out.println("수정할 게시글 bno =" + bno);
		
		FreeBoardDAO fDao = new FreeBoardDAO();
		FreeBoardDTO fDto = fDao.boardUpdateView(bno);
		
		
		
		bno = fDto.getBno();
		String title = fDto.getTitle();
		String content = fDto.getContent();
		String writer = fDto.getWriter();
		System.out.println("action update fDto : " + bno + ", " + title + ", " + content + ", " + writer);
		
		request.setAttribute("bno", bno);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		
		/*JSONObject jObj = new JSONObject();
		jObj.put("bno", bno);
		jObj.put("title", title);
		jObj.put("content", content);
		
		response.setContentType("application/x-json); charset=UTF-8");
		response.getWriter().println(jObj);*/
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
				
		return forward;
		
	}

}
