package com.dandy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dandy.action.Action;
import com.dandy.action.ActionForward;
import com.dandy.action.BoardListAction;
import com.dandy.action.ContentsDetailAction;
import com.dandy.action.DiyCompleteAction;
import com.dandy.action.DiyLoadingAction;
import com.dandy.action.DiyPageAction;
import com.dandy.action.FreeAnswerAction;
import com.dandy.action.FreeAnswerInsertAction;
import com.dandy.action.FreeBoardDeleteAction;
import com.dandy.action.FreeBoardDetailAction;
import com.dandy.action.FreeBoardInsertSaveAction;
import com.dandy.action.FreeBoardListAction;
import com.dandy.action.FreeBoardSearchAction;
import com.dandy.action.FreeBoardUpdateSaveAction;
import com.dandy.action.FreeBoardUpdateViewAction;
import com.dandy.action.FreeBoardWriteAction;
import com.dandy.action.FreeCommentListAction;
import com.dandy.action.FreeReplyAction;
import com.dandy.action.FreeReplyDeleteAction;
import com.dandy.action.FreeboardGoodPointAction;
import com.dandy.action.FreeboardfiledownloadAction;
import com.dandy.action.QuestionBoardListAction;
import com.dandy.action.QuestionBoardSearchAction;
import com.dandy.action.QuestionBoardSortAction;
import com.dandy.action.QuestionBoardWriteAction;
import com.dandy.action.QuestionCommentListAction;
import com.dandy.action.QuestionReplyAction;
import com.dandy.action.QuestionBoardInsertsaveAction;
import com.dandy.action.IndexAction;
import com.dandy.action.LogOutAction;
import com.dandy.action.LoginAjaxAction;
import com.dandy.action.MemberCheckAjaxAction;
import com.dandy.action.MemberConstractAction;
import com.dandy.action.MemberInsertAction;
import com.dandy.action.MemberRegisterAction;
import com.dandy.action.MemberUpdateViewAction;
import com.dandy.action.MovieListAction;
import com.dandy.action.MypageContentsDetailAction;
import com.dandy.action.MypageMovieListAction;
import com.dandy.action.MywordInsertAction;
import com.dandy.action.MywordeleteAction;
import com.dandy.action.QuestionAnswerAction;
import com.dandy.action.QuestionAnswerInsertAction;
import com.dandy.action.QuestionBoardDeleteAction;
import com.dandy.action.QuestionBoardDetailAction;

/**
 * Servlet implementation class DandyFrontController
 */
@WebServlet("/DandyFrontController")
public class DandyFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DandyFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");

		// 인터페이스
		Action action = null;

		// 페이지 이동방법 결정(Forward, sendRedirect)
		ActionForward forward = null;

		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length()); // uri에서 ctx를 빼면 내가 원하는 소스만 출력

		System.out.println("uri : " + uri);
		System.out.println("ctx : " + ctx);
		System.out.println("command : " + command);

		// ======= 액션 매핑 ======= //
		// 실제로 동작하는 곳, 하나의 Servlet에서 URL을 읽어 해당 기능을 구현
		if (command.equals("/index.dandy")) {
			action = new IndexAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/loginajax.dandy")) {
			action = new LoginAjaxAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/logout.dandy")) {
			action = new LogOutAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/boardQuestionInsertsave.dandy")) {
			action = new QuestionBoardInsertsaveAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/questionBoardList.dandy")) {
			action = new QuestionBoardListAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/questionBoardDetail.dandy")) {
			action = new QuestionBoardDetailAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/questionReply.dandy")) {
			action = new QuestionReplyAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/questionBoardSort.dandy")) {
			action = new QuestionBoardSortAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}		
		else if (command.equals("/questionBoardWrite.dandy")) {
			action = new QuestionBoardWriteAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/question_answer.dandy")) {
			action = new QuestionAnswerAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/questionAnswerInsert.dandy")) {
			action = new QuestionAnswerInsertAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/questionBoardSearch.dandy")) {
			action = new QuestionBoardSearchAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/memberCheckAjax.dandy")) {
			action = new MemberCheckAjaxAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/memberRegister.dandy")) {
			action = new MemberRegisterAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/memberConstract.dandy")) {
			action = new MemberConstractAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/memberInsert.dandy")) {
			action = new MemberInsertAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/movieList.dandy")) {
			action = new MovieListAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/questionCommentList.dandy")) {
			action = new QuestionCommentListAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/freeBoardList.dandy")) {
			action = new FreeBoardListAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeBoardDetail.dandy")) {
			action = new FreeBoardDetailAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeBoardInsertSave.dandy")) {
			action = new FreeBoardInsertSaveAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/diypage.dandy")) {
			action = new DiyPageAction(); // action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
		}
		else if (command.equals("/diyComplete.dandy")) {
			action = new DiyCompleteAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/contentsDetail.dandy")) {
			action = new ContentsDetailAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeBoardWrite.dandy")) {
			action = new FreeBoardWriteAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/mypageMovieList.dandy")) {
			action = new MypageMovieListAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeBoardSearch.dandy")) {
			action = new FreeBoardSearchAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeBoardDelete.dandy")) {
			action = new FreeBoardDeleteAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeBoardUpdateView.dandy")) {
			action = new FreeBoardUpdateViewAction();
			forward = action.excute(request, response);
		}
		else if (command.equals("/mypageContentsDetail.dandy")) {
			action = new MypageContentsDetailAction();
			forward = action.excute(request, response);
		}
		else if (command.equals("/mywordInsert.dandy")) {
			action = new MywordInsertAction();
			forward = action.excute(request, response);
		}
		else if (command.equals("/freeBoardUpdateSave.dandy")) {
			action = new FreeBoardUpdateSaveAction();
			forward = action.excute(request, response);
		}
		else if (command.equals("/freeAnswer.dandy")) {
			action = new FreeAnswerAction();
			forward = action.excute(request, response);
		}
		else if (command.equals("/freeAnswerInsert.dandy")) {
			action = new FreeAnswerInsertAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeReply.dandy")) {
			action = new FreeReplyAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeCommentList.dandy")) {
			action = new FreeCommentListAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeReplyDelete.dandy")) {
			action = new FreeReplyDeleteAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeboardfiledownload.dandy")) {
			action = new FreeboardfiledownloadAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/freeboardgoodpoint.dandy")) {
			action = new FreeboardGoodPointAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/mywordDelete.dandy")) {
			action = new MywordeleteAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/memberupdateview.dandy")) {
			action = new MemberUpdateViewAction(); 
			forward = action.excute(request, response); 
		}
		else if (command.equals("/questionBoardDelete.dandy")) {
			System.out.println("이걸 안타는거야?");
			action = new QuestionBoardDeleteAction(); 
			forward = action.excute(request, response); 
		} else if (command.equals("/diyLoading.dandy")) {
			action = new DiyLoadingAction(); 
			forward = action.excute(request, response); 
		}
		
		
		
		
		// ======= 공통분기 작업 ======= //
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}

	}

}
