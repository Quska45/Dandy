<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
/* font-family: 'Hanna', serif; */
	
	body{
	}
	#table {
		width: 1100px;
		margin: 90px 35px;
	}
	#table_contents, #inner_contents {
		border-left: none;
		border-right: none;
		border-bottom : 2px solid #0daa62; 
	}
	table {
		 table-layout: fixed;
	}
	#subject {
		font-size: 45px;
		text-align: center;
		color: #a7a7a7;
	}
	tr {
		height: auto;
	}
	.no, .contents, .name, .date {
		padding: 5px 0;
	}
	#table_contents {
		width: 1100px;
		margin: 0;
	}
	.no {
		width: 100px !important; 
		text-align: center;
		border-radius: 5px;
	}
	.contents {
		width: 500px !important;
		text-align: left;
		padding-left: 100px !important; 
	}
	#con {
		width: 700px !important;
		text-align: center;
	}
	#re_con{
		width: 700px;
		padding-left: 90px;
		text-align: left;
	}
	#rewrite{
		width: 700px !important;
		text-align: left;
	}
	.name {
		width: 130px !important;
		text-align: center;
		border-radius: 5px;
	}
	.date {
		width: 170px !important;
		text-align: center;
		border-radius: 5px;
	}
	.view {
		width: 100px !important;
		text-align: center;
		border-radius: 5px;
	}
	#inner_consub {
		text-align: center;
	}
	#list {
		text-align: left;
	}
	#re {
		color: #990000;
		font-size: 16px;
		background-color: white;
		border: 1px solid #990000;
		border-radius: 5px;
		width: 120px;
		padding: 5px;
	}
	#re_count {
		color: black;
	}
	#con_size {
		height: 200px;
	}
	#re_input {
		width: 500px;
		height: 145px;
		font-size: 18px;
		color: #ddd;
		border: 1px solid #ededed;
	}
	#rn_input {
		width: 100px;
		height: 145px;
		border: none;
		text-align: center;
		font-size: 16px;
		background-color: #f7f7f7;
	}
	#page_footer {
		height: 200px;
	}
	#freere_btn {
		border-radius: 5px;
		background-color: #0daa62;
		border: none;
		width: 100px;
		height: 26px;
		margin-bottom: 10px;
		color: white;
		font-size: 15px;
		cursor:pointer;	
	}
	.board_btn {
		border-radius: 5px;
		background-color: #0daa62;
		border: none;
		width: 70px;
		height: 26px;
		margin-bottom: 10px;
		color: white;
		font-size: 15px;
		cursor:pointer;	
		border: 0 15px;
		cursor: pointer;
		}
	#bno {
		border: none;
		background-color: #f7f7f7;
		text-align: center;
		width: 100px !important;
		font-size: 15px;
	}
	#re_login {
		text-align: center;
		height: 100px;
	}
	#re_idch {
		color: black;
	}
	#login {
		color: #0daa62;
		text-decoration: none;
		font-size: 17px;
	}
	form {
	}
	#freewr_btn {
		background-color: #0daa62;
		border: none;
		width: 100px;
		height: 26px;
		margin-bottom: 10px;
		border-radius: 5px;
		color: white;
		font-size: 15px;	
		cursor:pointer;
	}
	#recount {
		font-size: 18px;
		padding-left: 0px !important;
	}
	#remove_rebtn {
		border-radius: 5px;
		background-color: #0daa62;
		width: 50px;
		height: 26px;
		margin-bottom: 10px;
		color: white;
		font-size: 15px;
		cursor:pointer;	
		border: none;
	}
	#noreply {
		text-align: center;
		padding-bottom: 20px;
	}
	#file_upload{
		font-size: 16px;
		color: #0daa62;
		background-color: #f7f7f7;
		text-align: center;
		font-weight: bold;
	}
	#goodcnt {
		background-color: #f7f7f7;
		width:70px;
		height: 25px;
		margin-bottom: 10px;
		//font-size: 20px;
		//color: #0daa62;;
		text-align: center;
		line-height: 25px;
		border: none;
	}
	#freeboard_filedown {
		text-decoration: none;
	}
	#download {
		color: #a7a7a7;
	}
	#downcnt {
		margin-left: 50px;
		color: #0daa62;;
	}
	#fafa_icon, #good_fafa {
		color: #0daa62;;
	}
	#viewcnt, #goodcnt {
		color: #555555;
	}
	#table_top {
		background-color: #0daa62;
		color: white;
		border-radius: 5px;
		border: #0daa62;
		height: 40px;
	}
	/* 게시판 삭제 확인 모달 */	
	.mask {
 		width:100%;
 		height:100%;
 		position:fixed;
 		left:0;
 		top:0;
 		z-index:10;
 	}
 	#mo_board_del {
 		display:none;
		position: fixed; 
		z-index: 100!important; 
		left: 0;
		top: 0;
		width: 100%; 
		height: 100%; 
		overflow: auto; 
		background-color: rgb(0, 0, 0);
		background-color: rgba(0, 0, 0, 0.4);
 	}
 	#mo_board_del .modal_del {
 		width: 180px;
 		height: 120px;
 		padding: 35px;
 		border:1px solid #ccc;
 		border-radius: 15px;
 		position:fixed;
 		left:45%;
 		top:45%; 
 		z-index:11;
 		background:#fff;
 		text-align: center;
 	}
	#text {
		font-size: 15px;
	}
	#sel_bbtn{
		margin: 0 auto;
	}
	#remove_btn2 {
		float: left;
	}
	#cancel_bbtn {
		float: right;
	}
	.bbtn{
		margin: 50px 15px 0 15px;
		color: #555555;
		padding: 7px 14px;
		font-size: 15px;
		cursor:pointer;		
		background-color: #ededed;
		border-radius: 5px;
		border: 1px solid white;
	}
	.bbtn:hover {
		border: 1px solid #0daa62;
		background-color: white;
		color: #0daa62;
	}
	#freeremove_btn {
		margin-left: 0!important;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	
	$(document).ready(function(){
		
		//자유게시판 : 리플리스트
		function comment_list() {
			var bno = ${boardview.bno};

			$.ajax({
				type: "post",
				url: "freeCommentList.dandy",
				data: "bno=" + bno,
				success: function(result) {
					$("#commentList").html(result);
				}, error: function() {
					alert("System Error!!!");
				}
			});
		}
		
		//자유게시판 : 댓글 등록 AJAX
		$(document).on("click", "#freere_btn", function(){
			var re_input = $("#re_input").val();	// 댓글 내용
			var rn_input = $("#rn_input").val();	// 댓글 작성자
			var re_bno = $("#re_bno").val();	// 댓글 번호
		
			$.ajax({
				url: "freeReply.dandy",
				type: "POST",
				dataType: "json",
				data: "re_input="+ re_input + "&rn_input=" + rn_input + "&re_bno=" + re_bno,
				success: function(data) {
					comment_list();
				}
			});
		});
		
		// 자유게시판 : 댓글 삭제 AJAX
		$(document).on("click", ".reply_del", function(){
			var rno = $(this).attr("data_num");
			
			$.ajax({
		 		 url: "freeReplyDelete.dandy",
		 		 type: "POST",	
		 		 dataType: "json",
		 		 data: "rno=" + rno,
		 		 success: function(data) {
		 			comment_list();
		 		 }, error: function() {
		 			 alert("System Error!!!");
		 		 }
		 	 });
		});
		
	});
	
	
	
	
	// 자유게시판 : 좋아요♥
	$(document).on("click", "#good_fafa", function(){
		var gpoint = $("#gpoint").val();
		var bno = ${boardview.bno};
		$.ajax({
			url: "freeboardgoodpoint.dandy",
			type: "POST",
			dataType: "json",
			data: "bno=" + bno,
			success: function(data) {
				//alert(data.gpoint);
			}, error: function() {
				alert("System Error!!!");
			}
		});
	});
	
	// 자유게시판 : 삭제 확인 모달
	$(document).on("click", "#freeremove_btn1", function(){
		$("#mo_board_del").css("display", "block");
	});
	
	$(document).on("click", "#cancel_btn", function(){
		$("#mo_board_del").css("display", "none");
	});
	
	
	
</script>
</head>
<body>
<input type="hidden" id="free_answer_bno" value="${boardview.bno}">
<div id="board">
	<div id="table">
			<table id="table_top">
				<tbody>
					<tr>
						<td class="no"><span>NO</span></td>
						<td id="con"><span>CONTENTS</span></td>
						<td class="name"><span>NAME</span></td>
						<td class="date"><span>DATE</span></td>
						<td class="view"><span>&nbsp;</span></td>
					</tr>
				</tbody>
			</table>
			<table id="table_contents">
				<tbody>
			<!-- 작성 정보 -->
					<tr>
						<td class="no">
							<input type="text" name="bno" id="bno" value="${boardview.bno}" >
						</td>
						<td class="contents">
							<span>${boardview.title}</span>
						</td>
						<td class="name">
							<span>${boardview.writer}</span>
						</td>
						<td class="date">
							<span>${boardview.regdate}</span>
						</td>
						<td class="view">
							<i id="fafa_icon" class="fa fa-eye"></i>
							<span id="viewcnt">${boardview.viewcnt}</span>
							<i id="good_fafa" name="good_fafa" class="fa fa-heart-o"></i>
							<input type="hidden" id="gpoint" value="${gpoint}" readonly="readonly">
							<span id="goodcnt">${boardview.goodcnt}</span>
						</td>
					</tr>
			<!-- 첨부파일 -->
			<c:if test="${boardview.filesize > 0}">
					<tr>
						<td id="file_upload">
							<span><i class="fa fa-file"></i></span>
						</td>
						<td class="contents">
							<a href="#" id="freeboard_filedown">
								<span id ="download">${boardview.filename}</span>
								<span id="downcnt">
									<i class="fa fa-arrow-circle-o-down"></i>
									${boardview.downcnt}
								</span>
							</a>
						</td>
						<td class="name">
							<span>&nbsp;</span>
						</td>
						<td class="date">
							<span>&nbsp;</span>
						</td>
						<td class="view">
							<span>&nbsp;</span>
						</td>
					</tr>
			</c:if>
				
					<tr>
						<td colspan="5" bgcolor="#ddd" height="1"></td>
					</tr>
			<!-- 본문 -->
					<tr id="con_size">
						<td class="no">
							<span>문의내용</span>
						</td>
						<td class="contents">
							<span>
								${boardview.content}
							</span>
						</td>
						<td class="name">
							<span>&nbsp;</span>
						</td>
						<td class="date">
							<span>&nbsp;</span>
						</td>
						<td class="view">
							<span>&nbsp;</span>
						</td>
					</tr>
					
					<tr>
						<td colspan="5" bgcolor="#ddd" height="1"></td>
					</tr>
					<tr>
						<td colspan="5" bgcolor="white" height="#f7f7f7"></td>
					</tr>
					<tr>
						<td class="no" id="list">
							<input type="button" class="board_btn" id="freelist_btn" value="목록">
						</td>
						<td id="rewrite">
							<c:choose>
								<c:when test="${empty sessionScope.loginUser}">
									<span>&nbsp;</span>
								</c:when>
								<c:otherwise>
									<input type="button" class="board_btn" id="free_rewrite_btn" value="답변">
								</c:otherwise>
							</c:choose>
						</td>
						<c:choose>
							<c:when test="${sessionScope.loginUser.mid == boardview.writer}">
								<td class="name">
									<input type="button" class="board_btn" id="freemodify_btn"  value="수정">
								</td>
								<td class="date">
									<input type="button" class="board_btn" id="freeremove_btn1"  value="삭제">
									<input type="hidden" name="pcode" id="pcode" value="${pcode}">
								</td>
							</c:when>
							<c:otherwise>
								<td class="name">
									<span>&nbsp;</span>
								</td>
								<td class="date">
									<span>&nbsp;</span>
								</td>
							</c:otherwise>
						</c:choose>
						<td class="view">
							<a href="#"><input type="button" id="freewr_btn" value="글쓰기"></a>
						</td>
						
					</tr>
					<tr>
						<td colspan="5" bgcolor="#f7f7f7" height="50"></td>
					</tr>
					</tbody>
					<!-- 댓글 -->
					<input type="hidden" id="re_count" name="re_count" value=" ${re_count}">
					<tbody id="commentList"></tbody>
					
					<!-- 댓글 등록 -->
					<tbody>
					<tr>
						<td colspan="5" bgcolor="#EEEEEE" height="1"></td>
					</tr>
					<tr>
				<c:choose>
					<c:when test="${empty sessionScope.loginUser}">
							<td colspan="5" id="re_login">
								<span id="re_idch"><a href="#" id="free_board_detail_login">로그인</a>을 하시면 댓글과 답변을 등록하실 수 있습니다.</span>
							</td>
					</c:when>
					<c:otherwise>
							<td class="no" >
								<span>&nbsp;</span>
							</td>
					<input type="hidden" name="re_bno" id="re_bno" value="${boardview.bno}" >
							<td id="re_con">
								<input type="text" id="re_input" name="re_input" placeholder="댓글 작성하기" >
							</td>
							<td class="name">
								<input type="text" id="rn_input" name="rn_input" value="${sessionScope.loginUser.mid}">
							</td>
							<td class="date">
								<input type="button" id="freere_btn" name="freere_btn" value="댓글달기">
							</td>
							<td class="view">
								<span>&nbsp;</span>
							</td>
					</c:otherwise>
				</c:choose>
						</tr>
				</tbody>
			</table>
	</div>
	<div id="page_footer">
		<span>&nbsp;</span>
	</div> 
	
<!-- 게시글 삭제 확인 모달창 -->
	<div id="mo_board_del">
	  <div class="modal_del">
	  	<c:choose>
			<c:when test="${bno != '0'}">
						<span id="text">글을 삭제하시겠습니까?</span>
					<div id="sel_bbtn">
							<br>
							<a href="#">
								<button class="bbtn" id="freeremove_btn">삭제</button>
							</a>
							<button class="bbtn" id="cancel_btn">취소</button>
					</div>
			</c:when>
			<c:when test="${re_count !='0'}">
						<span id="text">해당 글은 댓글이 있어 삭제가 불가 합니다.</span>
				<div id="sel_bbtn">
						<br>
						<button class="bbtn" id="okay_btn">확인</button>
				</div>
			</c:when>
		</c:choose>
		</div>
	</div>
	
</div>
</body>
</html>