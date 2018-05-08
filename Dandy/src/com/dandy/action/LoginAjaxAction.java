package com.dandy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dandy.DAO.MemberDAO;
import com.dandy.DTO.MemberDTO;

public class LoginAjaxAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mid=request.getParameter("id");
		String mpw=request.getParameter("pw");
		System.out.println("LoginAjaxAction에서 login.jsp에서 값을 가져오는지 확인하기 위한 출력문 이다. mid" + mid + "mpw" + mpw);
		
		HttpSession session = request.getSession();
		
		MemberDTO mDto = null;
		
		if(mid != null && mpw != null) {
			if(mid.trim().equals("") == false) {
				MemberDAO mDao = MemberDAO.getInstance();
				
				mDto = mDao.sessionLogin(mid, mpw);
				
				if(mDto != null) {
					session.removeAttribute("loginUser");//혹시모를 남아있는 값 제거
					session.setAttribute("loginUser", mDto);//세션에 값 담기. 세션이 만료되기 전까지 세션은 mDto를 계속 가지고 있다.
				}
				
			}
			
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("id", mDto.getMid());
		jObj.put("pw", mDto.getMpw());
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jObj);
		
		return null;
	}

}
