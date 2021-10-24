package com.javatraining.OneToOneApplication.dto;

import javax.validation.Valid;

public class AadharDTO {
	private Integer aadharNumber;
	@Valid
	private CustomerDTO customerDTO;

	public Integer getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Integer aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

}
