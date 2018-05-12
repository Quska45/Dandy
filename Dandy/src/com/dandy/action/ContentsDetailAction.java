package com.dandy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MovieDAO;
import com.dandy.DTO.MovieEachDTO;
import com.dandy.DTO.MovieIndexDTO;

public class ContentsDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "contents_detail.jsp";
		
		String mno = request.getParameter("mno");
		String tablename = "movie" + mno;
		int mno2 = Integer.parseInt(mno);
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
		
		List<MovieIndexDTO> list2 = mDao.movieStatistics(mno2);
		request.setAttribute("movieStat", list2);
		/*int manview = 0; 
		int womanview = 0;
		int view_10 = 0;
		int view_20 = 0;
		int view_30 = 0;
		int view_40 = 0;
		int view_50 = 0;
		
		for (MovieIndexDTO movieIndexDTO : list2) {
			manview = movieIndexDTO.getMno();
			womanview = movieIndexDTO.getWomanview();
			view_10 = movieIndexDTO.getView_10();
			view_20 = movieIndexDTO.getView_20();
			view_30 = movieIndexDTO.getView_30();
			view_40 = movieIndexDTO.getView_40();
			view_50 = movieIndexDTO.getView_50();
		}
		
		int manview_result = manview/(manview + womanview) * 100;
		int womanview_result = womanview/(manview + womanview) * 100;*/
		
		
		
		request.setAttribute("title", title);
		request.setAttribute("img", img);
		request.setAttribute("size", size);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
