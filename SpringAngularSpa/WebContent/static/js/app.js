'use strict';

var scotchApp = angular.module('myApp', ['ngRoute']);

scotchApp.config(function($routeProvider) {
	$routeProvider

		.when('/', {
			templateUrl : 'views/HomeTemplate.html',
			controller  : 'HomeController'
		})

		.when('/user', {
			templateUrl : 'views/UserTemplate.html',
			controller  : 'UserController'
		})

});