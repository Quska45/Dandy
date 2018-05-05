package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.DTO.QuestionBoardDTO;
import com.dandy.mybatis.SqlMapConfig;


public class QuestionBoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	//mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
		
	//싱글톤패턴으로 만들어 줬다.
	private QuestionBoardDAO() {
		// TODO Auto-generated constructor stub
	}
	//미리 객체 생성을 해두고 메소드로 이것을 가져다 쓰는 방식이다.
	private static QuestionBoardDAO instance = new QuestionBoardDAO();
	public static QuestionBoardDAO getInstance() {
		return instance;
	}
	
	public void questionInsert(QuestionBoardDTO qDto){
		sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.insert("questionInsert", qDto);
			if(result > 0) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List<QuestionBoardDTO> boardlist2(){
		sqlSession = sqlSessionFactory.openSession();
		List<QuestionBoardDTO> list = new ArrayList<>();
		try {
			list = sqlSession.selectList("boardlist2");
			
			for(QuestionBoardDTO qDto : list){
				System.out.print(qDto.getBno());
				System.out.print(qDto.getTitle());
				System.out.print(qDto.getContent());
				System.out.print(qDto.getWriter());
				System.out.print(qDto.getRegdate());
				System.out.print(qDto.getViewcnt());
				System.out.print(qDto.getGoodcnt());
				System.out.print(qDto.getRef());
				System.out.print(qDto.getRe_step());
				System.out.print(qDto.getRe_level());
				System.out.print(qDto.getQuestion_type());
				System.out.print(qDto.getFlag());
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return list;
	}
	
}
