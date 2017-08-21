// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

var app = angular.module('BookStore_Example_App', [
'ngRoute',
'ngResource',
'ngCookies'
]).config(function ($routeProvider) {
	
	$routeProvider
// START - ROUTE
	.when('/authors/:id', {
	  templateUrl: 'html/AuthorEdit.html',
	  resolve: {
		  AccessManager: ["AccessManager", function(AccessManager) { return AccessManager.isAuthenticated(); }]
	  },
	})
	.when('/authors', {
	  templateUrl: 'html/AuthorList.html',
	  resolve: {
		  AccessManager: ["AccessManager", function(AccessManager) { return AccessManager.isAuthenticated(); }]
	  },
	})
	.when('/books/:id', {
	  templateUrl: 'html/BookEdit.html',
	  resolve: {
		  AccessManager: ["AccessManager", function(AccessManager) { return AccessManager.isAuthenticated(); }]
	  },
	})
	.when('/books', {
	  templateUrl: 'html/BookList.html',
	  resolve: {
		  AccessManager: ["AccessManager", function(AccessManager) { return AccessManager.isAuthenticated(); }]
	  },
	})
	.when('/home', {
	  templateUrl: 'html/Home.html',
	  resolve: {
		  AccessManager: ["AccessManager", function(AccessManager) { return AccessManager.isAuthenticated(); }]
	  },
	})

// END - ROUTE

// INSERT HERE YOUR CUSTOM ROUTES
		

// DEFAULT ROUTES
	.when('/login', {
	    templateUrl: 'html/Login.html',
	    controller: 'LoginController'
	})
	.when('/logout', {
	      templateUrl: 'html/Login.html',
	      controller: 'LogoutController',
    	  resolve: {
    		  AccessManager: ["AccessManager", function(AccessManager) { return AccessManager.isAuthenticated(); }]
    	  },
	})
	.when('/', {
	      templateUrl: 'html/Home.html',
    	  resolve: {
    		  AccessManager: ["AccessManager", function(AccessManager) { return AccessManager.isAuthenticated(); }]
    	  },
	})
	.otherwise({
		templateUrl: 'html/404.html',
	});
	
});