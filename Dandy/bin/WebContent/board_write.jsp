<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
	
		$("#btn_success").on("click", function(){
				form.submit();
		});
	});
	$(document).ready(function() {
		$("#sub_input").val("");
		$("#con_input").val("");
	});
	
	
	$(document).ready(function(){
		$('.upload_text').val('*첨부할 파일을 선택해 주세요.');
		$('.input_file').change(function(){
			var i = $(this).val();
			$('.upload_text').val(i).css("color","black");
			$("#filebtn").css("color","#FFDF24");
			
		});
	});
	
</script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/hanna.css);
/* font-family: 'Hanna', serif; */
	body {
		font-family: 'Hanna', serif;
	}
	table {
		border-left: none;
		border-right: none;
		border-top: 2px solid white;
		border-bottom : 2px solid #FFDF24; 
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
		border-bottom : 2px solid #FFDF24;
	}
	#contents {
		width: 1200px;
		margin: 10px 460px;
		margin-top: 30px;
	}
	.tx_cen {
		text-align: center;
	}
	#sub_input {
		width: 500px;
		font-family: 'Hanna', serif;
		font-size: 15px;
	}
	#name_input {
		width: 150px;
		font-family: 'Hanna', serif;
		font-size: 16px;
		border: none;
	}
	#con_input {
		width: 700px;
		height: 200px;
		font-family: 'Hanna', serif;
		font-size: 15px;
	}
	#qna_select {
		width: 150px;
		height: 26px;
		font-family: 'Hanna', serif;
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
	#btn_success { 
		color: #555555;
		padding: 7px 14px;
		font-size: 16px;
		cursor:pointer;		
		background-color: #ededed;
		border-radius: 5px;
		border: 1px solid white;
		font-family: 'Hanna', serif;
	}
	#btn_success:hover {
		border: 1px solid #ffdf24;
		background-color: white;
		color: #ffdf24;
	}
	#page_footer {
		height: 200px;
	}
	
	/*	파일첨부  */
	#file_td {
		font-size: 16px;
		font-family: 'Hanna', serif;
	}
	
	input.upload_text {
		float:left;
		width:230px;
		height:19px;
		line-height:19px;
		padding:0 3px;
		border:1px solid #bbb;
		font-size: 15px;
		font-family: 'Hanna', serif;
		color: #a7a7a7;
	}
	
	div.upload-btn_wrap input.input_file {
		position:absolute;
		top:0;
		right:0;
		cursor:pointer;
		opacity:0;
		font-size: 16px;
		font-family: 'Hanna', serif;
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
		font-family: 'Hanna', serif;
		color: #a7a7a7;
	}
</style>
</head>
<body>
	<div id="contents">
			<form role="form" action="boardinsertsave.bizpoll" method="post" enctype="multipart/form-data">
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
						<span>Q & A 작성하기</span>
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
						<input type="text" id="sub_input" name="title" >
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
	<!-- 첨부파일 -->
				<tr>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>파일첨부</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td id="file_td">
						<label for="file_upload">
						<span><input type="text" class="upload_text" readonly="readonly"></span>
						</label>
						<div class="upload-btn_wrap">
							<button type="button" id="filebtn"><i class="fa fa-file"></i></button>
							<input type="file" class="input_file" name="file_upload" id="file_upload">
						</div>
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
						<input type="text" id="con_input" name="content">
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 질문구분 -->
				<tr>
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
						<span>
							<select id="qna_select">
									<option value="선택해주세요.">선택해주세요.</option>
									<option value="-------------">-------------</option>
									<option value="상품관련">상품관련</option>
									<option value="주문/결제 관련">주문/결제 관련</option>
									<option value="교환/환불 관련">교환/환불 관련</option>
									<option value="배송관련">배송관련</option>
									<option value="품절관련">품절관련</option>
									<option value="해외배송">해외배송</option>
									<option value="기타문의">기타문의</option>
							</select>
							&nbsp;
						</span>
						<span id="select_m">
							※ 상품관련 문의시에는 해당 상품명을 반드시 기재해 주시기 바랍니다.
						</span>
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
							<button id="btn_success">문의사항 작성완료</button>
						</div>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
			</tbody>
		</table>
			</form>
	</div>
	
</body>
</html>