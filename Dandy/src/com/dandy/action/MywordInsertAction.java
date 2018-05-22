package com.dandy.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
            MemberDAO mDao = MemberDAO.getInstance();
            int listsize = 0;
            //추가하려는 영화가 단어장에 추가되어 있으면 1이고 추가되어 있지 않으면 0
            int flag=0;
            
            for(int i=1; i<11; i++){
            	movieDto = movieDao.getMyPageMovieList(mid, i);
            	if(movieDto == null){
            		System.out.println(i + "번째 단어장은 비어 있습니다.");
            	} else if(mno==movieDto.getMno()){
            		System.out.println("이 영화는 " + i + "번째 단어장에 추가 되어 있습니다.");
            		flag = 1;
            	} else if(mno!=movieDto.getMno()){
            		System.out.println(i + "번째 단어장에는 이 영화가 추가 되어 있지 않습니다.");
            	}
            }

            
            if(flag==1){
            	System.out.println("이 영화는 이미 추가되어 있기 때문에 추가 할 수 없습니다.");
            } else {
            	for(int i=1; i<11; i++){
                    movieDto = movieDao.getMyPageMovieList(mid, i);
                    if(movieDto==null){
                  	  System.out.println("이 사용자의 " + i + "번째단어장은 비어 있습니다.");
                  	  MemberDTO mDto = new MemberDTO(mid,mno,i);
                  	  mDao.mywordUpdate(mDto);
                  	  break;
                    } else {
                  	  System.out.println("mno:" + movieDto.getMno());
                  	  System.out.println("이 사용자의 " + i + "번째단어장은 채워져 있습니다.");
                  	  if(i==10){
                  		  listsize=10;
                  	  }
                    }
              }
            }
            
           
            
           
            
            System.out.println("listsize:" + listsize);
            
            
            JSONObject jObj = new JSONObject();
    		jObj.put("flag", listsize);
    		jObj.put("flag2", flag);
    		
    		response.setContentType("application/x-json; charset=UTF-8");
    		response.getWriter().println(jObj);
            
           
            
            return null;
      }
      
}