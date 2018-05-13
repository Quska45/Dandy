package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MemberDAO;
import com.dandy.DTO.MemberDTO;

public class MywordInsertAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mno = request.getParameter("mno");
		String mid = request.getParameter("mid");
		System.out.println(mno + ", " + mid);
		
		MemberDTO mDto = new MemberDTO();
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.mywordInsert();
		return null;
	}
	
}
