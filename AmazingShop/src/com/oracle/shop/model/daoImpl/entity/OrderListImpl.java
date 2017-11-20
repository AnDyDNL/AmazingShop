package com.oracle.shop.model.daoImpl.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.util.JdbcTemplate;
import com.oracle.shop.util.JdbcTemplate.PreparedStateMentSetter;
import com.oracleoaec.exception.DataAccessException;

public class OrderListImpl extends CommonDaoImpl<UserOrderlist> {

	

	@Override
	public List<UserOrderlist> findOrderlist(final int status,final String name) {
		return JdbcTemplate.Query("select orderliset_id,order_number,ORDERTIME,PRICE,AMOUNT,TYPEID,BRANDNAME,ORDERTYPE,totalprice,imgpath,discribe,goods_id from user_orderlist where ordertype=? and username=?",
				new PreparedStateMentSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, status);
						pstmt.setString(2, name);
					}
				}, createHandler());
	}
	
	private JdbcTemplate.RowCallBackHandel<UserOrderlist> createHandler(){
		return new JdbcTemplate.RowCallBackHandel<UserOrderlist>() {
			@Override
			public UserOrderlist processRow(ResultSet re) throws SQLException {
				UserOrderlist orderlist=new UserOrderlist();
				orderlist.setAmount(re.getInt("AMOUNT"));
				orderlist.setBrandName(re.getString("BRANDNAME"));
				orderlist.setOrderLisetid(re.getInt("orderliset_id"));
				orderlist.setOrderNumber(re.getDouble("order_number"));
				orderlist.setOrderTime(re.getDate("ORDERTIME"));
				orderlist.setOrderType(re.getInt("ORDERTYPE"));
				orderlist.setPrice(re.getDouble("PRICE"));
				orderlist.setTypeId(re.getInt("TYPEID"));
				orderlist.setDiscribe(re.getString("discribe"));
				orderlist.setImgpath(re.getString("imgpath"));
				orderlist.setTotalprice(re.getDouble("totalprice"));
				orderlist.setGoods_id(re.getInt("goods_id"));
				//System.out.println(orderlist);
				return orderlist;
			}
		};
	}
	/**
	 * 朱彬重写save方法，保存添加到购物车的信息
	 * */
	@Override
	public int save(final UserOrderlist t) {
		return JdbcTemplate.update("insert into user_orderlist(orderliset_id,ORDERTIME,PRICE,AMOUNT,TYPEID,BRANDNAME,ORDERTYPE,totalprice,imgpath,discribe,username,goods_id) values(s_orderlist.nextval,?,?,?,?,?,?,?,?,?,?,?)", 
				new PreparedStateMentSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setDate(1, t.getOrderTime());
				pstmt.setDouble(2, t.getPrice());
				pstmt.setInt(3, t.getAmount());
				pstmt.setInt(4, t.getTypeId());
				pstmt.setString(5, t.getBrandName());
				pstmt.setInt(6, t.getOrderType());
				pstmt.setDouble(7, t.getTotalprice());
				pstmt.setString(8, t.getImgpath());
				pstmt.setString(9, t.getDiscribe());
				pstmt.setString(10, t.getUserName());
				pstmt.setInt(11, t.getGoods_id());
			}
		});
	}

	/**
	 * @author 丁宁乐
	 * @return List<Goods>
	 * @deprecated根据类别查找商品
	 */
	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author 丁宁乐
	 * @return ArrayList<GoodsType>
	 * @deprecated动态获取商品类别和id
	 */
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

	@Override
	public int delete(final int id) {
		return JdbcTemplate.update("delete user_orderlist where orderliset_id=?", 
				new PreparedStateMentSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, id);
			}
		});
	}

	@Override
	public int updateOrderList(final UserOrderlist u) {
		return JdbcTemplate.update("update user_orderlist set order_number=?,amount=?,ordertype=?,totalprice=? where orderliset_id=?",
				new PreparedStateMentSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setDouble(1,u.getOrderNumber());
				pstmt.setInt(2, u.getAmount());
				pstmt.setInt(3, u.getOrderType());
				pstmt.setDouble(4, u.getTotalprice());
				pstmt.setInt(5, u.getOrderLisetid());
			}
		});
	}
	
	
	
	
	

}
