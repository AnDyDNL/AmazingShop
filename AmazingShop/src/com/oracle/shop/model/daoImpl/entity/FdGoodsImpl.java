package com.oracle.shop.model.daoImpl.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.util.JdbcTemplate;
import com.oracleoaec.exception.DataAccessException;

public class FdGoodsImpl extends CommonDaoImpl<Goods>{

	@Override
	public List<Goods> findgoods(String name) {
		final String sql="select typeid,id,price,brandName,"
				+ "IMGPATH,BRANDID,GOODSNAME,GOODSDISCRIBE from "
				+ "goods where GOODSNAME like lower("+"'%"+name+"%') "
						+ "or GOODSNAME like upper("+"'%"+name+"%')"+"or GOODSDISCRIBE like lower("+"'%"+name+"%') "
						+ "or GOODSDISCRIBE like upper("+"'%"+name+"%')";
		return JdbcTemplate.Query(sql, new JdbcTemplate.PreparedStateMentSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				
			}
		},createHandler());
	}

	@Override
	public ArrayList<GoodsType> getType() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	private JdbcTemplate.RowCallBackHandel<Goods> createHandler(){
		return new JdbcTemplate.RowCallBackHandel<Goods>() {
			@Override
			public Goods processRow(ResultSet re) throws SQLException {
				Goods good=new Goods();
				good.setTypeId(re.getInt("typeid"));
				good.setId(re.getInt("id"));
				good.setBrandId(re.getInt("BRANDID"));
				good.setBrandName(re.getString("brandName"));
				good.setGoodsDiscribe(re.getString("GOODSDISCRIBE"));
				good.setGoodsName(re.getString("GOODSNAME"));
				good.setPrice(re.getDouble("price"));
				good.setImgpath(re.getString("IMGPATH"));
				return good;
			}
		};
	}

}
