package com.oracle.shop.model.daoImpl.factory;

import java.util.WeakHashMap;

import com.oracle.shop.model.dao.ICommonDao;
import com.oracle.shop.model.daoImpl.entity.CommentsImpl;
import com.oracle.shop.model.daoImpl.entity.FOrderTypeImpl;
import com.oracle.shop.model.daoImpl.entity.FdGoodsImpl;
import com.oracle.shop.model.daoImpl.entity.GoodsImpl;
import com.oracle.shop.model.daoImpl.entity.GoodsTypeImpl;
import com.oracle.shop.model.daoImpl.entity.OrderListImpl;
import com.oracle.shop.model.daoImpl.entity.PassUpIml;
import com.oracle.shop.model.daoImpl.entity.SeqenceImpl;
import com.oracle.shop.model.daoImpl.entity.ShopUserImpl;
import com.oracle.shop.model.daoImpl.entity.UserOrderImpl;

public final class DaoImplFactory {
	private final static WeakHashMap<String, ICommonDao> map=new WeakHashMap<String, ICommonDao>();
	public static ICommonDao getDao(String name){
		ICommonDao dao =map.get(name);
		if(dao!=null){
			return dao;
		}
		return createDao(name);
	}
	private synchronized static ICommonDao createDao(String name){
		ICommonDao dao =null;
		if("shopuser".equals(name)){
			dao=new ShopUserImpl();
			map.put(name, dao);
		}
		if("username".equals(name)){
			dao=new ShopUserImpl();
			map.put(name, dao);
		}
		if("Comments".equals(name)){
			dao=new CommentsImpl();
			map.put(name, dao);
		}
		/**
		 * 朱彬，创建Goods的实例对象
		 * */
		if("Goods".equals(name)){
			dao=new GoodsImpl();
			map.put(name, dao);
		}
		if("UserOrderlist".equals(name)){
			dao=new OrderListImpl();
			map.put(name, dao);
		}
		if("UserOrder".equals(name)){
			dao=new UserOrderImpl();
			map.put(name, dao);
		}
		if("Seqence".equals(name)){
			dao=new SeqenceImpl();
			map.put(name, dao);
		}
		if("fgoods".equals(name)){
			dao=new FdGoodsImpl();
			map.put(name,dao);
		}
		
		
		
		
		
		
		
		
		
		//更改密码
		if("userpass".equals(name)){
			dao=new PassUpIml();
			map.put(name, dao);
		}
		//模糊查询
		if("goodstype".equals(name)){
			dao=new GoodsTypeImpl();
			map.put(name, dao);
		}
		if("userordertype".equals(name)){
			dao=new FOrderTypeImpl();
			map.put(name, dao);
		}
		return dao;
	}
}
