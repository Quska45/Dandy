package com.dandy.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MovieDAO;
import com.dandy.DTO.CriteriaDTO;
import com.dandy.DTO.MovieCriteriaDTO;
import com.dandy.DTO.MovieDTO;
import com.dandy.DTO.MoviePageMakerDTO;
import com.dandy.DTO.PageMakerDTO;


public class MovieSearchListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "dandy_contents_movie.jsp";
		String keyword = request.getParameter("keyword");
		System.out.println("keyword : " + keyword);
		String index = "empty";
		
		MovieCriteriaDTO CriDto = new MovieCriteriaDTO();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("페이지 번호 : " + page);
		CriDto.setPage(page);
		CriDto.setKeyword(keyword);
		
		
		MovieDAO mDao = MovieDAO.getInstance();
		List<MovieDTO> list = mDao.movieSearchList(CriDto); // = 게시글 목록
		int search_size = list.size();
		request.setAttribute("movieList", list);
		request.setAttribute("search_size", search_size);
		
		
		//페이지 메이커
		MoviePageMakerDTO moviePageMaker = new MoviePageMakerDTO();
		moviePageMaker.setCriDto(CriDto);
		moviePageMaker.setTotalCount(mDao.totalSearchCount(CriDto));
		
		request.setAttribute("pageMaker", moviePageMaker);
		request.setAttribute("index", index);
		request.setAttribute("keyword", CriDto.getKeyword());
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	
	}

}