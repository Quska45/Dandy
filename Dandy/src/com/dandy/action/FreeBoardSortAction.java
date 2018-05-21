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

public class FreeBoardSortAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "dandy_contents_free_board.jsp";
		
		String sort = request.getParameter("sort");
		String keyword = request.getParameter("keyword");
		System.out.println("sort : " + sort);
		System.out.println("Keyword : " + keyword);
		
		if(sort == "" || sort.equals("DESC")) {
			sort="ASC";
		} else {
			sort = "DESC";
		}
		System.out.println("sort : " + sort);
		
		CriteriaDTO criDto = new CriteriaDTO();
		int page = 1;		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		criDto.setPage(page);
		criDto.setSort(sort);
		criDto.setKeyword(keyword);
		
		FreeBoardDAO fDao = FreeBoardDAO.getInstance();	
		List<FreeBoardDTO> list = fDao.freeboardSort(criDto);
		request.setAttribute("freeboardlist", list);
		request.setAttribute("sort", sort);
		
		System.out.println("2222222sort : " + sort);
		
		PageMakerDTO pageMaker = new PageMakerDTO();
		pageMaker.setCriDto(criDto);
		int totalCount = fDao.totalCount(criDto);
		pageMaker.setTotalCount(totalCount);
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