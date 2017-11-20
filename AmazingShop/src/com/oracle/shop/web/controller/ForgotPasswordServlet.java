package com.oracle.shop.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("aaa");
		String username=req.getParameter("usernames");
		String password=req.getParameter("passwords");
		String phone=req.getParameter("tels");
		if(null==username||null==password||null==phone||"".equals(phone)||"".equals(username)||"".equals(password)){
			req.setAttribute("name_err", "用户名密码或手机号不能为空");
//			System.out.println("bbb");
			forward(req, resp,"/ForgotPassword.jsp");
//			resp.sendRedirect(getServletContext().getContextPath()+"/regeister.jsp");
			return;
		}else{
			//根据手机号查看是否有此用户
			try {
				String name=ServiceImplFactory.getDao("username").findShopUserT(phone).getUserName();
				if(name.equals(username)){
//					System.out.println("ccc");
					ShopUser s=new ShopUser();
					s.setUserName(username);
					s.setUserPassword(password);
					ServiceImplFactory.getDao("userpass").uppass(s);
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}else{
//					System.out.println("eee");
					req.setAttribute("names_err", "用户名或手机号不正确，请确保是本人操作");
					req.getRequestDispatcher("/ForgotPassword.jsp").forward(req, resp);
				}
			} catch (Exception e) {
//				System.out.println("ddd");
				req.setAttribute("names_err", "用户名或手机号不正确，请确保是本人操作");
				req.getRequestDispatcher("/ForgotPassword.jsp").forward(req, resp);
			}
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	private void forward(HttpServletRequest req, HttpServletResponse resp,
			String url) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
