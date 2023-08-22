package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청 URL: http://localhost:8090/01_servlet/login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) 
			throws ServletException, IOException {
	   
		System.out.println("LoginServlet.doGet");
		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr");
		
		System.out.println(userid+"\t"+ passwd +"\t"+ xxx);
		System.out.println("######################################");
		
		// Enumeration<String> getParameterNames() ==> tag의 name값 얻기
		Enumeration<String> enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = enu.nextElement(); // tag name 얻기
			String value = request.getParameter(name); // 사용자 입력값 얻기
			System.out.println(name+"\t"+ value );
		}
		System.out.println("######################################");
		
		//Map<String,String[]> getParameterMap()
		Map<String, String[]> map = request.getParameterMap();
		Set<String> keys = map.keySet();
		for (String key : keys) {
//			System.out.println(key);
			String [] values = map.get(key);
			System.out.println(key+"\t"+ Arrays.toString(values));
		}
		

	}
	protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) 
throws ServletException, IOException {

		System.out.println("LoginServlet.doPost");
		// POST 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr");
		
		System.out.println(userid+"\t"+ passwd +"\t"+ xxx);

}
}
