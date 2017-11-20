package com.oracle.shop.model.daoImpl.entity;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.exception.DataAccessException;
import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.Seqence;
import com.oracle.shop.model.entity.UserOrder;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.model.serviceImpl.entity.GoodsServiceImpl;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;


public class Text1 {

	public static void main(String[] args) throws DataAccessException {
		FdGoodsImpl d=new FdGoodsImpl();
		List<Goods> a=ServiceImplFactory.getDao("fgoods").findgoods("夏");
		for (Goods object : a) {
			System.out.println(object);
		}
		
//		good.add((Goods) d.findgoods("o"));
//		for (Goods goods : good) {
//			System.out.println(goods);
//		}
		
//		FOrderTypeImpl i=new FOrderTypeImpl();
//		UserOrderlist ol=ServiceImplFactory.getDao("userordertype").findordertype(34);
//		System.out.println(ol.getOrderType()+"**"+ol.getUserName());
//		Goods g = (Goods) DaoImplFactory.getDao("Goods").findByID(93);
//		System.out.println(g+"111");
//		
//		GoodsServiceImpl s=new GoodsServiceImpl();
//		Goods d = s.findGoods(93);
//		System.out.println(d+"222");
//		
//		Goods o = ServiceImplFactory.getDao("Goods").findGoods(93);
//		System.out.println(o+"333");
		
		/*Goods good = ServiceImplFactory.getDao("Goods").findGoods(10);
		System.out.println(good);
		UserOrderlist orderlist=new UserOrderlist();
		orderlist.setPrice(good.getPrice()*5);
		orderlist.setBrandName(good.getBrandName());
		orderlist.setAmount(5);
		orderlist.setOrderTime(new Date(System.currentTimeMillis()));
		orderlist.setTypeId(good.getTypeId());
		orderlist.setOrderType(0);
		ServiceImplFactory.getDao("UserOrderlist").save(orderlist);*/
//		OrderListImpl od=new OrderListImpl();
//		od.save(orderlist);
//		DaoImplFactory.getDao("UserOrderlist").save(orderlist);
		
		
		/*List orderlist = ServiceImplFactory.getDao("UserOrderlist").findOrderlist(0);
		System.out.println(orderlist);*/
		
		/*OrderListImpl o=new OrderListImpl();
		List<UserOrderlist> list = o.findOrderlist(0);
		for(UserOrderlist u:list){
			System.out.println(u);
		}*/
		
		/*OrderListImpl o=new OrderListImpl();
		o.save(t);*/
		
		/*List l = ServiceImplFactory.getDao("UserOrderlist").findOrderlist(0);
		System.out.println(l.toString()+"111");*/
		
		/*OrderListImpl o=new OrderListImpl();
		List<UserOrderlist> list = o.findOrderlist(0);
		System.out.println(list.toString());*/

		/*
		OrderListImpl o =new OrderListImpl();
		o.delete(67);*/
		
		/*UserOrderlistImpl u=new UserOrderlistImpl();
		u.delete(70);*/
		
		//ServiceImplFactory.getDao("UserOrderlist").delete(84);
		
		/*UserOrder uorder=new UserOrder();
		uorder.setTotal(100);
		uorder.setOrderUser("zhangsan");
		uorder.setOrderTiem(new Date(System.currentTimeMillis()));
		uorder.setOrderType(1);
		ServiceImplFactory.getDao("UserOrder").save(uorder);*/
		/*UserOrderImpl u=new UserOrderImpl();
		u.save(uorder);*/
	}

}
