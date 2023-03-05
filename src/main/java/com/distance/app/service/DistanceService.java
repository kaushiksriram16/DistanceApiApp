package com.distance.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.distance.app.entity.DistanceInfo;
import com.distance.app.repository.DistanceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DistanceService {
	
	@Autowired
	private DistanceRepository repository;
	
	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;
	
	public DistanceService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.objectMapper = new ObjectMapper();
	}
	
	String apiUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&";
	private String apiKey = "<YOUR API KEY>";
	
	@Cacheable("distanceInfo")
	public DistanceInfo getDistanceInfo(String fromPincode, String toPincode) throws JsonMappingException, JsonProcessingException {
		String response = restTemplate.getForObject(apiUrl+"origins="+fromPincode+"&destinations="+toPincode+"&key="+apiKey, String.class);
		
		JsonNode jsonNode = objectMapper.readTree(response);
		String distance = jsonNode.get("rows").get(0).get("elements").get(0).get("distance").get("text").asText();
		DistanceInfo distanceInfo = new DistanceInfo(fromPincode, toPincode, distance);
		return repository.save(distanceInfo);
	}
}
