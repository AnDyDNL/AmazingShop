package com.oracle.shop.model.serviceImpl.entity;

import java.util.List;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;

public class UserOrderlistImpl extends CommonServiceImpl<UserOrderlist>{

	@Override
	public int save(Object t) {
		// TODO Auto-generated method stub
		return DaoImplFactory.getDao("UserOrderlist").save(t);
	}

	@Override
	public List findOrderlist(int status,String name) {
		return DaoImplFactory.getDao("UserOrderlist").findOrderlist(status,name);
	}

	@Override
	public int update(UserOrderlist u) {
		return DaoImplFactory.getDao("UserOrderlist").updateOrderList(u);
	}

	@Override
	public int delete(int id) {
		return DaoImplFactory.getDao("UserOrderlist").delete(id);
	}
	
	
	
}
