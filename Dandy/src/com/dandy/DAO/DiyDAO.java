package com.dandy.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.rosuda.REngine.Rserve.RConnection;

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
		
	

}
