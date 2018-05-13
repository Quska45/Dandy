package com.dandy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MovieDAO;
import com.dandy.DTO.MovieEachDTO;
import com.dandy.DTO.MovieIndexDTO;

public class MypageContentsDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "dandy_contents_mypage_movie_detail.jsp";
		
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
		double manview1 = 0; 
		double womanview1 = 0;
		double view_101 = 0;
		double view_201 = 0;
		double view_301 = 0;
		double view_401 = 0;
		double view_501 = 0;
		
		for (MovieIndexDTO movieIndexDTO : list2) {
			manview1 = movieIndexDTO.getMno();
			womanview1 = movieIndexDTO.getWomanview();
			view_101 = movieIndexDTO.getView_10();
			view_201 = movieIndexDTO.getView_20();
			view_301 = movieIndexDTO.getView_30();
			view_401 = movieIndexDTO.getView_40();
			view_501 = movieIndexDTO.getView_50();
		}
		
		double manview = manview1/(manview1 + womanview1);
		double womanview = womanview1/(manview1 + womanview1);
		double view_10 = view_101/(view_101 + view_201 + view_301 + view_401 + view_501);
		double view_20 = view_201/(view_101 + view_201 + view_301 + view_401 + view_501);
		double view_30 = view_301/(view_101 + view_201 + view_301 + view_401 + view_501);
		double view_40 = view_401/(view_101 + view_201 + view_301 + view_401 + view_501);
		double view_50 = view_501/(view_101 + view_201 + view_301 + view_401 + view_501);

		
		request.setAttribute("manview", manview);
		request.setAttribute("womanview", womanview);
		request.setAttribute("view_10", view_10);
		request.setAttribute("view_20", view_20);
		request.setAttribute("view_30", view_30);
		request.setAttribute("view_40", view_40);
		request.setAttribute("view_50", view_50);
		
		request.setAttribute("title", title);
		request.setAttribute("img", img);
		request.setAttribute("size", size);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
