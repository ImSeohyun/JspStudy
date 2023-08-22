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
<h2>1. range 반복</h2>
<c:forEach begin="1" end="5">
hello<br>
</c:forEach>

<h2>1. range 반복2</h2>
<c:forEach var="x" begin="1" end="5">
${x }:hello<br>
</c:forEach>

<h2>1. range 반복3-step</h2>
<c:forEach var="x" begin="1" end="5" step="2">
${x }:hello<br>
</c:forEach>


<h2> 2. list 반복</h2>
<c:forEach var="dto" items="${list}" >
${dto.userid }&nbsp;${dto.passwd }<br> 
</c:forEach>
<h2> 2. list 반복2-idx</h2>
<c:forEach var="dto" items="${list}" varStatus="status">
${status.index}, ${status.count}, ${status.first},${status.last},
${dto.userid }<br> 
</c:forEach>

</body>
</html>