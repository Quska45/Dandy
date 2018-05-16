package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	//조회수를 세주는 메소드
	public void questionBoardViewCnt(Integer bno, HttpSession countSession) {
		sqlSession = sqlSessionFactory.openSession();
		int result=0;
		try {
			
			long update_time = 0;
			if(countSession.getAttribute("read_time_" + bno) != null) {
				update_time = (long)countSession.getAttribute("read_time_"+bno);
			}
			
			long current_time = System.currentTimeMillis();
			
			if(current_time - update_time > 24 * 60 * 60 * 1000) {
				result = sqlSession.update("questionBoardViewCnt", bno);
				sqlSession.commit();
				
				countSession.setAttribute("read_time_"+bno, current_time);
			}

			if(result > 0) {
				System.out.println("count 1 증가 성공");
			} else {
				System.out.println("count 1 증가 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	//답글의 순서를 조정 해줌
	public void updateStep(int ref, int re_step) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			QuestionBoardDTO bDto = new QuestionBoardDTO();
			bDto.setRef(ref);
			bDto.setRe_step(re_step);
			sqlSession.update("questionUpdateStep", bDto);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	//답글을 입력시키는 메소드
	public int answerInsert(QuestionBoardDTO qDto) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.insert("questionAnswerInsert", qDto);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return result;
	}
	
	
	//게시글 검색해주는 메소드
	public List<QuestionBoardDTO> questionSeach(CriteriaDTO criDto){
		sqlSession = sqlSessionFactory.openSession();
		List<QuestionBoardDTO> list = null;
		try {
			System.out.println("keyword=====>" + criDto.getKeyword());
			System.out.println("flag=====>" + criDto.getFlag());
			
			list = sqlSession.selectList("questionSearch", criDto);
			
			for(QuestionBoardDTO bDto : list) {
				System.out.print(bDto.getBno()+", ");
				System.out.print(bDto.getTitle()+", ");
				System.out.print(bDto.getContent()+", ");
				System.out.print(bDto.getWriter()+", ");
				System.out.print(bDto.getRegdate()+", ");
				System.out.print(bDto.getViewcnt()+", ");
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
	
	//게시글을 정렬하는 메소드
	public List<QuestionBoardDTO> questionSort(CriteriaDTO criDto){
		sqlSession = sqlSessionFactory.openSession();
		List<QuestionBoardDTO> list = null;
		System.out.println(criDto.getKeyword());
		System.out.println(criDto.getSort());
		try {
			list = sqlSession.selectList("questionSort", criDto);
			for(QuestionBoardDTO qDto : list){
				System.out.print(qDto.getBno());
				System.out.print(qDto.getContent());
				System.out.print(qDto.getTitle());
				System.out.print(qDto.getWriter());
				System.out.print(qDto.getViewcnt());
				System.out.print(qDto.getRegdate());
				System.out.print(qDto.getGoodcnt());
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
	
	//게시판글을 삭제하는 메소드
	public void questionDelete(Integer bno) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.delete("questionDelete", bno);
			if(result > 0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
}
