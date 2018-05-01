<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/* 공통사항, 태그에 직접 속성주기들 시작 */
	* {
		margin: 0;
		padding: 0;
		color: EEE9DD;
	}
	body {
		background: #363636;
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
		position: relative;
		width: 100%;
		height: 80px;
		background: #fff;
		text-align: center;
		overflow: hidden;
		z-index: 10;
	}
	div#header h1 {
		display: inline-block;;
		margin-top: 21px;
	}
	
		/*로그인 버튼 */
		div#header .login {
			width: 79px;
    		height: 79px;
			position: absolute;
			top: 0;
			left: 0;
			border: 1px solid #C7C7C7;
		}
		div#header .login img {
			width: 70px;
			height: 70px;
		}
		/*로그인 버튼 */
	/* 로고가 있는 헤더의 끝 */
	
	/* 인덱스 메인 페이지 시작 */
	div#cBody {
		postition: relative;
		width: 100%;
		min-height: 505px;
		overflow: hidden;
		height: 900px;
		border: 1px solid #C7C7C7;
	}
	div.mainCon {
		position: absolute;
		top: 81px;
		left: 80px;
		width: 100%;
		height: 900px;
	}
	
		
		/* nav메뉴 시작 */
		div#nav {
			position: absolute;
			top: 81px;
			left:0;
			height: 900px;
			width: 80px;
			overflow: hidden;
			line-height: 815px;
			border: 1px solid #C7C7C7;
		}
		a#navButton {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 100;
		}
		
			/* nav를 누르면 나오는 div 시작*/
			div#navWrap1 {
				position: absolute;
				top: 0;
				left: 0;
				width: 100%;
				height: 100%;
				z-index: 300;
				display: none;
			}
			div#navWrap2 {
				padding-top: 40px; 
				position: absolute;
				top: 100px;
				left: 100px;
				width: 80%;
				height: 80%;
				z-index: 400;
				display: none;
			}
			a#navClose {
				font-size: 70px;
				position: absolute;
				top: 0;
				right: 20px;
			}
			div.navContent {
				margin-top:70px;
				font-size: 70px;
				text-align: center;
			}
			a.navSpan {
				width: 100%;
  				  height: 100%;
   				 display: block;
			}
			a.navSpan:hover {
				background-color: yellow;
			}
			/* nav를 누르면 나오는 div 끝*/
		
			
		/* nav메뉴 끝 */
		
		/* 단어장 등을 누르면 시작되는 컨텐츠를 띄워주는 페이지 시작 */
		div#content1 {
			position: absolute;
			top:0!important;
			left: 2px;
			z-index: 300;
			display: none;
			margin: 0 auto;
			top: 834px;
			padding-bottom: 120px;
			background: #00AE93;
		}
		a#mainContentClose {
			font-size: 70px;
			position: absolute;
			top: 0;
			right: 20px;
		}
		/* 단어장 등을 누르면 시작되는 컨텐츠를 띄워주는 페이지 끝 */
	
	
		/* 단어장 시작 */
		a.openButton1 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 100;
		}
		div#block1 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 200;
			background-color: black;
			transition: 0.7s;
			display: none;
		}
		div.background {
			position: absolute;
			top: 0;
		}
		div.con1 {
			position: absolute;
			top: 0;
			width: 33.3%;
			height: 100%;
			overflow: hidden;
			border: 1px solid #C7C7C7;
		}
		div.txtArea {
			position: absolute;
			top: 60%;
			width: 600px;
			height: 400px;
			box-sizing: border-box;
			text-align: left;
			color: black;
			font-size: 50px;
			color: #00AE93;
		}	
		/* 단어장 끝 */
	
	
		/* 딕테이션 시작 */
		a.openButton2 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 100;
		}
		div#block2 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 200;
			background-color: black;
			transition: 0.7s;
			display: none;
		}
		div.con2 {
			position: absolute;
			top: 0;
			right: 33.3%;
			width: 33.3%;
			height: 100%;
			overflow: hidden;
			border: 1px solid #C7C7C7;
		}
		
		/* 딕테이션 끝 */

		/* 쉐도잉 시작 */
		div#block3 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 200;
			background-color: black;
			transition: 0.7s;
			display: none;
		}
		a.openButton3 {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: 100;
		}
		div.con3 {
			position: absolute;
			right:0;
			top: 0;
			width: 33.3%;
			height: 100%;
			overflow: hidden;
			border: 1px solid #C7C7C7;
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
			color: #57b74e;
			font-size: 18px;
		}
		/* 텍스트가 들어가는 끝 시작 */
	/* footer의 끝 */
	
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
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
		$(".openButton1").click(function(){
			$("#cBody").css("height","3354px");
			$("#content1").css("height", "3235px");	
			$("#content1").css("display", "block");	
			$("#content1").css("width", "82.6%");	
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 시작*/
			$(".con2").css("width", "6.5%");
			$(".con2").css("right", "6.5%");
			$(".con2").css("height", "97%");
			$(".con2").css("position", "fixed");
			$(".con2").css("top","80px");
			$(".con2").css({"background":"url(image/picture.png)" , 'background-repeat' : 'no-repeat', 'background-position': '4%'});
			
			$(".con3").css("width", "6.5%");
			$(".con3").css("right", "0");
			$(".con3").css("height", "97%");
			$(".con3").css("position", "fixed");
			$(".con3").css("top","80px");
			$(".con3").css({"background":"url(image/picture.png)" , 'background-repeat' : 'no-repeat', 'background-position': '92%'});
			$("#nav").css("position", "fixed");
			/* 단어장을 클릭하면 딕테이션과 쉐도잉이 작아지면서 위치를 옮김 끝*/
		});
		$("#mainContentClose").click(function(){
			$("#content1").css("display", "none");
			$("#cBody").css("height","900px");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 시작*/
			$(".con2").css("width", "33.3%");
			$(".con2").css("right", "33.3%");
			$(".con2").css("height", "100%");
			$(".con2").css("position", "absolute");
			$(".con2").css("top","0");
			$(".con3").css("width", "33.3%");
			$(".con3").css("right", "0");
			$(".con3").css("height", "100%");
			$(".con3").css("position", "absolute");
			$(".con3").css("top","0");
			$("#nav").css("position", "absolute");
			/* 딕테이션과 쉐도잉이 자기 자리를 찾아감 끝*/
		});
		/* 단어장 등을 클릭하면 컨텐츠를 띄우기 끝 */
		
		
		/* 호버하면 다른 contents의 색깔이 변함 시작 */		
		$(".openButton1").hover(function(){
			$("#block2").css("display", "block");
			$("#block3").css("display", "block");
		},
		function(){
			$("#block2").css("display", "none");
			$("#block3").css("display", "none");
		});
		
		$(".openButton2").hover(function(){
			$("#block1").css("display", "block");
			$("#block3").css("display", "block");
		},
		function(){
			$("#block1").css("display", "none");
			$("#block3").css("display", "none");
		});
		
		$(".openButton3").hover(function(){
			$("#block1").css("display", "block");
			$("#block2").css("display", "block");
		},
		function(){
			$("#block1").css("display", "none");
			$("#block2").css("display", "none");
		});
		/* 클릭하면 다른 contents의 색깔이 변함 끝 */
		//스크롤을 내렸을 때 햄버거와 딕테이션등의 크기가 변함 시작
		var didScroll;
		var lastScollTop = 0; //스크롤이 움지이고 난 후 마지막 위치
		var delta = 600; //동작의 구현이 시작되는 위치
		var navbarHeight = $("#nav").outerHeight(); //영향을 받는 요소
		
		/* //일단 스크롤이 되면 dijdScroll의 값을 트루로 바꿔서 스크롤 이벤트가 작동되도록 한다.
		$(window).scroll(function(event){
			didScroll = true; 
			alert("didScroll: " + didScroll + " lastScollTop: " + lastScollTop + " delta : " + delta + " navbarHeight : " + navbarHeight);
		});
		
		
		setInterval(function(){
			if (didScroll){ 
			//alert("setInterval탄다.");
				hasScrolled(); 
				didScroll = false; 
				} 
		});

		function hasScrolled() {
			var st = $(this).scrollTop(); //현재 스크롤의 위치를 저장한다.
			alert("hasScrolled탄다        " + st);
			if(Math.abs(lastScollTop - st) <= delta){
				//alert("그냥 끝나버림");					
				return;
			}
			
			//alert("계속됨");
			lastScrollTop = st;	
		}
		
		//스크롤을 내렸을 때 햄버거와 딕테이션등의 크기가 변함 끝 */
		
		
	});
	
</script>

</head>
<body>
	<!-- body전체를 감싸는 div -->
	<div id="wrapper" style = "height: auto">
		<!-- 로고가 있는 헤더 부분 시작 -->
		<div id="header" style="background: #363636;">
			<!-- 로고 시작 -->
			<h1>
				<a id="dandy_logo" href="index.jsp">
					단디입니다.
				</a>
			</h1>
			<!-- 로고 끝 -->
			<!-- 로그인 버튼 시작-->
			<a class="login">
				<img src="image/login.png">
			</a>
			<!-- 로그인 버튼 끝 -->
		</div>
		<!-- 로고가 있는 헤더 부분 끝 -->
		
		<!-- 인덱스 메인 페이지전체를 감싸는 div 시작 -->
		<div id="cBody" class="main pc" style="height: 900px;">
			<div id="nav">
				<a href="#" id="navButton">
				햄버거
				</a>
			</div>
			
			<!-- 메인콘텐츠 시작 -->
			<div class="mainCon">
				<!-- 단어장 등을 누르면 뜨는 컨텐츠창 시작 -->
				<div id="content1">
					<a href="#" id="mainContentClose">&times;</a>
					메인콘텐트 입니다.
				</div>
				<!-- 단어장 등을 누르면 뜨는 컨텐츠창 끝 -->
			
			
				<!-- nav를 클릭하면 뜨는 창 시작-->
				<div id="navWrap1">
					<div id="navWrap2">
						<a href="#" id="navClose">&times;</a>
						<div class="navContent"><a href="#" class="navSpan">단어장</a></div>
						<div class="navContent"><a href="#" class="navSpan">딕테이션</a></div>
						<div class="navContent"><a href="#" class="navSpan">쉐도잉</a></div>
						<div class="navContent"><a href="#" class="navSpan">마이페이지</a></div>
					</div>
				</div>
				<!-- nav를 클릭하면 뜨는 창 끝-->
				
				<!-- 단어장 페이지 시작 -->
				<div class="con1">
					<div id="block1"></div><!-- 이걸로 메인의 요소들을 가린다. -->
					<!-- 단어장을 열어주는 a 태그 시작 -->
					<a href="#" class="openButton1"></a>
					<!-- 단어장을 열어주는 a 태그 끝 -->
					<!-- 백그라운드 이미지가 들어가는 페이지 시작 -->
					<div class="background background1">
						
					</div>
					<!-- 백그라운드 이미지가 들어가는 페이지 끝 -->
					<!-- 문구가 들어가는 div시작 -->
					<div class="txtArea tal1" style="left:140px;">
						<p class="tit spon" style="width: 295px;">단어장</p>
					</div>
					<!-- 문구가 들어가는 div끝 -->
				</div>
				<!-- 단어장 페이지 끝 -->
				
				
				<!-- 딕테이션 페이지 시작 -->
				<div class="con2">
					<div id="block2"></div><!-- 이걸로 메인의 요소들을 가린다. -->
					<!-- 단어장을 열어주는 a 태그 시작 -->
					<a href="#" class="openButton2"></a>
					<!-- 단어장을 열어주는 a 태그 끝 -->
					<!-- 백그라운드 이미지가 들어가는 페이지 시작 -->
					<div class="background background2">
						
					</div>
					<!-- 백그라운드 이미지가 들어가는 페이지 끝 -->
					<!-- 문구가 들어가는 div시작 -->
					<div class="txtArea tal2" style="left:140px;">
						<p class="tit spon" style="width: 295px;">딕테이션</p>
					</div>
					<!-- 문구가 들어가는 div끝 -->
				</div>
				<!-- 딕테이션 페이지 끝 -->
				
				
				<!-- 쉐도잉 페이지 시작 -->
				<div class="con3">
					<div id="block3"></div><!-- 이걸로 메인의 요소들을 가린다. -->
					<!-- 단어장을 열어주는 a 태그 시작 -->
					<a href="#" class="openButton3"></a>
					<!-- 단어장을 열어주는 a 태그 끝 -->
					<!-- 백그라운드 이미지가 들어가는 페이지 시작 -->
					<div class="background background3">
						
					</div>
					<!-- 백그라운드 이미지가 들어가는 페이지 끝 -->
					<!-- 문구가 들어가는 div시작 -->
					<div class="txtArea tal3" style="left:140px;">
						<p class="tit spon" style="width: 295px;">쉐도잉</p>
					</div>
					<!-- 문구가 들어가는 div끝 -->
				</div>
				<!-- 쉐도잉 페이지 끝 -->
			</div>
			<!-- 메인콘텐츠 끝 -->
		</div>
		
		<!-- footer의 시작 -->
			<div id="footer">
				<!-- 텍스트가 들어가는 부분 시작 -->
				<div class="left">
					<div class="link">
						<a href="#" class="type2"><strong>개인정보처리방침</strong></a>
						<span class="divide">|</span>
						<a href="#">사이트맵</a>
					</div>
					<div class="address">
						<span>광주 한국정보원</span>
						<span class="divide">|</span>
						<span>Tel.000-000-0000</span>
						<span class="divide">|</span>
						<span>email@naver.com</span>
					</div>
					<p class="copy">
					
					</p>
				</div>
				<!-- 텍스트가 들어가는 부분 끝 -->
			</div>
			
		<!-- footer의 끝 -->
		<!-- 인덱스 메인 페이지 전체를 감싸는 div 끝 -->
	</div>
</body>
</html>