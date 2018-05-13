package com.dandy.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
			System.out.println("커넥션이 안되는거지???");

			try {
				RConnection connection = new RConnection();
				
				REXP x = connection.eval("aa");
				System.out.println("xxxxxxxxxxxx:" + x);
				connection.eval("meanVal=mean(c(1,2,3,4))");
				double mean = connection.eval("meanVal").asDouble();
				System.out.println("평균은 : " + mean);
				connection.eval("aa <- \"항상\"");
				System.out.println(connection.eval("aa").asString());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		
	

}
