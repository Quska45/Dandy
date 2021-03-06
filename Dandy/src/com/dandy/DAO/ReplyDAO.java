package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONObject;

import com.dandy.DTO.ReplyDTO;
import com.dandy.mybatis.SqlMapConfig;
import com.dandy.DAO.ReplyDAO;

public class ReplyDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	//mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
		
	//싱글톤패턴으로 만들어 줬다.
	private ReplyDAO() {
		// TODO Auto-generated constructor stub
	}
	//미리 객체 생성을 해두고 메소드로 이것을 가져다 쓰는 방식이다.
	private static ReplyDAO instance = new ReplyDAO();
	public static ReplyDAO getInstance() {
		return instance;
	}
	
	//댓글리스트를 띄워주는 메소드 
	public List<ReplyDTO> questionReplyList(Integer bno){
		sqlSession = sqlSessionFactory.openSession();
		List<ReplyDTO> list = new ArrayList<>();
		try {
			list = sqlSession.selectList("questionReplyList", bno);
			for(ReplyDTO rDto : list){
				System.out.print(rDto.getBno());
				System.out.print(rDto.getContent());
				System.out.print(rDto.getRno());
				System.out.print(rDto.getWriter());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return list;
	}
	
	//댓글을 입력하는 메소드
	public int questionReplyInsert(ReplyDTO rDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.insert("questionReplyInsert", rDto);
			
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}

	
	//댓글 삭제하는 메소드
	public void questionReplyDelete(Integer rno) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.delete("questionReplydelete", rno);
			sqlSession.commit();
			
			if(result > 0) {
				System.out.println("댓글 삭제 성공");
			} else {
				System.out.println("댓글 삭제 실패");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	//자유게시판 리플 출력 
	public List<ReplyDTO> freeReplyList(Integer bno){
		sqlSession = sqlSessionFactory.openSession();
		List<ReplyDTO> list = new ArrayList<>();
		try {
			list = sqlSession.selectList("freeReplyList", bno);
			for(ReplyDTO rDto : list){
				System.out.print(rDto.getBno());
				System.out.print(rDto.getContent());
				System.out.print(rDto.getRno());
				System.out.print(rDto.getWriter());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return list;
	}
	//자유게시판 리플 등록
		public int freeReplyInsert(ReplyDTO rDto) {
			
			sqlSession = sqlSessionFactory.openSession();
			int result = 0;
			
			try {
				result = sqlSession.insert("freeReplyInsert", rDto);
				
				sqlSession.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			
			return result;
		}
		//자유게시판 리플 삭제
		public void freeReplyDelete(Integer rno) {
			sqlSession = sqlSessionFactory.openSession();
			int result = 0;
			try {
				result = sqlSession.delete("freeReplydelete", rno);
				sqlSession.commit();
				
				if(result > 0) {
					System.out.println("댓글 삭제 성공");
				} else {
					System.out.println("댓글 삭제 실패");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			
		}
		// 자유게시판의 글이 삭제되면 댓글도 함께 삭제
		public int replyDeleteWithBoard(Integer bno) {
			int rd_result = 0;
			
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				rd_result = sqlSession.delete("bnoreplydelete", bno);
				sqlSession.commit();
				
				if(rd_result > 0) {
					System.out.println(bno + "번의 게시글 삭제와 동시에 리플도 함께 삭제 성공");
				} else {
					System.out.println(bno + "번의 게시글이 삭제되면서 실행한 리플 삭제 실패");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			return rd_result;
		}
}
