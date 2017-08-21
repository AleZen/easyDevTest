// START - USED SERVICES
/*
 *	BookService.delete
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 *	BookService.list
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * BookService  
 */
// END - REQUIRED RESOURCES


//CRUD LIST FOR [object Object]

app.controller('BookListController', ['$scope', 'BookService',
    function ($scope, BookService ) {
		
    	$scope.list = BookService.query();
    	
}]);