package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//쿠키얻기,최대300개
		Cookie[] cookies = request.getCookies();
		
		String id = null;
		for(Cookie c : cookies) {
			if("user".equals(c.getName())) {
				id = c.getValue();
			}
		}

		//로그인 유무 확인
		if(id != null) {
			//응답처리
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			 out.print("<html><head>");
			 out.print("<meta charset=\"UTF-8\">");
			 out.print("<title>Insert title here</title>");
			 out.print("</head>");
			 out.print("<body>");
			 
			 out.print("<h1>mypage</h1>");
			 out.print("안녕하세요. "+id+"님");
			 out.print("<a href='logout'>로그아웃</>");
			 
			 out.print("</body></html>");
		}else {
			response.sendRedirect("loginForm.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
