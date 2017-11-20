package com.oracle.shop.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

public class XiangQingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String cont=request.getParameter("conts");
		String name=(String) request.getSession().getAttribute("name_suc");
		int img_id=Integer.parseInt(request.getParameter("id"));
		UserOrderlist ol=null;
		if("".equals(name)||name==null){
			request.setAttribute("comm_err", "评论区(暂未登录不能评论)");	
		}else{
		try {
			//查看ordertype看是否购买
			ol=ServiceImplFactory.getDao("userordertype").findordertype(img_id);
			if(ol.getOrderType()<1||!ol.getUserName().equals(name)){
				request.setAttribute("comm_err", "评论区(您未曾购买不能评论)");
			}else{
				Date d=new Date();
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Comments comments=new Comments();
				comments.setCommentsUser(name);
				comments.setCommentsTime(f.format(d));
				comments.setCommentsContent(cont);
				comments.setGoodsid(img_id);
//				System.out.println(comments);
				ServiceImplFactory.getDao("Comments").save(comments);
			}
		} catch (Exception e) {
			request.setAttribute("comm_err", "评论区(您未购买不能评论)");
		}
		}
//		System.out.println(img_id);
//		System.out.println(cont);
//		System.out.println(name);
		Goods good = ServiceImplFactory.getDao("Goods").findGoods(img_id);
		List<Comments> comm=ServiceImplFactory.getDao("Comments").findcomm(img_id);
//		System.out.println(comm.get(img_id).getGoodsid());
		request.setAttribute("Comments", comm);		
//		System.out.println(good.getBrandName());
		request.setAttribute("Goods", good);
		request.setAttribute("img_id", img_id);
		request.getRequestDispatcher("shoppingExample.jsp").forward(request, response);
	}
}
