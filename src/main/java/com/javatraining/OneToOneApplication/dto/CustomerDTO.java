package com.javatraining.OneToOneApplication.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class CustomerDTO {

	private Integer customerId;
	@NotNull(message = "custmer not empty")
	private String customerName;
	@NotNull(message = "phone number not empty")
	@Pattern(regexp = "[0-9]{10}")
	private String phoneNo;
	@NotNull(message = "email should not be empty")
	@Email(message = "invalid email")
	private String emailId;
	@NotNull(message = "date of birth should not be empty")
	@PastOrPresent(message = "date should be past or present")
	private LocalDate dateOfBirth;
	@NotNull(message = "Gender should not be empty")
	@Pattern(regexp = "(MALE|FEMALE)", message = "invalid gender")
	private Gender gender;
	@Valid
	private AddressDTO addressDTO;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

}
