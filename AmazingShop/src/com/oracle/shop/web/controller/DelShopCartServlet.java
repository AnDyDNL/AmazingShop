package com.oracle.shop.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

public class DelShopCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		//System.out.println(id+"123");
		int a=ServiceImplFactory.getDao("UserOrderlist").delete(Integer.parseInt(id));
		
		//System.out.println(a);
	}

}
