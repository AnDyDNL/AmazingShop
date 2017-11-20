package com.oracle.shop.model.serviceImpl.entity;

import java.util.List;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;
import com.oracle.shop.util.JdbcTemplate;

public class FGoodsServicelImpl extends CommonServiceImpl<Goods>{

	@Override
	public List findgoods(String name) {
		// TODO Auto-generated method stub
		return DaoImplFactory.getDao("fgoods").findgoods(name);
	}
	
}
