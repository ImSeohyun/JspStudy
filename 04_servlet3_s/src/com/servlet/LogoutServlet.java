package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//세션얻기
		HttpSession session = request.getSession();
		
		//세션에 로그인 정보 저장
		String id = (String) session.getAttribute("user");
		
		if(id!=null) {
			//로그인 한 경우로서 응답처리
			session.invalidate();
			//로그아웃 이후의 화면 선택
			response.sendRedirect("loginForm.jsp");
		}else {
			//id값 null
			response.sendRedirect("loginForm.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
