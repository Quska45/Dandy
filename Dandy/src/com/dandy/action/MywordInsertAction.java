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
public class MywordInsertAction implements Action{
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
            List<MovieDTO> list = new ArrayList<>();
            
            for(int i=1; i<11; i++){
                  movieDto = movieDao.getMyPageMovieList(mid, i);
                  if(movieDto==null){
                	  System.out.println("이 사용자의 " + i + "번째단어장은 비어 있습니다.");
                  } else {
                	  System.out.println("mno:" + movieDto.getMno());
                	  list.add(movieDto);
                	  
                  }
            }
            
            MemberDAO mDao = MemberDAO.getInstance();
            int listsize = list.size();
            int result=0;
            System.out.println("listsize:" + listsize);
            if(listsize<10){
                  MemberDTO mDto = new MemberDTO(mid,mno,listsize+1);
                  System.out.println(listsize+"영화를 추가할 수 있습니다.");
                  result = mDao.mywordUpdate(mDto);
            } else if(listsize>=10){
                  System.out.println(listsize+"영화를 추가할 수 없습니다.");
            }
            
            ActionForward forward = new ActionForward();
            
            forward.setPath(url);
            forward.setRedirect(false);
            
            return forward;
      }
      
}