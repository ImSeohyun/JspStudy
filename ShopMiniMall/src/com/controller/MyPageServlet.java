package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		
		if (dto != null) {
			//로그인 한 경우
			nextPage = "mypage.jsp";
			String userid = dto.getUserid(); //현재  dto에 userid가 있어서 여기서 가져오지만 dto에 없다면 db에서 땡겨와야 한다
			//usderid를 서비스 거쳐서 dao 전달하고 반환
			MemberService service = new MemberServiceImpl();
			MemberDTO mypage = service.mypage(userid);
			session.setAttribute("login", mypage);
			
			
		} else {
			//로그인 안했거나 했는데 time-out된 경우
			nextPage = "member/checkLogin.jsp";
		}
		//요청위임
		response.sendRedirect(nextPage);
	}

}
