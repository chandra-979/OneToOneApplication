package com.javatraining.OneToOneApplication.repository;

import com.javatraining.OneToOneApplication.dto.AddressDTO;
import com.javatraining.OneToOneApplication.dto.CustomerDTO;

public interface CustomerRepository {

	void updateCustomer(Integer aadharNo,CustomerDTO updateCustomerDTO);
	Integer addAddressToExistingCustomer(Integer aadharNo,AddressDTO newAddressDTO);
}
