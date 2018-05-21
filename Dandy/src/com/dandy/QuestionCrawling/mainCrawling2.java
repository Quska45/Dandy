package com.dandy.QuestionCrawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dandy.DAO.QuestionBoardDAO;
import com.dandy.DTO.QuestionBoardDTO;

public class mainCrawling2 {
	static String base_url1 = "http://www.ebse.co.kr/ebs/fhz.AhbRetrieveArticle.laf?forum_id=FHZ_PSQNA&page=";
	static String base_url2 = "&index=zzzzzzzzzzzzzzzzzzzz";
	static int page = 1;
	static String complete_url = base_url1 + page + base_url2;
	
	public static void main(String[] args) throws IOException {
		int i=1;
		QuestionBoardDAO qDao = QuestionBoardDAO.getInstance();
		while(i<2){
			complete_url = base_url1 + page + base_url2;
			System.out.println(complete_url);
			Document doc = Jsoup.connect(complete_url).get();
			Elements firstPath = doc.select("td.tit a");
			System.out.println(firstPath);
			
			for(Element element : firstPath){
				String url = element.attr("href");
				System.out.println(url);
				String url_click = "http://www.ebse.co.kr"+url;
				System.out.println(url_click);
				
				Document doc_detail = Jsoup.connect(url_click).get();
				String title = element.text();
				System.out.println(title);
				String content = doc_detail.select("div.detailContDiv div").text();
				System.out.println(content);
				
				String writer = doc_detail.select("tr td:nth-child(4)").text().substring(0, 3);
				System.out.println(writer);
				String question_type = "기타";
				QuestionBoardDTO qDto = new QuestionBoardDTO(title,content,writer, question_type);
				qDao.questionInsert_dummy(qDto);
			}
			page++;
			i++;
		}
	}
}
