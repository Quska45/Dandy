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


public class MovieListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "dandy_contents_movie.jsp";
		String index = request.getParameter("index");
		System.out.println("index : " +  index);
		if(index == null) {
			index = "empty";
		}
		
		MovieCriteriaDTO CriDto = new MovieCriteriaDTO();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("페이지 번호 : " + page);
		CriDto.setPage(page);
		CriDto.setIndex(index);
		
		
		MovieDAO mDao = MovieDAO.getInstance();
		List<MovieDTO> list = mDao.movieList(CriDto); // = 게시글 목록
		request.setAttribute("movieList", list);
		
		
		
		
		//페이지 메이커
		MoviePageMakerDTO moviePageMaker = new MoviePageMakerDTO();
		moviePageMaker.setCriDto(CriDto);
		moviePageMaker.setTotalCount(mDao.totalCount(CriDto));
		
		request.setAttribute("pageMaker", moviePageMaker);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	
	}

}
