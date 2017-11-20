package com.oracle.shop.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.shop.model.daoImpl.entity.AddressImpl;
import com.oracle.shop.model.entity.Address;
import com.oracleoaec.exception.DataAccessException;

public class Add_AddressServlet extends HttpServlet {

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
		HttpSession session = request.getSession(false);
		//接收地址信息
		System.out.println(session.getAttribute("name_suc"));
		String user_name = (String) session.getAttribute("name_suc");
		String consignee_Name = request.getParameter("consignee_Name");
		String  consignee_Tel = request.getParameter("consignee_Tel");
		String consignee_Address = request.getParameter("detail_Address");
		String location = request.getParameter("location");
		//将地址信息存放到实体类
		Address address=new Address(user_name,consignee_Name,consignee_Tel,consignee_Address,location);
		AddressImpl addressImpl=new AddressImpl();
		String flag=null;//插入失败
		try {
			//添加收货地址
			addressImpl.add_Address(address);
			flag="suc";//插入成功
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		request.setAttribute("succsess",flag);
		request.getRequestDispatcher("/dizi.jsp").forward(request, response);
		}
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
