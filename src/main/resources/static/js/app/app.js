'use strict'

var app = angular.module('abcApp', [ 'ui.bootstrap', 'abcApp.controllers',
                                   'abcApp.services' ]);
        app.constant("CONSTANTS", {
            greeting: "/greeting",
            createProducerData: "/createProducerData?",
            reset: "/home"    
});

        