<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap_contents1 {
		font-family: 'Noto Sans KR', sans-serif;
		width: 1200px;
		height: 1700px;
		border: 2px solid white;
		background-color: #f7f7f7;
		border-radius: 10px;
		margin: 100px 200px;
	}
	.loading_img {
	    width: 200px;
	    margin: 0 auto;
	    margin-top: 200px;
		
	}
	.loading_text {
	    font-size: 20px;
	    color: #9e9e9e;
	    margin-top: 10px;
	}


</style>


<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var title = $("#diy_title").val();
		var text = $("#diy_text").val();
		
		$.ajax({
			url : "diyComplete.dandy",
			type : "POST",
			data : "title=" + title + "&text=" + text,
			success : function(result) {
				$("#diyPage").html(result);
			},
			error : function() {
				alert("System Error!!!");
			}
	
		}); 
	});
	
</script>
</head>
<body>
	
	
	<div id="wrap_contents1">
		<div class="loading_img">
			<img src="image/diy/loading.gif">
			<div class="loading_text">로딩중 입니다 ......</div>
		</div>
		<input type="hidden" id="diy_title" name="diy_title" placeholder="제목을 입력해 주세요." value="${title}">
		<input type="hidden" id="diy_text" name="diy_text" placeholder="스크립트를 입력해 주세요." value="${text}"></input>
	</div>
	
</body>
</html>