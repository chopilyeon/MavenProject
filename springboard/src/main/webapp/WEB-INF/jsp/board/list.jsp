<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	


<%-- 

	<c:forEach items="${boardlist}" var="board">
		${board.no} <br><a href="${pageContext.request.contextPath }/board/detail?boardNo=${ board.no }"> ${board.title}</a> <br> ${board.writer}
	</c:forEach> --%>


	<c:if test="${not empty loginVO }">
		${loginVO.name } 반가워요
	</c:if>
	<br>

	<c:forEach items="${boardlist}" var="board">
		${board.no} <br><a href="${pageContext.request.contextPath }/board/detail/${ board.no }"> ${board.title}</a> <br> ${board.writer}
	</c:forEach> 


<!--번호만 넘기는 방식을 어떨까?  -->
<!-- /board/detail/3 으로 만드는거임 -->

</body>
</html>