package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;
import com.service.OrderService;
import com.service.OrderServiceImpl;

@WebServlet("/OrderConfirmServlet")
public class OrderConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if (dto != null) {
			String num = request.getParameter("num");
			OrderService service = new OrderServiceImpl();
			
			//num값에 해당되는 CartDTO 얻기
			CartDTO cDTO = service.cartByNum(Integer.parseInt(num));
			
			String userid = dto.getUserid();
			//userid 값에 해당하는 MemberDTO 얻기
			MemberDTO mDTO = service.memberByUserid(userid);
			
			//scope에 저장
			request.setAttribute("cDTO", cDTO);
			request.setAttribute("mDTO", mDTO);
			
			//요청 위임
			nextPage="orderConfirm.jsp";
		} else {
			nextPage = "member/checkLogin.jsp";
		}
		
		//요청위임
		request.getRequestDispatcher("orderConfirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
