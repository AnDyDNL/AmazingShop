package com.oracle.shop.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

public class DingdanServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(null==session.getAttribute("name_suc")){
			response.sendRedirect("login.jsp");
		}else{
			String username=(String) session.getAttribute("name_suc");
			List orderlist = ServiceImplFactory.getDao("UserOrderlist").findOrderlist(1,username);
			request.setAttribute("orderlist",orderlist);
			//System.out.println(orderlist);
			request.getRequestDispatcher("dingdan.jsp").forward(request, response);
		}
		
	}

}
