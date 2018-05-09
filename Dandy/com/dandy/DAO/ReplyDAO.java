package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.DTO.ReplyDTO;
import com.dandy.mybatis.SqlMapConfig;

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
	
}
