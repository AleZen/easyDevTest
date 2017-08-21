// START - USED SERVICES
/*
 *	AuthorService.create
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 *	BookService.findBy_author
 *		PARAMS: 
 *					Objectid key - Id della risorsa _author da cercare
 *		
 *
 *	AuthorService.get
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
 *	AuthorService.update
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * AuthorService  
 * BookService  
 */
// END - REQUIRED RESOURCES

app.controller('AuthorEditController', ['$scope', '$location', '$routeParams', '$q', 'AuthorService', 'BookService', 'BookService',
    function ($scope, $location, $routeParams, $q, AuthorService , BookService , BookService) {

    	//manage create and save
		$scope.external = {};
		
    	if ($routeParams.id != 'new')
    	{
        	$scope.id = $routeParams.id;
        	$scope.obj = AuthorService.get({_id: $scope.id});
        	$scope.external._Book_author = BookService.findBy_author({key: $scope.id});
        	
    	}
    	else{
    		$scope.obj = new AuthorService();
        	$scope.external._Book_author = [];
        	
    	}
    	
    	$scope.save = function(){
    		$scope.obj.$save().then(function(data){
    			$scope.obj=data;
        		$location.path('/authors/');
    		});
    	}
    	
    	$scope.remove = function(){
    		AuthorService.remove({_id: $scope.obj._id}).$promise.then(function(){
				$('#removeModal').modal('hide');
				$('.modal-backdrop').remove();
				$('.modal-open').removeClass("modal-open");
        		$location.path('/authors/');
    		});
    	}
    	
    		
        //manage External relation _author
        		
    	$scope.list_Book_author = BookService.query();
    	
}]);