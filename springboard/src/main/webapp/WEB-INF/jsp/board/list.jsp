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

<header>
	<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
</header>


	


<%-- 

	<c:forEach items="${boardlist}" var="board">
		${board.no} <br><a href="${pageContext.request.contextPath }/board/detail?boardNo=${ board.no }"> ${board.title}</a> <br> ${board.writer}
	</c:forEach> --%>

	<c:forEach items="${boardlist}" var="board">
		<br>	게시글 번호: ${board.no} <br><a href="${pageContext.request.contextPath }/board/detail/${ board.no }"> ${board.title}</a> <br> ${board.writer} <br>댓글 수:${board.replyCnt} <br>
	</c:forEach> 


<!--번호만 넘기는 방식을 어떨까?  -->
<!-- /board/detail/3 으로 만드는거임 -->

</body>
</html>