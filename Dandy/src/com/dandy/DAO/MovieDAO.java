package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.DTO.CriteriaDTO;
import com.dandy.DTO.MovieCriteriaDTO;
import com.dandy.DTO.MovieDTO;
import com.dandy.mybatis.SqlMapConfig;


public class MovieDAO {
	
	// MyBatis 세팅값 호출
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;

	private MovieDAO() {
	}

	private static MovieDAO instance = new MovieDAO();

	public static MovieDAO getInstance() {
		return instance;
	}
	
	int result = 0;
	
	public int totalCount(MovieCriteriaDTO criDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			result = sqlSession.selectOne("movieCountPaging", criDto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return result;
		
	}
	
	
	public List<MovieDTO> movieList(MovieCriteriaDTO movieCriDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		List<MovieDTO> list = new ArrayList<>();
		
		try {
			list = sqlSession.selectList("movieListCriteria", movieCriDto);

			/*for (BoardDTO boardDTO : list) {
				System.out.print(boardDTO.getBno() + ",");
				System.out.print(boardDTO.getTitle() + ",");
				System.out.print(boardDTO.getContent() + ",");
				System.out.print(boardDTO.getWriter() + ",");
				System.out.print(boardDTO.getRegdate() + ",");
				System.out.print(boardDTO.getViewcnt() + ",");
				System.out.print(boardDTO.getRecommand() + ",");
				System.out.println();
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	
	public List<MovieDTO> movieIndexList(MovieCriteriaDTO movieCriDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		List<MovieDTO> list = new ArrayList<>();
		
		try {
			list = sqlSession.selectList("movieIndexListCriteria", movieCriDto);
			
			/*for (BoardDTO boardDTO : list) {
				System.out.print(boardDTO.getBno() + ",");
				System.out.print(boardDTO.getTitle() + ",");
				System.out.print(boardDTO.getContent() + ",");
				System.out.print(boardDTO.getWriter() + ",");
				System.out.print(boardDTO.getRegdate() + ",");
				System.out.print(boardDTO.getViewcnt() + ",");
				System.out.print(boardDTO.getRecommand() + ",");
				System.out.println();
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	

}
