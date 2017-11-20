package com.oracle.shop.model.daoImpl.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.util.JdbcTemplate;
import com.oracleoaec.exception.DataAccessException;
/**
 * 模糊查询
 * @author sdw
 *
 */
public class GoodsTypeImpl extends CommonDaoImpl<GoodsType> {

	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
//模糊查询
	@Override
	public GoodsType findname(final String s) {
		final String sql="select typeid,id from goods_type where typename like lower("+"'%"+s+"%') or typename like upper("+"'%"+s+"%')";
		return JdbcTemplate.singleQuery(sql, new JdbcTemplate.PreparedStateMentSetter(){
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				
			}
		}, createHandler());
	}
	private JdbcTemplate.RowCallBackHandel<GoodsType> createHandler(){
		return new JdbcTemplate.RowCallBackHandel<GoodsType>() {
			@Override
			public GoodsType processRow(ResultSet re) throws SQLException {
				GoodsType good=new GoodsType();
				good.setTypeId(re.getInt("typeid"));
				good.setId(re.getInt("id"));
				return good;
			}
			
		};
	}
	@Override
	public ArrayList<GoodsType> getType() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
