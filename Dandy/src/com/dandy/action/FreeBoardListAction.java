package com.dandy.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.BoardDAO;
import com.dandy.DTO.BoardDTO;
import com.dandy.DTO.CriteriaDTO;
import com.dandy.DTO.PageMakerDTO;

public class FreeBoardListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board_list.jsp";
		
		
		String lineup_code = request.getParameter("lineup_code");
		System.out.println("lineup_code : " + lineup_code);
		
		CriteriaDTO criDto = new CriteriaDTO();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("페이지 번호" + page);
		criDto.setPage(page);
		
		criDto.setLineup_code(lineup_code);
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardDTO> boardlist = bDao.listAll(criDto);

		request.setAttribute("boardlist", boardlist);
		
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
