package com.oracle.shop.model.daoImpl.entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.util.CloseConn;
import com.oracle.shop.util.Factory;
import com.oracleoaec.common.MyTemplate;
import com.oracleoaec.common.PreparedStatementSetter;
import com.oracleoaec.common.RowCallBackHandler;
import com.oracleoaec.exception.DataAccessException;

public class TypeImpl extends CommonDaoImpl<Comments>{
	ArrayList<GoodsType> typeList=new ArrayList<>();//接收查找到的types集合
	int total=0;//存储获取商品总数
	ArrayList <Goods> goodsBrand=new ArrayList<>();//接收查找到的品牌和品牌id
	ArrayList <Goods> goodsByBrand=new ArrayList<>();//接收查找到的品牌和品牌id
	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 获取商品总数
	 * @param id    可以是品牌也可以是类别
	 * @param judge 1按类别 2 按品牌
	 * @return
	 * @throws DataAccessException
	 */
	public int getTotalGoods(final int id,int judge) throws DataAccessException {
		//获取连接
				Connection conn = null;
				try {
					conn = Factory.getConnction();
					MyTemplate template=new MyTemplate(conn);
					String selectSql=null;
					if(judge==1){
						selectSql="select rownum from goods where typeId=?";
					}else{
						selectSql="select rownum from goods where brandId=?";
					}
					template.query(selectSql,
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement pstmt) throws SQLException {
								pstmt.setInt(1,id);
							}
						}, new RowCallBackHandler() {
							@Override
							public void processRow(ResultSet rs) throws SQLException {
								while(rs.next()){
								total=rs.getInt("rownum");
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
				return total;
	}
	/**
	 * 获取类别idh和类别名
	 */
	@Override
	public ArrayList<GoodsType> getType() throws DataAccessException{
		Connection conn = null;
		try {
			conn = Factory.getConnction();
			MyTemplate template=new MyTemplate(conn);
			template.query("select typeid,typename from goods_type ", new RowCallBackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					while(rs.next()){
						GoodsType type=new GoodsType();
						type.setTypeId(rs.getInt("typeid"));
						type.setName(rs.getString("typename"));
						typeList.add(type);
					}
				}
			});
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			CloseConn.close(conn, null, null, null);
		}
		return typeList;
	}
	
	
	/**
	 * 根据类别获取品牌id和类别名
	 * @author Administrator 丁宁乐
	 */

	public ArrayList<Goods> getBrand(final int typeId) throws DataAccessException{
		Connection conn = null;
		try {
			conn = Factory.getConnction();
			MyTemplate template=new MyTemplate(conn);
			template.query("select  DISTINCT  brandId,brandName from goods where typeId=? ",new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, typeId);
				}
			}, new RowCallBackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					while(rs.next()){
						Goods goods=new Goods();
						goods.setBrandId(rs.getInt("brandId"));
						goods.setBrandName(rs.getString("brandName"));
						goodsBrand.add(goods);
					}
				}
			});
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			CloseConn.close(conn, null, null, null);
		}
		return goodsBrand;
	}
	/**
	 * 根据品牌获取某一页商品信息
	 * @param brandId
	 * @returnArrayList<Goods>
	 * @throws DataAccessException
	 * @author Administrator 丁
	 */
	public ArrayList<Goods> getGoodsByBrand(final int brandId,int rownum) throws DataAccessException{
		Connection conn = null;
		try {
			conn = Factory.getConnction();
			MyTemplate template=new MyTemplate(conn);
			template.query("select goodsName,goodsDiscribe,Price,brandname,imgpath from goods where brandId=? "
					,new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, brandId);
				}
			}, new RowCallBackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					while(rs.next()){
						Goods goods=new Goods();
						goods.setImgpath(rs.getString("imgpath"));
						goods.setBrandName(rs.getString("brandName"));
						goods.setPrice(rs.getDouble("price"));
						goods.setGoodsDiscribe(rs.getString("goodsDiscribe"));
						goodsBrand.add(goods);
					}
				}
			});
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			CloseConn.close(conn, null, null, null);
		}
		return goodsBrand;
	}
	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}


