package com.trg.jpa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DIR") // value for manager rows in Discriminator column
public class Director extends Manager {

	private static final long serialVersionUID = 1L;
	
	@Column(length=15)
	private String client;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return   super.toString()+" Client=" + client;
	}
	
	


}
