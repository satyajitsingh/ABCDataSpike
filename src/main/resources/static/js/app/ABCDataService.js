'use strict'

angular.module('abcApp.services', []).factory('ABCDataService', 
		["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.greeting = function greeting(){
    	console.log('Fetching greeting');
    	var greeting = CONSTANTS.greeting;    	
    	return $http.get(greeting);
    }
    service.createProducerData = function(data) {
    	console.log('Getting createProducerRecords process');
    	var producerRecord = data.kTopic + "," + data.nRec;
        return $http.post(CONSTANTS.createProducerData,producerRecord );
    }
    service.reset = function() {
    	console.log('Reser process');
        return $http.get(CONSTANTS.reset);
    }
    return service;
}]);