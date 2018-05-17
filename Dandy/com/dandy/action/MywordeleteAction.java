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

public class MywordeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="contents_detail.jsp";
        Integer mno = Integer.parseInt(request.getParameter("mno"));
        String mid = request.getParameter("mid");
        System.out.println(mno + ", " + mid);
        
        MovieDTO movieDto = new MovieDTO();
        MovieDAO movieDao = MovieDAO.getInstance();
        MemberDAO mDao = MemberDAO.getInstance();
   
        
        for(int i=1; i<11; i++){
              movieDto = movieDao.getMyPageMovieList(mid, i);
              if(movieDto==null){
            	  System.out.println("이 사용자의 " + i + "번째단어장은 비어 있습니다.");
              } else {
            	  System.out.println("mno:" + movieDto.getMno());
            	  if(movieDto.getMno()== mno){
            		  System.out.println(movieDto.getMno() + " == " +mno );
            		  //사용자의 아이디, 삭제를 원하는 단어장의 번호, for문의 i를 mDto에 담아준다.
            		  MemberDTO mDto = new MemberDTO(mid, mno, i);
            		  mDao.mywordDelete(mDto);
            		  System.out.println(i+"번째 단어장이 삭제됐습니다.");
            	  }
              }
        }
        
        ActionForward forward = new ActionForward();
        
        forward.setPath(url);
        forward.setRedirect(false);
        
        return forward;
	}

}
