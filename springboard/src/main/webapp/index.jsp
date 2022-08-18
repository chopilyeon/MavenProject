<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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






<a href="${pageContext.request.contextPath}/board">게시판</a>
<a href="${pageContext.request.contextPath}/board/write">새글 쓰기</a>

<a href="${pageContext.request.contextPath}/login">로그인1</a>
<a href="${pageContext.request.contextPath}/logout">로그아웃</a>

<a href="http://localhost:3000/">리액트</a>


</body>
</html>