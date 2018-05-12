package com.dandy.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.MemberDAO;
import com.dandy.DAO.MovieDAO;
import com.dandy.DTO.MemberDTO;
import com.dandy.DTO.MovieDTO;

public class MypageMovieListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="mypage.jsp";
		String mid = request.getParameter("mid");
		System.out.println("mid");
		
/*		MemberDTO mDto = new MemberDTO();
		MemberDAO mDao = MemberDAO.getInstance();
		mDto = mDao.getMno(mid);
*/		MovieDTO mDto = new MovieDTO();
		MovieDAO mDao = MovieDAO.getInstance();
		List<MovieDTO> list = new ArrayList<>();
		
		for(int i=1; i<11; i++){
			mDto = mDao.getMyPageMovieList(mid, i);
			System.out.println(mDto.getTitle());
			System.out.println(mDto.getImg());
			list.add(mDto);
		}
		
		request.setAttribute("memlist", mDto);
		request.setAttribute("movieList", list);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
