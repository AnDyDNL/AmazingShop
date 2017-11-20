package com.oracle.shop.model.serviceImpl.entity;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.UserOrder;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;

public class UserOrderServiceImpl extends CommonServiceImpl<UserOrder> {

	@Override
	public int save(UserOrder o) {
		return DaoImplFactory.getDao("UserOrder").save(o);
	}
}
