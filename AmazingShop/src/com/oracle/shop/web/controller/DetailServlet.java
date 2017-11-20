package com.oracle.shop.web.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.oracle.shop.model.daoImpl.entity.GoodsImpl;
import com.oracle.shop.model.daoImpl.entity.TypeImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;
import com.oracleoaec.exception.DataAccessException;
public class DetailServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public DetailServlet() {
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
			//获取商品总数的实例（分出页数）
			TypeImpl goodsTotal=new TypeImpl();
			//根据页数查找商品的实例
			GoodsImpl findGoods=new GoodsImpl();
			//存储商品的集合
			ArrayList<Goods> goods=null;
			int totalGoods=0;//定义查找到的商品总数
			int page=0;//页数初始值
			//查找指定页的商品
			int rownum= Integer.parseInt(request.getParameter("rownum"));
			String brandId = request.getParameter("brandId");
			String goodsid=request.getParameter("Goodsid");
			//先判断是否根据品牌划分
			if(brandId!=null&&!(brandId.equals("0"))&&brandId!=""){
				//System.out.println(brandId);
			//切割出brandId
				String brandId2=brandId.replaceAll("'", " ").trim();
				//获取传过来的品牌（小类）id
				int newBrandId=Integer.parseInt(brandId2);
				//从数据库查找到对应的商品
				try {
					goods = goodsTotal.getGoodsByBrand(newBrandId,rownum);
					totalGoods=goodsTotal.getTotalGoods(newBrandId,2);
					//算出页数
					page = (int)Math.ceil(totalGoods/11.0);
					//判断页数是否小于o或者大于总页数
					if(rownum<=0){
						rownum=1;
					}
					else if(rownum>=page){
						rownum=page;
					}
					request.setAttribute("brandId",brandId);
					goods = (ArrayList<Goods>)findGoods.getGoodsByBrandRang(newBrandId,rownum);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(goodsid!=null&&!(goodsid.equals("0"))){
				request.setAttribute("ss", "1123");
//				System.out.println(brandId);
			//切割出brandId
				List<Goods> go=ServiceImplFactory.getDao("fgoods").findgoods(goodsid);
				int ar=0;
				for (Goods good : go) {
					ar++;
				}
				goods =(ArrayList<Goods>) go;
				//算出页数
				page = (int)Math.ceil(ar/11.0);
				//判断页数是否小于o或者大于总页数
				if(rownum<=0){
					rownum=1;
				}
				else if(rownum>=page){
					rownum=page;
				}
			}
			//否则根据类别划分
			else{
				//获取类型id
				int	typeId= Integer.parseInt(request.getParameter("id"));
				try {
					//获取商品总数
					totalGoods=goodsTotal.getTotalGoods(typeId,1);
					//算出页数
					page = (int)Math.ceil(totalGoods/11.0);
					//判断页数是否小于o或者大于总页数
					if(rownum<=0){
						rownum=1;
					}
					else if(rownum>=page){
						rownum=page;
					}
					goods = (ArrayList<Goods>)findGoods.findByTypeRange(typeId,rownum);
					request.setAttribute("brandId",0);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}
	
			//发送选择的商品页，总页数，商品集合
			
			request.setAttribute("rownum", rownum);
			request.setAttribute("page", page);
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("/Details.jsp").forward(request, response);										 
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