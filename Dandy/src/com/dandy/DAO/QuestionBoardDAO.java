package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.DTO.CriteriaDTO;
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
	
	//QnA 게시판에 글을 등록하는 메소드
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
	
	//QnA게시판 리스트를 띄우는 메소드
	public List<QuestionBoardDTO> questionList(CriteriaDTO criDto){
		sqlSession = sqlSessionFactory.openSession();
		List<QuestionBoardDTO> list = new ArrayList<>();
		try {
			list = sqlSession.selectList("listCriteria",criDto);
			
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
	
	//상세페이지의 정보를 가져오는 메소드
	public QuestionBoardDTO questionDetail(Integer bno){
		sqlSession = sqlSessionFactory.openSession();
		QuestionBoardDTO qDto = new QuestionBoardDTO();
		try {
			qDto = sqlSession.selectOne("questionDetail", bno);
			
			System.out.print(qDto.getBno());
			System.out.print(qDto.getContent());
			System.out.print(qDto.getContent());
			System.out.print(qDto.getGoodcnt());
			System.out.print(qDto.getTitle());
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return qDto;
		
	}
	
	
	//게시판에 있는 글의 수를 세는 메소드
	public int totalCount(CriteriaDTO criDto) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			//몇건이 출력될지 출력하는 단건을 출력시키기 때문에 단건만 출력하는 것이다.
			//즉 게시글의 건수가 여기 담기게 된다.
			result = sqlSession.selectOne("scountPaging", criDto);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		
		return result;
	}
	
	
	
	
	
	
}
