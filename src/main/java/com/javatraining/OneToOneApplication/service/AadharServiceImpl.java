package com.javatraining.OneToOneApplication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatraining.OneToOneApplication.dto.AadharDTO;
import com.javatraining.OneToOneApplication.repository.AadharRepository;

@Service
@Transactional
public class AadharServiceImpl implements AadharService{
	
	@Autowired
	private AadharRepository aadharRepo;

	@Override
	public Integer addAadhar(AadharDTO aadharDTO) throws Exception {
		// TODO Auto-generated method stub
		Integer aaadharNo = aadharRepo.addAadhar(aadharDTO);
		return aaadharNo;
	}

	@Override
	public Integer updatePhoneNumber(Integer aadhraNo, String phoneNo) throws Exception {
		// TODO Auto-generated method stub
		Integer aadharNo = aadharRepo.updatePhoneNumber(aadhraNo, phoneNo);
		if(aadharNo == null)
		{
			throw new Exception("Aadhar does not exist");
		}
		return aadharNo;
	}

	@Override
	public Integer deleteAadhar(Integer aadharNo) throws Exception {
		// TODO Auto-generated method stub
		Integer deletedAadharNo = aadharRepo.deleteAadhar(aadharNo);
		if(deletedAadharNo == null)
		{
			throw new Exception("Aadhar does not exist");
		}
		return deletedAadharNo;
	}

}
