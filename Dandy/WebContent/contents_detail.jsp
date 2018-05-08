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
		height: 1700px;
		border: 2px solid white;
		background-color: #f7f7f7;
		border-radius: 10px;
		margin: 100px 200px;
	}
 /*- modal창 내부 contents : 영화 포스터, 영화 제목, 해당 단어장의 단어 개수 */
 	#detail_modal_movie {
 		text-align: center;
 		width: 700px;
 		height: 400px;
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
 		height: 400px;
 		/* border: 1px solid yellow; */
 		float: right;
 		margin-right: 10px;
 	}
 /*- 상세페이지 영화제목 */
 	#detail_title {
 		margin-top: 120px;
 		width: 360px;
 		/* border: 1px solid green; */
 		height: 100px;
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
		margin: 0 80px;
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
		color: #00AE93;
		font-size: 22px;
	}
 /** 단어장 table */
 	#word_table {
 		font-family: 'Noto Sans KR', sans-serif;
 		margin-top: 420px;
 		/* border: 1px solid red; */
 		width: 700px;
 		height: 300px;
 	
 	}
 	#word-table-top {
 		background-color: #00AE93;
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
	.list_search {
		list-style: none;
	}
	.list_search li {
		float: left;
	}
	
	
	
	
</style>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

</script>

</head>
<body>
	<!-- Contents : 영화별 단어장 -->
		<div id="wrap_contents">
		
				<div id="detail_modal_movie">
				
					<div id="detail_modal_poster">
						<img src="${img}">
					</div>
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
						</div>
					</div>
					<div id="word_table">
						<table id="word-table-top">
							<tbody>
								<tr>
									<td class="table_no"><span>No.</span></td>
									<td class="table_word"><span>abc</span></td>
									<td class="table_mean"><span>가나다</span></td>
									<td class="table_fre"><span>10</span></td>
								</tr>
							</tbody>
						</table>
						<table>
							<tbody>
								<c:forEach items="${movieEach}" var="each">
									<tr>
										<td class="table_no"><span>No.</span></td>
										<td class="table_word"><span>${each.word}</span></td>
										<td class="table_mean"><span>${each.meaning}</span></td>
										<td class="table_fre"><span>${each.freq}</span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
	</div>
</body>
</html>












