<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="image/cupfavi.png">
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
/* font-family: 'Noto Sans KR', sans-serif; */
	
 /** contents page body */
	#wrap_contents_diy {
		font-family: 'Noto Sans KR', sans-serif;
		width: 1200px;
		height: 1100px;
		border: 2px solid white;
		background-color: #f7f7f7;
		border-radius: 10px;
		margin: 250px 200px;
	}
	#diy_title {
		width: 100%;
		border: none;
		height: 50px;
	}
	#diy_text {
		width: 100%;
		border: none;
	}
	#diy_btn {
		border: 1px solid #0daa62;
		margin: 20px auto;
		padding: 10px;
		width: 300px;
		height: 50px;
		color: #0daa62;
		text-align: center;
		line-height: 50px;
		font-size: 20px;
		cursor: pointer;
	}
	.diy_title_wrap {
		width: 900px;
		padding: 20px;
		margin: 20px auto;
	}
	.diy_text_wrap {
		width: 900px;
		padding: 20px;
		margin: 20px auto;
	}
 
</style>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	//단어장 만들기 버튼 클릭했을때 단어장 띄워주는 페이지
	

</script>

</head>
<body>
	<input type="hidden" id="diy_session" name="diy_session" value="${sessionScope.loginUser.mid}">
	<!-- Contents : 영화별 단어장 -->
	<div id="wrap_contents_diy">
			<div class="diy_title_wrap">
				<input type="text" id="diy_title" name="diy_title" placeholder="제목을 입력해 주세요.">
			</div>
			<div class="diy_text_wrap">
				<textarea rows="50" cols="100" id="diy_text" name="diy_text" placeholder="스크립트를 입력해 주세요." style="resize: none;"></textarea>
			</div>
			<a href="#"><div id="diy_btn">단어장 만들기</div></a>
	</div>
</body>
</html>












