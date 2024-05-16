package com.facade;

public class StoreData {
	
	private int itemCode;
	private int balance;
	private int rol;
	
	public StoreData(int itemCode, int balance, int rol) {
		super();
		this.itemCode = itemCode;
		this.balance = balance;
		this.rol = rol;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	

}
