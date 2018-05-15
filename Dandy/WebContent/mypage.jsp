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
	
	
	/* 회원정보 */
	#member_id_line {
		margin-top: 50px;
		margin-bottom: 30px;
	}
	#member_id {
		height: 30px;
		width: 260px;
		border: none;
		border-radius: 5px;
		background-color: #f7f7f7;
		text-align: center;
		font-size: 18px;
		font-family: 'Noto Sans KR', sans-serif;
	}
	
	#member_ngb {
		border: none;
		font-size: 16px;
		text-align: center;
	}
	#member_phone {
		border: none;
		font-size: 16px;
		text-align: center;
	}
	#member_email {
		border: none;
		font-size: 16px;
		text-align: center;
	}
	.member_info {
		margin-bottom: 20px;
		font-family: 'Noto Sans KR', sans-serif;
		height: 20px;
		width: 250px;
	}
	.member_btn {
		margin: 10px;
		color: #555555;
		padding: 7px 14px;
		font-size: 15px;
		cursor:pointer;		
		background-color: #ededed;
		border-radius: 5px;
		border: 1px solid white;
		font-family: 'Noto Sans KR', sans-serif;
	}
	.member_btn:hover {
		border: 1px solid #0daa62;
		background-color: white;
		color: #0daa62;
	}
	.mo_member_btn {
		margin: 10px;
		color: #555555;
		padding: 7px 14px;
		font-size: 15px;
		cursor:pointer;		
		background-color: #ededed;
		border-radius: 5px;
		border: 1px solid white;
		font-family: 'Noto Sans KR', sans-serif;
	}
	.mo_member_btn:hover {
		border: 1px solid #0daa62;
		background-color: white;
		color: #0daa62;
	}
	.modal_info_contents {
		text-align: center;
	}
	#modal_info {
		width: 400px;
 		height: 150px;
 		padding: 35px;
 		border:1px solid #ccc;
 		border-radius: 15px;
 		position:fixed;
 		left:40%;
 		top:40%; 
 		z-index:11;
 		background:#fff;
 		text-align: center;
	}
	
	#mo_info {
		 display: none; 
		position: fixed; 
		z-index: 60; 
		left: 0;
		top: 0;
		width: 100%; 
		height: 100%; 
		overflow: auto; 
		background-color: rgb(0, 0, 0); 
		background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	}
	#modal_info_pw_line {
		margin-top: 40px;
	}
	#modal_info_pw {
		text-align: center;
		font-size: 15px;
		height: 20px;
		border-radius: 5px;
		border: 1px solid #ddd;
	}
	#modal_info_btn_line {
		margin-top: 10px;
	}
	#mo_me {
		font-size: 14px;
		color: white;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	//mypage를 닫는 스크립트
	$(document).on("click", "#myPageClose", function(){
		$("#mypage_wrap").css("display", "none");
	});
	//마이페이지에서 영화누르면 상세페이지 띄워주는 스크립트
	$(document).on("click", ".mypageImg", function() {
		var mno = $(this).attr("data_mno");
		var img = $(this).attr("data_img");
		var title = $(this).attr("data_title");
		alert(mno + ", " + img + ", " + title);
		$.ajax({
			url : "mypageContentsDetail.dandy",
			type : "POST",
			data : "mno=" + mno + "&img=" + img + "&title=" + title,
			success : function(result) {
				$("#mypageMoviedetail").html(result);
				alert("왜 안뜨지?");
			},
			error : function() {
				alert("System Error!!!");
			}

		});
		
	});
	
	$(document).ready(function() {
		var meminfo_code = $("#meminfo_code").val();
		//alert(meminfo_code);
		
		$(document).on("click", "#member_infoupdate", function() {
			//alert("회원정보수정버튼 클릭");
			//meminfo_code.val("code1").change;
			$("#meminfo_code").attr("value", "1");
			$("#mo_info").css("display", "block");
		});
		
		$("#member_pwchange").click(function() {
			//alert("비밀번호변경버튼 클릭")
			$("#meminfo_code").attr("value", "2");
			$("#mo_info").css("display", "block");
		})
		
		$("#member_delete").click(function() {
			//alert("회원탈퇴버튼 클릭")
			$("#meminfo_code").attr("value", "3");
			$("#mo_info").css("display", "block");
		})
		
	});
		
	/* 모달창 닫기  */
	$(document).on("click", "#modal_info_close", function(){
		$("#mo_info").css("display", "none");
	});
	
	
	$(document).on("click", "#modal_info_btn", function(){
		var meminfo_code = $("#meminfo_code").val();
		var mid = $("#member_id").val();
		var mpw = $("#member_pw").val();
		var modal_mpw = $("#modal_info_pw").val();
		//alert(meminfo_code);
		//alert(mid);
		//alert(mpw);
		//alert(modal_mpw);
		if (mpw != modal_mpw){
			//alert("비밀번호 불일치");
			$("#mo_me").text("비밀번호가 일치하지 않습니다.").css("color", "red");
		} else {
			if(meminfo_code == 1){
				/* $.ajax({
					url : "memberupdate.dandy",
					type : "POST",
					data : "mid=" + mid,
					success : function(result) {
						//$("#boardList").html(result);
					},
					error : function() {
						alert("System Error!!!");
					}

				}); */
				alert(mpw +"===> 비밀번호확인");
			} else if(meminfo_code == 2){
				
			} else if(meminfo_code == 3){
				
			}
		}
		
	});
	
</script>
</head>
<body>
	<!-- My Page : 전체 감싸는 div -->
	<div id="mypage_wrap">
		<div id="mypageMoviedetail"></div>
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
							<!-- <span>회원정보, 회원정보 수정, 탈퇴 추가예정</span> -->
							<div id ="member_id_line">
								<input type="text" id="member_id" value="${sessionScope.loginUser.mid}" readonly="readonly">
								<input type="hidden" id="member_pw" value="${sessionScope.loginUser.mpw}">
							</div>
							<div id ="member_ngb_line">
								<input type="text" id="member_ngb" class="member_info" value="${sessionScope.loginUser.mname}&nbsp;(${sessionScope.loginUser.msex} ,&nbsp;${sessionScope.loginUser.mbirth})" readonly="readonly">
							</div>
							<div id ="member_phone_line">
								<input type="text" id="member_phone" class="member_info" value="${sessionScope.loginUser.mphone}" readonly="readonly">
							</div>
							<div id ="member_email_line">
								<input type="text" id="member_email" class="member_info" value="${sessionScope.loginUser.memail}" readonly="readonly">
							</div>
							<div id ="member_info_btn" >
								<input type="button" id="member_infoupdate" class="member_btn" value="회원정보수정">
								<input type="button" id="member_pwchange" class="member_btn" value="비밀번호변경">
								<input type="button" id="member_delete" class="member_btn" value="회원탈퇴">
								<input type="hidden" id="meminfo_code" value="">
							</div>
						</div>
					</div>
				</div>
				<div id="myword_arr" class="mycontent_rightdivide">
					<div id="myword" class="mycontent_box">
						<div class="mycontent_boxtitle"><span>나의 단어장</span></div>
						<div class="mycontent_contents">
							<c:forEach items="${movieList}" var="mDto">
								<div id="movieImgWrap">
									<c:choose>
									<c:when test="${empty mDto.img}">
										<a class="mypageImg" href="#" data_mno="${mDto.mno}" data_img="${mDto.img}" data_title="${mDto.title}">
											<img src="image/img_ready.gif"  style="width: 100px; height: 110px;" alt="${mDto.title}">
										</a>
									</c:when>
									<c:otherwise>
										<a class="mypageImg" href="#" data_mno="${mDto.mno}" data_img="${mDto.img}" data_title="${mDto.title}">
											<img src="${mDto.img}" style="width: 100px; height: 110px;" alt="${mDto.title}">
										</a>
									</c:otherwise>
								</c:choose>	

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
		
	<!-- 회원정보수정, 비밀번호변경, 탈퇴 클릭시 비밀번호 재확인 모달창 -->
	<div id="mo_info">
		<div id="modal_info">
			<div id="modal_info_message_line" class="modal_info_contents">
				<span id="modal_info_message">본인확인을 위해 비밀번호를 한번 더 입력해주세요.</span>
			</div>
			<div id="modal_info_pw_line" class="modal_info_contents">
				<input type="password" id="modal_info_pw" val="">
			</div>
			<div id="modal_info_message" class="modal_info_contents">
				<span id="mo_me">.</span>
			</div>
			<div id="modal_info_btn_line" class="modal_info_contents">
				<input type="button" id="modal_info_btn" class="mo_member_btn" value="확인">
				<input type="button" id="modal_info_close" class="mo_member_btn" value="취소">
			</div>
		</div>
	</div>
		
	</div>
</body>
</html>