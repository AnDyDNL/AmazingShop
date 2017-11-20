package com.oracle.shop.model.daoImpl.entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.util.JdbcTemplate;
import com.oracle.shop.util.JdbcTemplate.RowCallBackHandel;
import com.oracleoaec.exception.DataAccessException;

public class CommentsImpl extends CommonDaoImpl<Comments>{
	@Override
	public List<Comments> findcomm(final int id) {
		// TODO Auto-generated method stub
		//查看评论多条
		return JdbcTemplate.Query("select COMMENTSUSER,COMMENTSTIME,COMMENTSCONTENT from Comments where "
				+ "GOODSID=?", 
				new JdbcTemplate.PreparedStateMentSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, id);
			}
		},createHandler1());
	}
	private RowCallBackHandel<Comments> createHandler1() {
		return new JdbcTemplate.RowCallBackHandel<Comments>() {
			@Override
			public Comments processRow(ResultSet re) throws SQLException {
				Comments comm=new Comments();
				comm.setCommentsContent(re.getString("COMMENTSCONTENT"));
				comm.setCommentsTime(re.getString("COMMENTSTIME"));
				comm.setCommentsUser(re.getString("COMMENTSUSER"));
//				System.out.println(user);
				return comm;
			}
		};
	}
	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int save(final Comments t) {
		
		return JdbcTemplate.update(""
				+ "insert into Comments values(s_comments.nextval"
				+ ",?,?,?,?)",new JdbcTemplate.PreparedStateMentSetter(){
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, t.getCommentsUser());
				pstmt.setString(2,t.getCommentsTime());
				pstmt.setString(3, t.getCommentsContent());
				pstmt.setInt(4, t.getGoodsid());
			}
		});
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
