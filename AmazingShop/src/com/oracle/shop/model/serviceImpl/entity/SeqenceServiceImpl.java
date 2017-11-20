package com.oracle.shop.model.serviceImpl.entity;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.Seqence;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;
import com.oracle.shop.model.serviceImpl.factory.ServiceImplFactory;

public class SeqenceServiceImpl extends CommonServiceImpl<Seqence> {

	@Override
	public Seqence selectSeq() {
		return DaoImplFactory.getDao("Seqence").selectSeq();
	}
	
}
