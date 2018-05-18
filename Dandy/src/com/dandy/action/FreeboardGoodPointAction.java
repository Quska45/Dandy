package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.FreeBoardDAO;


public class FreeboardGoodPointAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String url = "dandy_contents_free_board_detail.jsp";
			
			Integer bno = Integer.parseInt(request.getParameter("bno"));
			
			System.out.println(bno);
			
			FreeBoardDAO fDao = new FreeBoardDAO();
			int gpoint;
			gpoint = fDao.boardGpoint(bno);
			
			request.setAttribute("gpoint", gpoint);
			JSONObject jObj = new JSONObject();
			jObj.put("gpoint", gpoint);
	
			response.setContentType("application/x-json); charset=UTF-8");
			response.getWriter().println(jObj);
	
			return null;
		
	}

}
