package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//상품 목록
		String gCategory = request.getParameter("gCategory");
		if(gCategory == null ) gCategory ="top"; //맨처음 시작 시 카테고리를 top으로 기본으로 설정
		
		GoodsService service = new GoodsServiceImpl();
		List<GoodsDTO> list = service.goodsList(gCategory);
		
		//scope 지정
		request.setAttribute("goodsList", list);

		//요청 위임-포워드
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
