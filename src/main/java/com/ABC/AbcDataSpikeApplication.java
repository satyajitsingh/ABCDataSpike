package com.ABC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.ABC.controller.ABCDataController;

@SpringBootApplication
public class AbcDataSpikeApplication {

	private final static Logger slf4jLogger = LoggerFactory.getLogger(AbcDataSpikeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AbcDataSpikeApplication.class, args);
	}
}
