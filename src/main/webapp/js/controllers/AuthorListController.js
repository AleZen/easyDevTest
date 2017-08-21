// START - USED SERVICES
/*
 *	AuthorService.delete
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 *	AuthorService.list
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * AuthorService  
 */
// END - REQUIRED RESOURCES


//CRUD LIST FOR [object Object]

app.controller('AuthorListController', ['$scope', 'AuthorService',
    function ($scope, AuthorService ) {
		
    	$scope.list = AuthorService.query();
    	
}]);