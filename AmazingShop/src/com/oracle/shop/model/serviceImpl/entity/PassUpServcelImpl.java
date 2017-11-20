package com.oracle.shop.model.serviceImpl.entity;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;
import com.oracle.shop.util.JdbcTemplate;

public class PassUpServcelImpl extends CommonServiceImpl<ShopUser>{

	@Override
	public int uppass(Object t) {
		
		return DaoImplFactory.getDao("userpass").uppass(t);
	}
	
}
