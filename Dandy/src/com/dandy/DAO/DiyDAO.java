package com.dandy.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.rosuda.REngine.Rserve.RConnection;

import com.dandy.DTO.MovieEachDTO;
import com.dandy.mybatis.SqlMapConfig;

public class DiyDAO {
	
	// MyBatis 세팅값 호출
		SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

		// mapper에 접근하기 위한 SqlSession
		SqlSession sqlSession;

		private DiyDAO() {
		}

		private static DiyDAO instance = new DiyDAO();

		public static DiyDAO getInstance() {
			return instance;
		}
		
		int result = 0;
		
		
		// RConnection 열어서 R과 연동해 Oracle에 데이터 쓰기까지 메서드
		public void textMining(String title, String text)  {
			RConnection c = null;
			try {
				c = new RConnection();
				c.eval("title <- '" + title + "'");
				c.eval("text <- '" + text + "'");
				c.eval("library(DBI)");
				c.eval("Sys.setenv(JAVA_HOME='C:\\\\Program Files\\\\Java\\\\jre1.8.0_151')");
				c.eval("library(rJava)");
				c.eval("library(RJDBC)");
				c.eval("OracleDriver <- 'oracle.jdbc.driver.OracleDriver'");
				c.eval("ojdbc6 <- 'C:/oraclexe/app/oracle/product/11.2.0/server/jdbc/lib/ojdbc6.jar'");
				c.eval("drv <- JDBC(OracleDriver, ojdbc6)");
				c.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@//jsDandyHome.iptime.org:1521/xe', 'java', '1234')");
				c.eval("library(RPostgreSQL)");
				c.eval("library(tm)");
				c.eval("library(SnowballC)");
				c.eval("jeopCorpus <- Corpus(VectorSource(text))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, PlainTextDocument)");
				c.eval("toSpace <- content_transformer(function (x , pattern ) gsub(pattern, ' ', x))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, toSpace, '/')");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, toSpace, '@')");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, toSpace, '\\\\|')");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removePunctuation)");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removeWords, stopwords('english'))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, content_transformer(tolower))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removeNumbers)");
				c.eval("excludes <- c('the', 'this', stopwords('english'))");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, removeWords, excludes)");
				c.eval("jeopCorpus <- tm_map(jeopCorpus, stemDocument)");
				c.eval("dtm <- TermDocumentMatrix(jeopCorpus)");
				c.eval("m <- as.matrix(dtm)");
				c.eval("v <- sort(rowSums(m), decreasing = T)");
				c.eval("d <- data.frame(morpheme  = names(v), freq = v)");
				c.eval("frame <- head(d, 300)");
				c.eval("write <- data.frame(frame, stringsAsFactors = F)");
				c.eval("dbWriteTable(conn, title, write, row.names = F)");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				c.close();
			}
			
		}
		
		
		public void alterTable(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();

	        try {

	            sqlSession.update("alterTable", mDto);
	            sqlSession.commit();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if(sqlSession != null) sqlSession.close();
	        }

			
		}
		
		
		public void selectWord(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			List<MovieEachDTO> list = null;
			String title = mDto.getTitle();
			try {
				
				list = sqlSession.selectList("selectWord", mDto);
				
				for (MovieEachDTO movieEachDTO : list) {
					String morpheme = movieEachDTO.getMorpheme();
					
					crawling(morpheme, title);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
		}
		
		
		public void crawling(String morpheme, String title) throws IOException {
			
			String base_url = "http://alldic.daum.net/search.do?q=";
			String complete_url = base_url + morpheme;
			
			Document doc = Jsoup.connect(complete_url).get();
			Elements card_word = doc.select("div.card_word");
			
			String word = null;
			String meaning = null;
			
			for(int j = 0; j < card_word.size(); j++) {
				Elements tit_word = card_word.get(j).select("h4.tit_word");
				Elements txt_emph1 = card_word.get(j).select("a.txt_cleansch span.txt_emph1");
				/*if (txt_emph1.text().equals(" ")) {
					System.out.println("값이 없어양");
				}*/
				Elements list_search = card_word.get(j).select("div.cleanword_type ul.list_search");
				
				if(tit_word.text().equals("영어사전")) {
					word = txt_emph1.text();
					meaning = list_search.toString();
					//System.out.println(word);
					//System.out.println(meaning);
					break;
				} else if(tit_word.text().equals("영영사전")){
					word = txt_emph1.text();
					//System.out.println(word);
				} else {
					continue;
				}
				
			}
			
			
			System.out.println("형태소 : " + morpheme);
			System.out.println("크롤링 단어 : " + word);
			System.out.println("크롤링 뜻 : " + meaning);
			if(meaning == null || meaning.equals("")) {
				meaning = "null";
				word = "null";
			}
			MovieEachDTO mDto = new MovieEachDTO(morpheme, word, meaning, title);
			completeTable(mDto);
			
		}
		
		
		public void completeTable(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				
				sqlSession.update("completeTable", mDto);
				sqlSession.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
		}
		
		
		public void updateNull(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			
			try {
				
				sqlSession.update("updateNull", mDto);
				sqlSession.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
		}
		
		
		public void delete(String title) {
			sqlSession = sqlSessionFactory.openSession();
			MovieEachDTO mDto = new MovieEachDTO(title);
			
			try {
			
				sqlSession.delete("deleteNull", mDto);
				sqlSession.commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
		}
		
		
		public void selectWno(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			List<MovieEachDTO> list = null;
			String title = mDto.getTitle();
			
			try {
				
				list = sqlSession.selectList("sortWord", mDto);
				
				
				for (MovieEachDTO MovieEachDTO : list) {
					String morpheme = MovieEachDTO.getMorpheme();
					updateWno(morpheme, title);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();			
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
			
		}
		
		
		public List<MovieEachDTO> resultWord(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			List<MovieEachDTO> list = null;
			
			try {
				
				list = sqlSession.selectList("sortWord", mDto);
				
				
			} catch (Exception e) {
				e.printStackTrace();			
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
			return list;
			
		}
		
		
		public void updateWno(String morpheme, String title) {
			sqlSession = sqlSessionFactory.openSession();
			MovieEachDTO mDto = new MovieEachDTO(morpheme, title);
			
			try {

				sqlSession.update("updateWno", mDto);
				sqlSession.commit();

			} catch (Exception e) {
				System.out.println("DB 연결에 문제가 있습니다.");
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
			
		}
		
		
		
		
		
		
		/*public void nullDelete(MovieEachDTO mDto) {
			sqlSession = sqlSessionFactory.openSession();
			List<MovieEachDTO> list = null;
			String title = mDto.getTitle();
			
			try {
				
				list = sqlSession.selectList("selectWord", mDto);
				
				for (MovieEachDTO movieEachDTO : list) {
					String morpheme = movieEachDTO.getWord();
					String meaning = movieEachDTO.getMeaning();
					
						if(meaning.equals("null")) {
					        if(morpheme.equals("activ")) {
					        	String morpheme2 = morpheme;
					           morpheme = "active";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("adem")) {
					        	String morpheme2 = morpheme;
					           morpheme = "ademe";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("ambul")) {
					        	String morpheme2 = morpheme;
					           morpheme = "ambule";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("apocalyps")) {
					        	String morpheme2 = morpheme;
					           morpheme = "apocalypse";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("apolog")) {
					        	String morpheme2 = morpheme;
					           morpheme = "apologe";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("appetit")) {
					        	String morpheme2 = morpheme;
					           morpheme = "appetite";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("applaus")) {
					        	String morpheme2 = morpheme;
					           morpheme = "applause";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("appreci")) {
					        	String morpheme2 = morpheme;
					           morpheme = "appreciate";
					           crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("arrang")) {
					        	String morpheme2 = morpheme;
					            morpheme = "arrange";
					            crawling2(morpheme, title, morpheme2);
					        }  else if (morpheme.equals("arriv")) {
					        	String morpheme2 = morpheme;
					            morpheme = "arrive";
					            crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("attitud")) {
					         	String morpheme2 = morpheme;
					            morpheme = "attitude";
					            crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("automobil")) {
					          	String morpheme2 = morpheme;
					            morpheme = "automobile";
					            crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("beaudri")) {
					           	String morpheme2 = morpheme;
					            morpheme = "beaudrie";
					            crawling2(morpheme, title, morpheme2);
					        } else if (morpheme.equals("biolog")) {
					          	String morpheme2 = morpheme;
					            morpheme = "biology";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("buddi")) {
					           	String morpheme2 = morpheme;
					            morpheme = "buddy";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("busi")) {
					        	String morpheme2 = morpheme;
					            morpheme = "busy";
			                    crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("carpent")) {
					        	String morpheme2 = morpheme;
		  	                    morpheme = "carpenter";
		 	                    crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("case")) {
					        	String morpheme2 = morpheme;
					            morpheme = "case";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("charact")) {
					        	String morpheme2 = morpheme;
					        	morpheme = "character";
					        	crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("chest")) {
					        	String morpheme2 = morpheme;
					            morpheme = "chest";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("cigarett")) {
					          	String morpheme2 = morpheme;
					            morpheme = "cigarette";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("citi")) {
					           	String morpheme2 = morpheme;
					            morpheme = "city";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("commerci")) {
					           	String morpheme2 = morpheme;
					            morpheme = "commerce";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("committe")) {
					           	String morpheme2 = morpheme;
					            morpheme = "committee";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("compromis")) {
					          	String morpheme2 = morpheme;
					            morpheme = "compromise";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("confus")) {
					          	String morpheme2 = morpheme;
					            morpheme = "confuse";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("convers")) {
					          	String morpheme2 = morpheme;
					            morpheme = "converse";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("cours")) {
					         	String morpheme2 = morpheme;
					            morpheme = "course";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("creat")) {
					         	String morpheme2 = morpheme;
					            morpheme = "create";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("cri")) {
					          	String morpheme2 = morpheme;
					            morpheme = "cry";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("crisi")) {
					          	String morpheme2 = morpheme;
					            morpheme = "crisis";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("crocodil")) {
					          	String morpheme2 = morpheme;
					            morpheme = "crocodile";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("declar")) {
					          	String morpheme2 = morpheme;
					            morpheme = "declare";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("definit")) {
					           	String morpheme2 = morpheme;
					            morpheme = "definite";
					            crawling2(morpheme, title, morpheme2);
					        }else if (morpheme.equals("degre")) {
					          	String morpheme2 = morpheme;
					            morpheme = "degree";
					            crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("delici")) {
				            	String morpheme2 = morpheme;
				                morpheme = "delicate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("desir")) {
				            	String morpheme2 = morpheme;
				                morpheme = "desire";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("diagnosi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "diagnosis";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("discret")) {
				            	String morpheme2 = morpheme;
				                morpheme = "discrete";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("duti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "duty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("endur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "endure";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("energi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "energy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("execut")) {
				            	String morpheme2 = morpheme;
				                morpheme = "execute";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("facil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "facile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("famili")) {
				            	String morpheme2 = morpheme;
				                morpheme = "family";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("fantasi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fantasy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("favorit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "favorite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("found")) {
				            	String morpheme2 = morpheme;
				                morpheme = "found";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("fulfil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fulfill";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("funni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "funny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("furi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fury";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("futur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "future";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gentl")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gentle";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("goodby")) {
				            	String morpheme2 = morpheme;
				                morpheme = "goodbye";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("happi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "happy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("histori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "history";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hormon")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hormone";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hostil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hostile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hurri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hurry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ideolog")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ideology";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("industri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "industry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("intellig")) {
				            	String morpheme2 = morpheme;
				                morpheme = "intelligence";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("januari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "january";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("jealous")) {
				            	String morpheme2 = morpheme;
				                morpheme = "jealousy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("kitti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "kitty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ladi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "lady";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("lazi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "lazy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("licens")) {
				            	String morpheme2 = morpheme;
				                morpheme = "license";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("light")) {
				            	String morpheme2 = morpheme;
				                morpheme = "light";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("medicin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "medicine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("messag")) {
				            	String morpheme2 = morpheme;
				                morpheme = "message";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("missil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "missile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("morphin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "morphine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("neighbourhood")) {
				            	String morpheme2 = morpheme;
				                morpheme = "neighbourhood";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("network")) {
				            	String morpheme2 = morpheme;
				                morpheme = "network";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("nonsens")) {
				            	String morpheme2 = morpheme;
				                morpheme = "nonsense";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ordinari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ordinary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("particip")) {
				            	String morpheme2 = morpheme;
				                morpheme = "participe";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pleas")) {
				            	String morpheme2 = morpheme;
				                morpheme = "please";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pressur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pressure";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("princip")) {
				            	String morpheme2 = morpheme;
				                morpheme = "principle";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("produc")) {
				            	String morpheme2 = morpheme;
				                morpheme = "produce";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("profil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "profile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("promis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "promise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("properti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "property";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("refus")) {
				            	String morpheme2 = morpheme;
				                morpheme = "refuse";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("registr")) {
				            	String morpheme2 = morpheme;
				                morpheme = "registry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("religi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "religion";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reserv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "reserve";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("respons")) {
				            	String morpheme2 = morpheme;
				                morpheme = "response";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reunit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "reunite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("revolutionari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "revolutionary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rewrit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rewrite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("romanc")) {
				            	String morpheme2 = morpheme;
				                morpheme = "romance";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("romant")) {
				            	String morpheme2 = morpheme;
				                morpheme = "romantic";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("secretari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "secretary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("situat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "situate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("solv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "solve";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("stori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "story";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("studi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "study";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("suppli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "supply";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("teeth")) {
				            	String morpheme2 = morpheme;
				                morpheme = "teeth";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tini")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tiny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tragedi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tragedie";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("univers")) {
				            	String morpheme2 = morpheme;
				                morpheme = "universe";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("vaccin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vaccine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("vampir")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vampire";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("vibrat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vibrate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("wori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "worry";
				                crawling2(morpheme, title, morpheme2);
				            }
				            //------------------------1페이지-------------
				            else if (morpheme.equals("abla")) {
				            	String morpheme2 = morpheme;
				                morpheme = "abla";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("aborigin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "aborigine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("abus")) {
				            	String morpheme2 = morpheme;
				                morpheme = "abuse";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("accommod")) {
				            	String morpheme2 = morpheme;
				                morpheme = "accommodate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("acquir")) {
				            	String morpheme2 = morpheme;
				                morpheme = "acquire";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("adem")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ademe";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("admir")) {
				            	String morpheme2 = morpheme;
				                morpheme = "admire";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ador")) {
				            	String morpheme2 = morpheme;
				                morpheme = "adore";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("adversari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "adversary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("advis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "advise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("aerobreath")) {
				            	String morpheme2 = morpheme;
				                morpheme = "aero breath";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("aeroplan")) {
				            	String morpheme2 = morpheme;
				                morpheme = "aero plan";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("africa")) {
				            	String morpheme2 = morpheme;
				                morpheme = "africa";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("agil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "agile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("alam")) {
				            	String morpheme2 = morpheme;
				                morpheme = "alam";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("alik")) {
				            	String morpheme2 = morpheme;
				                morpheme = "alike";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("allergi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "allergy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("alli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ally";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("amaz")) {
				            	String morpheme2 = morpheme;
				                morpheme = "amaze";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ambul")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ambule";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("analys")) {
				            	String morpheme2 = morpheme;
				                morpheme = "analyse";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("analys")) {
				            	String morpheme2 = morpheme;
				                morpheme = "analyst";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("anatomi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "anatomy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ander")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ander";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("antibiogram")) {
				            	String morpheme2 = morpheme;
				                morpheme = "antibiogram";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("antinomi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "antinomy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("apocalyps")) {
				            	String morpheme2 = morpheme;
				                morpheme = "apocalypse";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("apolog")) {
				            	String morpheme2 = morpheme;
				                morpheme = "apologes";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("appropri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "appropriate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("archer")) {
				            	String morpheme2 = morpheme;
				                morpheme = "archer";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("aris")) {
				            	String morpheme2 = morpheme;
				                morpheme = "arise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("artilleri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "artillery";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rishi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Arusha";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("asham")) {
				            	String morpheme2 = morpheme;
				                morpheme = "asham";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("asid")) {
				            	String morpheme2 = morpheme;
				                morpheme = "aside";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("astrolog")) {
				            	String morpheme2 = morpheme;
				                morpheme = "astrology";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("attent")) {
				            	String morpheme2 = morpheme;
				                morpheme = "attentive";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("automobil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "automobile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("auxiliari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "auxiliary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("awak")) {
				            	String morpheme2 = morpheme;
				                morpheme = "awake";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("awar")) {
				            	String morpheme2 = morpheme;
				                morpheme = "award";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("balan")) {
				            	String morpheme2 = morpheme;
				                morpheme = "balance";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("bamba")) {
				            	String morpheme2 = morpheme;
				                morpheme = "bamba";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("basketbal")) {
				            	String morpheme2 = morpheme;
				                morpheme = "basketball";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("batteri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "battery";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("beaudri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "beaudrie";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("befo")) {
				            	String morpheme2 = morpheme;
				                morpheme = "before";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("belgrad")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Belgrade";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ben")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ben";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("benigno")) {
				            	String morpheme2 = morpheme;
				                morpheme = "benign";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("berni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Berny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("biolog")) {
				            	String morpheme2 = morpheme;
				                morpheme = "biology";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("bodi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "body";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("bollock")) {
				            	String morpheme2 = morpheme;
				                morpheme = "bollock";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("bukit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "bucket";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("buncha")) {
				            	String morpheme2 = morpheme;
				                morpheme = "bunch";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("buri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "bury";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("bushi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "bushy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("calcul")) {
				            	String morpheme2 = morpheme;
				                morpheme = "calculus";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("cale")) {
				            	String morpheme2 = morpheme;
				                morpheme = "cale";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("candi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "candy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("captiv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "captive";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("cari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "care";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("carpent")) {
				            	String morpheme2 = morpheme;
				                morpheme = "carpenter";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("case")) {
				            	String morpheme2 = morpheme;
				                morpheme = "case";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("castrat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "castrate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ceas")) {
				            	String morpheme2 = morpheme;
				                morpheme = "cease";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("celeri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "celery";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("celesti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "celestie";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("censur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "censure";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("centuri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "century";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ceremoni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ceremony";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("chang")) {
				            	String morpheme2 = morpheme;
				                morpheme = "change";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("chao")) {
				            	String morpheme2 = morpheme;
				                morpheme = "chaos";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("charact")) {
				            	String morpheme2 = morpheme;
				                morpheme = "character";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("charg")) {
				            	String morpheme2 = morpheme;
				                morpheme = "charge";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("chest")) {
				            	String morpheme2 = morpheme;
				                morpheme = "chest";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("chosun")) {
				            	String morpheme2 = morpheme;
				                morpheme = "chosen";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("cho")) {
				            	String morpheme2 = morpheme;
				                morpheme = "chow";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("christ")) {
				            	String morpheme2 = morpheme;
				                morpheme = "christ";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("circumambul")) {
				            	String morpheme2 = morpheme;
				                morpheme = "circumambulator";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("claus")) {
				            	String morpheme2 = morpheme;
				                morpheme = "claus";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("climat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "climate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("clusterstorm")) {
				            	String morpheme2 = morpheme;
				                morpheme = "cluster storm";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("cocain")) {
				            	String morpheme2 = morpheme;
				                morpheme = "cocaine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("coincid")) {
				            	String morpheme2 = morpheme;
				                morpheme = "coincide";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("combin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "combine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("commerci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "commerce";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("committee")) {
				            	String morpheme2 = morpheme;
				                morpheme = "committeee";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("composit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "composite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("compromis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "compromise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("conclud")) {
				            	String morpheme2 = morpheme;
				                morpheme = "conclude";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("conclus")) {
				            	String morpheme2 = morpheme;
				                morpheme = "conclusion";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("concret")) {
				            	String morpheme2 = morpheme;
				                morpheme = "concrete";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("concubin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "concubine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("confidenti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "confident";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("confidenti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "confidential";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("conspiratori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "conspiratorial";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("convers")) {
				            	String morpheme2 = morpheme;
				                morpheme = "convers";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("convers")) {
				            	String morpheme2 = morpheme;
				                morpheme = "converse";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("creat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "create";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("creepypasta")) {
				            	String morpheme2 = morpheme;
				                morpheme = "creepy pasta";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("crisi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "crisis";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("crocodil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "crocodile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("cri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "cry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("daili")) {
				            	String morpheme2 = morpheme;
				                morpheme = "daily";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("daisi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "daisy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("deai")) {
				            	String morpheme2 = morpheme;
				                morpheme = "deair";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("debat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "debate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("declar")) {
				            	String morpheme2 = morpheme;
				                morpheme = "declare";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("declin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "decline";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("decolonis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "decolonise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("deduc")) {
				            	String morpheme2 = morpheme;
				                morpheme = "deduce";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("defin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "define";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("delet")) {
				            	String morpheme2 = morpheme;
				                morpheme = "delete";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("delici")) {
				            	String morpheme2 = morpheme;
				                morpheme = "delicate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("delici")) {
				            	String morpheme2 = morpheme;
				                morpheme = "delict";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("deni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "deny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("deputi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "deputy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("desire")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Desir";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("desir")) {
				            	String morpheme2 = morpheme;
				                morpheme = "desire";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("destro")) {
				            	String morpheme2 = morpheme;
				                morpheme = "destroy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("diagnosi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "diagnosis";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("disciplinari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "disciplinary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("disciplin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "discipline";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("discontinu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "discontinue";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("discret")) {
				            	String morpheme2 = morpheme;
				                morpheme = "discrete";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("divin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "divine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("divis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "divisor";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("documentari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "documentary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dodg")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dodge";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dofu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dofu";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dogg")) {
				            	String morpheme2 = morpheme;
				                morpheme = "doggy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("domin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "doming";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("donat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "donate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dosa")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dose";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("doubl")) {
				            	String morpheme2 = morpheme;
				                morpheme = "double";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("drago")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dragon";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("doop")) {
				            	String morpheme2 = morpheme;
				                morpheme = "droop";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dunkin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dunking";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dynamit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dynamite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dynasti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dynasty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("dyou")) {
				            	String morpheme2 = morpheme;
				                morpheme = "dyou";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("eas")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ease";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ecolog")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ecology";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("econom")) {
				            	String morpheme2 = morpheme;
				                morpheme = "economy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("eiffel")) {
				            	String morpheme2 = morpheme;
				                morpheme = "eiffel";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("eleg")) {
				            	String morpheme2 = morpheme;
				                morpheme = "elegy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("elv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "elf";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("elit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "elite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("emot")) {
				            	String morpheme2 = morpheme;
				                morpheme = "emote";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("empir")) {
				            	String morpheme2 = morpheme;
				                morpheme = "empire";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("endur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "endure";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("entropi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "entropy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("entri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "entry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("epilepsi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "epilepsy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("episod")) {
				            	String morpheme2 = morpheme;
				                morpheme = "episode";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("exboyfriend")) {
				            	String morpheme2 = morpheme;
				                morpheme = "exboyfriend";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("excit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "excite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("exercis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "exercise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("expedit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "expedite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("extraordinari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "extraordinary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("extrem")) {
				            	String morpheme2 = morpheme;
				                morpheme = "extreme";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("facil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "facile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("factori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "factory";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("fanni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fanny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("fatti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fatty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("favorit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "favorite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("favorit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "favorite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("femal")) {
				            	String morpheme2 = morpheme;
				                morpheme = "female";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ferit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ferity";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("feroci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ferocity";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("fertil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fertile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("festiv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "festive";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("fiftythre")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fifty-three";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("filtrat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "filtrate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("found")) {
				            	String morpheme2 = morpheme;
				                morpheme = "found";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("franci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "France";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("freez")) {
				            	String morpheme2 = morpheme;
				                morpheme = "freeze";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("frenk")) {
				            	String morpheme2 = morpheme;
				                morpheme = "French";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("frontflip")) {
				            	String morpheme2 = morpheme;
				                morpheme = "front flip";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("frustrat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "frustrate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("fulfil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fulfil";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("furnitur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "furniture";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("furi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "fury";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gai")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gain";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("galleri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gallery";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Gary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gasolin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gasoline";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gete")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gav")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gave";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("generat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "generate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gentri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gentry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("germain")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Germain";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gian")) {
				            	String morpheme2 = morpheme;
				                morpheme = "giant";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("goe")) {
				            	String morpheme2 = morpheme;
				                morpheme = "go";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("goodby")) {
				            	String morpheme2 = morpheme;
				                morpheme = "goodbye";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gaci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "grace";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("grandios")) {
				            	String morpheme2 = morpheme;
				                morpheme = "grandiose";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("groov")) {
				            	String morpheme2 = morpheme;
				                morpheme = "groove";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("gunni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "gunny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hairi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hairy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("han")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hand";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("handi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "handy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("harmoni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "harmony";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("harri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "harry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hau")) {
				            	String morpheme2 = morpheme;
				                morpheme = "haul";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hei")) {
				            	String morpheme2 = morpheme;
				                morpheme = "heir";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hellman")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hellman";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("henri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Henry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("himalaya")) {
				            	String morpheme2 = morpheme;
				                morpheme = "himalaya";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hiv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hive";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hogwallop")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hog wallop";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hormon")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hormone";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("hostil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "hostile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ideolog")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ideology";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("illeg")) {
				            	String morpheme2 = morpheme;
				                morpheme = "illegal";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("imaginari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "imaginary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("imperi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "imperil";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("impor")) {
				            	String morpheme2 = morpheme;
				                morpheme = "import";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("impos")) {
				            	String morpheme2 = morpheme;
				                morpheme = "impose";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("impuls")) {
				            	String morpheme2 = morpheme;
				                morpheme = "impulse";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("independ")) {
				            	String morpheme2 = morpheme;
				                morpheme = "in depend";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("incens")) {
				            	String morpheme2 = morpheme;
				                morpheme = "incense";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("incom")) {
				            	String morpheme2 = morpheme;
				                morpheme = "income";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("incomplet")) {
				            	String morpheme2 = morpheme;
				                morpheme = "incomplete";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("indica")) {
				            	String morpheme2 = morpheme;
				                morpheme = "indica";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("individu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "individual";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("infantri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "infantry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("infertil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "infertile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("insan")) {
				            	String morpheme2 = morpheme;
				                morpheme = "insane";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("instal")) {
				            	String morpheme2 = morpheme;
				                morpheme = "install";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("institut")) {
				            	String morpheme2 = morpheme;
				                morpheme = "institute";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("intellig")) {
				            	String morpheme2 = morpheme;
				                morpheme = "intelligence";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("intellig")) {
				            	String morpheme2 = morpheme;
				                morpheme = "intelligent";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("invad")) {
				            	String morpheme2 = morpheme;
				                morpheme = "invade";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("itali")) {
				            	String morpheme2 = morpheme;
				                morpheme = "italic";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("itali")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Italy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("januari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "january";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("juli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "July";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("junki")) {
				            	String morpheme2 = morpheme;
				                morpheme = "junky";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("juri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "jury";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("kilomet")) {
				            	String morpheme2 = morpheme;
				                morpheme = "kilometer";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("kitti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "kitty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("lanc")) {
				            	String morpheme2 = morpheme;
				                morpheme = "lance";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("lan")) {
				            	String morpheme2 = morpheme;
				                morpheme = "land";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("larg")) {
				            	String morpheme2 = morpheme;
				                morpheme = "large";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("latitud")) {
				            	String morpheme2 = morpheme;
				                morpheme = "latitude";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("latt")) {
				            	String morpheme2 = morpheme;
				                morpheme = "latte";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("legat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "legate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("liberti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "liberty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("librarian")) {
				            	String morpheme2 = morpheme;
				                morpheme = "librarian";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("librari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "library";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("licens")) {
				            	String morpheme2 = morpheme;
				                morpheme = "license";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("light")) {
				            	String morpheme2 = morpheme;
				                morpheme = "light";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("liston")) {
				            	String morpheme2 = morpheme;
				                morpheme = "listen";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("literari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "literary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("literatur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "literature";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("lotteri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "lottery";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("lou")) {
				            	String morpheme2 = morpheme;
				                morpheme = "loud";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("luci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Lucy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("madan")) {
				            	String morpheme2 = morpheme;
				                morpheme = "madan";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("maddi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Maddy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("magistr")) {
				            	String morpheme2 = morpheme;
				                morpheme = "magistracy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("mak")) {
				            	String morpheme2 = morpheme;
				                morpheme = "make";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("maksim")) {
				            	String morpheme2 = morpheme;
				                morpheme = "maksim";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("malik")) {
				            	String morpheme2 = morpheme;
				                morpheme = "malik";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("marri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "marry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("martino")) {
				            	String morpheme2 = morpheme;
				                morpheme = "martini";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("massarakhsh")) {
				            	String morpheme2 = morpheme;
				                morpheme = "massarakhsh";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("matur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "mature";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("mai")) {
				            	String morpheme2 = morpheme;
				                morpheme = "may";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("mcdonald")) {
				            	String morpheme2 = morpheme;
				                morpheme = "mcdonald";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("medicin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "medicine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("melodi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "melody";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("memori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "memory";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("meteorit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "meteorite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("mik")) {
				            	String morpheme2 = morpheme;
				                morpheme = "mike";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("militari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "military";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("mithra")) {
				            	String morpheme2 = morpheme;
				                morpheme = "mithra";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("molli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "molly";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("monopoli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "monopoly";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("morphin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "morphine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("motiv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "motive";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("mutat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "mutate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("naiv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "naive";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("nanni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "nanny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("narrat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "narrate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("nasti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "nasty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("neighbour")) {
				            	String morpheme2 = morpheme;
				                morpheme = "neighbor";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("neighbourhood")) {
				            	String morpheme2 = morpheme;
				                morpheme = "neighbourhood";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("network")) {
				            	String morpheme2 = morpheme;
				                morpheme = "network";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("nonsens")) {
				            	String morpheme2 = morpheme;
				                morpheme = "nonsense";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("notari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "notary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("nothin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "nothing";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("oblig")) {
				            	String morpheme2 = morpheme;
				                morpheme = "oblige";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("observatori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "observatory";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("oclock")) {
				            	String morpheme2 = morpheme;
				                morpheme = "o'clock";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("oliv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "olive";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("olimpia")) {
				            	String morpheme2 = morpheme;
				                morpheme = "olympia";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("olymp")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Olympic";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("oncom")) {
				            	String morpheme2 = morpheme;
				                morpheme = "oncome";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("oniy")) {
				            	String morpheme2 = morpheme;
				                morpheme = "only";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("opportun")) {
				            	String morpheme2 = morpheme;
				                morpheme = "opportune";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("oppos")) {
				            	String morpheme2 = morpheme;
				                morpheme = "oppose";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("organis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "organise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("other")) {
				            	String morpheme2 = morpheme;
				                morpheme = "other";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ovat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ovate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ove")) {
				            	String morpheme2 = morpheme;
				                morpheme = "over";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pais")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pais";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("palac")) {
				            	String morpheme2 = morpheme;
				                morpheme = "palace";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pappi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pappy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("parad")) {
				            	String morpheme2 = morpheme;
				                morpheme = "parade";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("paradis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "paradis";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("passag")) {
				            	String morpheme2 = morpheme;
				                morpheme = "passage";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pasti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pasty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pathet")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pathetic";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("penalti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "penalty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("perfor")) {
				            	String morpheme2 = morpheme;
				                morpheme = "perform";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pickl")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pickle";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("piec")) {
				            	String morpheme2 = morpheme;
				                morpheme = "piece";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pietro")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Pietro";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pinki")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pinkie";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pirat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pirate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("piti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pity";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("plagu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "plague";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pleas")) {
				            	String morpheme2 = morpheme;
				                morpheme = "please";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pediatr")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pediatry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pointi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pointy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("potteri")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pottery";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pregnanc")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pregnancy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("premis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "premise";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("pressur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "pressure";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("prete")) {
				            	String morpheme2 = morpheme;
				                morpheme = "preteen";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("primari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "primary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("probat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "probate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("procedur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "procedure";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("profil")) {
				            	String morpheme2 = morpheme;
				                morpheme = "profile";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("promot")) {
				            	String morpheme2 = morpheme;
				                morpheme = "promote";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("propos")) {
				            	String morpheme2 = morpheme;
				                morpheme = "propos";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("psychiatr")) {
				            	String morpheme2 = morpheme;
				                morpheme = "psychiatry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("que")) {
				            	String morpheme2 = morpheme;
				                morpheme = "que";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("quinci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "quince";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("radiat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "radiate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ralli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rally";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ramamurthi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Ramamurthy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rather")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rather";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reach")) {
				            	String morpheme2 = morpheme;
				                morpheme = "reach";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reai")) {
				            	String morpheme2 = morpheme;
				                morpheme = "real";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("realis")) {
				            	String morpheme2 = morpheme;
				                morpheme = "realis";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("refin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "refine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("registr")) {
				            	String morpheme2 = morpheme;
				                morpheme = "registry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reincarn")) {
				            	String morpheme2 = morpheme;
				                morpheme = "reincarnate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("religi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "religion";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rely";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("remain")) {
				            	String morpheme2 = morpheme;
				                morpheme = "remain";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ramak")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ramake";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("repli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "reply";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reput")) {
				            	String morpheme2 = morpheme;
				                morpheme = "repute";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reserv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "reserve";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("residu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "residue";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("restaur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "restaurant";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("reunit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "reunite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("revolutionari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "revolutionary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rewrit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rewrite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("richi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rich";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rideshar")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rideshare";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ritu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ritual";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("roden")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rodent";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rogu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rogue";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("romant")) {
				            	String morpheme2 = morpheme;
				                morpheme = "romantic";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rosi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rosy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("rotat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "rotate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("roundnround")) {
				            	String morpheme2 = morpheme;
				                morpheme = "round";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("royalti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "royalty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("ruhi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "ruin";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("salut")) {
				            	String morpheme2 = morpheme;
				                morpheme = "salute";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sandi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sandy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("satellit")) {
				            	String morpheme2 = morpheme;
				                morpheme = "satellite";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sayin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "say in";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("scari")) {
				            	String morpheme2 = morpheme;
				                morpheme = "scary";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sedat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sedate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("segui")) {
				            	String morpheme2 = morpheme;
				                morpheme = "seguing";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("senat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "senate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sermilik")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sermonic";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sesam")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sesame";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("setti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "setting";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("shitti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "shifty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("shi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "shy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sideburn")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sideburn";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("signatur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "signature";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("silencio")) {
				            	String morpheme2 = morpheme;
				                morpheme = "silence";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("simpli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "simple";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sini")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("situat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "situate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("snack")) {
				            	String morpheme2 = morpheme;
				                morpheme = "snack";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sonni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sonny";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("spiritu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "spiritual";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("squar")) {
				            	String morpheme2 = morpheme;
				                morpheme = "square";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("starv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "starve";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("statu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "statue";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("still")) {
				            	String morpheme2 = morpheme;
				                morpheme = "still";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("strategi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "strategy";
				                crawling2(morpheme, title, morpheme2);
				            }
				            //--------------------------------------------------------------
				            else if (morpheme.equals("struck")) {
				            	String morpheme2 = morpheme;
				                morpheme = "struck";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("submarin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "submarine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("suicid")) {
				            	String morpheme2 = morpheme;
				                morpheme = "suicide";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("sunshin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "sunshine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("suppli")) {
				            	String morpheme2 = morpheme;
				                morpheme = "supply";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("suprem")) {
				            	String morpheme2 = morpheme;
				                morpheme = "supreme";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("surrend")) {
				            	String morpheme2 = morpheme;
				                morpheme = "surrender";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tai")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tai";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tak")) {
				            	String morpheme2 = morpheme;
				                morpheme = "take";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("takan")) {
				            	String morpheme2 = morpheme;
				                morpheme = "taken";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tammi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "Tammy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tasti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tasty";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("technolog")) {
				            	String morpheme2 = morpheme;
				                morpheme = "technology";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("teeth")) {
				            	String morpheme2 = morpheme;
				                morpheme = "teeth";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("temperatur")) {
				            	String morpheme2 = morpheme;
				                morpheme = "temperature";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tendo")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tendon";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tenni")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tennis";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("territori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "territory";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tst")) {
				            	String morpheme2 = morpheme;
				                morpheme = "test";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tissu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tissues";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tongu")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tongue";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("traci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "trace";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tragedi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tragedie";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tragedi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tragedy";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tribe")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tribe";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tribun")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tribune";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("tribut")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tribute";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("trumbl")) {
				            	String morpheme2 = morpheme;
				                morpheme = "tumble";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("type")) {
				            	String morpheme2 = morpheme;
				                morpheme = "type";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("unconsci")) {
				            	String morpheme2 = morpheme;
				                morpheme = "unconscious";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("underestim")) {
				            	String morpheme2 = morpheme;
				                morpheme = "underestimate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("unfortun")) {
				            	String morpheme2 = morpheme;
				                morpheme = "unfortunate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("unti")) {
				            	String morpheme2 = morpheme;
				                morpheme = "untie";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("urg")) {
				            	String morpheme2 = morpheme;
				                morpheme = "urge";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("vacat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vacate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("vaccin")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vaccine";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("valen")) {
				            	String morpheme2 = morpheme;
				                morpheme = "valence";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("valv")) {
				            	String morpheme2 = morpheme;
				                morpheme = "valve";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("vampir")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vampire";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("veget")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vegete";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("vibrat")) {
				            	String morpheme2 = morpheme;
				                morpheme = "vibrate";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("voi")) {
				            	String morpheme2 = morpheme;
				                morpheme = "void";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("volleybal")) {
				            	String morpheme2 = morpheme;
				                morpheme = "volleyball";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("wai")) {
				            	String morpheme2 = morpheme;
				                morpheme = "wait";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("watch")) {
				            	String morpheme2 = morpheme;
				                morpheme = "watch";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("weve")) {
				            	String morpheme2 = morpheme;
				                morpheme = "wave";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("wai")) {
				            	String morpheme2 = morpheme;
				                morpheme = "way";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("weii")) {
				            	String morpheme2 = morpheme;
				                morpheme = "weir";
				                crawling2(morpheme , title, morpheme2);
				            }else if (morpheme.equals("wori")) {
				            	String morpheme2 = morpheme;
				                morpheme = "worry";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("worthiest")) {
				            	String morpheme2 = morpheme;
				                morpheme = "worthiest";
				                crawling2(morpheme, title, morpheme2);
				            }else if (morpheme.equals("yong")) {
				            	String morpheme2 = morpheme;
				                morpheme = "young";
				                crawling2(morpheme, title, morpheme2);
				            }
							else if (morpheme.equals("dairi")) {
								String morpheme2 = morpheme;
								morpheme = "dairy";
								crawling2(morpheme, title, morpheme2);
							}
							else if (morpheme.equals("plough")) {
								String morpheme2 = morpheme;
								morpheme = "plough";
								crawling2(morpheme, title, morpheme2);
							}
							else if (morpheme.equals("peni")) {
								String morpheme2 = morpheme;
								morpheme = "penis";
								crawling2(morpheme, title, morpheme2);
							}
							else if (morpheme.equals("abil")) {
								String morpheme2 = morpheme;
								morpheme = "ability";
								crawling2(morpheme, title, morpheme2);
							}
							else if (morpheme.equals("counsellor")) {
								String morpheme2 = morpheme;
								morpheme = "counselor";
								crawling2(morpheme, title, morpheme2);
							} else {
								//delete(morpheme, title);
							}
					} 
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) sqlSession.close();
			}
			
		}*/
		
		
		/*public void crawling2(String morpheme, String title, String morpheme2) throws IOException {
			
			String base_url = "http://alldic.daum.net/search.do?q=";
			String complete_url = base_url + morpheme;
			
			Document doc = Jsoup.connect(complete_url).get();
			Elements card_word = doc.select("div.card_word");
			
			String word = null;
			String meaning = null;
			
			for(int j = 0; j < card_word.size(); j++) {
				Elements tit_word = card_word.get(j).select("h4.tit_word");
				Elements txt_emph1 = card_word.get(j).select("a.txt_cleansch span.txt_emph1");
				if (txt_emph1.text().equals(" ")) {
					System.out.println("값이 없어양");
				}
				Elements list_search = card_word.get(j).select("div.cleanword_type ul.list_search");
				
				if(tit_word.text().equals("영어사전")) {
					word = txt_emph1.text();
					meaning = list_search.toString();
					//System.out.println(word);
					//System.out.println(meaning);
					break;
				} else if(tit_word.text().equals("영영사전")){
					word = txt_emph1.text();
					//System.out.println(word);
				} else {
					continue;
				}
				
			}
			
			
			System.out.println("형태소 : " + morpheme);
			System.out.println("크롤링 단어 : " + word);
			System.out.println("크롤링 뜻 : " + meaning);
			morpheme = morpheme2;
			
			MovieEachDTO mDto = new MovieEachDTO(morpheme, word, meaning, title);
			completeTable(mDto);
			
		}*/
		
		
		// diy 단어장을 엑셀파일로 생성
		public void xlsWiter(List<MovieEachDTO> list, String title) {
	        // 워크북 생성
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        // 워크시트 생성
	        HSSFSheet sheet = workbook.createSheet();
	        // 행 생성
	        HSSFRow row = sheet.createRow(0);
	        // 쎌 생성
	        HSSFCell cell;
	        
	        // 헤더 정보 구성
	        cell = row.createCell(0);
	        cell.setCellValue("NO");
	        
	        cell = row.createCell(1);
	        cell.setCellValue("단어");
	        
	        cell = row.createCell(2);
	        cell.setCellValue("뜻");
	        
	        cell = row.createCell(3);
	        cell.setCellValue("빈도");
	        
	        // 리스트의 size 만큼 row를 생성
	        MovieEachDTO mDto = null;
	        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
	            mDto = list.get(rowIdx);
	            
	            // 행 생성
	            row = sheet.createRow(rowIdx+1);
	            
	            cell = row.createCell(0);
	            cell.setCellValue(mDto.getWno());
	            
	            cell = row.createCell(1);
	            cell.setCellValue(mDto.getWord());
	            
	            cell = row.createCell(2);
	            cell.setCellValue(mDto.getMeaning());
	            
	            cell = row.createCell(3);
	            cell.setCellValue(mDto.getFreq());
	            
	        }
	        
	        // 입력된 내용 파일로 쓰기
	        File file = new File("G:\\Dandy\\" + title + ".xls");
	        FileOutputStream fos = null;
	        
	        try {
	            fos = new FileOutputStream(file);
	            workbook.write(fos);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(workbook!=null) workbook.close();
	                if(fos!=null) fos.close();
	                
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
		
		

}
