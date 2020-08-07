package com.nsdata.rest.food;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customername;

	public Orders() {
	}

	public Orders(Long id, String customername) {
		super();
		this.id = id;
		this.customername = customername;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customername=" + customername + "]";
	}

}
