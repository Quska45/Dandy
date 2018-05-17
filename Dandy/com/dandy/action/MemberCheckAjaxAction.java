package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.MemberDAO;


public class MemberCheckAjaxAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("id");
		System.out.println("id : " + mid);
		
		if(mid != null) {
			if(mid.trim().equals("") == false) {
				MemberDAO mDao = MemberDAO.getInstance();
				int flag = mDao.memIdCheck(mid);
				System.out.println("flag = " + flag);
				
				JSONObject jObj = new JSONObject();
				jObj.put("flag", flag);
				
				response.setContentType("application/x-json); charset=UTF-8");
				response.getWriter().println(jObj);
				
			}
		}
		
		return null;
	}

}
