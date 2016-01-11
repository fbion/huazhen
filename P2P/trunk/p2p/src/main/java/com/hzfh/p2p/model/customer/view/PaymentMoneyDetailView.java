package com.hzfh.p2p.model.customer.view;

import java.io.Serializable;
import java.sql.Timestamp;

import com.hzframework.contract.BaseEntity;


public class PaymentMoneyDetailView extends BaseEntity implements Serializable {
	private String moneyDetailTime;
	private String moneyDetailType;
	private String moneyDetailIncome;
	private String moneyDetailExpend;
	private String moneyDetailBalance;
	private String moneyDetailNote;
	public String getMoneyDetailTime() {
		return moneyDetailTime;
	}
	public void setMoneyDetailTime(String moneyDetailTime) {
		this.moneyDetailTime = moneyDetailTime;
	}
	public String getMoneyDetailType() {
		return moneyDetailType;
	}
	public void setMoneyDetailType(String moneyDetailType) {
		this.moneyDetailType = moneyDetailType;
	}
	public String getMoneyDetailIncome() {
		return moneyDetailIncome;
	}
	public void setMoneyDetailIncome(String moneyDetailIncome) {
		this.moneyDetailIncome = moneyDetailIncome;
	}
	public String getMoneyDetailExpend() {
		return moneyDetailExpend;
	}
	public void setMoneyDetailExpend(String moneyDetailExpend) {
		this.moneyDetailExpend = moneyDetailExpend;
	}
	public String getMoneyDetailBalance() {
		return moneyDetailBalance;
	}
	public void setMoneyDetailBalance(String moneyDetailBalance) {
		this.moneyDetailBalance = moneyDetailBalance;
	}
	public String getMoneyDetailNote() {
		return moneyDetailNote;
	}
	public void setMoneyDetailNote(String moneyDetailNote) {
		this.moneyDetailNote = moneyDetailNote;
	}
	
}