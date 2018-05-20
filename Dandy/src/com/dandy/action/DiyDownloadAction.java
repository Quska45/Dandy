package com.dandy.action;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.common.Constants;


public class DiyDownloadAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String filename = request.getParameter("title");
		
		
		// 다운로드 파일 경로
		String path = Constants.UPLOAD_PATH + filename + ".xls";
		byte b[] = new byte[4096]; // 바이트 배열 생성
		// 서버에 저장된 파일을 읽기 위한 스트림 생성
		FileInputStream fis = new FileInputStream(path);
		
		//mimeType(파일의 종류)
		String mimeType = request.getServletContext().getMimeType(path);
		if(mimeType == null) {
			mimeType = "application/octet-stream; charset=utf-8";
		}
		
		// 파일 이름에 한글이 포함된 경우
		// new String(바이트배열, 변환할 인코딩) 8859_1 서유럽언어
		// header에 특수문자 사용 못함, 서유럽언어로 변환
		filename = new String(filename.getBytes("utf-8"), "8859_1");
		
		
		// http header
		response.setHeader("content-Disposition", "attachment;filename=" + filename);
		
		// http body
		// OutputStream 생성(서버에서 클라이언트에 쓰기)
		ServletOutputStream out = response.getOutputStream();
		
		int numRead;
		while(true) {
			numRead = fis.read(b, 0, b.length); //데이터 읽기(4096 byte씩 끊어서 읽는다)
			if(numRead == -1) break;
			out.write(b, 0, numRead);
		}
		
		// 파일 처리 관련 리소스 정리
		out.flush(); // 4096바이트보다 작은 남은 잔류 데이터까지 받아주는 역할
		out.close();
		fis.close();
		
		
		return null;
	}

}
