<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

		$(document).ready(function() {
			$("#sub_input").val("");
			$("#con_input").val("");
		});
		
		$(document).ready(function(){
			$('.upload_text').val('*첨부할 파일을 선택해 주세요.');
			$('.input_file').change(function(){
				var i = $(this).val();
				$('.upload_text').val(i).css("color","black");
				$("#filebtn").css("color","#0daa62");
				
			});
		});
		
</script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/hanna.css);
/* font-family: 'Hanna', serif; */
	body {
		font-family: 'Hanna', serif;
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
		height: 20px;
		font-family: 'Hanna', serif;
		font-size: 15px;
	}
	#name_input {
		width: 150px;
		font-family: 'Hanna', serif;
		font-size: 16px;
		border: none;
		background-color: #f7f7f7;
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
		text-indent: 170px;
		font-size: 25px;
		font-weight: bold;
		color: #a7a7a7;
	}
	#btn_succ{
		text-indent: 230px;
		width: 200px;
		
	}
	#btn_freesuccess { 
		color: #555555;
		padding: 7px 14px;
		font-size: 16px;
		cursor:pointer;		
		background-color: #ededed;
		border-radius: 5px;
		border: 1px solid white;
		font-family: 'Hanna', serif;
	}
	#btn_freesuccess:hover {
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
		font-family: 'Hanna', serif;
	}
	
	input.upload_text {
		float:left;
		width:230px;
		height:20px;
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
		background: #f7f7f7;
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
			<form role="form" action="freeBoardInsertSave.dandy" method="post" enctype="multipart/form-data">
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
						<span>자유게시판 글쓰기</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 수정될 게시글 번호 -->			
				<tr>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>NO</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td>
						<input type="text" id="bno" name="bno"  class="form-control" value="${boardupdate.bno}" readonly="readonly">
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 수정될 게시글 제목 -->
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
						<input type="text" id="sub_input" name="title"  class="form-control1" value="${boardupdate.title}">
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 수정될 게시글 작성자 정보 -->
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
	<!-- 수정될 게시글 첨부파일 -->
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
	<!-- 수정될 게시글 내용 -->
				<tr>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td class="tx_cen">
						<span>내용</span>
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
					<td>
						<input type="text" id="con_input" name="content"  class="form-control1" value="${boardupdate.content}" >
					</td>
					<td class="empty">
						<span>&nbsp;</span>
					</td>
				</tr>
	<!-- 게시글 수정완료 버튼 -->
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
							<button id="btn_freesuccess">문의사항 작성완료</button>
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