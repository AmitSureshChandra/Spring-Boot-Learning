package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_orders")
class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@ManyToMany
	@JoinTable(
				name = "order_item",
				joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id")
	)
	private List<Item> items;
//	


}
