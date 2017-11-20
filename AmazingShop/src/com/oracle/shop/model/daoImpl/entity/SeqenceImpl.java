package com.oracle.shop.model.daoImpl.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.Seqence;
import com.oracle.shop.util.JdbcTemplate;
import com.oracleoaec.exception.DataAccessException;

public class SeqenceImpl extends CommonDaoImpl<Seqence>{

	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<GoodsType> getType() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seqence selectSeq() {
		return JdbcTemplate.singleQuery("select s_order.nextval from dual", createHandler());
	}
	
	private JdbcTemplate.RowCallBackHandel<Seqence> createHandler(){
		return new JdbcTemplate.RowCallBackHandel<Seqence>() {
			@Override
			public Seqence processRow(ResultSet re) throws SQLException {
				Seqence se=new Seqence();
				se.setNextSeq(re.getInt("nextval"));
				//se.setCurrSeq(re.getInt("currval"));
				//System.out.println(se+"123");
				return se;
			}
		};
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
