package com.javatraining.OneToOneApplication.service;

import com.javatraining.OneToOneApplication.dto.AadharDTO;

public interface AadharService {

	Integer addAadhar(AadharDTO aadharDTO) throws Exception;
	Integer updatePhoneNumber(Integer aadhraNo,String phoneNo) throws Exception;
	Integer deleteAadhar(Integer aadharNo) throws Exception;
}
