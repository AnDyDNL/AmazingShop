package com.oracle.shop.model.serviceImpl.entity;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;

public class ShopUserServiceImpl extends CommonServiceImpl<ShopUser> {

	@Override
	public int save(Object t) {
		return DaoImplFactory.getDao("username").save(t);
	}

	@Override
	public ShopUser findShopUserT(String tel) {
		return DaoImplFactory.getDao("username").findShopUserT(tel);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public ShopUser findShopUser(String name) {
		return DaoImplFactory.getDao("username").findShopUser(name);
	}
	
}
