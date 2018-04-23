package com.ABC.service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface ABCDataService {
	String createTravelData(String contactDet) throws JsonProcessingException;	
	int createProducerTravelData(String topic, String nRec) ;	
}

