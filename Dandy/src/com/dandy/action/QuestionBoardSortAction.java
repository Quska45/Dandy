package com.dandy.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.QuestionBoardDTO;
import com.dandy.DTO.CriteriaDTO;
import com.dandy.DTO.PageMakerDTO;
import com.dandy.action.ActionForward;

public class QuestionBoardSortAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "dandy_contents_question_board.jsp";
				
		String sort=request.getParameter("sort");
		System.out.println("sort:" + sort);
		
		if(sort == null || sort=="ASC"){
			sort="DESC";
		} else{
			sort="ASC";
		}
		System.out.println("sort:" + sort);

		//리스트 정렬시에 페이지를 다시 띄워야 하기 때문에 criDto가 필요하다.
		CriteriaDTO criDto = new CriteriaDTO();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		criDto.setPage(page);
		criDto.setSort(sort);
				
		//내가 원하는 정렬 키워드에 맞게 정렬된 리스트의 목록을 가져온다.
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		List<QuestionBoardDTO> list = qDao.questionSort(criDto);
		request.setAttribute("boardlist", list);
		request.setAttribute("sort", criDto.getSort());
		
		//페이지에 맞는 페이지 인덱스를 띄워줘야하기 때문에 pagemaker도 필요하다.
		PageMakerDTO pageMaker = new PageMakerDTO();
		pageMaker.setCriDto(criDto);
		int totalCount = qDao.totalCount(criDto);
		pageMaker.setTotalCount(totalCount);
		System.out.println("게시글 전체" + pageMaker.getTotalCount());
		request.setAttribute("pageMaker", pageMaker);
		
		//게시판에서 오늘 쓴 것은 날짜만 뜨고 예전에 쓴것은 일까지 뜨도록 하려고 한다.
		Date today = new Date();
		request.setAttribute("today", today);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
	}

