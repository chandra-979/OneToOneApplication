package com.javatraining.OneToOneApplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class Aadhar {

	@Id
	@TableGenerator(name = "aadhar_gen", allocationSize = 10, initialValue = 1000, pkColumnName = "aadhar_key", valueColumnName = "next_val", pkColumnValue = "aadhar_number")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "aadhar_gen")
	private Integer aadharNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", unique = true)
	private Customer customer;

	public Integer getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Integer aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
