package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.DTO.CriteriaDTO;
import com.dandy.DTO.MovieCriteriaDTO;
import com.dandy.DTO.MovieDTO;
import com.dandy.DTO.MovieEachDTO;
import com.dandy.DTO.MovieIndexDTO;
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
	
	
	public int stotalCount(MovieCriteriaDTO criDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			result = sqlSession.selectOne("smovieCountPaging", criDto);
			
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
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	
	public List<MovieEachDTO> movieEach(MovieEachDTO mDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		List<MovieEachDTO> list = new ArrayList<>();
		
		try {
			list = sqlSession.selectList("movieEach", mDto);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	
	public List<MovieIndexDTO> movieStatistics(int mno2) {
		sqlSession = sqlSessionFactory.openSession();
		List<MovieIndexDTO> list = new ArrayList<>();
		
		try {
			list = sqlSession.selectList("movieIndex", mno2);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
		
	}
	
	//mypage에서 mid를 가지고 영화제목, 이미지를 가져오는 메소드
	public MovieDTO getMyPageMovieList(String mid, int i){
		sqlSession = sqlSessionFactory.openSession();
		MovieDTO mDto = new MovieDTO(mid, i);
		try {
			mDto = sqlSession.selectOne("getMyPageMovieList", mDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return mDto;
	}
}
