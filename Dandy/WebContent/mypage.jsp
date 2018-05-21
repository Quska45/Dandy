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
	#member_ngb {
		width: 110px;
	}
	.member_info {
		margin-bottom: 15px;
		font-family: 'Noto Sans KR', sans-serif;
		height: 25px;
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
 		left:38%;
 		top:37%; 
 		z-index:11;
 		background:#fff;
 		text-align: center;
	}
	
	#mo_info {
		display: none;
		position: fixed; 
		z-index: 11; 
		left: 0;
		top: 0;
		width: 100%; 
		height: 100%; 
		overflow: auto; 
		background-color: rgb(0, 0, 0); 
		background-color: rgba(0, 0, 0, 0.4);
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
	#member_update_modal {
		display: none;
		width: 500px;
 		height: 500px;
 		padding: 5px 35px 35px 35px;
 		border:1px solid #ccc;
 		border-radius: 15px;
 		position:fixed;
 		left:35%;
 		top:25%; 
 		z-index:110;
 		background:#fff;
 		text-align: center;
 		z-index: 70; 
	}
	
	/* 회원정보 수정 모달 */
	#wrap {
		/* border: 1px solid red; */
		height: 500px;
		width: 500px;
	}
	
	/* header */
	#modal_header {
		/* position: relative; */
		width: 768px;
		width: 10px;
		min-width: 460px;
		margin: 0 30px;
	}
	#modal_header h1 {
		padding-bottom: 20px;
	}
	#modal_header > h1 {
		margin-top: 0;
	}
	.header_logo {
		display: block;
		width: 446px;
		height: 50px;
		margin: 0;
		border: 1px solid #0daa62;
		border-radius: 5px;
		text-align: center;
		color: white;
		background-color: #0daa62;
		text-decoration: none;
		position: fixed;
		margin-top: 25px;
	}
	
	
	
	/* container */
	#container {
		margin: 0 25px;
	}
	#content {
		margin: 0;
		width: 768px;
		min-width: 460px;
		margin-top: 60px;
	}
	.join_content {
		width: 460px;
		margin: 0;
	}
	.row_group {
		zoom: 1;
		margin-bottom: 5px;
		border: 1px solid #dadada;
		background: #fff;
	}
	
	
	.join_row {
		padding: 11px 11px 11px 13px;
		background: #fff;
		box-sizing: border-box;
	}
	.join_row+.join_row {
		border-top: 1px solid #f0f0f0;
	}
	.join_row:first-child {
		border-top: none;
	}
	.join_row > span {
		position: relative;
	}
	.input {
		font-family: 'Noto Sans KR', sans-serif;
		font-size: 15px;
		position: relative;
		z-index: 10;
		width: 100%;
		height: 16px;
		padding: 6px 0;
		border: none;
		background: #fff;
	}
	.label {
		font-size: 15px;
		line-height: 18px;
		position: absolute;
		z-index: 9;
		top: 5px;
		left: 0;
		display: block;
		color: #8e8e8e;
	}
	#errorms {
		font-size: 12px;
		margin: 5px 0 3px 0;
		color: white;
	}
	.join_sex {
		overflow: hidden;
		padding: 8px 18px 8px 15px;
	}
	.sex {
		display: block;
		height: 31px;
		margin-right: -3px;
		border: 1px solid #dcdcdc;
	}
	.gender {
		position: relative;
		z-index: 10;
		display: block;
		float: left;
		width: 49.7%;
		height: 31px;
		border-right: 1px solid #dcdcdc;
	}
	.gender:last-child {
		border-right: none;
	}
	.gender input {
		/* position: absolute; */
		z-index: 9;
		top: -3px;
		left: 0;
		width: 100%;
		height: 31px;
	}
	.gender label {
		line-height: 32px;
		position: absolute;
		z-index: 10;
		top: 0;
		left: 0;
		display: block;
		width: 100%;
		height: 31px;
		cursor: pointer;
		text-align: center;
		color: #8e8e8e;
		background: #fff;
	}
	.join_birthday {
		padding: 0;
	}
	.join_birth {
		display: table;
		padding-right: 15px;
	}
	.bir_title {
		font-size: 13px;
		display: table-cell;
		width: 28px;
		padding: 3px 12px 0 14px;
		table-layout: fixed;
		text-align: center;
		vertical-align: middle;
		color: #8e8e8e;
		border-right: 1px solid #efefef;
		background: #f7f7f7;
	}
	.bir_yy {
		padding-right: 4px;
		padding-left: 14px;
	}
	.bir_yy, .bir_mm, .bir_dd {
		display: table-cell;
		width: 114px;
		padding: 11px 0 11px 16px;
		table-layout: fixed;
		vertical-align: middle;
	} 
	.birth_box {
		position: relative;
		display: block;
		height: 27px;
	}
	.select {
		font-size: 15px;
		font-weight: 700;
		line-height: 18px;
		width: 100%;
		height: 30px;
		padding: 7px 8px 4px 7px;
		color: #000;
		border: none;
		border-radius: 0;
	}
	#error_ch {
		padding: 10px 0 0;
		text-align: center;
	}
	.btn_join {
		display: block;
		height: 61px;
		margin: 10px 0 10px;
		/* background: #1fbc02; */
	}
	.btn_join input {
		font-family: 'Noto Sans KR', sans-serif;
		width: 100%;
		height: 61px;
		text-indent: 0;
		font-size: 24px;
		
	}
	
	/* 우편번호  */
	.zipadress {
		width: 215px;
		height: 27px;
	}
	.zip {
		width: 210px;
		height: 27px;
		outline: none;
		border: none;
	}
	#zipbtn {
		width: 101px;
		height: 33px;
		border: 1px solid #dcdcdc;
		background-color: #fff;
		float: right;
		padding-right: 15px !important;
	}
	#phoneDiv {
		border-top: 1px solid #f0f0f0;
	}
	#email1, #email2 {
		width: 150px;
	}
	#mailAddress {
		height: 28px;
		width: 100px;
		font-family: 'Noto Sans KR', sans-serif;
		border: none;
	}
	#btn_update{
		margin: 0;
	}
	#id {
		text-align: center;
	}
	#info_myear {
		width: 40px;
		border: none; 
		font-size: 16px;
		font-family: 'Noto Sans KR', sans-serif;
	}
	#info_mmonth, #info_mday {
		width: 20px;
		border: none;
		font-size: 16px;
		font-family: 'Noto Sans KR', sans-serif;
	}
	#yy {
		text-align: center;
	}
	
	#email1 {
		text-align: center;
	}
	#phone {
		text-align: center;
	}
	
	
	
	/* 비밀번호 변경 모달창 */
	
	#passwordupdate {
		display: none;
		width: 400px;
 		height: 200px;
 		padding: 35px;
 		border:1px solid #ccc;
 		border-radius: 15px;
 		position:fixed;
 		left:38%;
 		top:33%; 
 		z-index:11;
 		background:#fff;
 		text-align: center;
 		z-index: 70;
	}
	#mo_pw_header {
		width: 300px;
		height: 35px;		 
		border: 1px solid #0daa62;
		background-color: #0daa62;
		border-radius: 5px;
		margin: 0 auto;
	}
	
	#passwordupdate_header {
		line-height:35px;
		text-align: center;
		color: white;
		font-size: 20px;
	}
	
	.password_input {
		width: 192px;
		height: 20px;
		border: 1px solid #ddd;
		border-radius: 5px;
		text-align: center;
		font-size: 15px;
		font-family: 'Noto Sans KR', sans-serif;
	}
	#pw1 {
		margin-top: 20px;
		margin-bottom: 20px;
	}
	#pw2 {
		margin-left: -5px;
		margin-bottom: 15px;
	}
	#pwmessage {
		color: white;
	}
	
	/* 회원탈퇴 */
	
	#memberdelete{
		display: none;
		width: 500px;
 		height: 200px;
 		padding: 5px 35px 35px 35px;
 		border:1px solid #ccc;
 		border-radius: 15px;
 		position:fixed;
 		left:35%;
 		top:35%; 
 		z-index: 100;
 		background:#fff;
 		text-align: center;
	}
	#memberdelete_complete {
	 	display: none;
	 	background-color: #f7f7f7;
	 	width: 500px;
 		height: 200px;
 		padding: 35px;
 		border:1px solid #ccc;
 		border-radius: 15px;
 		position:fixed;
 		left:35%;
 		top:35%; 
 		z-index:110;
 		text-align: center;
	}
	#memberdelete_header {
		line-height:35px;
		text-align: center;
		color: white; 
		font-size: 20px;
	}
	#mo_delete_header {
		width: 300px;
		height: 35px;		 
		border: 1px solid #0daa62;
		background-color: #0daa62;
		border-radius: 5px;
		margin: 0 auto;
		position: fixed;
		margin-left: 99px;
		margin-top: 20px;
	}
	.dandi_green {
		color: #0daa62;
		font-weight: bold;
	}
	#delete_message {
		margin-top: 65px;
	}
	#memberdelete_btn_area {
		margin-top: 0;
	}
	#main_bold {
		font-weight: bold;
	}
	#loading_img {
		width: 100px;
		height: 100px;
	}
	#loading_img_area {
		margin-top: 25px;
	}
	#del_complete_message {
		font-size: 17px;
	}
	#updateclose {
		float: left;
		margin-left: 500px;
	}
	.close_btn {
		width: 30px;
		cursor: pointer;
	}
	#deleteclose {
		float: left;
		margin-left: 500px;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	//mypage를 닫는 스크립트
	$(document).on("click", "#myPageClose", function(){
		$("#mypageMoviedetail").css("display", "none");
		$("#cBody").css("height", "20000px");
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
				$("#cBody").css("height", "7500px");
				$("#wrap_contents_mypage").css("height", "7235px");
				$("#mypage_wrap").css("height", "7563px");
			},
			error : function() {
				alert("System Error!!!");
			}

		});
		
	});
	
	$(document).ready(function() {
		var meminfo_code = $("#meminfo_code").val();
		
		var mbirth_value = $("#mbirth_value").val();
		var myear = mbirth_value.substr(0,4);
		var mmonth = mbirth_value.substr(4,2);
		var mday = mbirth_value.substr(6,2);
		var info_myear = $("#info_myear").val();
		var info_mmonth = $("#info_mmonth").val();
		var info_mday = $("#info_mday").val();
		
		
		
		$("#info_myear").attr("value", myear);
		$("#info_mmonth").attr("value", mmonth);
		$("#info_mday").attr("value", mday);
		
		$(document).on("click", "#member_infoupdate", function() {
			$("#meminfo_code").attr("value", "1");
			$("#mo_info").css("display", "block");
			$("#modal_info_pw").focus();
			$("#header").css("position", "inherit");
			$("#header").css("z-index", "50");
		});
		
		$("#member_pwchange").click(function() {
			$("#modal_info_pw").val("");
			$("#meminfo_code").attr("value", "2");
			$("#mo_info").css("display", "block");
			$("#modal_info_pw").focus();
			$("#header").css("position", "inherit");
			$("#header").css("z-index", "50");
		})
		
		$("#member_delete").click(function() {
			$("#meminfo_code").attr("value", "3");
			$("#mo_info").css("display", "block");
			$("#modal_info_pw").focus();
			$("#header").css("position", "inherit");
			$("#header").css("z-index", "50");
		})
		
	});
		
	/* 모달창 닫기  */
	$(document).on("click", "#modal_info_close", function(){
		$("#mo_info").css("display", "none");
		$("#modal_info_pw").val("");
		$("#mo_me").text(".").css("color", "white");
	});
	/* 회원정보수정 모달창 닫기 */
	$(document).on("click", "#updateclose_btn", function(){
		$("#member_update_modal").css("display", "none");	
	});
	/* 회원탈퇴 모달창 닫기 */
	$(document).on("click", "#deleteclose_btn", function(){
		$("#memberdelete").css("display","none");
	});
	$(document).on("click", ".close_btn", function(){
		$("#mo_info").css("display", "none");
		$("#modal_info_pw").val("");
		$("#mo_me").text(".").css("color", "white");
	});
	/* 마이페이지 닫기 */
	$(document).on("click", "#mypageclose_btn", function(){
		location.reload();
	});
	
	$(document).on("click", "#modal_info_btn", function(){
		var meminfo_code = $("#meminfo_code").val();
		var mid = $("#member_id").val();
		var mpw = $("#member_pw").val();
		var modal_mpw = $("#modal_info_pw").val();
		var modal_gendervalue = $("#modal_gendervalue").val();
		
		var mbirth_value = $("#mbirth_value").val();
		var myear = mbirth_value.substr(0,4);
		var mmonth = mbirth_value.substr(4,2);
		var mday = mbirth_value.substr(6,2);
		
		var memail_value = $("#member_email").val();
		var midx = memail_value.indexOf("@");
		var memail1 = memail_value.substring(0, midx);
		var memail2 = memail_value.substring(midx+1);
		var mailAddress = $("#mailAddress").val();
		
		var member_phone = $("#member_phone").val();
		var mphone1 = member_phone.substring(0,3);
		var mphone2 = member_phone.substring(3,7);
		var mphone3 = member_phone.substring(7,11);
		
		var mphone = $("#phone").val();
		if (mpw != modal_mpw){
			$("#mo_me").text("비밀번호가 일치하지 않습니다.").css("color", "red");
		} else {
			if(meminfo_code == 1){
				$("#member_update_modal").css("display", "block");
				
					if(modal_gendervalue == "여자"){
						$("#womanlabel").css("color", "#0daa62");
					} else if(modal_gendervalue == "남자"){
						$("#manlabel").css("color", "#0daa62");
					} else {
						$("#manlabel").css("color", "rgb(142, 142, 142)");
					}
					
				$("#yy").attr("value", myear);
				$("#month_select").val(mmonth).prop("selected", true);
				$("#dd").attr("value", mday);
			
				$("#email1").attr("value", memail1);
				
					if(memail2 == "naver.com"){
						$("#mailAddress").val("2").prop("selected", true);
						$("#email2").val("naver.com");
					} else if(memail2 == "hanmail.net"){
						$("#mailAddress").val("3").prop("selected", true);
						$("#email2").val("hanmail.net");
					} else if(memail2 == "google.com"){
						$("#mailAddress").val("4").prop("selected", true);
						$("#email2").val("google.com");
					}
				$("#phone").attr("value", member_phone);
				
			} else if(meminfo_code == 2){
				$("#passwordupdate").css("display","block");
				
			} else if(meminfo_code == 3){
				$("#memberdelete").css("display", "block");
			}
		}
	});
	
	// Enter key 작동으로 다음 모달 열기
	$("#modal_info_pw").keydown(function(e){
		if(e.keyCode == 13) {
			var meminfo_code = $("#meminfo_code").val();
			var mid = $("#member_id").val();
			var mpw = $("#member_pw").val();
			var modal_mpw = $("#modal_info_pw").val();
			var modal_gendervalue = $("#modal_gendervalue").val();
			
			var mbirth_value = $("#mbirth_value").val();
			var myear = mbirth_value.substr(0,4);
			var mmonth = mbirth_value.substr(4,2);
			var mday = mbirth_value.substr(6,2);
			
			var memail_value = $("#member_email").val();
			var midx = memail_value.indexOf("@");
			var memail1 = memail_value.substring(0, midx);
			var memail2 = memail_value.substring(midx+1);
			var mailAddress = $("#mailAddress").val();
			
			var member_phone = $("#member_phone").val();
			var mphone1 = member_phone.substring(0,3);
			var mphone2 = member_phone.substring(3,7);
			var mphone3 = member_phone.substring(7,11);
			
			var mphone = $("#phone").val();
			if (mpw != modal_mpw){
				$("#mo_me").text("비밀번호가 일치하지 않습니다.").css("color", "red");
			} else {
				if(meminfo_code == 1){
					$("#member_update_modal").css("display", "block");
					
						if(modal_gendervalue == "여자"){
							$("#womanlabel").css("color", "#0daa62");
						} else if(modal_gendervalue == "남자"){
							$("#manlabel").css("color", "#0daa62");
						} else {
							$("#manlabel").css("color", "rgb(142, 142, 142)");
						}
						
					$("#yy").attr("value", myear);
					$("#month_select").val(mmonth).prop("selected", true);
					$("#dd").attr("value", mday);
				
					$("#email1").attr("value", memail1);
					
						if(memail2 == "naver.com"){
							$("#mailAddress").val("2").prop("selected", true);
							$("#email2").val("naver.com");
						} else if(memail2 == "hanmail.net"){
							$("#mailAddress").val("3").prop("selected", true);
							$("#email2").val("hanmail.net");
						} else if(memail2 == "google.com"){
							$("#mailAddress").val("4").prop("selected", true);
							$("#email2").val("google.com");
						}
					$("#phone").attr("value", member_phone);
					
				} else if(meminfo_code == 2){
					$("#passwordupdate").css("display","block");
					$("#pw1").focus();
					
				} else if(meminfo_code == 3){
					$("#memberdelete").css("display", "block");
				}
			}
		}
	});
	
	// 성별 버튼 색상 및 값 변경
	$("#manlabel").click(function(){
		$("#manlabel").css("color", "#0daa62");
		$("#womanlabel").css("color", "#8e8e8e");
		$("#modal_gendervalue").val("남자");
	});
	
	$("#womanlabel").click(function(){
		$("#womanlabel").css("color", "#0daa62");
		$("#manlabel").css("color", "#8e8e8e");
		$("#modal_gendervalue").val("여자");
	});
	
	// 이메일 셀렉트 박스 변경 적용
	$(document).on("change", "#mailAddress", function(){
		var mailAddress = $("#mailAddress").val();
		var email2 = $("#email2").val();
		if(mailAddress == "1") {
			$("#email2").attr("readonly", false);
			$("#email2").val("");
			$("#email2").focus();
			email2 = "";
		} else if (mailAddress == "2"){
			$("#email2").val("naver.com");
			$("#email2").attr("readonly",true);
		} else if (mailAddress == "3"){
			$("#email2").val("hanmail.net");
			$("#email2").attr("readonly",true);
		} else if (mailAddress == "4"){
			$("#email2").val("google.com");
			$("#email2").attr("readonly",true);
		}
	});
	
	$(document).on("click", "#btn_update", function(){
		var mid = $("#member_id").val();
		var mpw = $("#member_pw").val();
 		/* var mname = $("#name").val(); */
		var name = $("#name").val();
		var mname = $.trim(name);
		var mgender = $("#modal_gendervalue").val();
		var yy = $("#yy").val();
		var mm = $("#month_select").val();
		var dd = $("#dd").val(); 
		var mbirth = yy + mm + dd;
		var email1 = $("#email1").val();
		var email2 = $("#email2").val();
		var memail = email1 + "@" + email2;
		var mphone = $("#phone").val(); 
		
		// 이름 유효성검사
		if(mname == ""){
			$("#name").focus();
			$("#errorms").text("이름은 필수 사항입니다. 정확히 입력해주세요.").css("color", "red");
			return false;
		}
		
		// 생년월일 유효성검사
		if(yy == ""){
			$("#yy").focus();
			$("#errorms").text("생년월일은 필수 사항입니다. 정확히 입력해주세요.").css("color", "red");
			return false;
		}
		if(mm == ""){
			$("#month_select").focus();
			$("#errorms").text("생년월일은 필수 사항입니다. 정확히 입력해주세요.").css("color", "red");
			return false;
		}
		if(dd == ""){
			$("#dd").focus();
			$("#errorms").text("생년월일은 필수 사항입니다. 정확히 입력해주세요.").css("color", "red");
			return false;
		}
		
		// 이메일 처리 (필수사항 아님)
		if(email1 == ""){
			memail = "";
		}
			
		// 전화번호 처리 (필수사항 아님)
		
		alert("mid : " + mid + ", mname : " + mname + ", mgender : " + mgender + ", mbirth : " + mbirth + ", memail : " + memail + "mphone : " + mphone);
		  $.ajax({
			url : "memberupdate.dandy",
			type : "POST",
			dataType: "JSON",
			data : "mid=" + mid + "&mpw=" + mpw + "&mname=" + mname + "&mgender=" + mgender + "&mbirth=" + mbirth + "&memail=" + memail + "&mphone=" + mphone,
			success : function(data) {
				 if(data.result == "1"){
					 alert("수정 성공");
						location.reload();
				 } else if(data.result == "0"){
					 alert("수정 실패");
				 }
			},
			error : function() {
				alert("System Error!!!");
			}

		});  
		 
		 
	});
	
	$(document).on("click", "#modal_password_close", function(){
		$("#mo_info").css("display","none");
		$("#passwordupdate").css("display","none");
		$("#pwmessage").text(".").css("color","white");
		$("#pw1").val(""); 
		$("#pw2").val("");
	});
	$(document).on("click", "#modal_password_btn", function(){
		var mid = $("#member_id").val();
		
		var pw1 = $("#pw1").val();
		var mpw1 = $.trim(pw1);
		var pw2 = $("#pw2").val();
		var mpw2 = $.trim(pw2);
		
		var regPass = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		
		if(mpw1 == ""){
			$("#pwmessage").text("변경할 비밀번호를 입력해주세요.").css("color","red");
			$("#pw1").focus();
			return false;
		} else if(!regPass.test(mpw1)) {
			$("#pwmessage").text("6~20자 이내 숫자 + 영문만 사용하세요.").css("color", "red"); 
			$("#pw1").focus();
			return false;
		}  else if(mpw2 == ""){
			$("#pwmessage").text("비밀번호확인을 입력해주세요.").css("color","red");
			$("#pw2").focus();
			return false;
		}  else if(mpw1 != mpw2){
			$("#pwmessage").text("비밀번호가 일치하지 않습니다.").css("color","red");
		}  else if(mpw1 == mpw2){
			$("#pwmessage").text(".").css("color","white");
			$.ajax({
				url : "memberpwchange.dandy",
				type : "POST",
				dataType: "JSON",
				data : "mid=" + mid + "&pw1=" + mpw1,
				success : function(data) {
					 if(data.result == "1"){
						 alert("비밀번호변경 성공");
							location.reload();
					 } else if(data.result == "0"){
						 alert("비밀번호변경 실패");
					 }
				},
				error : function() {
					alert("System Error!!!");
				}

			});
		}
		
	});
	
	// EnterKey로 비밀번호 변경 적용
	$("#pw2").keydown(function(e){
		if(e.keyCode == 13) {
			var mid = $("#member_id").val();
			
			var pw1 = $("#pw1").val();
			var mpw1 = $.trim(pw1);
			var pw2 = $("#pw2").val();
			var mpw2 = $.trim(pw2);
			
			var regPass = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
			
			if(mpw1 == ""){
				$("#pwmessage").text("변경할 비밀번호를 입력해주세요.").css("color","red");
			} else if(!regPass.test(mpw1)) {
				$("#pwmessage").text("6~20자 이내 숫자 + 영문만 사용하세요.").css("color", "red"); 
			}  else if(mpw2 == ""){
				$("#pwmessage").text("비밀번호확인을 입력해주세요.").css("color","red");
			}  else if(mpw1 != mpw2){
				$("#pwmessage").text("비밀번호가 일치하지 않습니다.").css("color","red");
			}  else if(mpw1 == mpw2){
				$("#pwmessage").text(".").css("color","white");
				$.ajax({
					url : "memberpwchange.dandy",
					type : "POST",
					dataType: "JSON",
					data : "mid=" + mid + "&pw1=" + mpw1,
					success : function(data) {
						 if(data.result == "1"){
							 alert("비밀번호변경 성공");
								location.reload();
						 } else if(data.result == "0"){
							 alert("비밀번호변경 실패");
						 }
					},
					error : function() {
						alert("System Error!!!");
					}

				});
			}
		}
	});
	
	$(document).on("click", "#memberdelete_btn", function(){
		var mid = $("#member_id").val();
		//alert(mid);
		 $.ajax({
				url : "memberdelete.dandy",
				type : "POST",
				dataType: "JSON",
				data : "mid=" + mid,
				success : function(data) {
					 if(data.result == "1"){
						 alert("회원 탈퇴 성공");
							if(data.flag == "1"){
								$("#memberdelete_complete").css("display", "block");
								setTimeout(function() {
									location.reload();
								}, 5000);
							}
					 } else if(data.result == "0"){
						 alert("회원 탈퇴 실패");
					 }
				},
				error : function() {
					alert("System Error!!!");
				}

			});
		
	});
	
</script>
</head>
<body>
	<!-- My Page : 전체 감싸는 div -->
	<div id="mypage_wrap">
		<div id="mypageMoviedetail"></div>
		<div id="myPageClose">
			<img src="image/btn/btn_error_gray2.png" class="close_btn" id="mypageclose_btn">
		</div>
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
								<input type="text" id="member_id" name="mid" value="${sessionScope.loginUser.mid}" readonly="readonly">
								<input type="hidden" id="member_pw" name="mpw" value="${sessionScope.loginUser.mpw}">
							</div>
							<div id ="member_ngb_line">
								<input type="hidden" id="mbirth_value" value="${sessionScope.loginUser.mbirth}">
								<input type="text" id="member_ngb" class="member_info" value="${sessionScope.loginUser.mname}&nbsp;(${sessionScope.loginUser.msex} ," readonly="readonly">
								<input type="text" id="info_myear" value="" readonly="readonly">-
								<input type="text" id="info_mmonth" value="" readonly="readonly">-
								<input type="text" id="info_mday" value="" readonly="readonly">)
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
	
	<!-- 회원정보 수정 모달창 -->
		<div id="member_update_modal">
				<div id="updateclose">
					<img src="image/btn/btn_error_gray2.png" class="close_btn" id="updateclose_btn">
				</div>
			<div id="wrap">
				<div id="modal_header"><h1><span class="header_logo">회원정보수정</span></h1></div>
				<div id="container">
					<div id="content">
						<div class="join_content">
	<!----------------------------아이디--------->
							<div class="row_group">
								<div class="join_row" id="idDiv">
									<span>
										<input type="text" id="id" name="id" class="input" value="${sessionScope.loginUser.mid}" readonly="readonly">
										<label id="idlb" for="id" class="label">아이디</label>
									</span>	
								</div>	
							</div>
							<div class="row_group">
	<!----------------------------이름--------->
								<div class="join_row join_sex" id="nameDiv">
									<span>
										<input type="text" id="name" name="name" class="input" maxlength="4" value="${sessionScope.loginUser.mname}">
										<label id="namelb" for="name" class="label">이름</label>
									</span>	
								</div>
	<!----------------------------성별--------->													
								<div class="join_row" id="sexDiv">
									<span class="sex">
										<input type="hidden" id="modal_gendervalue" value="${sessionScope.loginUser.msex}">
										<span class="gender">
											<input type="radio" id="man" name="gender" value="1">
											<label id="manlabel" for="man">남자</label>
										</span>
										<span class="gender">
											<input type="radio" id="woman" name="gender" value="2">
											<label id="womanlabel" for="woman">여자</label>
										</span>
									</span>	
								</div>
	<!----------------------------생일--------->										
								<div class="join_row join_birthday" id="birthDiv">
									<div class="join_birth">
										<div class="bir_title"><span>생일</span></div>
										<div class="bir_yy">
											<span class="birth_box">
												<input type="text" id="yy" name="yy" maxlength="4" class="input" value="">
												<label id="yyLb" for="yy" class="label"></label>
											</span>
										</div>
										<div class="bir_mm">
											<span class="birth_box">
												<select id="month_select" class="select" name="mm">
													<option value>월</option>
													<option value="01">01</option>
													<option value="02">02</option>
													<option value="03">03</option>
													<option value="04">04</option>
													<option value="05">05</option>
													<option value="06">06</option>
													<option value="07">07</option>
													<option value="08">08</option>
													<option value="09">09</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
												</select>
											</span>
										</div>
										<div class="bir_dd">
											<span class="birth_box">
												<input type="text" id="dd" name="dd" maxlength="2" placeholder="일" class="input">
												<label class="label" id="ddLb" for="dd">일</label>
											</span>
										</div>
									</div>				
								</div>	
	<!----------------------------이메일--------->			
								<div class="join_row" id="emailDiv">
									<span>
										<input type="text" id="email1" name="email1" class="input" value="">
										<label id="emaillb1" for="email1" class="label">이메일</label>
										<span>@</span>
										<input type="text" id="email2" name="email2" value="" class="input">
										<label id="emaillb2" for="email2" class="label">이메일</label>
										<select id="mailAddress" name="mailAddress">
											<option value="1">직접입력</option>
											<option value="2">naver.com</option>
											<option value="3">hanmail.net</option>
											<option value="4">google.com</option>
										</select>
									</span>	
								</div>						
							</div>
	<!----------------------------휴대전화--------->
							<div class="row_group">
								<div class="join_row" id="phoneDiv">
									<span>
										<input type="text" id="phone" name="phone" class="input" maxlength="11">
										<label id="phonelb" for="phone" class="label">휴대전화번호</label>
									</span>	
								</div>
							</div>
							<div id="error_ch">
								<span id="errorms">.</span>
							</div>
							
							<span class="btn_join">
								<input type="submit" id="btn_update" class="mo_member_btn" value="수정완료">
								<input type="hidden" id="idCheck" name="idCheck" value="Y"/>
							</span>
					</div>
				</div>
			</div>
			
			
		</div>
		</div>
		
	<!-- 비밀번호 변경 모달창 -->
		<div id="passwordupdate">
			<div id="mo_pw_header"><span id="passwordupdate_header">비밀번호변경</span></div>
			<div id="password_input_area">
				<input type="password"  id ="pw1" name="pw1" class="password_input" value="" placeholder="새비밀번호">
				<br>
				<input type="password" id="pw2" name="pw2" class="password_input" value=""placeholder="비밀번호확인">
			</div>
			<div id="password_message">
				<span id="pwmessage">.</span>
			</div>
			<div id="password_btn_area">
				<input type="button" id="modal_password_btn" class="mo_member_btn" value="확인">
				<input type="button" id="modal_password_close" class="mo_member_btn" value="취소">
			</div>
		</div>
		
	<!-- 회원탈퇴 모달창 -->
		<div id="memberdelete" class="memeberdelete_modal">
			<div id="deleteclose">
					<img src="image/btn/btn_error_gray2.png" class="close_btn" id="deleteclose_btn">
			</div>
			<div id="mo_delete_header"><span id="memberdelete_header">회원탈퇴</span></div>
			<div id="delete_message">
				<span class="dandi_green">DANDI</span><span>를 탈퇴하시면 회원정보와 내단어장리스트가
				<br>초기화되며 복구하실 수 없습니다.
				<br>정말로 탈퇴를 원하신다면 아래의 탈퇴버튼을 눌러주세요.</span>
				<br><span class="dandi_green">DANDI</span><span>를 탈퇴하시겠습니까?</span>
			</div>
			<div id="memberdelete_btn_area">
				<input type="button" id="memberdelete_btn" class="mo_member_btn" value="회원탈퇴">
			</div>
		</div>
		
	<!-- 회원탈퇴 완료 모달창 -->
		<div id="memberdelete_complete" class="memeberdelete_modal">
			<div id="del_complete_message">
				<span>회원탈퇴가 정상적으로 처리되었습니다.</span>
				<br><span class="dandi_green">DANDI</span><span>를 이용해주셔서 감사합니다.
				<br>5초 후 <span id="main_bold">main</span>으로 돌아갑니다.</span>
			</div>
			<div id="loading_img_area">
				<img src="image/diy/loading.gif" id="loading_img">
			</div>
		</div>
		
	</div>
</body>
</html>