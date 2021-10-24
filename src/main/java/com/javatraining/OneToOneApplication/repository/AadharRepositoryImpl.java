package com.javatraining.OneToOneApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.javatraining.OneToOneApplication.dto.AadharDTO;
import com.javatraining.OneToOneApplication.entity.Aadhar;
import com.javatraining.OneToOneApplication.entity.Address;
import com.javatraining.OneToOneApplication.entity.Customer;

@Repository
public class AadharRepositoryImpl implements AadharRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addAadhar(AadharDTO aadharDTO) {
		// TODO Auto-generated method stub
		Aadhar aadhar = new Aadhar();
		Customer customer = new Customer();
		customer.setCustomerName(aadharDTO.getCustomerDTO().getCustomerName());
		customer.setDateOfBirth(aadharDTO.getCustomerDTO().getDateOfBirth());
		customer.setEmailId(aadharDTO.getCustomerDTO().getEmailId());
		customer.setGender(aadharDTO.getCustomerDTO().getGender());
		customer.setPhoneNo(aadharDTO.getCustomerDTO().getPhoneNo());
		Address address = new Address();
		address.setPincode(aadharDTO.getCustomerDTO().getAddressDTO().getPincode());
		address.setStreet(aadharDTO.getCustomerDTO().getAddressDTO().getStreet());
		address.setVillage(aadharDTO.getCustomerDTO().getAddressDTO().getVillage());
		customer.setAddress(address);
		aadhar.setCustomer(customer);
		entityManager.persist(aadhar);
		return aadhar.getAadharNumber();
	}

	@Override
	public Integer updatePhoneNumber(Integer aadhraNo, String phoneNo) {
		// TODO Auto-generated method stub
		Aadhar aadharEntity = entityManager.find(Aadhar.class, aadhraNo);
		if (aadharEntity != null) {
			Customer customerEntity = aadharEntity.getCustomer();
			customerEntity.setPhoneNo(phoneNo);
			aadharEntity.setCustomer(customerEntity);
			entityManager.persist(aadharEntity);
			return aadhraNo;
		}
		return null;

	}

	@Override
	public Integer deleteAadhar(Integer aadharNo) {
		// TODO Auto-generated method stub
		Aadhar aadharEntity = entityManager.find(Aadhar.class, aadharNo);
		if (aadharEntity != null) {
			entityManager.remove(aadharEntity);
			return aadharNo;
		}
		return null;
	}

}
