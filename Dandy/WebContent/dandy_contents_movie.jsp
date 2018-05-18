<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
 		font-size: 20px;
 		font-weight: bold;
 		color: #FA6C00;
 		cursor: pointer;
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
 		height: 392px;
 		background-color: #FA6C00;
 		float: left;
 		margin: 0 40px 50px 40px;
 		border: 1px solid #FA6C00;
 		border-radius: 5px;
 	}
 	.posterTitle {
 		display: table-cell;
 		width: 100%;
 		height: 42px;
 		vertical-align: middle;
 	}
 	.posterTitle span{
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
 		margin-top: 1390px;
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
 	
 	
</style>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	/* //영화 목록에서 페이지네이션의 숫자 눌렀을때 페이지 이동하게 해주는 스크립트
	$(document).on("click", ".active_page", function() {
		var page = $(this).attr("page_num");
		var index = $("#index_number").val();
			$.ajax({
				url : "movieList.dandy",
				type : "POST",
				data : "page=" + page + "&index=" + index,
				success : function(result) {
					$("#movieList").html(result);
				},
				error : function() {
					alert("System Error!!!");
				}
	
			});
	
	});
	
	
	// 영화 목록에서 위에 알파벳 눌렀을때 띄워주는 페이지 스크립트
	$(document).on("click", ".active_index", function() {
		var index = $(this).attr("index_num");
			$.ajax({
				url : "movieList.dandy",
				type : "POST",
				data : "index=" + index,
				success : function(result) {
					$("#movieList").html(result);
				},
				error : function() {
					alert("System Error!!!");
				}
	
			});
	
	});*/
	

	$(document).on("click", "#search_btn", function(){
		alert("클릭");
		var keyword = $("#search_keyword").val();
		alert(keyword);
		$.ajax({
			url : "movieList.dandy",
			type : "POST",
			data : "index=" + index + "&keyword=" + keyword,
			success : function(result) {
				$("#movieList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
	});

</script>

</head>
<body>
	<!-- Contents : 영화별 단어장 -->
		<div id="wrap_contents">
		
	<!-- 영화 검색 -->
			<div id="search_box">
				<input id="search_keyword" class="search" name="search_keyword" type="text" placeholder="영화를 검색해주세요.">
				<span id="search_btn" class="search"><i class="fa fa-search"></i></span>
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
			<input type="hidden" id="index_number" value="${index}">
	<!-- 영화 포스터 -->
			<div id="poster">
				<c:forEach items="${movieList}" var="ml">
					<input type="hidden" id="mno" value="${ml.mno}">
					<input type="hidden" id="img" value="${ml.img}">
					<input type="hidden" id="title" value="${ml.title}">
						<div class="poster_frame">
						<a href="#" class="modalLink" data_mno="${ml.mno}" data_img="${ml.img}" data_title="${ml.title}">
							<div id="movieposter">
								<c:choose>
									<c:when test="${empty ml.img}">
										<img src="image/img_ready.gif">
									</c:when>
									<c:otherwise>
										<img src="${ml.img}">
									</c:otherwise>
								</c:choose>	
							</div>
							<div class="posterTitle">${ml.title}</div>
						</a>
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
</body>
</html>












