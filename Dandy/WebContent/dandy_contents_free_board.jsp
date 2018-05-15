<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- commit 추가 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
/* font-family: 'Nanum Gothic', serif; */
/* font-family: 'Hanna', serif; */
	body {
	}
	a {
		text-decoration: none;
		color: none;
	}
	#table {
		width: 1100px;
		margin: 90px 35px;
	}
	#board_table > tr {
		height: 30px;
	}
	.no {
		width: 100px!important;
		text-align: center;
	}
	.contents {
		width: 650px!important;
		text-align: left;
		padding-left: 10px; 
	}
	.upload{
		width: 50px!important;
		text-align: center;
		font-size: 16px;
		color: #0daa62;
		font-weight: bold;
	}
	.point {
		width: 50px;
		text-align: center;
	}
	#contents {
		text-align: center;
	}
	.name {
		width: 130px!important;
		text-align: center;
	}
	.date {
		width: 140px!important;
		text-align: center;
	}
	.view {
		width: 130px!important;
		text-align: center;
		padding-right: 30px;
	}
	#re {
		color: #990000;
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
	#table_top {
		border-top: 2px solid #0daa62;
		border-bottom : 2px solid #0daa62;
		height: 40px;
		background-color: #0daa62;
		color: white;
		border-radius: 5px;
	}
	.qnasearch {
		float: right;
	}
	#free_search_keyword {
		width: 140px;
		height: 26px;
		font-size: 13px;
		box-sizing: border-box;
		display: block;
		border: 1px solid #0daa62;
		padding-left: 5px;
		margin-left: 15px;
		font-style: oblique;
	}
	#free_search_btn {
		width: 50px;
		height: 26px;
		background-color: #0daa62; 
		color: #FFFFFF;
		display: block;
		border: 0px;
	}
	#page_num {
		text-align: center;
		margin-bottom: 100px;
		color: black!important;
	}
	#reline {
		height: 30px;
	}
	#line {
		height: 80px;
	}
	#number_tr {
		height: 100px;
	}
	#page_td {
		width: 700px;
		padding-left: 382px;
	}
	.text_black {
		color: black!important;
	}
	#pageline {
		text-align: center;
		float: none;
		margin: 25px 550px 25px 500px;
	}
	#pagetable {
		border-collapse: collapse;
		text-align: center;
	 	line-height: 40px;
	 	background-color: white;
	 	font-weight: bold;
	 	color: #0daa62;
	}
	#pagetable tr, #pagetable td {
		border: 1px solid #0daa62;
	 }
	 #pagetable tr {
	 	height: 40px;
	 }
	 #pagetable td {
	 	padding-left: 15px;
	 	padding-right: 15px;
	 }
	 #pagetable td > a{
	 	color: #0daa62;
	 } 
	 #big_table {
	 	margin-bottom: 30px;
	 }
	  #recount{
	 	color: #990000;
	 } 
	 #free_selsearch {
		width: 80px;
		height: 26px;
	}
	.searchkey_ms {
		text-align: center;
		padding-bottom: 10px;
    	padding-top: 5px;
    	font-size: 17px;
	}
	#key {
		color: #0daa62;
	}
	#new {
		color: #0daa62;
		border: 1px solid #0daa62;
		font-size: 14px;
		background-color: white;
		border-radius: 5px;
		padding: 1px 3px;
	}
	#fafa_icon, #good_fafa {
		color: #0daa62;
	}
	#viewcnt, #goodcnt {
		color: #555555;
	}
	.lineup {
		color: white;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		var code = $("#code").val();
		
		/* $("#freewr_btn").on("click", function(){
			location.href="boardloginck.bizpoll";
		}); */
	
			if(code == 1){
				$("#id01").css("display","block");
				
				code != 1;
				
			} else if(code != 1){
				$("#id01").css("display","none");
			}
				
			// 댓글 수 표시
			var bnoform = $("#bnoform");
			bnoform.submit();
			
			//게시판 상세 페이지를 띄우는 쿼리 : 자유게시판
			$(document).on("click", "#freeboardDetailBtn", function(){
				var bno = $(this).attr("data_num");
				$.ajax({
					url : "freeBoardDetail.dandy",
					type : "POST",
					data : "bno=" + bno,
					success : function(result) {
						$("#boardList").html(result);
					},
					error : function() {
						alert("System Error!!!");
					}

				});
				
			});
			
	});
	
	$(document).on("click","#qnasearch_btn",function(){
		
		$("#frm_search").submit();
		
	});
	
	// 자유게시판 : 글쓰기를 누르면 게시글 작성페이지로 가는 쿼리
	$(document).on("click", "#freewr_btn", function(){
		var sessionLogin = $("#sessionMid").val();
		if(sessionLogin==""){
			$(".modal").css("display", "block");
		} else {
			$.ajax({
				type : "post",
				url : "freeBoardWrite.dandy",
				success : function(result) {
					$("#boardList").html(result);
				}
			});
		}
	});
	
	/* // 게시판 정렬
	var lineup_code = $("#lineup_code").val();
	$(document).on("click", "#l_no", function(){
		location.href="qna.bizpoll?lineup_code=" + "l_no";
	});
	$(document).on("click", "#l_contents", function(){
		location.href="qna.bizpoll?lineup_code=" + "l_contents";
	});
	$(document).on("click", "#l_name", function(){
		location.href="qna.bizpoll?lineup_code=" + "l_name";
	});
	$(document).on("click", "#l_date", function(){
		location.href="qna.bizpoll?lineup_code=" + "l_date";
	});
	$(document).on("click", "#l_view", function(){
		location.href="qna.bizpoll?lineup_code=" + "l_view";
	});
	$(document).on("click", "#l_good", function(){
		location.href="qna.bizpoll?lineup_code=" + "l_good";
	}); */
</script>
</head>
<body>
<div id="board">
	<div id="table">
				<div>
					<input type="hidden" name="code" id="code" value="${code}">
					<span width="100">&nbsp;</span>
					<span>
						<a href="#"><input type="button" id="freewr_btn" value="글쓰기"></a>
					</span>
					<input id="free_search_btn" class="qnasearch" type="submit" value="검색">
					<input id="free_search_keyword" class="qnasearch" name="search_keyword" type="text" placeholder="검색어">
					<select id="free_selsearch" name="free_selsearch" class="qnasearch" >
							<option value="1">전체</option>
							<option value="---------------">---------------</option>
							<option value="2">제목</option>
							<option value="3">내용</option>
							<option value="4">제목 + 내용</option>
							<option value="5">작성자</option>
						</select>
				</div>
		<table id="big_table">
			<tbody>
				<tr>
			<c:if test="${!empty keyword}">
					<td class="searchkey_ms"  id="searchkeyword_block">
						<span>『 ${selflag} 』&nbsp;&nbsp;</span>
						<span id="key">"${keyword}"</span>
						<span>&nbsp;&nbsp;검색&nbsp;&nbsp;결과&nbsp;:&nbsp;&nbsp;${freeboardlist.size()}&nbsp;건</span>
					</td>
			</c:if>
					<td class="searchkey_ms" id="searchkeyword_none">
						<span>&nbsp;</span>
					</td>
				</tr>
				<tr>
					<td id="table_top">
						<input type="hidden" name="lineup_code" value="">
						<table>
							<tbody>
								<tr>
									<td class="no">
										<a href="#" id="l_no" class="lineup">
											<span>NO</span>
										</a>
									</td>
									<td class="point"></td>
									<td class="upload"></td>
									<td class="contents" id="contents">
										<a href="#"  id="l_contents"  class="lineup">
											<span>CONTENTS</span>
										</a>
									</td>
									<td class="name" id="name">
										<a href="#"  id="l_name" class="lineup">
											<span>NAME</span></a>
										</td>
									<td class="date" id="date">
										<a href="#"  id="l_date" class="lineup">
											<span>DATE</span>
										</a>
									</td>
									<td class="view" id="view">
										<a href="#"  id="l_view" class="lineup">
											<span><i class="fa fa-eye"></i></span>
										</a>
										<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
										<a href="#" id="l_good"  class="lineup">
											<span><i class="fa fa-heart"></i></span>
										</a>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				
			<!-- 게시물 시작 -->
				<tr>
					<td id="board_table">
						<table>
							<tbody>
							
								<c:forEach items="${freeboardlist}" var="bDto">
								<tr id="line">
									<input type="hidden" id="free_hiddenBno" name="free_hiddenBno" value="${bDto.bno}">
									<td class="no"><span>${bDto.bno}</span></td>
									<td class="point">
										<c:if test="${today2 == regdate2}">
											<span id="new">new</span>
										</c:if>
									</td>
									
									<td class="upload">
										<span>&nbsp;
											<c:if test="${bDto.filesize > 0}">
											<i class="fa fa-file"></i>
											</c:if>
										</span>
									</td>
									<td class="contents">
										<table>
											<tr>
												<td>
													<a id="freeboardDetailBtn" href="#" data_num="${bDto.bno}">
														<span class="text_black">
															<c:forEach var ="i" begin="1" end="${bDto.re_level}">
																&nbsp;&nbsp;&nbsp;
															</c:forEach>
															${bDto.title}&nbsp;&nbsp;&nbsp;
															</span>
														<c:if test="${bDto.replycnt!='0'}">
															<span id="recount">(${bDto.replycnt})</span>
														</c:if>
													</a>
												</td>
											</tr>
										</table>
									</td>
									<td class="name"><span>${bDto.writer}</span></td>
									<td class="date">
										<span>
											<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="today2"/>
											<fmt:formatDate value="${bDto.regdate}" pattern="yyyy-MM-dd" var="regdate2"/>
										</span>
										<c:choose>
											<c:when test="${today2 == regdate2}">
												<fmt:formatDate pattern="HH:mm:ss"  value="${bDto.regdate}"/>
											</c:when>
											<c:otherwise>
												<fmt:formatDate pattern="yyyy-MM-dd" value="${bDto.regdate}"/>
											</c:otherwise>
										</c:choose>
									</td>
									<td class="view" id="view">
										<i id="fafa_icon" class="fa fa-eye"></i>
										<span id="viewcnt">${bDto.viewcnt}</span>
										&nbsp;&nbsp;
										<c:choose>
											<c:when test="${bDto.goodcnt > 0}">
												<i id="good_fafa" class="fa fa-heart"></i>
											</c:when>
											<c:otherwise>
												<i id="good_fafa" class="fa fa-heart-o"></i>
											</c:otherwise>
										</c:choose>
												<span id="goodcnt">${bDto.goodcnt}</span>
									</td>
								</tr>
								<tr>
									<td colspan="7" bgcolor="#ddd" height="1"></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<div id="page_wrap">
			<div id="pageline">
				<table id="pagetable">
						<tr>
							<c:if test="${pageMaker.prev}">
								<td>
									<a href="freeBoardList.dandy?page=${pageMaker.startPage - 1}">◀</a>
								</td>
							</c:if>
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
								<td>
									<a <c:out value="${pageMaker.criDto.page == idx? 'class=active':''}"/>></a>
									<a href="freeBoardList.dandy?page=${idx}">${idx}</a>
								</td>
							</c:forEach>
							<c:if test="${pageMaker.next}">
								<td>
									<a href="freeBoardList.dandy?page=${pageMaker.endPage + 1}">▶</a>
								</td>
							</c:if>
						</tr>
				</table>
			</div>
		</div>
	</div>
</div>

</body>
</html>