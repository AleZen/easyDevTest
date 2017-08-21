// START - USED SERVICES
/*
 *	BookService.create
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 *	BookService.findBy_author
 *		PARAMS: 
 *					Objectid key - Id della risorsa _author da cercare
 *		
 *
 *	BookService.get
 *		PARAMS: 
 *					ObjectId id - Id 
 *		
 *
 *	BookService.list
 *		PARAMS: 
 *		
 *
 *	BookService.strictLinkListOf_author
 *		PARAMS: 
 *					Objectid key - Id Book to link list
 *					Array list - List of linked resource
 *		
 *
 *	BookService.update
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

app.controller('BookEditController', ['$scope', '$location', '$routeParams', '$q', 'BookService', 'AuthorService',
    function ($scope, $location, $routeParams, $q, BookService , AuthorService) {

    	//manage create and save
		$scope.external = {};
		
    	if ($routeParams.id != 'new')
    	{
        	$scope.id = $routeParams.id;
        	$scope.obj = BookService.get({_id: $scope.id});
        	
    	}
    	else{
    		$scope.obj = new BookService();
        	
    	}
    	
    	$scope.save = function(){
    		$scope.obj.$save().then(function(data){
    			$scope.obj=data;
        		$location.path('/books/');
    		});
    	}
    	
    	$scope.remove = function(){
    		BookService.remove({_id: $scope.obj._id}).$promise.then(function(){
				$('#removeModal').modal('hide');
				$('.modal-backdrop').remove();
				$('.modal-open').removeClass("modal-open");
        		$location.path('/books/');
    		});
    	}
    	
    		
        //manage relation _author
        		
    	$scope.list_Author = AuthorService.query();

}]);