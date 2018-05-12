<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>My Page</title>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
/* font-family: 'Noto Sans KR', sans-serif; */
	/* My Page : 전체 감싸는 div, width와 height 조정할 것 */
	#mypage_wrap {
		margin: 0;
		padding: 0;
		width: 100%;
		height: 1000px;
		background-color: white;
		position: relative;
		font-family: 'Noto Sans KR', sans-serif;
		position: absolute!important;
		z-index: 50;
		
	}
	
	/* My Page : contents 영역 wrap div */
	#mycontent_wrap {
		margin: 100px 345px; 
		/* border: 1px solid black; */
		/* border: 2px solid #f7f7f7; */
		border-radius: 10px;
		width: 1200px;
		height: 800px;
		position: absolute;
		
	}
	
	/* My Page : content 영역 4분할 */
	.mycontent_topbottomdivide {
		margin: 0;
		/* border: 1px solid red; */
		width: 100%;
		height: 50%;
	}
	.mycontent_leftdivide {
		margin: 0;
		/* border: 1px solid green; */
		width: 50%;
		height: 100%;
		float: left;
	}
	.mycontent_rightdivide {
		margin: 0;
		/* border: 1px solid blue; */
		width: 50%;
		height: 100%;
		float: right;
	}
	
	/* My Page : content 영역 내부 박스 */
	.mycontent_box {
		margin: 20px auto;
		border: 1px dashed #0daa62;
		/* border-top-color: white; */
		border-radius: 10px;
		width: 90%;
		height: 90%;
	}
	/* My Page : content title box */
	.mycontent_boxtitle {
		margin-top: -2px;
		margin-left: -0.25%;
		background-color: #0daa62;
		border-radius: 3px;
		width: 100.5%;
		height: 40px;
		text-align: center;
	}
	.mycontent_boxtitle > span {
		color: white;
		font-weight: bold;
		font-size: 20px;
		line-height: 40px;
	}
	
	/* My Page : content 내용 */
	.mycontent_contents {
		margin: 1%;
		width: 95%;
		height: 95%;
		text-align: center;
	}
	.mycontent_contents > span {
		color: black;
		font-size: 15px;
	}
	#myPageClose {
		position: absolute;
   		top: 90px;
		right: 110px;
		cursor: pointer;
	}
	#movieImgWrap {
		display: inline-block;
		width: 95px;
		height: 110px;
	}
	
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	

<script type="text/javascript">
	//mypage를 닫는 스크립트
	$(document).on("click", "#myPageClose", function(){
		$("#mypage_wrap").css("display", "none");
	});
</script>
</head>
<body>
	<!-- My Page : 전체 감싸는 div -->
	<div id="mypage_wrap">
		<div id="myPageClose">X</div>
		<!-- My Page : contents 영역 wrap div -->
		<div id="mycontent_wrap">
			<!-- My Page : content 영역 상하분할 -->
			<div id="mycontent_top" class="mycontent_topbottomdivide">
				<!-- My Page : content 영역 좌우분할 -->
				<div id="myinfo_arr" class="mycontent_leftdivide">
					<!-- My Page : content 영역 내부 박스 -->
					<div id="myinfo" class="mycontent_box">
						<!-- My Page : content title box -->
						<div class="mycontent_boxtitle"><span>회원정보</span></div>
						<!-- My Page : content 내용 -->
						<div class="mycontent_contents">
							<span>회원정보, 회원정보 수정, 탈퇴 추가예정</span>
						</div>
					</div>
				</div>
				<div id="myword_arr" class="mycontent_rightdivide">
					<div id="myword" class="mycontent_box">
						<div class="mycontent_boxtitle"><span>나의 단어장</span></div>
						<div class="mycontent_contents">
							<c:forEach items="${movieList}" var="mDto">
								<div id="movieImgWrap">
									<img src="${mDto.img}" style="width: 100px; height: 110px;">
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div id="mycontent_bottom" class="mycontent_topbottomdivide">
				<div id="myachieve_arr" class="mycontent_leftdivide">
					<div id="myachieve" class="mycontent_box">
						<div class="mycontent_boxtitle"><span>성취도</span></div>
						<div class="mycontent_contents">
							<span>단어시험 결과, 단어장 성취률</span>
						</div>
					</div>
				</div>
				<div id="mylog_arr" class="mycontent_rightdivide">
					<div id="mylog" class="mycontent_box">
						<div class="mycontent_boxtitle"><span>최근 활동 로그</span></div>
						<div class="mycontent_contents">
							<span>최근에 이용한 사이트 내역</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>