<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
</script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/hanna.css);
/* font-family: 'Hanna', serif; */
	body {
	}
	table {
		border-left: none;
		border-right: none;
		border-top: 2px solid #f7f7f7;
		border-bottom : 2px solid #0daa62; 
 		border-collapse: collapse;
 		width: 1000px;
 		margin-left: 95px;
	}
	tr {
		height: 100px;
		border: 1px solid #ddd;
		border-left: none;
		border-right: none;
	}
	tr, td {
		padding: 15px;
	}
	#title_tr{
		border-bottom : 2px solid #0daa62;
	}
	#contents {
		width: 1200px;
		margin-top: 30px;
	}
	.tx_cen {
		text-align: center;
	}
	#sub_input {
		width: 500px;
		font-size: 15px;
	}
	#name_input {
		width: 150px;
		font-size: 16px;
		border: none;
		background-color: #f7f7f7;
	}
	#con_input {
		width: 700px;
		height: 200px;
		font-size: 15px;
	}
	#qna_select {
		width: 150px;
		height: 26px;
		font-size: 15px;
	}
	
	#title {
		text-indent: 270px;
		font-size: 25px;
		font-weight: bold;
		color: #a7a7a7;
	}
	#btn_succ{
		text-indent: 230px;
		width: 200px;
		
	}
	#btn_success { 
		color: #555555;
		padding: 7px 14px;
		font-size: 16px;
		cursor:pointer;		
		background-color: #ededed;
		border-radius: 5px;
		border: 1px solid white;
	}
	#btn_success:hover {
		border: 1px solid #0daa62;
		background-color: white;
		color: #0daa62;
	}
	#page_footer {
		height: 200px;
	}
	
	/*	파일첨부  */
	#file_td {
		font-size: 16px;
	}
	
	input.upload_text {
		float:left;
		width:230px;
		height:19px;
		line-height:19px;
		padding:0 3px;
		border:1px solid #bbb;
		font-size: 15px;
		color: #a7a7a7;
	}
	
	div.upload-btn_wrap input.input_file {
		position:absolute;
		top:0;
		right:0;
		cursor:pointer;
		opacity:0;
		font-size: 16px;
	}
	div.upload-btn_wrap {
		overflow:hidden;
		position:relative;
		float:left;
		width:70px;
		height:21px;
		padding-left:3px;
	}
	#filebtn{
		height:21px;
		background: white;
		color:#a7a7a7;
		border: none;
		font-size: 16px;
		font-weight: bold;
	}
	#upload_text {
		border: 1px solid #ddd;
		float:left;
		width:230px;
		height:19px;
		line-height:19px;
		padding:0 3px;
		font-size: 15px;
		color: #a7a7a7;
	}
	#secret_label_flag {
		cursor: pointer;
		/* background: (image/password-protection-symbol-on-monitor-screen.png) center 90px no-repeat; */
	}
</style>
<script type="text/javascript">
$(document).on("click", "#secret_span_flag", function(){
	var flag = $("#secret_input_flag").val();
	if(flag==1){
		//공개글로 작성하려는 것
		flag = $("#secret_input_flag").val("0");
		$("#secret_span_flag").css({"background":"url(image/checked1.png)", 'background-repeat' : 'no-repeat', 'background-position':'left center'}); 
	} else {
		//비밀글로 작성하려는 것
		flag = $("#secret_input_flag").val("1");
		$("#secret_span_flag").css({"background":"url(image/checked.png)", 'background-repeat' : 'no-repeat', 'background-position':'left center'}); 
	}
});


</script>
</head>
<body>

	<div id="contents">
		<table>
			<tbody>
	<!-- Q & A : title -->
				<tr id="title_tr">
					<td class="tx_cen">
						<span>&nbsp;</span>
					</td>
					<td id="title">
						<span>Q & A 작성하기</span>
					</td>
				</tr>
	<!-- 작성 제목 -->
				<tr>
					<td class="tx_cen">
						<span>제목</span>
					</td>
					<td>
						<input type="text" id="sub_input" name="title" >
					</td>
				</tr>
	<!-- 작성자 정보 -->
				<tr>
					<td class="tx_cen">
						<span>작성자</span>
					</td>
					<td>
						<input type="text" id="name_input" name="writer" value="${sessionScope.loginUser.mid}" readonly="readonly">
					</td>
				</tr>
	<!-- 비밀글여부 -->
				<tr>
					<td class="tx_cen">
						<span>비밀글여부</span>
					</td>
					<td id="secret_td">
						<span id="secret_span_flag" style="background: url('image/checked1.png') 100% 50% no-repeat; background-position: 2px; padding-left: 20px; ">
						<label for="secret_input_flag" id="secret_label_flag">비밀글 여부</label>
						<input id="secret_input_flag" name="secret_input_flag" type="hidden">
						</span>
					</td>
				</tr>
	<!-- 문의내용 -->
				<tr>
					<td class="tx_cen">
						<span>문의내용</span>
					</td>
					<td>
						<input type="text" id="con_input" name="content">
					</td>
				</tr>
	<!-- 질문구분 -->
				<tr>
					<td class="tx_cen">
						<span>&nbsp;</span>
					</td>
					<td>
						<span>
							<select id="qna_select" name="qna_select">
									<option value="선택해주세요.">선택해주세요.</option>
									<option value="-------------">-------------</option>
									<option value="회원">회원</option>
									<option value="사이트이용">사이트이용</option>
									<option value="단어장관련문의">단어장관련문의</option>
							</select>
							&nbsp;
						</span>
						<span id="select_m">
							※ 단어장관련 문의시에는 해당 단어장명을 기재해 주시면 보다 원활한 처리가 가능합니다.
						</span>
					</td>
				</tr>
	<!-- 작성완료 버튼 -->
				<tr class="bin">
					<td class="tx_cen">
						<span>&nbsp;</span>
					</td>
					<td>
						<div id="btn_succ">
							<button id="btn_success">문의사항 작성완료</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: "con_input",
			sSkinURI: "smarteditor/SmartEditor2Skin.html",
			fCreator: "createSEditor2"
		});
	</script>
</body>
</html>