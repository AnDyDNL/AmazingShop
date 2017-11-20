package com.oracle.shop.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

public class AddShopCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		if(null==session.getAttribute("name_suc")){
			out.println("<span>请登录</span>");
		}
		else{
			int img_id=Integer.parseInt(request.getParameter("id"));
			int count=Integer.parseInt(request.getParameter("count"));
			String username=(String) session.getAttribute("name_suc");
			//System.out.println(img_id+"111"+count);
			Goods good = ServiceImplFactory.getDao("Goods").findGoods(img_id);
			//System.out.println(good);
			UserOrderlist orderlist=new UserOrderlist();
			orderlist.setPrice(good.getPrice());
			orderlist.setBrandName(good.getBrandName());
			orderlist.setAmount(count);
			orderlist.setOrderTime(new Date(System.currentTimeMillis()));
			orderlist.setTypeId(good.getTypeId());
			orderlist.setOrderType(0);
			
			orderlist.setDiscribe(good.getGoodsDiscribe());
			orderlist.setImgpath(good.getImgpath());
			orderlist.setTotalprice(good.getPrice()*count);
			orderlist.setGoods_id(good.getId());
			orderlist.setUserName(username);
			//System.out.println(orderlist);
			ServiceImplFactory.getDao("UserOrderlist").save(orderlist);
			out.println("<span>已加入购物车</span>");
		}
		out.close();
	}

}
