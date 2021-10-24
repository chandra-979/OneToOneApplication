package com.javatraining.OneToOneApplication.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatraining.OneToOneApplication.dto.AadharDTO;
import com.javatraining.OneToOneApplication.service.AadharService;

@RestController
@RequestMapping("/aadhar")
@Validated
public class AadharController {

	@Autowired
	private AadharService aadharService;

	@PostMapping("/add")
	public ResponseEntity<String> addAadhar(@RequestBody @Valid AadharDTO aadharDTO) throws Exception {
		Integer aadharNo = aadharService.addAadhar(aadharDTO);
		return new ResponseEntity<String>("Aadhar added successfully with aadharNo : " + aadharNo, HttpStatus.CREATED);
	}

	@PutMapping("/update-phone/{aadharNumber}/{phoneNo}")
	public ResponseEntity<String> updatePhoneNumber(@PathVariable  @NotNull(message = "aadhar not empty") Integer  aadharNumber,
			@PathVariable @Pattern(regexp = "[0-9]{10}", message = "invalid phone number") String phoneNo)
			throws Exception {
		aadharService.updatePhoneNumber(aadharNumber, phoneNo);
		return new ResponseEntity<String>("Aadhar updated successfully with phone number : " + phoneNo, HttpStatus.OK);
	}

}
