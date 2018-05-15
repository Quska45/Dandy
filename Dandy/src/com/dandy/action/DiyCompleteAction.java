package com.dandy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dandy.DAO.DiyDAO;
import com.dandy.DTO.MovieEachDTO;

public class DiyCompleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "diy_complete.jsp";
		String title3 = request.getParameter("title");
		String text2 = request.getParameter("text");
		
		String title2 = title3.replaceAll("\"", "");
		String title1 = title2.replaceAll("'", "");
		String title = title1.replaceAll(" ", "_");
		
		String text1 = text2.replaceAll("\"", "");
		String text = text1.replaceAll("'", "");
		
		System.out.println(title + ", " + text);
		
		MovieEachDTO mDto = new MovieEachDTO();
		DiyDAO mDao = DiyDAO.getInstance();
		mDao.textMining(title, text);
		
		mDto.setTitle(title);
		mDao.alterTable(mDto);
		mDao.selectWord(mDto);
		//mDao.nullDelete(mDto);
		//mDao.updateNull(mDto);
		mDao.delete(title);
		mDao.selectWno(mDto);
		List<MovieEachDTO>list = mDao.resultWord(mDto);
		int size = list.size();
		
		request.setAttribute("list", list);
		request.setAttribute("title", title3);
		request.setAttribute("size", size);
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
