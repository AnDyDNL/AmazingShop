package com.oracle.shop.model.entity;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String user_Name;//用户名
	private String consignee_Name;//收货人姓名
	private String consignee_Tel;//收货人电话号码
	private String location;//收货人地区
	private String detail_Address;//详细地址
	public Address(){
		
	}
	public Address(String user_name, String consignee_Name,
			String consignee_Tel, String detail_Address, String location) {
			this.user_Name=user_name;	
			this.consignee_Name=consignee_Name;
			this.consignee_Tel=consignee_Tel;
			this.detail_Address=detail_Address;
			this.location=location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getConsignee_Name() {
		return consignee_Name;
	}
	public void setConsignee_Name(String consignee_Name) {
		this.consignee_Name = consignee_Name;
	}
	public String  getConsignee_Tel() {
		return consignee_Tel;
	}
	public void setConsignee_Tel(String consignee_Tel) {
		this.consignee_Tel = consignee_Tel;
	}
	public String getlocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetail_Address() {
		return detail_Address;
	}
	public void setDetail_Address(String detail_Address) {
		this.detail_Address = detail_Address;
	}
	
}
