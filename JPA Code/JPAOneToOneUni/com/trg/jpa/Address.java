package com.trg.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@Column(name="ADDRESS_ID")
	private int addressId;
	@Column(name="ADDRESS_STREET",length=12)
	private String street;
	@Column(name="ADDRESS_CITY",length=12)
	private String city;
	@Column(name="ADDRESS_STATE",length=12)
	private String state;
	@Column(name="ADDRESS_PINCODE",length=6)
	private String pinCode;
	

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pinCode=" + pinCode + "]";
	}
	
	
}
