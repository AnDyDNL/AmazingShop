package com.oracle.shop.web.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebService;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

@WebServlet("/LoginSerlet")
public class LoginSerlet extends HttpServlet {
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username=req.getParameter("username").trim();
		String password=req.getParameter("password").trim();
//		System.out.println(username);
		if(null==username||null==password||"".equals(username)||"".equals(password)){
			req.setAttribute("name_err", "用户名或密码不能为空");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}else{	
//			username=new String(username.getBytes("iso-8859-1"),"utf-8");
//			password=new String(password.getBytes("iso-8859-1"),"utf-8");
//			System.out.println(username);
			String ss="^[1][3,4,5,7,8][0-9]{9}$";
			Pattern pa=Pattern.compile(ss);
			Matcher mm=pa.matcher(username);
			if(!mm.matches()){
				try {
				String name = ServiceImplFactory.getDao("username").findShopUser(username).getUserName();
				String userpass = ServiceImplFactory.getDao("username").findShopUser(username).getUserPassword();
				if(name==""||!name.toString().equals(username)||!userpass.equals(password)){
					req.setAttribute("name_err", "密码错误");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
//						resp.sendRedirect(getServletContext().getContextPath()+"/login.jsp");
						return;
					}else{
						req.getSession().setAttribute("name_suc", name);
						resp.sendRedirect("/AmazingShop/servlet/Homepage");
					}
				} catch (Exception e) {
					req.setAttribute("name_err", "用户名错误");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
				
			} else{
				try {
					String name1 = ServiceImplFactory.getDao("username").findShopUserT(username).getUserName();
					String userpass1 = ServiceImplFactory.getDao("username").findShopUserT(username).getUserPassword();
					if(name1==""||!userpass1.equals(password)){
						req.setAttribute("name_err", "密码错误");
						req.getRequestDispatcher("/login.jsp").forward(req, resp);
						return;
					}else{
						req.getSession().setAttribute("name_suc", name1);
						resp.sendRedirect("/AmazingShop/servlet/Homepage");
					}
					
				}catch (Exception e) {
					req.setAttribute("name_err", "用户名错误");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}	
			}
			}
  }
	@SuppressWarnings("unused")
	private void forward(HttpServletRequest req, HttpServletResponse resp,
			String url) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doGet(req, resp);
		}
	}