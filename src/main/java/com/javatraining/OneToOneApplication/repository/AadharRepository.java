package com.javatraining.OneToOneApplication.repository;

import com.javatraining.OneToOneApplication.dto.AadharDTO;

public interface AadharRepository {
	
	Integer addAadhar(AadharDTO aadharDTO);
	Integer updatePhoneNumber(Integer aadhraNo,String phoneNo);
	Integer deleteAadhar(Integer aadharNo);

}
