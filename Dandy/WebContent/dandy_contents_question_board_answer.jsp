<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<title>Insert title here</title>
<style type="text/css">
/* font-family: 'Hanna', serif; */
	body {
	}
	table {
		border-left: none;
		border-right: none;
		border-top: 2px solid white;
		border-bottom : 2px solid #0daa62; 
 		border-collapse: collapse;
 		width: 1000px;
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
		width: 1100px;
		margin-left: 100px;
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
		border: none;
		font-size: 16px;
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
	.empty {
		width: 25px;
	}
	#title {
		text-indent: 230px;
		font-size: 25px;
		font-weight: bold;
		color: #a7a7a7;
	}
	#btn_succ{
		text-indent: 230px;
		width: 200px;
		
	}
	#question_answer_wr_btn { 
		color: #555555;
		padding: 7px 14px;
		font-size: 16px;
		cursor:pointer;		
		background-color: #ededed;
		border-radius: 5px;
		border: 1px solid white;
	}
	#question_answer_wr_btn:hover {
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
</style>
<script type="text/javascript">

</script>
</head>
<body>
<input type="hidden" id="question_answer_bno" value="${boardview.bno}">
	<div id="contents">
				<input type="hidden" id="bno" name="bno" value="${boardview.bno}">
		<table>
			<tbody>
	<!-- Q & A : title -->
				<tr id="title_tr">
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>&nbsp;</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td id="title">
						<span>답변 작성하기</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	
	<!-- 작성 제목 -->
				<tr>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>제목</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td>
						<input type="text" id="sub_input" name="title" value="RE: ${boardview.title}" readonly="readonly">
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 작성자 정보 -->
				<tr>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>작성자</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td>
						<input type="text" id="name_input" name="writer" value="${sessionScope.loginUser.mid}" readonly="readonly">
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 문의내용 -->
				<tr>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>문의내용</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td>
						<input type="text" id="con_input" name="content" value="${boardview.content}">
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 작성완료 버튼 -->
				<tr class="bin">
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>&nbsp;</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td>
						<div id="btn_succ">
							<button id="question_answer_wr_btn">답변 작성완료</button>
						</div>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
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