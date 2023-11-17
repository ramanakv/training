package com.trg.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_master")
public class Product{

	@Id
	private int id;
	@Column(length = 20)
	private String name;
	private double price;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="products")
	private Set<Order> orders = new HashSet<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public void show() {
		System.out.println("Product Id: "+id);
		System.out.println("Product Name: "+name);
		System.out.println("Orders with this product: ");
		for(Order o: orders) {
			System.out.println("\tId: "+o.getId()+ " Date: "+ o.getPurchaseDate());
		}
	}
	
		
}
