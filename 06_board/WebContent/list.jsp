<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
  <script>
  
     $(document).ready(function(){
    	 
    	 // button 이벤트 추가
    	 $("button").on("click", function(){
    		  var num = $(this).attr("data-num");
    		  //alert("button" + num);
    		  location.href="delete?num="+num;
    	 });
    	 
     });
  
  </script>
</head>
<body>
<h2>게시판 목록보기</h2>

<c:set var="pageDTO" value="${pageDTO}" />
<c:set var="list" value="${pageDTO.list}" />

<table border="1">
   <!-- 검색 화면 -->
    <tr>
     <td colspan="6">
       <form action="list">
          <select name="searchName">
            <option value="title">제목</option>
            <option value="author">작성자</option>
          </select>
          <input type="text" name="searchValue">
          <input type="submit" value="검색">
       </form>
     </td>
    </tr>
   <!-- 검색 화면 -->
   <tr>
     <th>글번호</th>
     <th>제목</th>
     <th>작성자</th>
     <th>작성일</th>
     <th>조회수</th>
     <th>삭제</th>
   </tr>
<c:forEach var="dto" items="${list}" >
	<c:set var="num" value="${dto.num}" />
	<c:set var="title" value="${dto.title}" />
	<c:set var="author" value="${dto.author}" />
	<c:set var="writeday" value="${dto.writeday}" />
	<c:set var="readcnt" value="${dto.readcnt}" />
	<tr>
		    <td>${num}</td>
		    <td><a href="/retrieve?num=${num}">${title}</a></td>
		    <td>${author }</td>
		    <td>${writeday }</td>
		    <td>${readcnt}</td>   
		    <td><button data-num="${num}">삭제</button></td>   
	</tr>
</c:forEach>

<!-- page 번호 출력 -->

<c:set var="perPage" value="${pageDTO.perPage}" />
<c:set var="curPage" value="${pageDTO.curPage}" />
<c:set var="totalCount" value="${pageDTO.totalcount}" />

<c:set var="totalNum" value="${totalCount / perPage}" />
<c:if test="${totalCount%perPage !=0 }">
<c:set var="totalNum" value="${totalNum+1}" />
</c:if>
<c:set var="searchName" value="${pageDTO.searchName}" />
<c:set var="searchValue" value="${pageDTO.searchValue}" />


	<tr>
		<td colspan="6">
		<c:forEach var="x" begin="1" end="${totalNum}">
		<c:choose>
			<c:when test="${curPage == x}">
				${x}
			</c:when>
			<c:otherwise>
<a href="/list?curPage=${x}&searchName=${searchName}&searchValue=${searchValue}">${x}</a>			
			</c:otherwise>
		</c:choose>
		</c:forEach>

		</td>
	</tr>
<!-- page 번호 출력 -->

</table>
 <a href="writeui">글쓰기</a>



</body>
</html>


