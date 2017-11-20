package com.oracle.shop.model.entity;
/*
 * 用户
 */
/**
 * 用户
 */
public class ShopUser {
	private int userId;
	private String userName;
	private String userTel;//电话
	private String userPassword;
	private double userBalance;//钱
	private String userAddress;//地址
	
	public ShopUser() {
	}
	public ShopUser(int userId, String userName, String userTel,
			String userPassword, double userBalance, String userAddress) {
		this.userId = userId;
		this.userName = userName;
		this.userTel = userTel;
		this.userPassword = userPassword;
		this.userBalance = userBalance;
		this.userAddress = userAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String phone) {
		this.userTel = phone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public double getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "ShopUser [userId=" + userId + ", userName=" + userName
				+ ", userTel=" + userTel + ", userPassword=" + userPassword
				+ ", userBalance=" + userBalance + ", userAddress="
				+ userAddress + "]";
	}
	
}
