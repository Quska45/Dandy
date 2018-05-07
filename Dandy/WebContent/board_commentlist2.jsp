<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 댓글 -->
				
					<tr>
					<c:if test="${re_count!='0'}">
						<td class="no">
							<span id="re">댓글&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span id="re_count" name="re_count">${re_count}</span>
							</span>
						</td>
						<td class="contents" id="recount">
							<span>&nbsp;</span>
						</td>
						<td class="name">
							<span>&nbsp;</span>
						</td>
						<td class="date">
							<span>&nbsp;</span>
						</td>
						<td class="view">
							<span>&nbsp;</span>
						</td>
					</c:if>
					<c:if test="${re_count=='0'}">
						<td colspan="5" id="noreply">
								<span>등록된 댓글이 없습니다. 댓글을 달아주세요.</span>
						</td>
					</c:if>
					</tr>
				<c:forEach items="${replyview}" var="replyview">
					<tr>
						<td colspan="5" bgcolor="#EEEEEE" height="1"></td>
					</tr>
					<tr>
						<td class="no">
							<span></span>
						</td>
						<td class="contents">
							<span>${replyview.content}</span>
						</td>
						<td class="name">
							<span>${replyview.writer}</span>
						</td>
						<td class="date">
							<span>${replyview.regdate}</span>
						</td>
						<c:if test="${sessionScope.loginUser.mid == replyview.writer}">
						<td class="view">
							<input type="button" value="삭제" id="remove_rebtn"  class="reply_del" name="input_rno" data_num="${replyview.rno}">
						</td>
						</c:if>
					</tr>
				</c:forEach>
				
</body>
</html>