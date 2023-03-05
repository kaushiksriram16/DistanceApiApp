package com.distance.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.distance.app.entity.DistanceInfo;
import com.distance.app.service.DistanceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class DistanceController {
	private final DistanceService distanceService;
	
	public DistanceController(DistanceService distanceService) {
		this.distanceService = distanceService;
	}
	
	@GetMapping("/distance/{fromPincode}/{toPincode}")
	public ResponseEntity<DistanceInfo> getDistance(@PathVariable String fromPincode, @PathVariable String toPincode) throws JsonMappingException, JsonProcessingException {
		return new ResponseEntity<>(distanceService.getDistanceInfo(fromPincode, toPincode), HttpStatus.OK);
	}
	
}
