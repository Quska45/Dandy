package com.dandy.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DTO.FreeBoardDTO;
import com.dandy.DTO.CriteriaDTO;
import com.dandy.DTO.PageMakerDTO;


public class FreeBoardSearchAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "dandy_contents_free_board.jsp";
		
		String keyword = request.getParameter("keyword");		
		String flag = request.getParameter("type");	
		
		CriteriaDTO criDto = new CriteriaDTO();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		System.out.println("페이지 번호" + page);
		
		criDto.setPage(page);
		criDto.setFlag(flag);
		criDto.setKeyword(keyword);
		
		FreeBoardDAO bDao = FreeBoardDAO.getInstance();
		List<FreeBoardDTO> fboardlist = bDao.boardSearch(criDto);
		request.setAttribute("freeboardlist", fboardlist);
		
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
