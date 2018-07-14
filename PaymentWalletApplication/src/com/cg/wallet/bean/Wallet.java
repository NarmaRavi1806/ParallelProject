package com.cg.wallet.bean;

import java.time.LocalDateTime;

/**
 * 
 * Class name : Wallet
 * No. of Methods : 2
 * Purpose : Bean class to access the attributes
 * 
 * Author : Narmatha
 * Date of Creation : 13-July-2018
 * 
 * Last Modification Date : 14-July-2018
 *
 */

public class Wallet {
	
	String name;
	String mobileNo;
	String emailId;
	double balance;
	LocalDateTime date;
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Wallet(String name, String mobileNo, String emailId, double balance,
			LocalDateTime date) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.balance = balance;
		this.date = date;
	}
	public Wallet(){
		super();
	}

}
