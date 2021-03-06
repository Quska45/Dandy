package com.dandy.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dandy.DTO.FreeBoardDTO;
import com.dandy.DTO.CriteriaDTO;
import com.dandy.mybatis.SqlMapConfig;

public class FreeBoardDAO {
	
		SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
		SqlSession sqlSession;
		
		private static FreeBoardDAO instance = new FreeBoardDAO();
		public static FreeBoardDAO getInstance() {
			
			return instance;
		}
		
		int result = 0;
	
		// 게시판 목록
		public List<FreeBoardDTO> freeboardListAll(CriteriaDTO criDto) {
			
			sqlSession = sqlSessionFactory.openSession();
			List<FreeBoardDTO> list = new ArrayList<>();
			
			String lineup_code = criDto.getLineup_code();
			System.out.println(lineup_code);
			
			try {
				list = sqlSession.selectList("fblistCriteria", criDto);
				
				for (FreeBoardDTO boardDTO : list) {
					System.out.print(boardDTO.getBno() + ", ");
					System.out.print(boardDTO.getTitle() + ", ");
					System.out.print(boardDTO.getContent() + ", ");
					System.out.print(boardDTO.getWriter() + ", ");
					System.out.print(boardDTO.getRegdate() + ", ");
					System.out.print(boardDTO.getViewcnt());
					System.out.println();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return list;
		}
		
		public int totalCount(CriteriaDTO criDto) {
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				result = sqlSession.selectOne("fbscountPaging", criDto);
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return result;
		}
		
		// 게시글 등록
		public int boardInsert(FreeBoardDTO bDto) {
			
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				result = sqlSession.insert("boardinsert",bDto);
				sqlSession.commit();
				
				System.out.println("result = " + result);
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			
			return result;
		}
		
		// 게시글 상세 뷰 
		public FreeBoardDTO boardDetailView(Integer bno) {
			
			FreeBoardDTO fDto = null;
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				// 여러건 출력 : selectList = LIST Type
				// 단건 출력 : selectOne = DTO Type
				fDto = sqlSession.selectOne("boarddetailview", bno);
				
				System.out.print(fDto.getBno() + ", ");
				System.out.print(fDto.getTitle() + ", ");
				System.out.print(fDto.getContent() + ", ");
				System.out.print(fDto.getWriter() + ", ");
				System.out.print(fDto.getRegdate() + ", ");
				System.out.print(fDto.getViewcnt());
				System.out.println();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return fDto;
		}
		
		// 게시글 수정 뷰
		public FreeBoardDTO boardUpdateView(Integer bno) {
			
			//FreeBoardDTO fDto = null;
			FreeBoardDTO fDto = new FreeBoardDTO();
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("게시글 수정 DAO");
			
			try {
				fDto = sqlSession.selectOne("boardupdateview", bno);
				
				System.out.print(fDto.getBno() + ", ");
				System.out.print(fDto.getTitle() + ", ");
				System.out.print(fDto.getContent() + ", ");
				System.out.print(fDto.getWriter() + ", ");
				System.out.print(fDto.getRegdate() + ", ");
				System.out.print(fDto.getViewcnt());
				System.out.println();
				
				System.out.println("게시글 수정 mapper 다녀온 후");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return fDto;
		}
		
		// 게시글 수정
		public int boardUpdate(FreeBoardDTO bDto) {
			
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				result = sqlSession.update("boardupdate",bDto);
				sqlSession.commit();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			
			
			return result;
		}
		
		// 게시글 삭제
		public int boardDelete(Integer bno) {
			
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				result = sqlSession.delete("boarddelete", bno);
				sqlSession.commit();
				
			} catch(Exception e) {
				
			} finally {
				sqlSession.close();
			}
			return result;
		}
		
		// 뷰 카운트
		
		public void boardViewCnt(Integer bno, HttpSession countSession) {
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				
				long update_time = 0;
				if(countSession.getAttribute("read_time_" + bno) != null) {
					update_time = (long)countSession.getAttribute("read_time_"+bno);
				}
				
				long current_time = System.currentTimeMillis();
				
				if(current_time - update_time > 24 * 60 * 60 * 1000) {
					result = sqlSession.update("boardViewCnt", bno);
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
		
		// 좋아요♥ 카운트
		public int boardGpoint(Integer bno) {
			sqlSession = sqlSessionFactory.openSession();
			try {
				result = sqlSession.update("boardGoodCnt",bno);
				sqlSession.commit();
				
				if(result > 0) {
					System.out.println("♥♥♥좋아요♥♥♥ 포인트 1 증가 성공");
				} else {
					System.out.println("ㅠㅠ좋아요ㅠㅠ 포인트 증가 실패");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			} return result;
		}
		
		public List<FreeBoardDTO> boardSearch(CriteriaDTO criDto){
			sqlSession = sqlSessionFactory.openSession();
			List<FreeBoardDTO> list = null;
			
			String flag = criDto.getFlag();
			
			try {
				System.out.println("Keyword ===>" + criDto.getKeyword());
				System.out.println("Flag ===>" + flag);
				
				list = sqlSession.selectList("boardSearch", criDto);
				
				for (FreeBoardDTO boardDTO : list) {
					System.out.print(boardDTO.getBno() + ", ");
					System.out.print(boardDTO.getTitle() + ", ");
					System.out.print(boardDTO.getContent() + ", ");
					System.out.print(boardDTO.getWriter() + ", ");
					System.out.print(boardDTO.getRegdate() + ", ");
					System.out.print(boardDTO.getViewcnt() + ", ");
					System.out.println();
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return list;
		}
		public String boardSearchSelectBox(CriteriaDTO criDto){
			
			String flag = criDto.getFlag();
			String selflag = null;
			
			try {
				if(flag.equals("1")) {
					selflag = "전체";
				} else if(flag.equals("2")) {
					selflag = "제목";
				} else if(flag.equals("3")) {
					selflag = "내용";
				} else if(flag.equals("4")) {
					selflag = "제목+내용";
				} else if(flag.equals("5")) {
					selflag = "작성자";
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return selflag;
		}
		// 검색 게시판 페이지
		public int boardSPaging(CriteriaDTO criDto) {
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				result = sqlSession.selectOne("fbscountPaging", criDto);
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return result;
		}
		
		// 파일 다운로드
		public String getFileName(Integer bno) {
			
			String result = " ";
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				
				result = sqlSession.selectOne("getFileName", bno);
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			return result;
		}
		
		// 파일 다운로드 횟수 1 증가
		public int downCount(Integer bno) {
			int result = 0;
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				result = sqlSession.update("downCount",bno);
				sqlSession.commit();
				
				if(result > 0) {
					System.out.println("다운로드 횟수 1 증가 성공");
				} else {
					System.out.println("다운로드 횟수 증가 실패");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			} return result;
		
		}
		
		// 답변
		public void updateStep(int ref, int re_step) {
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				FreeBoardDTO bDto = new FreeBoardDTO();
				bDto.setRef(ref);
				bDto.setRe_step(re_step);
				
				
				sqlSession.update("updateStep", bDto);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) sqlSession.close();
			}
			
		}
		
		// 답변 등록
		public int answerInsert(FreeBoardDTO bDto) {
			sqlSession = sqlSessionFactory.openSession();
			int result = 0;
			
			try {
				result = sqlSession.insert("answerInsert", bDto);
				sqlSession.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) sqlSession.close();
			}
			return result;
		}
		
		// 게시판 정렬
		/*public List<FreeBoardDTO> freeboardlineup(CriteriaDTO criDto){
			sqlSession = sqlSessionFactory.openSession();
			List<FreeBoardDTO> list = null;
			
			String lineup_code = criDto.getLineup_code();
			String sort = criDto.getSort();
			System.out.println("정렬 코드 ===>" + lineup_code);
			System.out.println("정렬 방식 ===>" + sort);
			
			try {
				if(sort.equals("asc")) {
					list = sqlSession.selectList("boardlineup_asc", criDto);
					System.out.println("asc로 정렬한 게시판 리스트 : "+ list.size());
				} else if(sort.equals("desc")) {
					list = sqlSession.selectList("boardlineup_desc", criDto);
					System.out.println("desc로 정렬한 게시판 리스트 : "+ list.size());
				}
				for (FreeBoardDTO boardDTO : list) {
					System.out.print(boardDTO.getBno() + ", ");
					System.out.print(boardDTO.getTitle() + ", ");
					System.out.print(boardDTO.getContent() + ", ");
					System.out.print(boardDTO.getWriter() + ", ");
					System.out.print(boardDTO.getRegdate() + ", ");
					System.out.print(boardDTO.getViewcnt() + ", ");
					System.out.println();
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return list;
		}*/
		
		// 정렬
		public List<FreeBoardDTO> freeboardSort(CriteriaDTO criDto){
			sqlSession = sqlSessionFactory.openSession();
			List<FreeBoardDTO> list = null;
			System.out.println(criDto.getKeyword());
			System.out.println(criDto.getSort());
			try {
				list = sqlSession.selectList("freeSort", criDto);
				for(FreeBoardDTO fDto : list) {
					System.out.print(fDto.getBno());
					System.out.print(fDto.getContent());
					System.out.print(fDto.getTitle());
					System.out.print(fDto.getWriter());
					System.out.print(fDto.getViewcnt());
					System.out.print(fDto.getRegdate());
					System.out.print(fDto.getGoodcnt());
					System.out.println();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return list;
		}
	} 
























