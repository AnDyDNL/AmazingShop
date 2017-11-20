package com.oracle.shop.web.controller;
import java.io.IOException;
import java.sql.Savepoint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.shop.model.daoImpl.entity.ShopUserImpl;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;
@WebServlet("/RegeisterServlet")
public class RegeisterServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username=req.getParameter("username").trim();
		String password=req.getParameter("password").trim();
		String phone=req.getParameter("phone").trim();
			ShopUser user=new ShopUser();
			user.setUserName(username);
			user.setUserTel(phone);
			user.setUserPassword(password);
//			if(null==username||null==password||null==phone||"".equals(phone)||"".equals(username)||"".equals(password)){
//				req.setAttribute("name_err", "用户名密码不能为空");
//				req.getRequestDispatcher("/regeister.jsp").forward(req, resp);
////				resp.sendRedirect(getServletContext().getContextPath()+"/regeister.jsp");
//				return;
//			}
			try {
				//查看用户是否存在
				String name = ServiceImplFactory.getDao("username").findShopUser(username).getUserName();
//				if(name!=""){
				    req.setAttribute("name_err", "该用户名已注册");
					forward(req, resp, "/regeister.jsp");
					return;
//				}else{
//					int row=ServiceImplFactory.getDao("username").save(user);
//					req.getSession().setAttribute("username", user);
//					resp.sendRedirect(getServletContext().getContextPath()+"/login.jsp");
//				}
			} catch (Exception e) {
				try {
					String name = ServiceImplFactory.getDao("username").findShopUserT(phone).getUserName();
//					if(name!=""){
						req.setAttribute("name_err", "该手机号已注册");
						forward(req, resp, "/regeister.jsp");
						return;
//					}else{
//						System.out.println(username+"c");
//						int row=ServiceImplFactory.getDao("username").save(user);
//						req.getSession().setAttribute("username", user);
//						resp.sendRedirect(getServletContext().getContextPath()+"/login.jsp");
//					}
				} catch (Exception e2) {
					int save = ServiceImplFactory.getDao("username").save(user);
//					System.out.println(save);
					req.getSession().setAttribute("username", user);
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
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
