<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dandy : 회원가입</title>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
/* font-family: 'Noto Sans KR', sans-serif; */
	body, h1, ul, p, h3 {
		margin: 0px;
		padding: 0px;
	}
	body {
		background-color: #f5f6f7;
		font-family: 'Noto Sans KR', sans-serif;
	}
	
	div#container {
		width: 768px;
		margin: 0 auto;
		box-sizing: border-box;
	}
	div#container {
		position: relative;
		width: 600px;
		height: 760px;
	}
	
	
	/* container */
	form#join_content {
		width: 460px!important;
		margin: 0 auto!important;
	}
	#terms {
		margin-top: 30px;
		margin-bottom: 20px;
		background-color: white;
		border: 1px solid #dadada;
		width: 432px;
		margin-left: 83px;
	}
	.terms_span > input {
		position: absolute;
		right: 1px;
		top: 50%;
		width: 22px;
		height: 22px;
		margin-top: -11px;
		visibility: hidden; 
	}
	.terms_span {
		position: relative;
		display: block;
		height: 58px;
	}
	.terms_p {
		display: block;
		padding: 15px;
		margin: 0;
		position: relative;
	}
	.terms_span > label {
		background: url('image/constract/check_off.gif') 100% 50% no-repeat;
		display: block;
		line-height: 20px;
		height: 58px;
		top: -1px;
		font-size: 14px;
		font-weight: 700;
	}
	.terms_span > input:checked +label {
		background-image: url('image/constract/check_on.gif')
	}
	
	
	/* terms_li1 */
	#terms_ul {
		padding-bottom: 7px;
		list-style: none;
	}
	#terms_ul_li1 {
		border-top: 1px solid #f0f0f0;
	}	
	ul#terms_ul > li {
		display: block;
		padding: 13px 15px 7px;
	}
	.ul_li_span {
		position: relative;
		display: block;
		height: 24px;
	}
	.label1 {
		height: 24px;
		font-size: 14px;
		font-weight: 700;
		line-height: 24px;
		position: absolute;
		color: #333;
		top: 0;
		left: 0;
		width: 100%;
	}
	.span_only {
		color: #0daa62;
		font-size: 12px;
		font-weight: 400;
	}
	.terms_no {
		color: #8e8e8e;
	}
	.ul_li_span > input {
		visibility: hidden;
		position: absolute;
		right: 1px;
		width: 22px;
		height: 22px;
		margin-top: -11px;
		top: 50%;
	}
	.ul_li_span > label {
		background: url('image/constract/check_off.gif') 100% 50% no-repeat;
		display: block; 
	}
	.ul_li_span > input:checked +label {
		background-image: url('image/constract/check_on.gif')
	}
	
	.terms_box {
		position: relative;
		box-sizing: border-box;
		height: 88px;
		margin-top: 11px;
		padding: 8px 10px;
		border: 1px solid #f0f0f0;
		background-color: #f7f7f7;
		overflow: auto;
	}
	.article {
		margin-top: 0px;
	}
	h3.article_title {
		font-size: 12px;
		font-weight: 700;
		line-height: 16px;
		color: #666;
	}
	.article > p {
		display: block;
		font-size: 12px;
		line-height: 16px;
		color: #666;
	}
	.span_select {
		color: #969696;
		font-size: 12px;
		font-weight: 400;
	}
	
	.btn_double_area {
		margin: 30px 83px 0px;
		overflow: hidden;
		width: 432px;
	}
	.btn_double_area > span {
		display: block;
		float: left;
		width: 50%;
	}
	.btn_type {
		width: auto;
		margin: 0 5px;
		font-size: 20px;
		font-weight: 600;
		line-height: 61px;
		display: block;
		box-sizing: border-box;
		height: 61px;
		padding-top: 1px;
		text-align: center;
	}
	.btn_default {
		color: #333;
		border: 1px solid #e7e7e7;
		background-color: #fff;
		font-family: 'Noto Sans KR', sans-serif;
	}
	.btn_agree {
		color: #0daa62;
		border: 1px solid #e7e7e7;
		background-color: #fff;
		font-family: 'Noto Sans KR', sans-serif;
	}
	a {
		text-decoration: none;
		color: inherit;	
	}
	
	
	
	#warning {
		display: none;
		line-height: 16px;
		margin: -3px 15px 11px;
		font-size: 12px;
		color: red;
	}
	#constract_top{
		margin: 0 auto;
		width: 458px;
		height: 50px;
		border: 1px solid #0daa62;
		background: #0daa62;
		border-radius: 5px;
		left: -5px!important;
		text-align: center;
	}
	#constract_top_logo {
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

</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#cbox").click(function(){
		var checked = $("#cbox").is(":checked");
			if(checked == true){
				$(".ckbox").prop("checked", true);
			} else if(checked == false) {
				$(".ckbox").prop("checked", false);
			}
		});
		
		
		/* 하나라도 체크 해제되면 전체동의도 해제되게 만들기 */
		$(".ckbox").on("click", function(){
			var ckChecked = $(".ckbox:checkbox:checked").length;
			if(ckChecked == 4) {
				$("#cbox").prop("checked", true);
			} else {
				$("#cbox").prop("checked", false);
			}
		});
		
		
		 /* 동의 눌렀을 때 유효성 체크 */
		/* $(".btn_agree").click(function(){
			var necessary1 = $("#li1box").is(":checked");
			var necessary2 = $("#li2box").is(":checked");
			if (necessary1 == false || necessary2 == false) {
				$("#warning").css("display", "block");
				return false;
			} else {
				$("#join_content").submit();
			}
		});  */
		
		
	});
	
	$(document).on("click", "#btn_disagree", function(){
		//alert("비동의 클릭!");
		location.reload();
	});
	

</script>

</head>
<body>

	<div id="container">
		<!-- <form id="join_content" action="memberInsert.dandy"> -->
		<div id="constract_top"><span id="constract_top_logo">이용약관 동의</span></div>
			<div id="terms">
				<p class="terms_p">
					<span class="terms_span">
						<input type="checkbox" id="cbox">
						<label for="cbox">
							이용약관, 개인정보 수집 및 이용, <br>
							위치정보 이용약관(선택), 프로모션 안내 <br>
							메일 수신(선택)에 모두 동의합니다.
						</label>
					</span>
				</p>
				
				<ul id="terms_ul">
					<li id="terms_ul_li1">
						<span class="ul_li_span">
							<input type="checkbox" id="li1box" class="ckbox">
							<label for="li1box" class="label1">
								단디 이용약관 동의<span class="span_only">(필수)</span>
							</label>
						</span>
						<div class="terms_box">
							<div class="article">
								<h3 class="article_title">제 1 조 (목적)</h3>
								<p>제 1 조 (목적)
								이 약관은 단디 주식회사 ("회사" 또는 "단디")가 제공하는 단디<br> 
								및 단디 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리,<br> 
								의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
								</p>

								<h3 class="article_title">제 2 조 (정의)</h3>
								<p>제 2 조 (정의)
								이 약관에서 사용하는 용어의 정의는 다음과 같습니다.<br>
								①"서비스"라 함은 구현되는 단말기(PC, TV, 휴대형단말기 등의 각종 유<br>
								무선 장치를 포함)와 상관없이 "회원"이 이용할 수 있는 단디 및 단디<br>
								관련 제반 서비스를 의미합니다.
								</p>
							</div>
						</div>
					</li>
					<li id="terms_ul_li2">
						<span class="ul_li_span">
							<input type="checkbox" id="li2box" class="ckbox">
							<label for="li2box" class="label1">
								개인정보 수집 및 이용에 대한 안내<span class="span_only">(필수)</span>
							</label>
						</span>
						<div class="terms_box">
							<div class="article">
								<p>정보통신망법 규정에 따라 단디에 회원가입 신청하시는 분께 수집하는<br>
								 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이<br>
								 용기간을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
								</p><br>
								
								<h3 class="article_title">1. 수집하는 개인정보</h3>
								<p>이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 단<br>
								디 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘<br>
								린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위<br>
								해 회원가입을 할 경우, 단디는 서비스 이용을 위해 필요한 최소한의<br>
								 개인정보를 수집합니다.
								</p>
							</div>
						</div>
					</li>
					<li id="terms_ul_li3">
						<span class="ul_li_span">
							<input type="checkbox" id="li3box" class="ckbox">
							<label for="li3box" class="label1">
								위치정보 이용약관 동의<span class="span_only terms_no">(선택)</span>
							</label>
						</span>
						<div class="terms_box">
							<div class="article">
								<p>위치정보 이용약관에 동의하시면, <strong>위치를 활용한 광고 정보 수신</strong> 등을<br>
								 포함하는 단디 위치기반 서비스를 이용할 수 있습니다.
								</p><br>
								
								<h3 class="article_title">제 1 조 (목적)</h3>
								<p>이 약관은 단디 주식회사 (이하 “회사”)가 제공하는 위치정보사업 또는<br>
								 위치기반서비스사업과 관련하여 회사와 개인위치정보주체와의 권리, 의<br>
								 무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
								</p>
							</div>
						</div>
					</li>
					<li id="terms_ul_li3">
						<span class="ul_li_span">
							<input type="checkbox" id="li4box" class="ckbox">
							<label for="li4box" class="label1">
								이벤트 등 프로모션 알림 메일 수신<span class="span_only terms_no">(선택)</span>
							</label>
						</span>
					</li>
					
				</ul>
				
				<span id="warning">
					 단디 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.
				</span>
				
			</div>
			
			 <div class="btn_double_area">
				<span><a href="#" class="btn_type btn_default" id="btn_disagree">비동의</a></span>
				<span><a href="#" class="btn_type btn_agree" id="btn_agree" onclick="btn_agree();">동의</a></span>
			</div> 
			
		<!-- </form> -->
		
	</div>
	
</body>
</html>