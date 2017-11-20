package com.oracle.shop.model.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oracle.shop.model.daoImpl.entity.CommentsImpl;
import com.oracle.shop.model.daoImpl.entity.GoodsImpl;
import com.oracle.shop.model.daoImpl.entity.PassUpIml;
import com.oracle.shop.model.daoImpl.entity.ShopUserImpl;
import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.serviceImpl.entity.CommentsServicelImpl;
import com.oracle.shop.model.serviceImpl.entity.GoodsServiceImpl;
import com.oracle.shop.model.serviceImpl.entity.ShopUserServiceImpl;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		ShopUser s=new ShopUser();
//		s.setUserName("zhu");
//		s.setUserPassword("123");
//		ServiceImplFactory.getDao("userpass").uppass(s);
		
//		String s=ServiceImplFactory.getDao("username").findShopUserT("15700786748").getUserName();
//		System.out.println(s);
//		List<Comments> comm=ServiceImplFactory.getDao("Comments").findcomm(93);
//		System.out.println(comm.toString());
//		Goods good = ServiceImplFactory.getDao("Goods").findGoods(87);
//		System.out.println(good.toString());
//		try {
//		String name = ServiceImplFactory.getDao("username").findShopUser("zhu").getUserPassword();
		//String name=DaoImplFactory.getDao("username").findShopUser("zhu").getUserPassword();
//		System.out.println(name);
		/*ShopUser f = DaoImplFactory.getDao("shopuser").findShopUser("zhu");
		System.out.println(f+"222");*/
		
//		CommentsImpl cm=new CommentsImpl();
//		CommentsServicelImpl cm=new CommentsServicelImpl();
//		List<Comments> f=cm.findcomm(87);
//		List<Comments> f =ServiceImplFactory.getDao("Comments").findcomm(87);
//		List<Comments> f=DaoImplFactory.getDao("Comments").findcomm(87);
//		ShopUser f1 = s.findShopUserT("15700786748");
//		for (Comments comments : f) {
//			System.out.println(comments.getCommentsContent()+"333");
//		}
		
//		} catch (Exception e) {
//			System.out.println("");
//		}
		
		
//		ShopUser user=new ShopUser();
//		user.setUserName("12");
//		user.setUserTel("15700786746");
//		user.setUserPassword("12");
//		ServiceImplFactory.getDao("username").save(user);
//		System.out.println(row);
		//ShopUserImpl s=new ShopUserImpl();
		//s.save(user);
		//DaoImplFactory.getDao("username").save(user);
//		int save = ServiceImplFactory.getDao("shopuser").save(user);
//		System.out.println(save);
//		Goods good = (Goods) DaoImplFactory.getDao("Goods").findByID(87);
//		int j=0;
//		for (int i = 0; i < 10; i++) {
//			j=(int)(1+Math.random()*95);
//			GoodsImpl g=new GoodsImpl();
//			Goods good=g.findByID(j);
//			System.out.println(good.getGoodsName());
//			System.out.println(j);
//		}
		/*int newsj=0;
		List<Goods> goods=new ArrayList<>();
		for (int newi = 0; newi < 20; newi++) {
			newsj=(int)(1+Math.random()*95);
			Goods good = ServiceImplFactory.getDao("Goods").findGoods(newsj);
			goods.add(good);
		}	*/	
		
//		
//		Date d=new Date();
//		SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
////		System.out.println(f.format(d));
//		Comments t=new Comments();
//		t.setCommentsContent("还可以1");
//		t.setCommentsTime(f.format(d).toString());
//		t.setCommentsUser("zhu");
//		t.setGoodsid(30);
//		ServiceImplFactory.getDao("Comments").save(t);
//		System.out.println(f.format(d).toString());
//		System.out.println(t);
	}
}
