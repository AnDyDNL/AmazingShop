package com.oracle.shop.web.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.daoImpl.entity.TypeImpl;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;
import com.oracleoaec.exception.DataAccessException;

public class Homepage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Homepage() {
		super();
	}

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
		TypeImpl findGoods=new TypeImpl();
		ArrayList<GoodsType> type=null;
		List<Goods> list1=new ArrayList<>();
		List<Goods> list2=new ArrayList<>();
//		System.out.println("nnh");

		try {
			//拿到商品类别
			 type = findGoods.getType();
//		System.out.println("nnh");
		//获取前20条信息
		int j=0;
		for (int i = 1; i <= 20; i++) {
			j=(int)(1+Math.random()*97);
			Goods good=ServiceImplFactory.getDao("Goods").findGoods(j);
			if(i<=10){
				list1.add(good);
			}else{
				list2.add(good);
			}
		}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		request.setAttribute("goodsty1",list1);
		request.setAttribute("goodsty2",list2);
		request.setAttribute("goodsTypes", type);
		request.getRequestDispatcher("/homepage.jsp").forward(request, response);
	
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
