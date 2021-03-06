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
	#wrap_contents {
		font-family: 'Noto Sans KR', sans-serif;
		width: 1200px;
		border: 2px solid white;
		background-color: #f7f7f7;
		border-radius: 10px;
		margin: 100px 200px;
	}
 /*- modal창 내부 contents : 영화 포스터, 영화 제목, 해당 단어장의 단어 개수 */
 	#detail_modal_movie {
 		text-align: center;
 		width: 700px;
 		margin: 50px 246px;
 		border: 2px solid white;
 		padding: 3px;
 		border-radius: 10px;
 	}
 /*- 상세페이지 영화포스터 */
 	#detail_modal_poster {
 		margin-top: 50px;
 		margin-left: 80px;
 		width: 220px;
 		height: 300px;
 		/* border: 1px solid red; */
 		float: left;
 	}
 	#detail_modal_poster > img {
 		width: 220px;
 		height: 300px;
 		border-radius: 5px;
 	}
 /*- 상세페이지 정보 */
 	#detail_modal_info {
 		width: 360px;
 		height: 0;
 		/* border: 1px solid yellow; */
 		margin: 0 auto;
 		position: relative;
 	}
 /*- 상세페이지 영화제목 */
 	#detail_title {
 		width: 360px;
 		/* border: 1px solid green; */
 		height: 75px;
 		text-align: center;
 		line-height: 100px;
 	}
 	#detail_title > span {
 	 	font-family: 'Noto Sans KR', sans-serif;
 		font-size: 22px;
 		font-weight: bold;
 		
 	}
 /*- 상세페이지 해당영화 추출단어 수 */
	#detail_frequency {
		/* border: 1px solid red; */
		width: 360px;
		height: 80px;
	}
	.frequency {
		/* border: 1px solid gray;  */
		font-family: 'Noto Sans KR', sans-serif;
		width: 50px;
		height: 80px;
		text-align: center;
		font-size: 20px;
		float: left;
		padding: 0 4px;
		line-height: 80px;
	}
	#frequency_count {
		font-weight: bold;
		text-decoration: underline;
		color: #0daa62;
		font-size: 22px;
	}
 /** 단어장 table */
 	#word_table {
 		font-family: 'Noto Sans KR', sans-serif;
 		margin-top: 180px;
 		/* border: 1px solid red; */
 		width: 700px;
 	}
 	#word-table-top {
 		background-color: #0daa62;
 		border-radius: 5px;
 		color: white;
 		font-size: 16px;
 	}
	.table_no {
		width: 100px;
		height: 30px;
	}
	.table_word {
		width: 242px;
		height: 30px;
	}
	.table_mean {
		width: 242px;
		height: 30px;
	}
	.table_fre {
		width: 100px;
		height: 30px;
	}
	
	/* 단어 뜻  */
	.list_search {
		list-style: none;
	}
	.list_search li {
		padding-right: 15px;
		float: left;
	}
	.word-table-bottom tr {
		height: 50px;
	}
	
	
	/* 다운로드 버튼  */
	.diy_download {
		width: 100px;
		height: 30px;
		background: #0daa62;
		color: white;
		border: 1px solid #0daa62;
		border-radius: 5px;
		line-height: 30px;
		cursor: pointer;
	    display: inline-block;
    	margin-top: 23px;
	}
	
	
</style>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$('.word-table-bottom tr:odd').css("backgroundColor","#fff");         // odd 홀수
  		$('.word-table-bottom tr:even').css("backgroundColor","#f5f5fc");   // even 짝수
	});
	
		
	/* var checkUnload = true;
    $(window).on("beforeunload", function(){
        if(checkUnload) return "이 페이지를 벗어나면 작성된 내용은 저장되지 않습니다.";
    }); */


</script>

</head>
<body>
	<!-- Contents : 영화별 단어장 -->
		<div id="wrap_contents">
		
				<div id="detail_modal_movie">
				
					
					<div id="detail_modal_info">
						<div id="detail_title">
							<span>${title}</span>
						</div>
						<div id="detail_frequency">
							<div class="frequency">
								<span>단어:</span>
							</div>
							<div class="frequency" id="frequency_count">
								<span>${size}</span>
							</div>
							<div class="frequency">
								<span>개</span>
							</div>
							<a href="diyDownload.dandy?title=${title}">
								<div class="diy_download">다운로드</div>
							</a>
						</div>
						
					</div>
					<div id="word_table">
						<table id="word-table-top">
							<tbody>
								<tr>
									<td class="table_no"><span>No.</span></td>
									<td class="table_word"><span>단어</span></td>
									<td class="table_mean"><span>뜻</span></td>
									<td class="table_fre"><span>빈도</span></td>
								</tr>
							</tbody>
						</table>
						<table class="word-table-bottom">
							<tbody>
								<c:forEach items="${list}" var="list">
									<tr>
										<td class="table_no"><span>${list.wno}</span></td>
										<td class="table_word"><span>${list.word}</span></td>
										<td class="table_mean"><span>${list.meaning}</span></td>
										<td class="table_fre"><span>${list.freq}</span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
	</div>
</body>
</html>












