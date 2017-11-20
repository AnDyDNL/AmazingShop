package com.oracle.shop.model.entity;

import java.sql.Date;


/**
 *订单明细
 */
public class UserOrderlist {
	private int orderLisetid;//id
	private double orderNumber;//订单号
	private Date orderTime;//订单时间
	private double price;//订单金额
	private int amount;//数量
	private int typeId;//商品类型名
	private String brandName;//品牌
	private int orderType;//结算类型
	private double totalprice;
	private String imgpath;
	private String discribe;
	private int goods_id;
	private String userName;
	public int getOrderLisetid() {
		return orderLisetid;
	}
	public void setOrderLisetid(int orderLisetid) {
		this.orderLisetid = orderLisetid;
	}
	public double getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(double orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getDiscribe() {
		return discribe;
	}
	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserOrderlist(){}
	public UserOrderlist(int orderLisetid, double orderNumber, Date orderTime,
			double price, int amount, int typeId, String brandName,
			int orderType, double totalprice, String imgpath, String discribe,
			int goods_id, String userName) {
		super();
		this.orderLisetid = orderLisetid;
		this.orderNumber = orderNumber;
		this.orderTime = orderTime;
		this.price = price;
		this.amount = amount;
		this.typeId = typeId;
		this.brandName = brandName;
		this.orderType = orderType;
		this.totalprice = totalprice;
		this.imgpath = imgpath;
		this.discribe = discribe;
		this.goods_id = goods_id;
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserOrderlist [orderLisetid=" + orderLisetid + ", orderNumber="
				+ orderNumber + ", orderTime=" + orderTime + ", price=" + price
				+ ", amount=" + amount + ", typeId=" + typeId + ", brandName="
				+ brandName + ", orderType=" + orderType + ", totalprice="
				+ totalprice + ", imgpath=" + imgpath + ", discribe="
				+ discribe + ", goods_id=" + goods_id + ", userName="
				+ userName + "]";
	}
	
	
}
