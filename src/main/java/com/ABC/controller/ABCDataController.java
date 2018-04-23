package com.ABC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ABC.service.ABCDataService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.MediaType;



@RestController
public class ABCDataController {
	
	@Autowired
	ABCDataService abcDataService;
	private final static Logger slf4jLogger = LoggerFactory.getLogger(ABCDataController.class);	
	
	@RequestMapping(method = RequestMethod.POST,
            value = "/createTravelData",
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE)
			public String createTravelData(@RequestBody String newContact) throws JsonProcessingException {
				return abcDataService.createTravelData(newContact);
			}
	
	@RequestMapping(method = RequestMethod.POST,
            value = "/createProducerData",
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE)
			public String createProducerTravelData(@RequestBody String producerRecord) throws JsonProcessingException {
				String[] producerRecordArr= producerRecord.split(",");
				if(producerRecordArr.length >1) {
					return Integer.toString(abcDataService.createProducerTravelData(producerRecordArr[0],producerRecordArr[1]));
				}
				else {
					return "0";
				}
				
			}
	
	@RequestMapping(method = RequestMethod.GET,
			value = "/greeting",
			produces = MediaType.TEXT_HTML_VALUE)
	public String greeting() {
		return"Hi! This works!";
		
	}
	
}
