package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiyPageAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "diy.jsp";
		System.out.println("diypage action");
		System.out.println("url : " + url);
		
		return null;
	}

}
