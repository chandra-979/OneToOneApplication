package com.javatraining.OneToOneApplication.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressDTO {

	private Integer addressId;
	@NotNull(message = "street should not be empty")
	private String street;
	@NotNull(message = "village should not be empty")
	private String village;
	@NotNull(message = "pincode should not be empty")
	@Pattern(regexp = "[0-9]{6}",message = "invalid pincode")
	private String pincode;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
