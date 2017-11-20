package com.oracle.shop.model.daoImpl.entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.util.CloseConn;
import com.oracle.shop.util.Factory;
import com.oracle.shop.util.JdbcTemplate;
import com.oracle.shop.util.JdbcTemplate.PreparedStateMentSetter;
import com.oracle.shop.util.JdbcTemplate.RowCallBackHandel;
import com.oracleoaec.common.MyTemplate;
import com.oracleoaec.common.PreparedStatementSetter;
import com.oracleoaec.common.RowCallBackHandler;
import com.oracleoaec.exception.DataAccessException;


public class GoodsImpl extends CommonDaoImpl<Goods>{
	ArrayList<Goods> goodsList=new ArrayList<>();//接收查找到的goods集合
	int id=0; //接收查找到的id
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//重写查找商品类别的方法
	@Override
	public Goods findByID(final int id) {
		return JdbcTemplate.singleQuery("select id,typeid,brandname,brandid,goodsname,goodsdiscribe,price,imgpath from goods where id=?", 
				new PreparedStateMentSetter() {
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, id);
					}
				}, createHandler());
	}
	private RowCallBackHandel<Goods> createHandler(){
		return new JdbcTemplate.RowCallBackHandel<Goods>() {
			@Override
			public Goods processRow(ResultSet rs) throws SQLException {
				Goods goods=new Goods();
				goods.setId(rs.getInt("id"));
				goods.setTypeId(rs.getInt("typeid"));
				goods.setBrandName(rs.getString("brandname"));
				goods.setBrandId(rs.getInt("brandid"));
				goods.setGoodsName(rs.getString("goodsname"));
				goods.setGoodsDiscribe(rs.getString("goodsdiscribe"));
				goods.setPrice(rs.getDouble("price"));
				goods.setImgpath(rs.getString("imgpath"));
				return goods;
			}
			
		};
	}

	public ArrayList<Goods> findByTypeRange(final int id,final int rownum) throws DataAccessException {
		//获取连接
		Connection conn = null;
		try {
			conn = Factory.getConnction();
			MyTemplate template=new MyTemplate(conn);
			template.query("select * from(select id,imgpath,goodsName,goodsDiscribe,Price,brandname,ROWNUM rn from goods where typeId=? and ROWNUM<=?)where rn>?",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1,id);
						pstmt.setInt(2, rownum*11);//小于等于页数乘以页面的商品数量
						pstmt.setInt(3, (rownum-1)*11);//大于等于页数减一乘以页面的商品数量
					}
				}, new RowCallBackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						while(rs.next()){
							Goods good=new Goods();
							good.setTypeId(id);
							good.setId(rs.getInt("id"));
							good.setImgpath(rs.getString("imgpath"));
							good.setGoodsName(rs.getString("goodsName"));
							good.setGoodsDiscribe(rs.getString("goodsDiscribe"));
							good.setPrice(rs.getDouble("Price"));
							good.setBrandName(rs.getString("brandname"));
							goodsList.add(good);
						}
					}
				});

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			CloseConn.close(conn, null, null, null);
		}
		return goodsList;
	}
	/**
	 * 查找某一页根据品牌
	 */
	public ArrayList<Goods> getGoodsByBrandRang(final int id,final int rownum) throws DataAccessException {
		//获取连接
		Connection conn = null;
		try {
			conn = Factory.getConnction();
			MyTemplate template=new MyTemplate(conn);
			template.query("select * from(select id,imgpath,goodsName,goodsDiscribe,Price,brandname,ROWNUM rn from goods where brandId=? and ROWNUM<=?)where rn>?",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1,id);
						pstmt.setInt(2, rownum*11);//小于等于页数乘以页面的商品数量
						pstmt.setInt(3, (rownum-1)*11);//大于等于页数减一乘以页面的商品数量
					}
				}, new RowCallBackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						while(rs.next()){
							Goods good=new Goods();
							good.setTypeId(id);
							good.setId(rs.getInt("id"));
							good.setImgpath(rs.getString("imgpath"));
							good.setGoodsName(rs.getString("goodsName"));
							good.setGoodsDiscribe(rs.getString("goodsDiscribe"));
							good.setPrice(rs.getDouble("Price"));
							good.setBrandName(rs.getString("brandname"));
							goodsList.add(good);
						}
					}
				});

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			CloseConn.close(conn, null, null, null);
		}
		return goodsList;
	}
	
	
	
	
	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserOrderlist> findOrderlist(int status,String name) {
		// TODO Auto-generated method stub
		return null;
	}

	 /**
		 * @author 丁宁乐
		 * 查找到商品类别的总数
		 * @return
		 * @throws DataAccessException 
		 */


	@Override
	public Goods findtyid(String s) {
		//C模糊查询商品
		final String sql="select typeid,brandid from goods where goodsname like lower("+"'%"+s+"%') or goodsname like upper("+"'%"+s+"%')";
		return JdbcTemplate.singleQuery(sql, new JdbcTemplate.PreparedStateMentSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				
			}
		}, createHandler1());
	}
	public ArrayList<GoodsType> getType() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;

	}
	private JdbcTemplate.RowCallBackHandel<Goods> createHandler1(){
		return new JdbcTemplate.RowCallBackHandel<Goods>() {
			@Override
			public Goods processRow(ResultSet re) throws SQLException {
				Goods good=new Goods();
				good.setTypeId(re.getInt("typeid"));
				good.setBrandId(re.getInt("brandid"));
				return good;
			}
			
		};
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}