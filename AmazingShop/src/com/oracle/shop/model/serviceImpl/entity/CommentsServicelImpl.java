package com.oracle.shop.model.serviceImpl.entity;

import java.util.List;

import com.oracle.shop.model.daoImpl.factory.DaoImplFactory;
import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.serviceImpl.CommonServiceImpl;

public class CommentsServicelImpl extends CommonServiceImpl<Comments> {

	@Override
	public List<Comments> findcomm(int id) {
		// TODO Auto-generated method stub
		return DaoImplFactory.getDao("Comments").findcomm(id);
	}

	@Override
	public int save(Object t) {
		// TODO Auto-generated method stub
		return DaoImplFactory.getDao("Comments").save(t);
	}
	
}
