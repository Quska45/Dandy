package com.dandy.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.DAO.FreeBoardDAO;
import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.FreeBoardDTO;
import com.dandy.DTO.QuestionBoardDTO;
import com.dandy.common.Constants;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FreeAnswerInsertAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String url = "freeBoardList.dandy";
		
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println(bno + ", " + title  + ", " + content  + ", " + writer);*/
		
		String url = "index.dandy";
		//파일 업로드 처리
		File uploadDir = new File(Constants.UPLOAD_PATH);

		// 파일을 저장할 디렉토리가 존재하지 않다면 디렉토리 생성
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// request를 확장시킨 MultipartRequest 생성
		// new MultipartRequest(request, 파일업로드 디렉토리, 업로드 용량, 인코딩, 파일이름중복정책)
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, Constants.UPLOAD_PATH, Constants.MAX_UPLOAD, "UTF-8",
				policy);
		Integer bno = Integer.parseInt(multi.getParameter("bno"));
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		String formData = multi.getParameter("formData");
		String filename = " "; // (공백)
		int filesize = 0;
		System.out.println(bno + ", " + title + ", " + writer + ", " + content + ", " + formData);
		
		try {
			  // 첨부파일의 집합(배열로 가져옴)
			  Enumeration files = multi.getFileNames();
			  
			  while(files.hasMoreElements()) {
				  // 첨부파일의 이름
				  String file1 = (String)files.nextElement();
				  filename = multi.getFilesystemName(file1);
				  File f1 = multi.getFile(file1);
				  
				  if(f1 != null) {
					  filesize = (int)f1.length(); // 파일 사이즈 저장
				  }
			  }
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  
		  // filename이 null 또는 ""일 때 "-" 처리
		  if(filename == null || filename.trim().equals("")) {
			  filename = "-";
		  }
		  
		//
		FreeBoardDAO ffDao = FreeBoardDAO.getInstance();
		FreeBoardDTO ffDto = ffDao.boardDetailView(bno);
		
		int ref = ffDto.getRef();
		int re_step = ffDto.getRe_step() + 1;
		int re_level = ffDto.getRe_level() + 1;
		
		ffDao.updateStep(ref, re_step);
		
		FreeBoardDAO fDao = FreeBoardDAO.getInstance();
		FreeBoardDTO fDto = new FreeBoardDTO(title, content, writer, ref, re_step, re_level);
		fDao.answerInsert(fDto);
		
		System.out.println("bno" + bno + "title" + title + " content" + content + "writer" + writer);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
	

}
