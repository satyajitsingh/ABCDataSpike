package com.ABC.service;

import java.text.ParseException;

import com.ABC.Contact;
import com.ABC.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ABCDataServiceImpl implements ABCDataService {
	String contactDetails;
	@Autowired
    private Environment environment;
	@Override
	 public String createTravelData(String contactDet) throws JsonProcessingException   {
		String rContact = "Contact not created";
		Contact contact = new Contact();
		contactDetails = contactDet;
		try {			
			contact.parseString(contactDetails);				
			ObjectMapper mapper = new ObjectMapper();
			rContact = mapper.writeValueAsString(contact);
		} catch (ParseException e) {
			System.out.println("Invalid Parameters");
		}
		return rContact;
	}
	@Override
	public int createProducerTravelData(String topic, String nRec) {
		int rec = Integer.parseInt(nRec);
		String kafka_connect = environment.getProperty("kafkaconnect"); 
		int recCreated = 0;
		recCreated = Producer.runProducer(topic, rec, kafka_connect);
		return recCreated;
		
	}
	
}
