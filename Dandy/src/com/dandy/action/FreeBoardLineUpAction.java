package com.dandy.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.CriteriaDTO;
import com.dandy.DTO.FreeBoardDTO;
import com.dandy.DTO.PageMakerDTO;
import com.dandy.DTO.QuestionBoardDTO;

public class FreeBoardLineUpAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "dandy_contents_free_board.jsp";
		
		String lineup_code = request.getParameter("lineup_code");
		String sort = request.getParameter("sort");
		System.out.println("lineup_code : " + lineup_code);
		System.out.println("sort : " + sort);
		
		if(lineup_code.equals("fl_no")) {
			System.out.println("게시판 번호순으로 정렬");
		} else if(lineup_code.equals("fl_contents")) {
			System.out.println("게시판 제목순으로 정렬");
		} else if(lineup_code.equals("fl_name")) {
			System.out.println("게시판 작성자순으로 정렬");
		} else if(lineup_code.equals("fl_date")) {
			System.out.println("게시판 날짜순으로 정렬");
		} else if(lineup_code.equals("fl_view")) {
			System.out.println("게시판 조회순으로 정렬");
		} else if(lineup_code.equals("fl_good")) {
			System.out.println("게시판 좋아요순으로 정렬");
		}
		
		CriteriaDTO criDto = new CriteriaDTO();
		int page = 1;		
		if(request.getParameter("page") != null) {
		page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("페이지 번호 : " + page);
		criDto.setPage(page);
		criDto.setLineup_code(lineup_code);
		criDto.setSort(sort);
		
		FreeBoardDAO bDao = FreeBoardDAO.getInstance();	
		List<FreeBoardDTO> boardlist = bDao.freeboardlineup(criDto);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("sort", criDto.getSort());
		
		PageMakerDTO pageMaker = new PageMakerDTO();
		pageMaker.setCriDto(criDto);
		int result = bDao.totalCount(criDto);
		pageMaker.setTotalCount(result);
		System.out.println("게시글 전체" + pageMaker.getTotalCount());
		request.setAttribute("pageMaker", pageMaker);
		
		Date date = new Date();
		request.setAttribute("today", date);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}
}