package com.trg.jpa;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_master")
public class Order {

	@Id
	private int id;

	@Column(name = "order_date")
	private Date purchaseDate;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_orders", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private Set<Product> products = new HashSet<>();	//required to avoid NullPointerException

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.getProducts().add(product);
	}

	
	public void show() {
		System.out.println("order Id: "+id);
		System.out.println("Order date: "+purchaseDate);
		System.out.println("Products: ");
		for(Product p: products) {
			System.out.println("\tId: "+p.getId()+ " Name: "+ p.getName()+ " Price: "+ p.getPrice());
		}
	}
	
	
}
