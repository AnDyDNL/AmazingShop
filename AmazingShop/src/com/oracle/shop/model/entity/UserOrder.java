package com.oracle.shop.model.entity;

import java.sql.Date;
import java.util.ArrayList;


/**
 * 
 * 用户订单
 */
public class UserOrder {
	private int orderId;
	private Date orderTiem;//下单时间
	private double total;//总计
	private int orderType;//结算类型
	private String orderUser;//下单用户
	private ArrayList<UserOrderlist> orderList;//包含多个订单明细
	public UserOrder() {
	}
	public UserOrder(int orderId, Date orderTiem, double total, int orderType,
			String orderUser) {
		this.orderId = orderId;
		this.orderTiem = orderTiem;
		this.total = total;
		this.orderType = orderType;
		this.orderUser = orderUser;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderTiem() {
		return orderTiem;
	}
	public void setOrderTiem(Date orderTiem) {
		this.orderTiem = orderTiem;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public String getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}
	@Override
	public String toString() {
		return "UserOrder [orderId=" + orderId + ", orderTiem=" + orderTiem
				+ ", total=" + total + ", orderType=" + orderType
				+ ", orderUser=" + orderUser + ", orderList=" + orderList + "]";
	}
	
	
}
