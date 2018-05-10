package com.dandy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.DTO.MemberDTO;
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
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	int result, flag;
	
	
	public int memIdCheck(String memberid) {
		sqlSession = sqlSessionFactory.openSession();
		List<MemberDTO> list = null;

		try {

			list = sqlSession.selectList("memIdCheck", memberid);

			if (list.size() > 0) {
				System.out.println("중복된 아이디 입니다.");
				flag = 0;
			} else {
				System.out.println("사용 가능한 아이디 입니다.");
				flag = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}

		return flag;
	}
	
	
	public int registerMember(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;

		try {

			result = sqlSession.insert("registerMember", mDto);
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}

		return result;
	}
	
	public MemberDTO sessionLogin(String mid, String mpw) {
		sqlSession = sqlSessionFactory.openSession();
		
		MemberDTO mDto = new MemberDTO(mid, mpw);
		try {
			mDto = sqlSession.selectOne("sessionlogin", mDto);
			if(mDto == null) {
				System.out.println("로그인정보가 틀림");
			} else {
				System.out.print(mDto.getMid());
				System.out.print(mDto.getMpw());
				System.out.print(mDto.getMname());
				System.out.print(mDto.getMphone());
				System.out.print(mDto.getMsex());
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return mDto;
	}
	
	//mypage에서 회원의 단어장 mno를 가져오는 메소드
	public MemberDTO getMno(String mid){
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = null;
		try {
			mDto = sqlSession.selectOne("selectMno", mid);
				System.out.println(mDto.getMno1());
				System.out.println(mDto.getMno2());
				System.out.println(mDto.getMno3());
				System.out.println(mDto.getMno4());
				System.out.println(mDto.getMno5());
				System.out.println(mDto.getMno6());
				System.out.println(mDto.getMno7());
				System.out.println(mDto.getMno8());
				System.out.println(mDto.getMno9());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return mDto;
	}
	
	
	
}
