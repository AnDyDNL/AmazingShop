package com.oracle.shop.model.serviceImpl.entity;

import java.util.List;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;

public class FOrdertypeServicelImpl extends CommonServiceImpl<UserOrderlist> {

	@Override
	public UserOrderlist findordertype(int t) {
		// TODO Auto-generated method stub
		return DaoImplFactory.getDao("userordertype").findordertype(t);
	}


}
