<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>단디 : 회원가입</title>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
/* font-family: 'Noto Sans KR', sans-serif; */
	
	body {
		font-family: 'Noto Sans KR', sans-serif;
	}
	/* body, div, h1 {
		margin: 0;
		padding: 0;
	} */
	a {
		text-decoration: none;
	}
	
	/* container */
	#content {
		margin: 0 auto;
		width: 600px;
		min-width: 460px;
	}
	.join_content {
		width: 460px;
		margin: 30px 70px 50px 70px;;
	}
	.row_group {
		zoom: 1;
		margin-bottom: 10px;
		border: 1px solid #dadada;
		background: #fff;
	}
	
	
	.join_row {
		padding: 11px 11px 11px 13px;
		background: #fff;
		box-sizing: border-box;
		margin: 0!important;
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
		margin: 0;
	}
	.error {
		font-size: 12px;
		margin: 5px 0 3px 0;
		color: red;
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
	.error_ch {
		padding: 0;
		text-align: center;
	}
	.btn_join {
		display: block;
		height: 61px;
		margin: 30px 0 20px;
		background: #1fbc02;
	}
	.btn_join input {
		font-family: 'Noto Sans KR', sans-serif;
		background: #fff;
		width: 100%;
		height: 61px;
		border: 1px solid #0daa62;
		text-indent: 0;
		font-size: 24px;
		color: #0daa62;
		font-weight: 600;
		font-size: 20px;
		cursor: pointer;
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
	}
	
	#join_top {
		margin: 0 auto;
		width: 458px;
		height: 50px;
		border: 1px solid #0daa62;
		background: #0daa62;
		border-radius: 5px;
		left: -5px!important;
		text-align: center;
	}
	#join_top_logo {
		margin: 0;
		border: 1px solid #0daa62;
		border-radius: 5px;
		text-align: center;
		color: white;
		background-color: #0daa62;
		text-decoration: none;
		margin-top: 25px;
		line-height: 50px;
		font-size: 25px;
		font-weight: 600;
	}
	#join_close {
		width: 30px;
		float: right;
		margin-top: -45px;
		padding-right: -5px;
		cursor: pointer;
	}
	
</style>


<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#manlabel").click(function(){
		$("#manlabel").css("color", "green");
		$("#womanlabel").css("color", "#8e8e8e");
	});
	
	$("#womanlabel").click(function(){
		$("#womanlabel").css("color", "green");
		$("#manlabel").css("color", "#8e8e8e");
	});
	
	
	$("#btn_submit").on("click", function(){
		var id = $("#id"),
			pw = $("#pw"),
			pw2 = $("#pw2"),
			name = $("#name"),
			yy = $("#yy"),
			mm = $("#mm"),
			dd = $("#dd"),
			sex = $("input[type=radio][name=sex]:checked").val(),		
			phone = $("#phone"),
			email1 = $("#email1"),
			email2 = $("#email2");
		
		
		var mid = $.trim(id.val());
		var mpw = $.trim(pw.val());
		var mpw2 = $.trim(pw2.val());
		var regPass = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; // 6~20 자 이내 숫자 + 영문
		var mname = $.trim(name.val());
		if(mid == ""){
			id.focus();
			$("#idMsg").css("display", "block").css("color", "red");
			return false;
		} else if(mpw == "") {
			pw.focus();
			$("#pwMsg").css("display", "block");
			return false;
		} else if(!regPass.test(mpw)) {
			pw.select();
			$("#pwMsg").text("6~20자 이내 숫자 + 영문만 사용하세요.").css("display", "block");
			return false;
		} else if(mpw2 == "") {
			pw2.focus();
			$("#pw2Msg").css("display", "block");
			return false;
		} else if(mpw != mpw2){
			pw2.select();
			$("#pw2Msg").text("비밀번호가 일치하지 않습니다.").css("display", "block");
			return false;
		} else if(mname == ""){
			name.focus();
			$("#nameMsg").css("display", "block");
			return false;
		} else if(sex == null){
			$("#sexMsg").css("display", "block");
			return false;
		} 
		/* else if(sex == 1){
			$("#manlabel").css("color", "green");
			$("#sexMsg").css("display", "none");
		} else if(sex == 2){
			$("#womanlabel").css("color", "green");
			$("#sexMsg").css("display", "none");
		} */ 
		else if(yy.val() == ""){
			yy.focus();
			$("#birthMsg").text("태어난 년도 4자리를 정확하게 입력하세요.").css("display", "block");
			return false;
		} else if(mm.val() == ""){
			mm.focus();
			$("#birthMsg").text("태어난 월을 선택하세요.").css("display", "block");
			return false;
		} else if(dd.val() == ""){
			dd.focus();
			$("#birthMsg").text("태어난 일(날짜) 2자리를 정확하게 입력하세요.").css("display", "block");
			return false;
		} else {
			$.ajax({
				url: "memberRegister.dandy",
				type: "POST",
				dataType :  "JSON",
				data: "id=" + mid + "&pw=" + mpw + "&name=" + mname + "&sex=" + sex + "&yy=" + yy.val() + "&dd=" + dd.val() + "&email1=" + email1.val() + "&email2=" + email2.val() + "&phone=" + phone.val(),
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
		
		/* var memail = email1.val() + "@" + email2.val();
		var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		 // 정규식에 해당하면 true, 맞지 않으면 false 반환
		if(email1.val() == "") {
			email1.focus();
			$("#emailMsg").css("display", "block");
			return false;
		} else if (email2.val() == "") {
			email2.focus();
			$("#emailMsg").css("display", "block");
			return false;
		} else if(!regEmail.test(memail)) {
			email2.select();
			$("#emailMsg").text("이메일 형식이 잘 못 되었습니다.").css("display", "block");
			return false;
		}
		 
		 
		var mphone = $.trim(phone.val());
		var regPhone = /^(?:(010\d{4})|(01[1|6|7|8|9]\d{3,4}))(\d{4})$/;
		if(mphone == "") {
			phone.focus();
			$("#phoneMsg").css("display", "block");
			return false;
		} else if(!regPhone.test(mphone)) {
			phone.select();
			$("#phoneMsg").text("'-'를 제외한 11자리 숫자만 입력해 주세요.").css("display", "block");
			return false;
		} */
		
				 
	});
	
	
	$("#id").blur(function(){
		$("#idMsg").css("display", "none");
	});
	$("#pw").blur(function(){
		$("#pwMsg").css("display", "none");
	});
	$("#pw2").blur(function(){
		$("#pw2Msg").css("display", "none");
	});
	$("#name").blur(function(){
		$("#nameMsg").css("display", "none");
	});
	$("#sex").blur(function(){
		$("#sexMsg").css("display", "none");
	});
	$("#yy").blur(function(){
		$("#birthMsg").css("display", "none");
	});
	$("#mm").blur(function(){
		$("#birthMsg").css("display", "none");
	});
	$("#dd").blur(function(){
		$("#birthMsg").css("display", "none");
	});
	$("#email").blur(function(){
		$("#emailMsg").css("display", "none");
	});
	$("#emai2").blur(function(){
		$("#emailMsg").css("display", "none");
	});
	$("#phone").blur(function(){
		$("#phoneMsg").css("display", "none");
	});
	
	
});

	
	$(document).on("change", "#mailAddress", function(){
		var mailAddress = $("#mailAddress").val();
		var email2 = $("#email2");
		if(mailAddress == "직접입력") {
			email2.attr("readonly", false);
			email2.focus();
			email2.val(null);
		} else {
			email2.val(mailAddress);
			email2.attr("readonly",true);
			$("#emailMsg").css("display", "none");
		}
	});
	
	
	// ID 중복체크 Ajax
	$(document).on("blur", "#id", function(){
		var id = $("#id").val();
		
		if(id == "") {
			$("#id").focus();
			$("#idMsg").text("아이디를 입력하세요.").css("display", "block");
			return false;			
		} else if(id != "") {
			$("#idMsg").text("아이디를 입력하세요.").css("display", "block");
			$.ajax({
				url: "memberCheckAjax.dandy",
				type: "POST",
				dataType: "json",
				data: "id=" + id,
				success: function(data) {
					if(data.flag == "0") {
						$("#idCheck").val("N");
						$("#idMsg").text("중복된 아이디 입니다.").css("display", "block").css("color", "red");	
					} else {
						$("#idCheck").val("Y");
						$("#idMsg").text("멋진 아이디 입니다.").css("display", "block").css("color", "green");
					}
				},
				error: function() {
					alert("System Error!!!");
				}
			});
		} 
		
		
	});
	
	$(document).on("click","#join_close", function(){
		location.reload();
	});
	
	
</script>
</head>
<body>

	<div id="wrap">
		
		<div id="container">
			<div id="content">
				<div id="join_top"><span id="join_top_logo">단디 회원가입</span></div>
				<div><img src="image/btn/btn_error_gray3.png" id="join_close"></div>
				<div class="join_content">
						<div class="row_group">
							<!-- 아이디  -->
							<div class="join_row" id="idDiv">
								<span>
									<input type="text" id="id" name="id" placeholder="아이디" class="input">
									<label id="idlb" for="id" class="label">아이디</label>
									
								</span>	
								<div id="idMsg" class="error" style="display: none">필수 정보입니다.</div>						
							</div>	
							
							<!-- 비밀번호  -->												
							<div class="join_row" id="pwDiv">
								<span>
									<input type="password" id="pw" name="pw" placeholder="비밀번호" class="input">
									<label id="pwlb" for="pw" class="label">비밀번호</label>
								</span>	
								<div id="pwMsg" class="error" style="display: none">필수 정보입니다.</div>						
							</div>	
							
							<!-- 비밀번호 재확인  -->												
							<div class="join_row" id="pw2Div">
								<span>
									<input type="password" id="pw2" name="pw2" placeholder="비밀번호 재확인" class="input">
									<label id="pw2lb" for="pw2" class="label">비밀전호 재확인</label>
								</span>	
								<div id="pw2Msg" class="error" style="display: none">필수 정보입니다.</div>						
							</div>													
						</div>
						
						
						<div class="row_group">
							<!-- 이름 -->
							<div class="join_row join_sex" id="nameDiv">
								<span>
									<input type="text" id="name" name="name" placeholder="이름" class="input" maxlength="4">
									<label id="namelb" for="name" class="label">이름</label>
								</span>	
								<div id="nameMsg" class="error" style="display: none">필수 정보입니다.</div>						
							</div>
							
							<!-- 성별  -->													
							<div class="join_row" id="sexDiv">
								<span class="sex">
									<span class="gender">
										<input type="radio" id="man" name="sex" value="1">
										<label id="manlabel" for="man">남자</label>
									</span>
									<span class="gender">
										<input type="radio" id="woman" name="sex" value="2">
										<label id="womanlabel" for="woman">여자</label>
									</span>
								</span>	
								<div id="sexMsg" class="error" style="display: none">필수 정보입니다.</div>						
							</div>
							
							<!-- 생일 -->										
							<div class="join_row join_birthday" id="birthDiv">
								<div class="join_birth">
									<div class="bir_title">
										<span>생일</span>
									</div>
									<div class="bir_yy">
										<span class="birth_box">
											<input type="text" id="yy" name="yy" maxlength="4" placeholder="년(4자)" class="input">
											<label id="yyLb" for="yy" class="label">년(4자)</label>
										</span>
									</div>
									<div class="bir_mm">
										<span class="birth_box">
											<select class="select" name="mm">
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
								<div id="birthMsg" class="error" style="display: none">필수 정보입니다.</div>
							</div>	
												
							<div class="join_row" id="emailDiv">
								<span>
									<input type="text" id="email1" name="email1" placeholder="이메일" class="input">
									<label id="emaillb1" for="email1" class="label">이메일</label>
									<span>@</span>
									<input type="text" id="email2" name="email2" placeholder="" class="input">
									<label id="emaillb2" for="email2" class="label">이메일</label>
									<select id="mailAddress" name="mailAddress">
										<option>직접입력</option>
										<option>naver.com</option>
										<option>daum.net</option>
										<option>google.com</option>
									</select>
								</span>	
							</div>						
							<div id="emailMsg" class="error" style="display: none">필수 정보입니다.</div>						
						</div>
						
					<!-- 휴대전화  -->
					<div class="row_group">
						<div class="join_row" id="phoneDiv">
							<span>
								<input type="text" id="phone" name="phone" placeholder="휴대전화번호" class="input" maxlength="11">
								<label id="phonelb" for="phone" class="label">휴대전화번호</label>
							</span>	
						<div id="phoneMsg" class="error" style="display: none">필수 정보입니다.</div>						
						</div>
					</div>
					
					
						<div class="error_ch">
							<span id="joinMsg" class="error" style="display: none">입력하신 정보를 다시 확인해주세요.</span>
						</div>
						
						<span class="btn_join">
							<input type="button" id="btn_submit" alt="회원가입" class="input_join" value="가입하기">
							<input type="hidden" id="idCheck" name="idCheck" value="Y"/>
						</span>
				</div>
			</div>
		</div>
		
		
	</div>






</body>
</html>