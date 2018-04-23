'use strict'

var module = angular.module('abcApp.controllers', []);
module.controller("ABCDataController", ["$scope", "ABCDataService",
                                         
        function($scope,ABCDataService) {
            $scope.greeting = function() {
                console.log('Calling greeting Service');
                ABCDataService.greeting().then (function(value) {
                    console.log('Return from greeting service');
                    $scope.greet = value.data;
                }, function(reason) {
                    console.log("error occurred");
                }, function(value) {                    
                    console.log("no callback");
                }); 
            }
            
            $scope.createProducerData = function(kafka) {
                console.log('Calling Producer records create Service');
                var data = {
                        kTopic: kafka.kTopic,
                        nRec: kafka.nRec
                     }
                console.log(data);
                $scope.greet = "Creating record........";
                ABCDataService.createProducerData(data).then (function(value) {
                    console.log('Return from service');
                    $scope.greet = "Created " + value.data + " record(s)";
                }, function(reason) {
                    console.log("error occurred");
                }, function(value) {                    
                    console.log("no callback");
                }); 
            }
            
            $scope.reset = function() {
                console.log('Reset Called');
                ABCDataService.reset().then (function(value) {
                    $scope.greet = "";
                    $scope.kTopic = "";
                    $scope.nRec = "";
                },
                function(reason) {
                    console.log("error occurred");
                }, function(value) {                    
                    console.log("no callback");
                }); 
            }
            
        }
]);

