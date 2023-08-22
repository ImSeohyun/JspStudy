<%@page import="java.util.List"%>
<%@page import="com.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scope에 저장된 값 출력</h1>
<h2>1. 이전방식</h2>
<%
	String userid = (String)request.getAttribute("userid");
	String xxx = (String)request.getAttribute("xxx");
	
	String userid2 = (String)session.getAttribute("userid");
	String userid3 = (String)application.getAttribute("userid");
	
	//dto 얻기
	LoginDTO dto = (LoginDTO)request.getAttribute("login");
	
	//list 얻기
	List<LoginDTO> list = (List<LoginDTO>)request.getAttribute("list");
	
%>
이름: <%= userid %><br>
null값: <%= xxx %><br>
null 여부: <%= xxx==null %><br>
request: <%= userid %><br>
session: <%= userid2 %><br>
application: <%= userid3 %><br>
아이디: <%= dto.getUserid() %><br>
비번: <%= dto.getPasswd() %><br>
list: <%= list.get(0).getUserid() %><%= list.get(0).getPasswd() %><br>
list: <%= list.get(1).getUserid() %><%= list.get(1).getPasswd() %><br>

<h2>EL 방식</h2>
<% 
String kkk="이순신";//el로 출력 불가. 반드시 scope에 저장된 값만 출력 가능 
%> 
이름: ${userid}<br>
이름: ${kkk}<br>
null값: ${xxx}<br>
null여부: ${empty xxx }<br>
request: ${userid }<br>
session: ${sessionScope.userid }<br>
application: ${applicationScope.userid}<br>
아이디: ${login.userid }<br>
비번: ${login.passwd }
list1:${list[0].userid}${list[0].passwd}<br>
list2:${list[1].userid}${list[1].passwd}<br>
</body>
</html>