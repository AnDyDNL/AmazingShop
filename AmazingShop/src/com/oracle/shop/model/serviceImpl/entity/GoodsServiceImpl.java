package com.oracle.shop.model.serviceImpl.entity;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;

public class GoodsServiceImpl extends CommonServiceImpl<Goods> {
	/**
	 * @author 朱彬
	 * 根据ID查找商品详情页的信息
	 * */
	@Override
	public Goods findGoods(int id) {
		return (Goods) DaoImplFactory.getDao("Goods").findByID(id);
	}

	@Override
	public Goods findtyid(String s) {
		// TODO Auto-generated method stub
		return DaoImplFactory.getDao("Goods").findtyid(s);
	}
	
	
	
}
