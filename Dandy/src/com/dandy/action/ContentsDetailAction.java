package com.dandy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MovieDAO;
import com.dandy.DTO.MovieEachDTO;

public class ContentsDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "contents_detail.jsp";
		
		String mno = request.getParameter("mno");
		String tablename = "movie" + mno;
		String img = request.getParameter("img");
		String title = request.getParameter("title");
		System.out.println("영화 번호 : " + mno);
		System.out.println("영화 이미지 : " + img);
		System.out.println("영화 제목 : " + title);
		System.out.println("테이블명 : " + tablename);
		MovieEachDTO mDto = new MovieEachDTO();
		mDto.setTablename(tablename);
		
		
		MovieDAO mDao = MovieDAO.getInstance();
		List<MovieEachDTO> list = mDao.movieEach(mDto);
		int size = list.size();
		request.setAttribute("movieEach", list);
		
		
		request.setAttribute("title", title);
		request.setAttribute("img", img);
		request.setAttribute("size", size);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
