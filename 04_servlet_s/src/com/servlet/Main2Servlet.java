package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//요청 서블릿
@WebServlet("/main2")
public class Main2Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Main2Servlet");
		// 요청위임 2 - redirect

		// scope에 저장
		request.setAttribute("request", "request");

		HttpSession session = request.getSession();
		session.setAttribute("session", "session");

		ServletContext applicaton = getServletContext();
		applicaton.setAttribute("applicaton", "applicaton");

		// url 변경됨
		response.sendRedirect("response");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
