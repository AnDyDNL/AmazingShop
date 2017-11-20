package com.oracle.shop.model.serviceImpl.factory;

import java.util.WeakHashMap;

import com.oracle.shop.model.dao.ICommonDao;
import com.oracle.shop.model.daoImpl.entity.CommentsImpl;
import com.oracle.shop.model.daoImpl.entity.OrderListImpl;
import com.oracle.shop.model.daoImpl.entity.PassUpIml;
import com.oracle.shop.model.daoImpl.entity.ShopUserImpl;
import com.oracle.shop.model.service.ICommonService;
import com.oracle.shop.model.serviceImpl.entity.CommentsServicelImpl;
import com.oracle.shop.model.serviceImpl.entity.FGoodsServicelImpl;
import com.oracle.shop.model.serviceImpl.entity.FOrdertypeServicelImpl;
import com.oracle.shop.model.serviceImpl.entity.GoodsServiceImpl;
import com.oracle.shop.model.serviceImpl.entity.GoodsTypeServicelImpl;
import com.oracle.shop.model.serviceImpl.entity.PassUpServcelImpl;
import com.oracle.shop.model.serviceImpl.entity.SeqenceServiceImpl;
import com.oracle.shop.model.serviceImpl.entity.ShopUserServiceImpl;
import com.oracle.shop.model.serviceImpl.entity.UserOrderServiceImpl;
import com.oracle.shop.model.serviceImpl.entity.UserOrderlistImpl;

public final class ServiceImplFactory {
	private final static WeakHashMap<String, ICommonService> map=new WeakHashMap<String, ICommonService>();
	public static ICommonService getDao(String name){
		ICommonService service =map.get(name);
		if(service!=null){
			return service;
		}
		return createDao(name);
	}
	private synchronized static ICommonService createDao(String name){
		ICommonService service =null;
//		if("shopuser".equals(name)){
//			service=new ShopUserServiceImpl();
//			map.put(name, service);
//		}
		if("username".equals(name)){
			service=new ShopUserServiceImpl();
			map.put(name, service);
		}
		/**
		 * @author 朱彬
		 * 根据ID查找商品详情页的信息
		 * */
		if("Goods".equals(name)){
			service=new GoodsServiceImpl();
			map.put(name, service);
		}
		if("UserOrderlist".equals(name)){
			service=new UserOrderlistImpl();
			map.put(name, service);
		}
		if("UserOrder".equals(name)){
			service=new UserOrderServiceImpl();
			map.put(name, service);
		}
		if("Seqence".equals(name)){
			service=new SeqenceServiceImpl();
			map.put(name, service);
		}
		
		
		
		
		if("Comments".equals(name)){
			service=new CommentsServicelImpl();
			map.put(name, service);
		}
		
		if("fgoods".equals(name)){
			service=new FGoodsServicelImpl();
			map.put(name, service);
		}
		
		
		
		
		
		
		
		
		//忘记密码
		if("userpass".equals(name)){
			service=new PassUpServcelImpl();
			map.put(name, service);
		}
		//模糊查询
		if("goodstype".equals(name)){
			service=new GoodsTypeServicelImpl();
			map.put(name, service);
		}
		if("userordertype".equals(name)){
			service=new FOrdertypeServicelImpl();
			map.put(name, service);
		}
		
		return service;
	}
}
