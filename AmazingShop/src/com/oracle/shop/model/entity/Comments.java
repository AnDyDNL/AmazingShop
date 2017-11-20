package com.oracle.shop.model.entity;

import java.util.Date;

/**
 * 评价
 */
public class Comments {
	private int id;
	private String commentsUser;
	private int goodsid;//商品id
	private String commentsTime;//评价时间
	private String commentsContent;//评价内容
	
	public Comments() {
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", commentsUser=" + commentsUser
				+ ", goodsid=" + goodsid + ", commentsTime=" + commentsTime
				+ ", commentsContent=" + commentsContent + "]";
	}
	public Comments(int id, String commentsUser, int goodsid,
			String commentsTime, String commentsContent) {
		this.id = id;
		this.commentsUser = commentsUser;
		this.goodsid = goodsid;
		this.commentsTime = commentsTime;
		this.commentsContent = commentsContent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommentsUser() {
		return commentsUser;
	}
	public void setCommentsUser(String commentsUser) {
		this.commentsUser = commentsUser;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getCommentsTime() {
		return commentsTime;
	}
	public void setCommentsTime(String commentsTime) {
		this.commentsTime = commentsTime;
	}
	public String getCommentsContent() {
		return commentsContent;
	}
	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}
	
	
}
