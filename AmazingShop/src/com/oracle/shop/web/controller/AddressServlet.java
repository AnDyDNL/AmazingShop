package com.oracle.shop.web.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.shop.model.daoImpl.entity.AddressImpl;
import com.oracle.shop.model.entity.Address;
import com.oracleoaec.exception.DataAccessException;

public class AddressServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
			HttpSession session = request.getSession(false);//获取session判断是否登录
			//设置初始值为空
			String user_Name=(String) request.getSession().getAttribute("name_suc");
			ArrayList<Address> listAddress=null;//接收查找到的地址对象集合
			if(session!=null&&user_Name!=null){
				AddressImpl add=new AddressImpl();
				try {
					listAddress =add.query_Address(user_Name);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//集合为空
				if(listAddress.size()!=0){
						request.setAttribute("address", listAddress);
						request.getRequestDispatcher("/myAddress.jsp").forward(request, response);
						return;
				}
				//地址为空
				else{
					request.getRequestDispatcher("/dizi.jsp").forward(request, response);
					return;
				}
			}
			//没有登录请跳转到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
