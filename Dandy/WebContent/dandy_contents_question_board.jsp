<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QnA</title>
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
	#wrap_contents1 {
		font-family: 'Noto Sans KR', sans-serif;
		width: 1200px;
		height: 1700px;
		border: 2px solid white;
		background-color: #f7f7f7;
		border-radius: 10px;
		margin: 100px 200px;
	}
	#wr_btn {
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
	#question_search_keyword {
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
	#question_search_btn {
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
		margin: 25px 550px;
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
	 	width: 40px;
	 	padding: 0 15px;
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
	 #question_selsearch {
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
	.active {
		color: #0daa62!important;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	

	
	
	

</script>
</head>
<body>

<div id="board">
	<div id="table">
				<div>
					<input type="hidden" name="code" id="code" value="${code}">
					<span width="100">&nbsp;</span>
					<span>
					
					
					<!-- view 단 이어놓기 위해 임의로 jsp끼리 연결 -->
						<a href="#"><input type="button" id="wr_btn" value="글쓰기"></a>
						
						
					</span>
					<input id="question_search_btn" class="qnasearch" type="button" value="검색">
					<input id="question_search_keyword" class="qnasearch" name="search_keyword" type="text" placeholder="검색어">
					<select id="question_selsearch" name="selsearch" class="qnasearch" >
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
						<span>&nbsp;&nbsp;검색&nbsp;&nbsp;결과&nbsp;:&nbsp;&nbsp;${questionboardlist.size()}&nbsp;건</span>
					</td>
			</c:if>
					<td class="searchkey_ms" id="searchkeyword_none">
						<span>&nbsp;</span>
					</td>
				</tr>
				<tr>
					<td id="table_top">
						<table>
							<tbody>
								<tr>
									<td class="no">
										<a href="#" id="l_no" class="lineup">
										<input type="hidden" id="l_no_input" value="${sort}">
										<input type="hidden" id=l_no_input_keyword value="NO">
										
											<span>NO</span>
										</a>
									</td>
									<td class="point"></td>
									<td class="upload"></td>
									<td class="contents" id="contents">
										<a href="#"  id="l_contents"  class="lineup">
										<input type="hidden" id="l_content_input" value="${sort}">
										<input type="hidden" id=l_content_input_keyword value="CONTENTS">
											<span>CONTENTS</span>
										</a>
									</td>
									<td class="name" id="name">
										<a href="#"  id="l_name" class="lineup">
										<input type="hidden" id="l_name_input" value="${sort}">
										<input type="hidden" id=l_name_input_keyword value="NAME">
											<span>NAME</span></a>
										</td>
									<td class="date" id="date">
										<a href="#"  id="l_date" class="lineup">
										<input type="hidden" id="l_date_input" value="${sort}">
										<input type="hidden" id=l_date_input_keyword value="DATE">
											<span>DATE</span>
										</a>
									</td>
									<td class="view" id="view">
										<a href="#"  id="l_view" class="lineup">
										<input type="hidden" id="l_view_input" value="${sort}">
											<span><i class="fa fa-eye"></i></span>
										</a>
										<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
										<a href="#" id="l_good"  class="lineup">
										<input type="hidden" id="l_good_input" value="${sort}">
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
							
								<c:forEach items="${questionboardlist}" var="bDto">
								<tr id="line">
									<td class="no"><span>${bDto.bno}</span></td>
									<td class="point">
										<c:if test="${today2 == regdate2}">
											<span id="new">new</span>
										</c:if>
									</td>
									
									<td class="contents">
										<table>
											<tr>
												<td>
													<a id="boardDetailBtn" href="#" data_num="${bDto.bno}" secret_flag="${bDto.flag}" writer="${bDto.writer}">
														<span class="text_black">
															<c:forEach var ="i" begin="1" end="${bDto.re_level}">
																&nbsp;&nbsp;&nbsp;
															</c:forEach>
															${bDto.title}&nbsp;&nbsp;&nbsp;
															<c:if test="${bDto.flag == 1}">
																<i class="fa fa-expeditedssl"></i>
															</c:if>
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
									<a href="questionBoardList.dandy?page=${pageMaker.startPage - 1}">◀</a>
								</td>
							</c:if>
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
								<td>
									<a <c:out value="${pageMaker.criDto.page == idx? 'class=active':''}"/> class="pageMove" href="#" page_num="${idx}">${idx}</a>
									
								</td>
							</c:forEach>
							<c:if test="${pageMaker.next}">
								<td>
									<a href="questionBoardList.dandy?page=${pageMaker.endPage + 1}">▶</a>
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