<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>내장객체(내장변수)</h2>
<%
	//scriptlet tag 에서는
	System.out.println("HttpServletRequest request 내장객체 "+request );
	System.out.println("HttpServletResponse request 내장객체 "+response );
	System.out.println("HttpSession session 내장객체 "+ session);
	System.out.println("ServletContext applicatoin 내장객체 "+ application);
	System.out.println("ServletConfig config 내장객체 "+ config);
	System.out.println("PrintWriter out 내장객체 "+ out);
%>
</body>
</html>