package com.dandy.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.mybatis.SqlMapConfig;



public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	//mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
		
	//싱글톤패턴으로 만들어 줬다.
	private MemberDAO() {
	
	}
	
	//미리 객체 생성을 해두고 메소드로 이것을 가져다 쓰는 방식이다.
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public void test() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			System.out.println("DAO를 잘 탑니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
}
