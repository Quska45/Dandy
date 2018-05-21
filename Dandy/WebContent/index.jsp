<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dandi</title>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
/* font-family: 'Nanum Gothic', serif; */
/* font-family: 'Hanna', serif; */
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
	/* 공통사항, 태그에 직접 속성주기들 시작 */
	* {
		margin: 0;
		padding: 0;
		color: EEE9DD;
	}
	body {
		background: #363636;
		font-family: 'Noto Sans KR', sans-serif;
	}
	a{
		text-decoration: none;
		color: #454545;
	}
	/* 공통사항, 태그에 직접 속성주기들 끝 */
	
	/* body 전체를  감싸는 div wrapper시작*/
	div#wrapper {
		position: relative;
		width: 100%;
		max-width: 100%;
		overflow: hidden;
		color: black;
	}
	/* body 전체를  감싸는 div wrapper끝*/
	
	/* 로고가 있는 헤더의 시작 */
	#dandy_logo {
		color: #FA6C00;
		
	}
	div#header {
		position: fixed;
		width: 100%;
		height: 81px;
		background: white;
		text-align: center;
		overflow: hidden;
    		z-index: 70;
	}
	div#header h1 {
		display: inline-block;;
		margin-top: 7px;
	}
	
		/*로그인 버튼 */
		div#header .login {
			width: 79px;
    			height: 79px;
			position: absolute;
			top: 0;
			left: 0;
			cursor: pointer;
		}
		div#header .login img {
			width: 70px;
			height: 70px;
		}
		div#header .login_in {
			width: 79px;
    			height: 79px;
			position: absolute;
			top: 0;
			left: 0;
			cursor: pointer;
		}
		div#header .login_in img {
			width: 70px;
			height: 70px;
		}
		/*로그인 버튼 */
		login_in
	/* 로고가 있는 헤더의 끝 */
	
	/* 인덱스 메인 페이지 시작 */
	div#cBody {
		postition: relative;
		width: 100%;
		min-height: 505px;
		overflow: hidden;
		height: 1000px;
		background: #363636;
	}
	div.mainCon {
		position: absolute;
		top: 81px;
		left: 80px;
		width: 100%;
		height: 1000px;
	}
		
		/* 단어장 등을 누르면 시작되는 컨텐츠를 띄워주는 페이지 시작 */
		div#content1 {
			position: absolute;
			top:81.4px!important;
			left: 3.8px;
			z-index: 40;
			display: none;
			margin: 0 auto;
			top: 834px;
			padding-bottom: 120px;
			background: #00AE93;
		}
		img.mainContentClose1 {
			position: absolute;
			top: 0;
			right: 20px;
			width: 50px;
			padding-top: 15px;
			cursor: pointer;
		}
		div#content2 {
			position: absolute;
			top:81.4px!important;
			left: 126.4px;
			z-index: 40;
			display: none;
			margin: 0 auto;
			top: 834px;
			padding-bottom: 120px;
			background: #00AE93;
		}
		img.mainContentClose2 {
			position: absolute;
			top: 0;
			right: 20px;
			width: 50px;
			padding-top: 15px; 
			cursor: pointer;
		}
		div#content3 {
			position: absolute;
			top:81.4px!important;
			left: 250.8px;
			z-index: 40;
			display: none;
			margin: 0 auto;
			top: 834px;
			padding-bottom: 120px;
			background: #00AE93;
		}
		img.mainContentClose3 {
			position: absolute;
			top: 0;
			right: 20px;
			width: 50px;
			padding-top: 15px;
			cursor: pointer;
		}
		/* 단어장 등을 누르면 시작되는 컨텐츠를 띄워주는 페이지 끝 */
	
	
		/* 단어장 시작 */
		a.openButton1 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 20;
		}
		div#block1 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height:85.4%;
			z-index: 19;
			background-color: black;
			transition: 0.7s;
			opacity: 0.4;
		}
		div.background {
			position: absolute;
			top: 0;
		}
		div.con1 {
			background: url('image/background/bk_o12.jpg') 100% 50% no-repeat;
			background-position: 30% -12.8%;
			position: absolute;
			top: 0;
			width: 33.4%;
			height: 100%;
			overflow: hidden;
		}
		div.txtArea {
			position: absolute;
			top: 48%;
			width: 600px;
			height: 400px;
			box-sizing: border-box;
			text-align: left;
			font-size: 50px;
			color: white;
			z-index: 21;
		}	
		/* 단어장 끝 */
	
	
		/* 딕테이션 시작 */
		a.openButton2 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 20;
		}
		div#block2 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 85.4%;
			z-index: 19;
			background-color: black;
			transition: 0.7s;
			opacity: 0.4;
		}
		div.con2 {
			background: url('image/background/bk_o11.jpg') 100% 50% no-repeat;
			background-position: 30% -12.8%;
			position: absolute;
			top: 0;
			right: 33.3%;
			width: 33.3%;
			height: 100%;
			overflow: hidden;
		}
		
		/* 딕테이션 끝 */

		/* 쉐도잉 시작 */
		div#block3 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 85.4%;
			z-index: 19;
			background-color: black;
			transition: 0.7s;
			opacity: 0.4;
		}
		a.openButton3 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 20;
		}
		div.con3 {
			background: url('image/background/bk_o15.jpg') 100% 50% no-repeat;
			background-position: 30% -12.8%;
			position: absolute;
			right:0;
			top: 0;
			width: 33.3%;
			height: 100%;
			overflow: hidden;
		}
		
		/* 쉐도잉 끝 */
	
	/* 인덱스 메인 페이지 끝 */
	
	/* footer의 시작 */
	div#footer {
		position: relative;
		padding: 50px 80px 120px;
		z-index: 10;
		background-color: #C7C7C7;
	}	
		/* 텍스트가 들어가는 부분 시작 */
		div.left {
			float: left;
		}
		div.left a {
			padding: 10px;
		}
		div.left a:first-child {
			padding-left: 0;
		}
		div.link {
			margin: 10px;
			margin-left: 0;
		}
		a.type2 {
			color: #0daa62;
			font-size: 18px;
		}
		/* 텍스트가 들어가는 끝 시작 */
	/* footer의 끝 */
	
	
	
	
	/* modal  */
	#kakao_content {
		margin: 10px auto;
		height: 95%;
		text-align: center;
	}
	
	#login_content {
		width: 90%;
		height: 100%;
		padding: 0 25px;
		/* border: 1px solid #ddd; */
		text-align: left;
		display: inline-block;
		border-top: 4px solid #0daa62;
		background-color: #fff;
		/* background-color: #f5f6f7; */
	}
	
	#login_area {
		width: 270px;
		height: 270px;
		position: relative;
	}
	
	#subtitle {
		position: relative;
		height: 40px;
		margin: 22px auto 12px 0px;
	}
	
	#subtitle>a>img {
		width: 150px;
		height: 50px;
	}
	
	.idpw {
		color: #333;
		letter-spacing: -1px;
		background-color: white;
		width: 94%;
		height: 25px;
		border: 1px solid #e5e5e5;
		border-radius: 5px;
		font-weight: normal;
		font-size: 13px;
		line-height: 22px;
		padding: 8px 12px;
		margin-bottom: 8px;
		outline: none;
	}
	
	#login_form {
		position: relative;
	}
	
	#login_form>img {
		display: inline-block;
		width: 24px;
		height: 24px;
		position: absolute;
		top: 8px;
		right: 8px;
	}
	
	#remember {
		margin: -1px 0 16px;
	}
	
	#remrmber>input {
		color: #333;
		margin: 3px 3px 3px 4px;
		vertical-align: middle;
	}
	
	#remember>label {
		font-size: 13px;
		letter-spacing: -1px;
	}
	
	#btn_login {
		display: inline-block;
		background-color: #0daa62;
		border: 1px solid #0daa62;
		width: 100%;
		padding-top: 5px;
		line-height: 38px;
		text-align: center;
		border-radius: 5px;
		font-weight: bold;
		cursor: pointer;
		font-size: 20px;
		margin-bottom: 15px;
		color: white;
	}
	
	#login_help {
		width: 100%;
		padding-top: 20px;
		font-size: 15px;
		letter-spacing: -1px;
		border-top: 1px solid #cfcfcf;
	}
	
	#login_help a {
		letter-spacing: -1px;
		color: #333;
	}
	
	#login_help a:hover {
		text-decoration: underline;
	}
	
	.right {
		display: inline-block;
		position: absolute;
		right: 46px;
	}
	
	.right>a {
		color: #777 !important;
	}
	
	.right_bar {
		display: inline-block;
		width: 1px;
		height: 11px;
		background-color: #ccc;
		font-size: 11px;
		margin: 4px 1px 0 3px;
	}
	
	
	.modal {
		display: none; /* Hidden by default */
		position: fixed; /* Stay in place */
		z-index: 100; /* Sit on top */
		left: 0;
		top: 0;
		width: 100%; /* Full width */
		height: 100%; /* Full height */
		overflow: auto; /* Enable scroll if needed */
		background-color: rgb(0, 0, 0); /* Fallback color */
		background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	}
	
	/* Modal Content/Box */
	.modal-content {
		background-color: #fefefe;
		margin: 15% auto; /* 15% from the top and centered */
		padding: 20px;
		border: 1px solid #888;
		width: 500px; /* Could be more or less, depending on screen size */
		height: 350px;
		position: absolute;
	    top: -60px;
    	left: 700px;
    	border-radius: 15px;
	}
	/* 모달 닫기 버튼   */
	.close {
		color: #aaa;
		float: right;
		font-size: 28px;
		font-weight: bold;
		position: absolute;
		top: 5px;
		right: 5px;
		width: 20px;
	}
	
	.close:hover, .close:focus {
		color: black;
		text-decoration: none;
		cursor: pointer;
	}
	#wrap_contents1 {
		font-family: 'Noto Sans KR', sans-serif;
		width: 1200px;
		/* height: 1700px; */
		border: 2px solid white;
		background-color: #f7f7f7;
		border-radius: 10px;
		margin: 100px 200px;
	}
	
	#board_sel {
		/* border: 1px solid red; */
		width: 500px;
		height: 60px;
		margin: 50px auto;
	}
	.board_selbtn {
		width: 180px;
		height: 40px;
		margin: 8px 33px;
		float: left;
		border-radius: 5px;
		text-align: center;
		font-weight: bold;
		font-size: 16px;
	}
	#qna_btn{
		border: 2px solid white;
		background-color: #0daa62;
	}
	#qna_btn > a > span {
		color: white;
	}
	#free_btn{
		border: 2px solid #0daa62;
		background-color: white;
	}
	#free_btn > a > span {
		color: #0daa62
	}
	.board_selbtn > a > span {
		line-height: 40px;
		padding: 0 auto;
	}
	#logoutbtn_div {
		float: right;
		margin-right: 5px;
		margin-top: 20px;
	}
	#index_logout, #index_logout_ {
		width: 50px;
		
	}
	#index_logout {
		cursor: pointer;
	}
	
	.main_logo {
		height: 125px;
		bottom: 10px;
	}
	.logo_class {
		display: none;
		margin-top: 300px;
		margin-left: 40px;
		width: 40px;
	}
	
	
	#movieList {
		height: auto!important;
	}
	
	#constract_modal {
		display: none; 
		position: fixed; 
		z-index: 100;
		left: 0;
		top: 0;
		width: 100%; 
		height: 100%; 
		overflow: auto; 
		background-color: rgb(0, 0, 0);
		background-color: rgba(0, 0, 0, 0.4);
	}
	#constract_wrap {
		width: 600px;
 		height: 760px;
 		padding: 35px;
 		border:1px solid #ccc;
 		border-radius: 15px;
 		position:fixed;
 		left:33%;
 		top:10%; 
 		z-index:11;
 		background:#fff;
 		z-index: 70;
	}
	.tArea {
		color: white;
		font-size: 40px;
		float: left;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		// 로그인 할 때 enter키 작동
		$("#login_pw").keydown(function(e){
			if(e.keyCode == 13) {
				var mid = $("#sessionMid").val();
				
				if(mid == "") {
					var id = $("#login_id");
					var pw = $("#login_pw");
					
					var lid = id.val();
					
					if(lid == "") {
						$("#ErrCk").text("ID값을 입력하시오").css("display", "block").css("color", "red");
						id.focus();
						return false;
					}
					
					var lpw = pw.val();
					
					if(lpw == "") {
						$("#ErrCk").text("PW값을 입력하시오").css("display", "block").css("color", "red");
						pw.focus();
						return false;
					}
					
					$.ajax({
						url: "loginajax.dandy",
						type: "POST",
						dataType :  "JSON",
						data: "id=" + lid + "&pw=" + lpw,
						success: (function(data){
							if(data.id != null && data.pw != null) {
								alert("로그인 성공");
								//index 페이지로 이동
								location.reload();
							} else {
								$("#login_id").select();
								$("#ErrCk").text("ID, PW값을 정확히 입력하시오.").css("display", "block").css("color", "red");
							}
						}),
						error: function(){
							alert("system error");
						}
					});
				}
				
				
			}
		});
		
		
		
		
	});
	
	
	
	// 해쉬에 주소 저장해서 뒤로가기 구현
	$(window).on('hashchange', function () {
		var str_hash = document.location.hash;
			str_hash = str_hash.replace("#","");
			arr_curpage = str_hash.split("^");
			selector = arr_curpage[0];
			page = arr_curpage[1];
			index = arr_curpage[2];
			keyword = arr_curpage[3];
			
			if(selector == "sel01"){
				movieHash();	
			} else if(selector == "sel02") {
				
			} else if(selector == "sel03") {
				
			}
	     
	     
	     function movieHash() {		
			if(document.location.hash) {
				//hash 가 있다면 ^ 를 구분자로 하나씩 string을 추출하여 각각 페이지정보를 가져옵니다.
				var str_hash = document.location.hash;
				str_hash = str_hash.replace("#","");
				arr_curpage = str_hash.split("^");
				selector = arr_curpage[0];
				page = arr_curpage[1];
				index = arr_curpage[2];
				keyword = arr_curpage[3];
			
				// 뒤로가기 처리.. 각각 현재페이지를 가지고 다시 ajax를 실행해줍니다.
				$.ajax({
					url : "movieList.dandy",
					type : "POST",
					data : "page=" + page + "&index=" + index + "&keyword=" + keyword,
					success : function(result) {
						$("#movieList").html(result);
					},
					error : function() {
						alert("System Error!!!");
					}
				});
				
			} else {
				//nothing..
			}
	
		}
	     
	 });






	//로그인 모달창에서 로그인을 할 수 있도록 하는 쿼리
	$(document).on("click", "#btn_login", function(){
		var mid = $("#sessionMid").val();
		
		if(mid == "") {
			var id = $("#login_id");
			var pw = $("#login_pw");
			
			var lid = id.val();
			
			if(lid == "") {
				$("#ErrCk").text("ID값을 입력하시오").css("display", "block").css("color", "red");
				id.focus();
				return false;
			}
			
			var lpw = pw.val();
			
			if(lpw == "") {
				$("#ErrCk").text("PW값을 입력하시오").css("display", "block").css("color", "red");
				pw.focus();
				return false;
			}
			
			$.ajax({
				url: "loginajax.dandy",
				type: "POST",
				dataType :  "JSON",
				data: "id=" + lid + "&pw=" + lpw,
				success: (function(data){
					if(data.id != null && data.pw != null) {
						//alert("로그인 성공");
						//index 페이지로 이동
						location.reload();
					} else {
						$("#login_id").select();
						$("#ErrCk").text("ID, PW값을 정확히 입력하시오.").css("display", "block").css("color", "red");
					}
				}),
				error: function(){
					alert("system error");
				}
			});
		} 
		
	});
	
	//임시로 로그아웃 버튼 만듦
	$(document).on("click", "#index_logout", function(){
			$.ajax({
				url: "logout.dandy",
				type: "POST",
				dataType :  "JSON",
				success: function(data){
					if(data.flag=="1"){
						location.reload();
					} else if(data.flag!="0"){
						alert("data.flag" + data.flag);
						alert("로그아웃 실패");
					}
				},
				error: function(){
					alert("system error");
				}	
			});
	});
	
	// 게시판 버튼 이동 : QnA
	
	$(document).on("click", "#qna_btn", function(){
		$("#qna_btn").css("background-color", "#0daa62");
		$("#qna_btn").css("border", "2px solid white");
		$("#qna_btn > a > span").css("color", "white");
		$("#free_btn").css("background-color", "white");
		$("#free_btn").css("border", "2px solid #0daa62");
		$("#free_btn > a > span").css("color", "#0daa62");
		$.ajax({
			type : "post",
			url : "questionBoardList.dandy",
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	// 게시판 버튼 이동 : 자유게시판
		
	$(document).on("click", "#free_btn", function(){
		$("#free_btn").css("background-color", "#0daa62");
		$("#free_btn").css("border", "2px solid white");
		$("#free_btn > a > span").css("color", "white");
		$("#qna_btn").css("background-color", "white");
		$("#qna_btn").css("border", "2px solid #0daa62");
		$("#qna_btn > a > span").css("color", "#0daa62");
		$.ajax({
			type : "post",
			url : "freeBoardList.dandy",
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	
	//게시글목록을 띄우는 콜백함수. openButton3에 onclick으로 걸려있다.
	function board_list() {
		//alert("onclick");
		$.ajax({
			type : "post",
			url : "questionBoardList.dandy",
			success : function(result) {
				$("#boardList").html(result);
			}
		});
		
	};
	
	$(document).on("click", "#question_board_detail_login", function(){
		$(".modal").css("display", "block");
	});

	//mypage를 띄우기 위해 필요한 함수
	function myPageAll(){
		var mid=$("#sessionMid_id").val();
		alert(mid);
		
		$.ajax({
			type : "post",
			url : "mypageMovieList.dandy",
			data: "mid=" + mid,
			success : function(result) {
				$("#myPageAll").html(result);
			}
		});
	}
	
	//로그인 되어 있으면 마이페이지 띄워주는 스크립트
	$(document).on("click", ".login_in", function(){
		myPageAll();
	});
	
	
	
	// 단어장 눌렀을때 영화 목록 띄워주는 스크립트
	function movie_list() {
		var keyword = "empty";
		var page = "1";
		var index = "empty";
		var selector = "sel01";
		
		var str_hash = selector + "^" + page + "^" + index + "^" + keyword;
		document.location.hash = "#" + str_hash;
		
		//alert("onclick");
		$.ajax({
			type : "post",
			url : "movieList.dandy?index=empty&keyword=empty",
			success : function(result) {
				$("#movieList").html(result);
			}
		});
		
	}
	
	
	//영화 목록에서 페이지네이션의 숫자 눌렀을때 페이지 이동하게 해주는 스크립트
	$(document).on("click", ".active_page", function() {
		var keyword = $("#search_keyword_empty");
			if(keyword.val() == "") {
				keyword.val("empty");
			}
		var keyword_result = keyword.val();
		var page = $(this).attr("page_num");
		var index = $("#index_number").val();
		var selector = "sel01";
		var str_hash = selector + "^" + page + "^" + index + "^" + keyword_result;
		document.location.hash = "#" + str_hash;
		
			$.ajax({
				url : "movieList.dandy",
				type : "POST",
				data : "page=" + page + "&index=" + index + "&keyword=" + keyword_result,
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
		var keyword = $("#search_keyword_empty");
			if(keyword.val() == "") {
				keyword.val("empty");
			}
		var keyword_result = keyword.val();
		var page = "1";
		var selector = "sel01";
		var str_hash = selector + "^" + page + "^" + index + "^" + keyword_result;
		document.location.hash = "#" + str_hash;
			
			$.ajax({
				url : "movieList.dandy",
				type : "POST",
				data : "index=" + index + "&keyword=empty",
				success : function(result) {
					$("#movieList").html(result);
				},
				error : function() {
					alert("System Error!!!");
				}
	
			});
	
	});
	
	
	$(document).on("click", "#search_btn", function(){
		var keyword = $("#search_keyword");
			if(keyword.val() == "") {
				keyword.val("empty");
			}
		var keyword_result = keyword.val();
		var index = "empty";
		var page = "1";
		var selector = "sel01";
		var str_hash = selector + "^" + page + "^" + index + "^" + keyword_result;
		document.location.hash = "#" + str_hash;
		
		$.ajax({
			url : "movieList.dandy",
			type : "POST",
			data : "index=" + index + "&keyword=" + keyword_result,
			async: false,
			success : function(result) {
				$("#movieList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
		
		
	});
	
	
	// 단어장 상세 페이지 띄워주는 ajax
	$(document).on("click", ".modalLink", function() {
		var mno = $(this).attr("data_mno");
		var img = $(this).attr("data_img");
		var title = $(this).attr("data_title");
		
		var keyword = $("#search_keyword_empty");
			if(keyword.val() == "") {
				keyword.val("empty");
			}
		var keyword_result = keyword.val();
		var page = $("#save_page").val();
		var index = $("#index_number").val();
		var selector = "sel01";
		var str_hash = selector + "^" + page + "^" + index + "^" + keyword_result;
		document.location.hash = "#" + str_hash;
		
		
		$("#cBody").css("height","20000px");
		$.ajax({
			url : "contentsDetail.dandy",
			type : "POST",
			data : "mno=" + mno + "&img=" + img + "&title=" + title,
			success : function(result) {
				$("#movieList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});

	});
	
	
	// diy 버튼 눌렀을때 입력창 띄워주는 스크립트
	function diy_page() {
		$.ajax({
			type : "post",
			url : "diypage.dandy",
			success : function(result) {
				$("#diyPage").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	}
	
	$(document).on("click", "#contract_open", function(){
		$("#constract_modal").css("display","block");
		$(".modal").css("display", "none");
		$()
	});
	
	// 모달 : 회원가입을 누르면 열리는 이용약관동의 페이지
	function constract() {
		$.ajax({
			type : "post",
			url : "memberConstract.dandy",
			success : function(result) {
				$("#constract").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	}
	
	// 모달 : 이용약관동의 동의 클릭시 회원가입페이지로 이동
	function btn_agree() {
		var necessary1 = $("#li1box").is(":checked");
		var necessary2 = $("#li2box").is(":checked");
		if (necessary1 == false || necessary2 == false) {
			$("#warning").css("display", "block");
			return false;
		} else {
			$.ajax({
				type : "post",
				url : "memberInsert.dandy",
				success : function(result) {
					$("#constract").html(result);
					$("#constract_wrap").css("height", "650px");
				},
				error : function() {
					alert("System Error!!!");
				}
			});
		}
	}
	
	

	$(document).ready(function(){
		
		/* 햄버거 버튼을 클릭하면 div가 뜸 시작 */
		$("#navButton").click(function(){
			$("#navWrap1").css("display", "block");
			$("#navWrap2").css("display", "block");
		});
		$("#navClose").click(function(){
			$("#navWrap1").css("display", "none");
			$("#navWrap2").css("display", "none");
		});
		/* 햄버거 버튼을 클릭하면 div가 뜸 끝 */
		
		/* 단어장 등을 클릭하면 컨텐츠를 띄우기 시작 */
		
		function openButton1(){
			$("#cBody").css("height","1938px");
			$("#content1").css("height", "auto");
			$(".main_logo").css("display", "none");
			$("#content1").css("display", "block");	
			$("#content1").css("width", "86.8%");	
			$("#content1").css({"background":"url(image/background/bk_o12.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '100% 0%', 'background-size':'100%'});
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 시작*/
			$(".con2").css("width", "6.5%");
			$(".con2").css("right", "6.5%");
			$(".con2").css("height", "97%");
			$(".con2").css("position", "fixed");
			$(".con2").css("top","80px");
			$(".con2").css({"background":"url(image/background/bk_o11.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '11% 0%'});
			
			$(".con3").css("width", "6.5%");
			$(".con3").css("right", "0");
			$(".con3").css("height", "97%");
			$(".con3").css("position", "fixed");
			$(".con3").css("top","80px");
			$(".con3").css({"background":"url(image/background/bk_o15.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% 12%'});
			$("#nav").css("position", "fixed");
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 끝*/
			$(".logo_class").css("display", "block");
		}
		
		$(".openButton1").click(function(){
			mainContentClose2();
			mainContentClose3();
			openButton1();
		});
		
		function openButton2() {
			$("#cBody").css("height","1938px");
			$("#content2").css("height", "3153px");	
			$(".main_logo").css("display", "none");
			$("#content2").css("display", "block");	
			$("#content2").css("width", "86.9%");	
			$("#content2").css({"background":"url(image/background/bk_o11.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '100% 0%', 'background-size':'100%'});
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 시작*/
			$(".con1").css("width", "6.7%");
			$(".con1").css("right", "93.3%");
			$(".con1").css("height", "97%");
			$(".con1").css("position", "fixed");
			$(".con1").css("top","81px");
			$(".con1").css({"background":"url(image/background/bk_o12.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '50% 0%'});
			
			$(".con3").css("width", "6.5%");
			$(".con3").css("right", "0");
			$(".con3").css("height", "97%");
			$(".con3").css("position", "fixed");
			$(".con3").css("top","80px");
			$(".con3").css({"background":"url(image/background/bk_o15.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% 12%'});
			$("#nav").css("position", "fixed");
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 끝*/
			$(".logo_class").css("display", "block");
		}
		
		$(".openButton2").click(function(){
			mainContentClose1();
			mainContentClose3();
			openButton2();
		});
		
		function openButton3(){
			$("#cBody").css("height","1938px");
			$("#content3").css("height", "3153px");	
			$("#content3").css("display", "block");	
			$(".main_logo").css("display", "none");
			$("#content3").css("width", "86.9%");	
			$("#content3").css({"background":"url(image/background/bk_o15.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '100% 0%', 'background-size':'100%'});
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 시작*/
			$(".con1").css("width", "6.5%");
			$(".con1").css("right", "93.4%");
			$(".con1").css("height", "97%");
			$(".con1").css("position", "fixed");
			$(".con1").css("top","81px");
			$(".con1").css("top","81px");
			$(".con1").css({"background":"url(image/background/bk_o12.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '50% 0%'});
			
			$(".con2").css("width", "6.5%");
			$(".con2").css("right", "86.8%");
			$(".con2").css("height", "97%");
			$(".con2").css("position", "fixed");
			$(".con2").css("top","81px");
			$(".con2").css({"background":"url(image/background/bk_o11.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '11% 0%'});
			$("#nav").css("position", "fixed");
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 끝*/
			$(".logo_class").css("display", "block");
		}
		
		$(".openButton3").click(function(){
			mainContentClose1();
			mainContentClose2();
			openButton3();
		});
		
		function mainContentClose1(){
			$("#content1").css("display", "none");
			$("#cBody").css("height","1000px");
			$(".main_logo").css("display", "block");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 시작*/
			$(".con2").css("width", "33.3%");
			$(".con2").css("right", "33.3%");
			$(".con2").css("height", "100%");
			$(".con2").css("position", "absolute");
			$(".con2").css("top","0");
			$(".con2").css({"background":"url(image/background/bk_o11.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% -12.8%'});
			
			
			$(".con3").css("width", "33.3%");
			$(".con3").css("right", "0");
			$(".con3").css("height", "100%");
			$(".con3").css("position", "absolute");
			$(".con3").css("top","0");
			$(".con3").css({"background":"none"});
			$(".con3").css({"background":"url(image/background/bk_o15.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% -12.8%'});
			$("#nav").css("position", "absolute");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 끝*/
			$(".logo_class").css("display", "none");
		}
		
		$(".mainContentClose1").click(function(){
			mainContentClose1();
		});
		
		function mainContentClose2() {
			$("#content2").css("display", "none");
			$("#cBody").css("height","1000px");
			$(".main_logo").css("display", "block");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 시작*/
			$(".con1").css("width", "33.3%");
			$(".con1").css("right", "66.6%");
			$(".con1").css("height", "100%");
			$(".con1").css("position", "absolute");
			$(".con1").css("top","0");
			$(".con1").css({"background":"url(image/background/bk_o12.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% -12.8%'});
			
			
			$(".con3").css("width", "33.3%");
			$(".con3").css("right", "0");
			$(".con3").css("height", "100%");
			$(".con3").css("position", "absolute");
			$(".con3").css("top","0");
			$(".con3").css({"background":"url(image/background/bk_o15.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% -12.8%'});
			$("#nav").css("position", "absolute");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 끝*/
			$(".logo_class").css("display", "none");
		}
		
		
		$(".mainContentClose2").click(function(){
			mainContentClose2();
		});
		
		function mainContentClose3() {
			$("#content3").css("display", "none");
			$("#cBody").css("height","1000px");
			$(".main_logo").css("display", "block");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 시작*/
			$(".con1").css("width", "33.3%");
			$(".con1").css("right", "66.6%");
			$(".con1").css("height", "100%");
			$(".con1").css("position", "absolute");
			$(".con1").css("top","0");
			$(".con1").css({"background":"url(image/background/bk_o12.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% -12.8%'});
			
			
			$(".con2").css("width", "33.3%");
			$(".con2").css("right", "33.3%");
			$(".con2").css("height", "100%");
			$(".con2").css("position", "absolute");
			$(".con2").css("top","0");
			$(".con2").css({"background":"url(image/background/bk_o11.jpg)" , 'background-repeat' : 'no-repeat', 'background-position': '30% -12.8%'});
			$("#nav").css("position", "absolute");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 끝*/
			$(".logo_class").css("display", "none");
		}
		
		$(".mainContentClose3").click(function(){
			mainContentClose3();
		});
		/* 단어장 등을 클릭하면 컨텐츠를 띄우기 끝 */
		
		
		/* 호버하면 다른 contents의 색깔이 변함 시작 */		
		$(".openButton1").hover(function(){
			$("#block2").css("display", "block");
			$("#block2").css("opacity", "0.6");
			$("#block3").css("display", "block");
			$("#block3").css("opacity", "0.6");
		},function(){
			$("#block2").css("opacity", "0.3");
			$("#block3").css("opacity", "0.3");
		});
		
		$(".openButton2").hover(function(){
			$("#block1").css("display", "block");
			$("#block1").css("opacity", "0.6");
			$("#block3").css("display", "block");
			$("#block3").css("opacity", "0.6");
		},function(){
			$("#block1").css("opacity", "0.3");
			$("#block3").css("opacity", "0.3");
		});
		
		$(".openButton3").hover(function(){
			$("#block1").css("display", "block");
			$("#block1").css("opacity", "0.6");
			$("#block2").css("display", "block");
			$("#block2").css("opacity", "0.6");
		},
		function(){
			$("#block1").css("opacity", "0.3");
			$("#block2").css("opacity", "0.3");
		});
		/* 클릭하면 다른 contents의 색깔이 변함 끝 */
		
		
		
		
		
	});
	
	
	/* 모달창 열기   */
	$(document).on("click", ".login", function(){
		$(".modal").css("display", "block");
		$("#login_id").focus();
		
	});
	
	
	/* 모달창 닫기  */
	$(document).on("click", ".close", function(){
		$(".modal").css("display", "none");
	});
	
	
	
	/**********************************************자유게시판**************************************************/
	//***** dandy_contents_free_board.jsp
	// 자유게시판 : 게시판 상세 페이지를 띄우는 쿼리 : 자유게시판
	$(document).on("click", "#freeboardDetailBtn", function(){
		var bno = $(this).attr("data_num");
		var page = $("#activepage").val();
		//alert(page);
		$.ajax({
				url : "freeBoardDetail.dandy",
				type : "POST",
				data : "bno=" + bno + "&page=" + page,
				success : function(result) {
					$("#boardList").html(result);
					}, error : function() {
					alert("System Error!!!");
					}
				});
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
				}, error : function() {
					alert("System Error!!!");
				}
			});
		}
	});	
	// 자유게시판 : 정렬
	$(document).on("click", "#fl_no", function(){
		var sort = $("#fl_no_input").val();
		var keyword = $("#fl_no_input_keyword").val();
		//alert(sort);
		//alert(keyword);
		$.ajax({
			url : "freeBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	});
	$(document).on("click", "#fl_contents", function(){
		var sort = $("#fl_content_input").val();
		var keyword = $("#fl_content_input_keyword").val();
		//alert(sort);
		//alert(keyword);
		$.ajax({
			url : "freeBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	});
	$(document).on("click", "#fl_name", function(){
		var sort = $("#lf_name_input").val();
		var keyword = $("#fl_name_input_keyword").val();
		//alert(sort);
		//alert(keyword);
		$.ajax({
			url : "freeBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	});
	$(document).on("click", "#fl_date", function(){
		var sort = $("#fl_date_input").val();
		var keyword = $("#fl_date_input_keyword").val();
		//alert(sort);
		//alert(keyword);
		$.ajax({
			url : "freeBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	});
	$(document).on("click", "#fl_view", function(){
		var sort = $("#fl_view_input").val();
		var keyword = $("#fl_view_input_keyword").val();
		//alert(sort);
		//alert(keyword);
		$.ajax({
			url : "freeBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	});
	$(document).on("click", "#fl_good", function(){
		var sort = $("#fl_good_input").val();
		var keyword = $("#fl_good_input_keyword").val();
		//alert(sort);
		//alert(keyword);
		$.ajax({
			url : "freeBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	});
	//***** dandy_contents_free_board_write.jsp
	// 자유게시판 : 게시글 작성페이지 default 빈칸
	$(document).ready(function() {
			$("#sub_input").val("");
			$("#con_input").val("");
		});
	
	
	//자유게시판 : 게시글 작성페이지에서 버튼을 누르면 글이 등록되게 하는 쿼리
	$(document).on("click", "#btn_freesuccess", function(){
		var title = $("#sub_input").val();
		var writer = $("#name_input").val();
		var content = $("#content").val();
		var form = $('form')[0];
        var formData = new FormData(form);
        oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		$.ajax({
			type : "post",
			processData: false,
            contentType: false,
			url : "freeBoardInsertSave.dandy",
			data : "title=" + title + "&writer=" + writer + "&content=" + content + "&formData=" + formData,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	//***** dandy_contents_free_board_update.jsp
	//자유게시판 : 게시글 수정 등록
	$(document).on("click", "#btn_freeup", function(){
		var bno = $("bno").val();
		var title = $("#sub_input").val();
		var writer = $("#name_input").val();
		var content = $("#content").val();
		/* var content = oEditors.getById["content"].getIR(); */
		var form = $('form')[0];
        var formData = new FormData(form);
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		$.ajax({
			type : "post",
			url : "freeBoardUpdateSave.dandy",
			data : "bno=" + bno + "&title=" + title + "&writer=" + writer + "&content=" + content + "&formData=" + formData,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});	
	
	//***** dandy_contents_free_board_detail.jsp
	
	// 자유게시판 : 목록버튼 클릭 리스트 출력
	$(document).on("click", "#freelist_btn",function(){
		var page = $("#page").val();
		//alert(page);
		 $.ajax({
			type : "post",
			url : "freeBoardList.dandy?page=" + page,
			success : function(result) {
				$("#boardList").html(result);
				comment_list(result);
			}, error : function() {
				alert("System Error!!!");
			}
		}); 
	});
	
	// 자유게시판 :  댓글 등록을 위한 로그인을 유도하는 쿼리
	$(document).on("click", "#free_board_detail_login", function(){
		$(".modal").css("display", "block");
	});
	
	// 자유게시판 : 파일 다운로드 
	/* $(document).on("click", "#freeboard_filedown", function(){
		var bno = $("#bno").val();
		
		$.ajax({
			type : "post",
			url : "freeboardfiledownload.dandy",
			data : "bno=" + bno,
			success : function(result) {
				$("#boardList").html(result);
			}, error : function() {
				alert("System Error!!!");
			}
		}); 
	}); */
	
	//자유게시판 : 답변 페이지 
	$(document).on("click", "#free_rewrite_btn", function(){
		var bno = $("#free_answer_bno").val();
		$.ajax({
			type : "post",
			url : "freeAnswer.dandy",
			data : "bno=" + bno,
			success : function(result) {
				$("#boardList").html(result);
			}, error : function() {
				alert("System Error!!!");
			}
		}); 
	});
	
	// 자유게시판 : 게시글 수정
	$(document).on("click", "#freemodify_btn", function(){
		var bno = $("#bno").val();
		
		$.ajax({
			url : "freeBoardUpdateView.dandy",
			type : "POST",
			data : "bno=" + bno,
			success : function(result) {
				$("#boardList").html(result);
			}, error : function() {
				alert("System Error!");
			}
		});
	});
	
	// 자유게시판 : 게시글 삭제
	$(document).on("click", "#freeremove_btn", function(){
		var bno = $("#bno").val();
		$.ajax({
			url : "freeBoardDelete.dandy",
			type : "POST",
			data : "bno=" + bno,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!");
			}
		});
		
	});
	
	// 자유게시판 : 검색
	$(document).on("click", "#free_search_btn", function(){
		var keyword = $("#free_search_keyword").val();
		var type = $("#free_selsearch").val();
		$.ajax({
			url : "freeBoardSearch.dandy",
			type : "POST",
			data : "keyword=" + keyword + "&type=" + type,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
		
	});
	
	//자유게시판 : 페이지 이동
	$(document).on("click", ".freepageMove", function(){
		var page=$(this).attr("page_num");
		$.ajax({
			type : "post",
			url : "freeBoardList.dandy",
			data: "page=" + page,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	//***** dandy_contents_free_board_answer.jsp
	//자유게시판 : 답변등록
	$(document).on("click", "#free_answer_wr_btn", function(){
		var title = $("#sub_input").val();
		var bno = $("#free_answer_bno").val();
		var writer = $("#name_input").val();
		var content = $("#content").val();
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		$.ajax({
			type : "post",
			url : "freeAnswerInsert.dandy",
			data : "bno=" + bno + "&title=" + title + "&writer=" + writer + "&content=" + content,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	/* 광진 시작 */
	//QnA에서 답변쓰기를 누르면 답변이 등록된다.
	$(document).on("click", "#question_answer_wr_btn", function(){
		var title = $("#sub_input").val();
		var bno = $("#question_answer_bno").val();
		var writer = $("#name_input").val();
		var content = $("#con_input").val();
		alert(title + ", " + bno  + ", " + writer  + ", " + content);
		$.ajax({
			type : "post",
			url : "questionAnswerInsert.dandy",
			data : "bno=" + bno + "&title=" + title + "&writer=" + writer + "&content=" + content,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	
	//내 단어장 디테일에서 내 단어장에서 삭제 누르면 삭제되게 하는 스크립트
	$(document).on("click", "#mywordDelete", function(){
		var mno = $("#hiddenMno").val();
		var mid = $("#sessionMid_id").val();
		alert(mno +","+ mid);
		$.ajax({
			url : "mywordDelete.dandy",
			type : "POST",
			data : "mno=" + mno + "&mid=" + mid,
			success : function(result) {
				alert("단어장을 삭제했습니다.");
			},
			error : function() {
				alert("System Error!!!");
			}
		});
	});
	
	

	
	
	// QnA 상세 페이지에서 목록버튼 클릭하면 게시판 리스트로 돌아온다.
	$(document).on("click", "#list_btn",function(){
		$.ajax({
			type : "post",
			url : "questionBoardList.dandy",
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	
	//QnA에서 답변을 눌렀을 때 답글작성 페이지로 넘어간다.
	$(document).on("click", "#qustion_rewrite_btn", function(){
		var bno = $("#question_detail_bno").val();
			$.ajax({
				type : "post",
				url : "question_answer.dandy",
				data : "bno=" + bno,
				success : function(result) {
					$("#boardList").html(result);
				}
			});
	});
	
	//게시판 상세 페이지를 띄우는 쿼리 : QnA
	$(document).on("click", "#boardDetailBtn", function(){
		var bno = $(this).attr("data_num");
		alert("bno" + bno);
		$.ajax({
			url : "questionBoardDetail.dandy",
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
	
	//QnA 게시판검색기능
	$(document).on("click", "#question_search_btn", function(){
		var keyword = $("#question_search_keyword").val();
		var type = $("#question_selsearch").val();
		$.ajax({
			url : "questionBoardSearch.dandy",
			type : "POST",
			data : "keyword=" + keyword + "&type=" + type,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
		
	});
	
	// QnA : 글쓰기를 누르면 게시글 작성페이지로 가는 쿼리
	$(document).on("click", "#wr_btn", function(){
		var sessionLogin = $("#sessionMid").val();
		if(sessionLogin==""){
			$(".modal").css("display", "block");
		} else {
			$.ajax({
				type : "post",
				url : "questionBoardWrite.dandy",
				success : function(result) {
					$("#boardList").html(result);
				}
			});
		}
	});
	
	//페이지 이동하기
	$(document).on("click", ".pageMove", function(){
		var page=$(this).attr("page_num");
		$.ajax({
			type : "post",
			url : "questionBoardList.dandy",
			data: "page=" + page,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});

	//QnA게시글 작성페이지에서 버튼을 누르면 글이 등록되게 하는 쿼리
	$(document).on("click", "#btn_success", function(){
		var title = $("#sub_input").val();
		var writer = $("#name_input").val();
		var flag = $("#secret_input_flag").val();
		var content = $("#con_input").val();
		var select = $("#qna_select").val();
		alert(title + ", " + name  + ", " +  flag + ", " + content + ", " + select);
		
		$.ajax({
			type : "post",
			url : "boardQuestionInsertsave.dandy",
			data : "title=" + title + "&writer=" + writer + "&flag=" + flag + "&content=" + content + "&select=" + select,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	//QnA게시글 작성페이지에서 버튼을 누르면 글이 등록되게 하는 쿼리
	$(document).on("click", "#btn_success", function(){
		var bno = $("#hidden_bno_update").val();
		var title = $("#sub_input").val();
		var writer = $("#name_input").val();
		var flag = $("#secret_input_flag").val();
		var content = $("#con_input").val();
		var select = $("#qna_select").val();
		alert(bno + ", " +title + ", " + name  + ", " +  flag + ", " + content + ", " + select);
		
		$.ajax({
			type : "post",
			url : "boardQuestionUpdatesave.dandy",
			data : "bno=" +bno + "&title=" + title + "&writer=" + writer + "&flag=" + flag + "&content=" + content + "&select=" + select,
			success : function(result) {
				$("#boardList").html(result);
			}
		});
	});
	
	// QnA 게시판 정렬 해준다.
	$(document).on("click", "#l_no", function(){
		var sort = $("#l_no_input").val();
		var keyword = $("#l_no_input_keyword").val();
		alert(sort);
		alert(keyword);
		$.ajax({
			url : "questionBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
	});
	$(document).on("click", "#l_contents", function(){
		var sort = $("#l_content_input").val();
		var keyword = $("#l_content_input_keyword").val();
		alert(sort);
		alert(keyword);
		$.ajax({
			url : "questionBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
	});
	$(document).on("click", "#l_name", function(){
		var sort = $("#l_name_input").val();
		var keyword = $("#l_name_input_keyword").val();
		alert(sort);
		alert(keyword);
		$.ajax({
			url : "questionBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
	});
	$(document).on("click", "#l_date", function(){
		var sort = $("#l_date_input").val();
		var keyword = $("#l_date_input_keyword").val();
		alert(sort);
		alert(keyword);
		$.ajax({
			url : "questionBoardSort.dandy",
			type : "POST",
			data : "sort=" + sort + "&keyword=" + keyword,
			success : function(result) {
				$("#boardList").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}

		});
	});
	
	/* 광진 끝 */
	
	
	
	
</script>

</head>
<body>
	
	<input type="hidden" id="sessionMid" value="${sessionScope.loginUser}">
	<input type="hidden" id="sessionMid_id" value="${sessionScope.loginUser.mid}">
	<!-- body전체를 감싸는 div -->
	<div id="wrapper" style = "height: auto">
		<!-- 로고가 있는 헤더 부분 시작 -->
		<div id="header" style="background: white;">
			<!-- 로고 시작 -->
			<h1>
				<a id="dandy_logo" href="index.dandy">
					<img src="image/logo.png" style="width: 170px;">
				</a>
			</h1>
			<!-- 로고 끝 -->
			<!-- 로그인 버튼 시작-->
			<c:choose>
				<c:when  test="${empty sessionScope.loginUser.mid}">
					<a class="login" style="background: url('image/mypage_icon1.png') 40% 50% no-repeat;
			background-size: 75px;"></a>
				<div id="logoutbtn_div"><img src="image/btn/btn_logout3_.png" id="index_logout_"></div>
				</c:when>
				
				<c:otherwise>
					<a href="#" class="login_in" style="background: url('image/mypage_icon2.png') 40% 50% no-repeat;
			background-size: 75px;"></a>
					<div id="logoutbtn_div"><img src="image/btn/btn_logout3.png" id="index_logout"></div>
				
				</c:otherwise>
				
			</c:choose>
			<!-- 로그인 버튼 끝 -->
		</div>
		<!-- 로고가 있는 헤더 부분 끝 -->
		<div id="myPageAll"></div>
		<!-- 인덱스 메인 페이지전체를 감싸는 div 시작 -->
		<div id="cBody" class="main pc" style="height: 1000px;">
			<!-- 메인콘텐츠 시작 -->
				<!-- 단어장 등을 누르면 뜨는 컨텐츠창 시작 -->
				<div id="content1">
					<img src="image/btn/btn_error_white.png" class="mainContentClose1">
					<!-- 메인콘텐트 입니다. -->
					<div id="movieList"></div>
				</div>
				<!-- 단어장 등을 누르면 뜨는 컨텐츠창 끝 -->

				<!-- 단어장 페이지 시작 -->
				<div class="con1">
					<div id="block1"></div><!-- 이걸로 메인의 요소들을 가린다. -->
					<!-- 단어장을 열어주는 a 태그 시작 -->
					<a href="#" onclick="movie_list();" class="openButton1">
					<img src="image/index_logo/logo_voca_1.png" id="voca_logo" class="logo_class">
					</a>
					<!-- 단어장을 열어주는 a 태그 끝 -->
					<!-- 백그라운드 이미지가 들어가는 페이지 시작 -->
					<div class="background background1">
						
					</div>
					<!-- 백그라운드 이미지가 들어가는 페이지 끝 -->
					<!-- 문구가 들어가는 div시작 -->
					<div class="txtArea tal1" style="left:80px;">
						<!-- <p class="main_logo" style="width: 295px;">단어장</p> -->
						<img src="image/index_logo/logo_voca_2.png" class="main_logo">
						<!-- <span class="tArea"><br>─</span> -->
					</div>
					<!-- 문구가 들어가는 div끝 -->
				</div>
				<!-- 단어장 페이지 끝 -->
				
				
				<!-- 딕테이션 페이지 시작 -->
				<div id="content2">
					<img src="image/btn/btn_error_white.png" class="mainContentClose2">
					
					<div id="diyPage"></div>
					
				</div>
				<div class="con2">
					<div id="block2"></div><!-- 이걸로 메인의 요소들을 가린다. -->
					<!-- 단어장을 열어주는 a 태그 시작 -->
					<a href="#" class="openButton2" onclick="diy_page();">
					<img src="image/index_logo/logo_diy_1.png" id="diy_logo" class="logo_class">
					</a>
					<!-- 단어장을 열어주는 a 태그 끝 -->
					<!-- 백그라운드 이미지가 들어가는 페이지 시작 -->
					<div class="background background2">
						
					</div>
					<!-- 백그라운드 이미지가 들어가는 페이지 끝 -->
					<!-- 문구가 들어가는 div시작 -->
					<div class="txtArea tal2" style="left:80px;">
						<!-- <p class="main_logo" style="width: 295px;">딕테이션</p> -->
						<img src="image/index_logo/logo_diy_2.png" class="main_logo">
						<!-- <span class="tArea"><br>─</span> -->
					</div>
					<!-- 문구가 들어가는 div끝 -->
				</div>
				<!-- 딕테이션 페이지 끝 -->
				
				
				<!-- 쉐도잉 페이지 시작 -->
				<div id="content3">
					<img src="image/btn/btn_error_white.png" class="mainContentClose3">
					<div id="wrap_contents1">
						<div id="board_sel">
							<div class="board_selbtn" id="qna_btn">
								<a href="#"><span>Q & A</span></a>
							</div>
							<div class="board_selbtn" id="free_btn">
								<a href="#freeboard"><span>자유게시판</span></a>
							</div>
						</div>
						<div id="boardList">
						
						</div>
					</div>
				</div>
				<div class="con3">
					<div id="block3"></div><!-- 이걸로 메인의 요소들을 가린다. -->
					<!-- 단어장을 열어주는 a 태그 시작 -->
					<a href="#" class="openButton3" onclick="board_list();">
					<img src="image/index_logo/logo_board_1.png" id="board_logo" class="logo_class">
					</a>
					<!-- 단어장을 열어주는 a 태그 끝 -->
					<!-- 백그라운드 이미지가 들어가는 페이지 시작 -->
					<div class="background background3">
						
					</div>
					<!-- 백그라운드 이미지가 들어가는 페이지 끝 -->
					<!-- 문구가 들어가는 div시작 -->
					<div class="txtArea tal3" style="left:80px;">
						<!-- <p class="main_logo" style="width: 295px;">쉐도잉</p> -->
						<img src="image/index_logo/logo_board_2.png" class="main_logo">
						<!-- <span class="tArea"><br>─</span> -->
					</div>
					<!-- 문구가 들어가는 div끝 -->
				</div>
				<!-- 쉐도잉 페이지 끝 -->
			
			<!-- 메인콘텐츠 끝 -->
		</div>
		
		<!-- footer의 시작 -->
			<div id="footer">
				<!-- 텍스트가 들어가는 부분 시작 -->
				<div class="left">
					<div class="link">
						<a href="#" class="type2"><strong>Dandi</strong></a>
						<!-- <span class="divide">|</span>
						<a href="#">사이트맵</a> -->
					</div>
					<div class="address">
						<span>프로젝트 기한 : 2018.03.15 ~ 2018.05.24</span>
					</div>
						<span>고재선</span>
						<span class="divide">|</span>
						<span>변광진</span>
						<span class="divide">|</span>
						<span>정지선</span>
						<span class="divide">|</span>
						<span>이시연</span>
						<span class="divide">|</span>
						<span>류영아</span>
					<div class="address">
					</div>
					<p class="copy">
					
					</p>
				</div>
				<!-- 텍스트가 들어가는 부분 끝 -->
			</div>
			
		<!-- footer의 끝 -->
		<!-- 인덱스 메인 페이지 전체를 감싸는 div 끝 -->
	</div>
	
	
	
	
	
	<!-- 모달창  -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<img src="image/btn/btn_error_gray3.png" class="close">
			<div id="kakao_content">
				<div id="login_content">
					<div id="login_area2">
						<div id="subtitle">
							<a href="index.dandy"> 
								<img src="image/logo.png">
							</a>
						</div>
						<div id="container">
							<form method="post" id="login_form" action="#" name="login_form">
								<input class="idpw" type="text" name="login_id" id="login_id" placeholder="아이디를 입력해 주세요"></input> 
									<input class="idpw" type="password" name="login_pw" id="login_pw" placeholder="비밀번호를 입력해 주세요"></input>
								<div id="ErrCk" style="display: none">
									
								</div>
								<!-- <div id="remember">
									<input type="checkbox" name="remember" id="remember2">
									<label for="remember2">계정 저장</label>
								</div> -->
								<div id="btn_login">로그인</div>
							</form>
						</div>
						
						<div id="login_help">
							<a href="#" id="contract_open"onclick="constract();">회원가입</a>
							<div class="right">
								<a href="#">
									계정 찾기
								</a> 
								<span class="right_bar"></span> 
								<a href="#">비밀번호 재설정</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 모달창 끝   -->
	<!-- 이용약관동의 모달페이지 -->
	<div id="constract_modal">
		<div id="constract_wrap">
			<div id="constract"></div>
		</div>
	</div>
	
	
	
</body>
</html>