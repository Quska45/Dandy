<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="image/cupfavi.png">
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
/* font-family: 'Noto Sans KR', sans-serif; */
	
 /** contents page body */
	#wrap_contents {
		font-family: 'Noto Sans KR', sans-serif;
		width: 1200px;
		height: 1700px;
		border: 2px solid white;
		background-color: #EEE9DD;
		border-radius: 10px;
		margin: 100px 200px;
	}
	

 /** 영화 검색창 */
	#search_box {
		text-align: center;
		margin-top: 100px;
	}
	
 /*- 검색창 키워드 박스  */
 	#search_keyword {
 		font-family: 'Noto Sans KR', sans-serif;
 		width: 300px;
 		height: 30px;
 		border: 1px solid white;
 		border-radius: 5px;
 		font-style: oblique;
 		padding-left: 10px;
 		font-size: 15px;
 	}
  /*- 검색 버튼  */
 	#search_btn {
 		width: 40px;
 		height: 30px;
 		border: 1px solid #EEE9DD;
 		background-color: #EEE9DD;
 		border-radius: 5px;
 		font-size: 15px;
 		font-weight: bold;
 		color: #FA6C00;
 	}

 /** 알파벳 페이지 */
 	#alpha_page {
 		text-align: center;
 		margin-top: 30px;
 		width :1200px;
 		height: 50px;
 	}
 	#alpha_page > a {
 		font-family: 'Noto Sans KR', sans-serif;
 		text-decoration: none;
 		font-size: 25px;
 		color: black;
 		padding: 5px;
 	}

 /** 영화 포스터 */
 	#poster {
 		text-align: center;
 		margin: 50px 100px;
 	}
 	.poster_frame {
 		width: 250px;
 		height: 375px;
 		background-color: #FA6C00;
 		float: left;
 		margin: 0 40px 50px 40px;
 		border: 1px solid #FA6C00;
 		border-radius: 5px;
 	}
 	#movieposter {
 		width: 240px;
 		height: 345px;
 		/* border: 1px solid red; */
 		border-radius: 5px;
 		margin: 2px 5px;
 		background-color: white;
 	}
 	#movieposter > img {
 		width: 240px;
 		height: 345px;
 		border-radius: 5px;
 	}
 	.poster_frame a {
 		font-family: 'Noto Sans KR', sans-serif;
 		width: 240px;
 		height: 30px;
 		/* border: 1px solid yellow; */
 		text-decoration: none;
 		font-size: 15px;
 		background-color: #FA6C00;
 		color: white;
 		font-weight: bold;
 		
 	}
 /** 숫자 페이지 */
 	#num_page {
 		text-align: center;
 		margin-top: 1350px;
 		width :1200px;
 		height: 50px;
 	}
 	#num_page > a {
 		font-family: 'Noto Sans KR', sans-serif;
 		text-decoration: none;
 		font-size: 18px;
 		background-color: #EEE9DD;
 		color: #FA6C00;
 		padding: 5px 10px;
 		border: 1px solid #FA6C00;
 		border-radius: 5px;
 	}
 	
 	
  /** 단어장 상세페이지 모달창 */
 	
  	.mask {
 		width:100%;
 		height:100%;
 		position:fixed;
 		left:0;
 		top:0;
 		z-index:10;
 		background:#000;
 	}
	#modalLayer {
		display:none;
		position:relative;
		border-radius: 5px;
 		/* border: 1px solid black; */
	}
	#modalLayer .modalContent {
		width:1100px;
		height:800px;
		padding:20px; 
		border:1px solid #ccc;
		position:fixed;
		left:50%; 
		top:50%;
		z-index:11;
		background:#fff;
		border-radius: 10px;
	}
 /*- modal창 닫기 버튼 */
	#detail_modal_closebtn {
		position:absolute;
		right:3px;
		top:3px;
		cursor:pointer;
 		background: white;
 		border: none;
 		font-size: 30px;
 		color: #C7C7C7;
	}
 /*- modal창 내부 contents : 영화 포스터, 영화 제목, 해당 단어장의 단어 개수 */
 	#detail_modal_movie {
 		text-align: center;
 		width: 700px;
 		height: 400px;
 		margin: 50px 200px;
 		border: 1px solid #EEE9DD;
 		padding: 3px;
 		border-radius: 10px;
 		
 	}
 /*- 상세페이지 영화포스터 */
 	#detail_modal_poster {
 		margin-top: 50px;
 		margin-left: 80px;
 		width: 220px;
 		height: 300px;
 		/* border: 1px solid red; */
 		float: left;
 	}
 	#detail_modal_poster > img {
 		width: 220px;
 		height: 300px;
 		border-radius: 5px;
 	}
 /*- 상세페이지 정보 */
 	#detail_modal_info {
 		width: 360px;
 		height: 400px;
 		/* border: 1px solid yellow; */
 		float: right;
 		margin-right: 10px;
 	}
 /*- 상세페이지 영화제목 */
 	#detail_title {
 		margin-top: 120px;
 		width: 360px;
 		/* border: 1px solid green; */
 		height: 100px;
 		text-align: center;
 		line-height: 100px;
 	}
 	#detail_title > span {
 	 	font-family: 'Noto Sans KR', sans-serif;
 		font-size: 22px;
 		font-weight: bold;
 		
 	}
 /*- 상세페이지 해당영화 추출단어 수 */
	#detail_frequency {
		/* border: 1px solid red; */
		width: 360px;
		height: 80px;
		margin: 0 80px;
	}
	.frequency {
		/* border: 1px solid gray;  */
		font-family: 'Noto Sans KR', sans-serif;
		width: 50px;
		height: 80px;
		text-align: center;
		font-size: 20px;
		float: left;
		padding: 0 4px;
		line-height: 80px;
	}
	#frequency_count {
		font-weight: bold;
		text-decoration: underline;
		color: #00AE93;
		font-size: 22px;
	}
 /** 단어장 table */
 	#word_table {
 		font-family: 'Noto Sans KR', sans-serif;
 		margin-top: 420px;
 		/* border: 1px solid red; */
 		width: 700px;
 		height: 300px;
 	
 	}
 	#word-table-top {
 		background-color: #00AE93;
 		border-radius: 5px;
 		color: white;
 		font-size: 16px;
 	}
	.table_no {
		width: 100px;
		height: 30px;
	}
	.table_word {
		width: 242px;
		height: 30px;
	}
	.table_mean {
		width: 242px;
		height: 30px;
	}
	.table_fre {
		width: 100px;
		height: 30px;
	}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">



/* 단어장 상세페이지 모달창 */
	$(document).ready(function(){
	  var modalLayer = $("#modalLayer");
	  var modalLink = $(".modalLink");
	  var modalCont = $(".modalContent");
	  var marginLeft = modalCont.outerWidth()/2;
	  var marginTop = modalCont.outerHeight()/2; 
	 
	  modalLink.click(function(){
	    modalLayer.fadeIn("slow");
	    modalCont.css({"margin-top" : -marginTop, "margin-left" : -marginLeft});
	    $(this).blur();
	    $(".modalContent > a").focus(); 
	    return false;
	  });
	 
	  $(".modalContent > button").click(function(){
	    modalLayer.fadeOut("slow");
	    modalLink.focus();
	  });        
	});
	
	
	/* $(document).on("click", ".active_page", function() {
		var page = $(this).attr("page_num");
			$.ajax({
				url : "movieListAjax.dandy",
				type : "POST",
				dataType : "JSON",
				data : "page=" + page,
				success : function(data) {
					alert("aaaaaaa");
				},
				error : function() {
					alert("System Error!!!");
				}

			});


	}); */



</script>

</head>
<body>
	<!-- Contents : 영화별 단어장 -->
		<div id="wrap_contents">
		
	<!-- 영화 검색 -->
			<div id="search_box">
				<input id="search_keyword" class="search" name="search_keyword" type="text" placeholder="영화를 검색해주세요.">
				<input id="search_btn" class="search" type="submit" value="◎">
			</div>
	<!-- 알파벳 페이지 -->
			<div id="alpha_page">
				<a href="#" class="active_index" index_num="0">0</a>
				<a href="#" class="active_index" index_num="A">A</a>
				<a href="#" class="active_index" index_num="B">B</a>
				<a href="#" class="active_index" index_num="C">C</a>
				<a href="#" class="active_index" index_num="D">D</a>
				<a href="#" class="active_index" index_num="E">E</a>
				<a href="#" class="active_index" index_num="F">F</a>
				<a href="#" class="active_index" index_num="G">G</a>
				<a href="#" class="active_index" index_num="H">H</a>
				<a href="#" class="active_index" index_num="I">I</a>
				<a href="#" class="active_index" index_num="J">J</a>
				<a href="#" class="active_index" index_num="K">K</a>
				<a href="#" class="active_index" index_num="L">L</a>
				<a href="#" class="active_index" index_num="M">M</a>
				<a href="#" class="active_index" index_num="N">N</a>
				<a href="#" class="active_index" index_num="O">O</a>
				<a href="#" class="active_index" index_num="P">P</a>
				<a href="#" class="active_index" index_num="Q">Q</a>
				<a href="#" class="active_index" index_num="R">R</a>
				<a href="#" class="active_index" index_num="S">S</a>
				<a href="#" class="active_index" index_num="T">T</a>
				<a href="#" class="active_index" index_num="U">U</a>
				<a href="#" class="active_index" index_num="V">V</a>
				<a href="#" class="active_index" index_num="W">W</a>
				<a href="#" class="active_index" index_num="X">X</a>
				<a href="#" class="active_index" index_num="Y">Y</a>
				<a href="#" class="active_index" index_num="Z">Z</a>
			</div>
	<!-- 영화 포스터 -->
			<div id="poster">
				<c:forEach items="${movieList}" var="ml">
					<input type="hidden" id="index_number" value="${ml.indexchar}">
						<div class="poster_frame">
						<div id="movieposter">
							<c:choose>
								<c:when test="${empty ml.img}">
									<img src="image/img_ready.jpg">
								</c:when>
								<c:otherwise>
									<img src="${ml.img}">
								</c:otherwise>
							</c:choose>	
						</div>
						<a href="#modalLayer" class="modalLink">${ml.title}</a>
					</div>
				</c:forEach>
			</div>
	<!-- 숫자 페이지 -->
			<div id="num_page">
			
				<c:if test="${pageMaker.prev}">
					<a href="#" class="active_page" page_num="${pageMaker.startPage-1}">◀</a>
				</c:if>
			
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					
						<a <c:out value="${pageMaker.criDto.page == idx? 'class=active':''}"/> href="#" class="active_page" page_num="${idx}">${idx}</a>
					
				</c:forEach>
				<c:if test="${pageMaker.next}">
					<a href="#" class="active_page" page_num="${pageMaker.endPage+1}">▶</a>
				</c:if>
			</div>
			
		</div>
		
		
	<!-- 단어장 상세페이지 모달창 -->
	<div id="modalLayer">
		<div class="modalContent">
		
		<!-- 모달창 닫기 버튼 -->
			<button type="button" id="detail_modal_closebtn">ⓧ</button>
		<!-- 내부 contents : 영화 포스터, 영화 제목, 해당 단어장의 단어 개수 -->
			<div id="detail_modal_movie">
			
				<div id="detail_modal_poster">
					<img src="image/aven.jpg">
				</div>
				<div id="detail_modal_info">
					<div id="detail_title">
						<span>〈Avengers: Infinity War, 2018〉</span>
					</div>
					<div id="detail_frequency">
						<div class="frequency">
							<span>단어:</span>
						</div>
						<div class="frequency" id="frequency_count">
							<span>123</span>
						</div>
						<div class="frequency">
							<span>개</span>
						</div>
					</div>
				</div>
				<div id="word_table">
					<table id="word-table-top">
						<tbody>
							<tr>
								<td class="table_no"><span>No.</span></td>
								<td class="table_word"><span>abc</span></td>
								<td class="table_mean"><span>가나다</span></td>
								<td class="table_fre"><span>10</span></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<tr>
								<td class="table_no"><span>No.</span></td>
								<td class="table_word"><span>abc</span></td>
								<td class="table_mean"><span>가나다</span></td>
								<td class="table_fre"><span>10</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>












