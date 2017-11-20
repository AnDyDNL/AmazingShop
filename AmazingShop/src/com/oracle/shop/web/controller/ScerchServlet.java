package com.oracle.shop.web.controller;

import java.io 

.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;
@WebServlet("/ScerchServlet")
public class ScerchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name=req.getParameter("text1s").trim();
		if("".equals(name)||null==name){
			//为空把错误信息返回Homepage页面
			req.setAttribute("type_err", "输入内容为空");
			resp.sendRedirect("/AmazingShop/servlet/Homepage");
		}else{
//			name=new String(name.getBytes("iso-8859-1"),"utf-8");
//			System.out.println(name.toString());
			try {
				//创建goods type对象看是否有此商品
				GoodsType g=ServiceImplFactory.getDao("goodstype").findname(name);
				//获取typeid
				int tyid=g.getTypeId();
				//传入详情servlet
				req.getRequestDispatcher("/servlet/DetailServlet?id="+tyid+"&rownum=1").forward(req, resp);
			} catch (Exception e) {
				try {
					List<Goods> go=ServiceImplFactory.getDao("fgoods").findgoods(name);
					req.getRequestDispatcher("/servlet/DetailServlet?Goodsid="+name+"&rownum=1").forward(req, resp);
				} catch (Exception e2) {
					req.setAttribute("type_err", "没有此商品");
					resp.sendRedirect("/AmazingShop/servlet/Homepage");
				}
			}	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@SuppressWarnings("unused")
	private void forward(HttpServletRequest req, HttpServletResponse resp,
			String url) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}

}