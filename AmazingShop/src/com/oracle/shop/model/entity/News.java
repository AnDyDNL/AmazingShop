package com.oracle.shop.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.entity.GoodsImpl;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

public class News {
	private List<Goods> news1(){
		int newsj=0;
		List<Goods> goods=new ArrayList<>();
		for (int newi = 0; newi < 20; newi++) {
			newsj=(int)(1+Math.random()*95);
			Goods good = ServiceImplFactory.getDao("Goods").findGoods(newsj);
			goods.add(good);
		}
		return goods;
	}
}
