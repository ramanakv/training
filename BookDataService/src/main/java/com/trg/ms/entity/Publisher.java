package com.trg.ms.entity;


public class Publisher {

	private int publisherId;
	private String name;
	private String address;

	public Publisher() {
		super();
	}

	public Publisher(int publisherId, String name, String address) {
		super();
		this.publisherId = publisherId;
		this.name = name;
		this.address = address;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
