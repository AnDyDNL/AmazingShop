package com.oracle.shop.model.serviceImpl.entity;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;

public class GoodsTypeServicelImpl extends CommonServiceImpl<GoodsType>{

	@Override
	public GoodsType findname(String s) {
	
		return DaoImplFactory.getDao("goodstype").findname(s);
	}

	
}
