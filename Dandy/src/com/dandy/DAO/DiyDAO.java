package com.dandy.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.rosuda.REngine.Rserve.RConnection;

import com.dandy.DTO.MovieEachDTO;
import com.dandy.common.Constants;
import com.dandy.mybatis.SqlMapConfig;

public class DiyDAO {
	
	// MyBatis 세팅값 호출
		SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

		// mapper에 접근하기 위한 SqlSession
		SqlSession sqlSession;

		private DiyDAO() {
		}

		private static DiyDAO instance = new DiyDAO();

		public static DiyDAO getInstance() {
			return instance;
		}
		
		int result = 0;
		
		
		// RConnection 열어서 R과 연동해 Oracle에 데이터 쓰기까지 메서드
		public void textMining(String title, String text)  {
			RConnection c = null;
			try {
				c = new RConnection();
				c.eval("title <- '" + title + "'");
				c.eval("text <- '" + text + "'");
				c.eval("library(DBI)");
				c.eval("Sys.setenv(JAVA_HOME='C:\\\\Program Files\\\\Java\\\\jre1.8.0_151')");
				c.eval("library(rJava)");
				c.eval("library(RJDBC)");
				c.eval("OracleDriver <- 'oracle.jdbc.driver.OracleDriver'");
				c.eval("ojdbc6 <- 'C:/oraclexe/app/oracle/product/11.2.0/server/jdbc/lib/ojdbc6.jar'");
				c.eval("drv <- JDBC(OracleDriver, ojdbc6)");
				c.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@//jsDandyHome.iptime.org:1521/xe', 'java', '1234')");
				c.eval("library(RPostgreSQL)");
				c.eval("library(tm)");
				c.eval("library(SnowballC)");
				c.eval("jeopCorpus <- Corpus(VectorSource(text))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, PlainTextDocument)");
				c.eval("toSpace <- content_transformer(function (x , pattern ) gsub(pattern, ' ', x))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, toSpace, '/')");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, toSpace, '@')");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, toSpace, '\\\\|')");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removePunctuation)");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removeWords, stopwords('english'))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, content_transformer(tolower))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removeNumbers)");
				c.eval("excludes <- c('the', 'this', stopwords('english'))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removeWords, excludes)");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, stemDocument)");
				c.eval("dtm <- TermDocumentMatrix(jeopCorpus)");
				c.eval("m <- as.matrix(dtm)");
				c.eval("v <- sort(rowSums(m), decreasing = T)");
				c.eval("d <- data.frame(morpheme  = names(v), freq = v)");
				c.eval("frame <- head(d, 300)");
				c.eval("write <- data.frame(frame, stringsAsFactors = F)");
				c.eval("dbWriteTable(conn, title, write, row.names = F)");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				c.close();
			}
			
		}
		
		
		public void alterTable(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();

	        try {

	            sqlSession.update("alterTable", mDto);
	            sqlSession.commit();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if(sqlSession != null) sqlSession.close();
	        }

			
		}
		
		
		public void selectWord(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			List<MovieEachDTO> list = null;
			String title = mDto.getTitle();
			try {
				
				list = sqlSession.selectList("selectWord", mDto);
				
				for (MovieEachDTO movieEachDTO : list) {
					String morpheme = movieEachDTO.getMorpheme();
					
					crawling(morpheme, title);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
		}
		
		
		public void crawling(String morpheme, String title) throws IOException {
			
			String base_url = "http://alldic.daum.net/search.do?q=";
			String complete_url = base_url + morpheme;
			
			Document doc = Jsoup.connect(complete_url).get();
			Elements card_word = doc.select("div.card_word");
			
			String word = null;
			String meaning = null;
			
			for(int j = 0; j < card_word.size(); j++) {
				Elements tit_word = card_word.get(j).select("h4.tit_word");
				Elements txt_emph1 = card_word.get(j).select("a.txt_cleansch span.txt_emph1");
				/*if (txt_emph1.text().equals(" ")) {
					System.out.println("값이 없어양");
				}*/
				Elements list_search = card_word.get(j).select("div.cleanword_type ul.list_search");
				
				if(tit_word.text().equals("영어사전")) {
					word = txt_emph1.text();
					meaning = list_search.toString();
					//System.out.println(word);
					//System.out.println(meaning);
					break;
				} else if(tit_word.text().equals("영영사전")){
					word = txt_emph1.text();
					//System.out.println(word);
				} else {
					continue;
				}
				
			}
			
			
			System.out.println("형태소 : " + morpheme);
			System.out.println("크롤링 단어 : " + word);
			System.out.println("크롤링 뜻 : " + meaning);
			if(meaning == null || meaning.equals("")) {
				meaning = "null";
				word = "null";
			}
			MovieEachDTO mDto = new MovieEachDTO(morpheme, word, meaning, title);
			completeTable(mDto);
			
		}
		
		
		public void completeTable(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				
				sqlSession.update("completeTable", mDto);
				sqlSession.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
		}
		
		
		public void delete(String title) {
			sqlSession = sqlSessionFactory.openSession();
			MovieEachDTO mDto = new MovieEachDTO(title);
			
			try {
			
				sqlSession.delete("deleteNull", mDto);
				sqlSession.commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
		}
		
		
		public void selectWno(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			List<MovieEachDTO> list = null;
			String title = mDto.getTitle();
			
			try {
				
				list = sqlSession.selectList("sortWord", mDto);
				
				
				for (MovieEachDTO MovieEachDTO : list) {
					String morpheme = MovieEachDTO.getMorpheme();
					updateWno(morpheme, title);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();			
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
			
		}
		
		
		public List<MovieEachDTO> resultWord(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			List<MovieEachDTO> list = null;
			
			try {
				
				list = sqlSession.selectList("sortWord", mDto);
				
				
			} catch (Exception e) {
				e.printStackTrace();			
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
			return list;
			
		}
		
		
		public void updateWno(String morpheme, String title) {
			sqlSession = sqlSessionFactory.openSession();
			MovieEachDTO mDto = new MovieEachDTO(morpheme, title);
			
			try {

				sqlSession.update("updateWno", mDto);
				sqlSession.commit();

			} catch (Exception e) {
				System.out.println("DB 연결에 문제가 있습니다.");
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
			
		}
		
		
		// diy 단어장을 엑셀파일로 생성
		public void xlsWiter(List<MovieEachDTO> list, String title) {
	        // 워크북 생성
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        // 워크시트 생성
	        HSSFSheet sheet = workbook.createSheet();
	        // 행 생성
	        HSSFRow row = sheet.createRow(0);
	        // 쎌 생성
	        HSSFCell cell;
	        
	        // 헤더 정보 구성
	        cell = row.createCell(0);
	        cell.setCellValue("NO");
	        
	        cell = row.createCell(1);
	        cell.setCellValue("단어");
	        
	        cell = row.createCell(2);
	        cell.setCellValue("뜻");
	        
	        cell = row.createCell(3);
	        cell.setCellValue("빈도");
	        
	        // 리스트의 size 만큼 row를 생성
	        MovieEachDTO mDto = null;
	        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
	            mDto = list.get(rowIdx);
	            
	            // 행 생성
	            row = sheet.createRow(rowIdx+1);
	            
	            cell = row.createCell(0);
	            cell.setCellValue(mDto.getWno());
	            
	            cell = row.createCell(1);
	            cell.setCellValue(mDto.getWord());
	            
	            cell = row.createCell(2);
	            cell.setCellValue(mDto.getMeaning());
	            
	            cell = row.createCell(3);
	            cell.setCellValue(mDto.getFreq());
	            
	        }
	        
	        // 입력된 내용 파일로 쓰기
	        File file = new File(Constants.UPLOAD_PATH + title + ".xls");
	        FileOutputStream fos = null;
	        
	        try {
	            fos = new FileOutputStream(file);
	            workbook.write(fos);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(workbook!=null) workbook.close();
	                if(fos!=null) fos.close();
	                
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
		
		

}
