appWkg.controller("produtoContrClient", function($scope, $http,$routeParams){
	$scope.produto={};
	$scope.produtos=[];
	
	$scope.produtoId=$routeParams.produtoId;

	var mostrarTodos = function() {
		$http.get("/produtos").then(function(response) {
			$scope.produtos = response.data;

		}, function(response) {
			window.alert("Não foi possível exibir os produtos!");
		});

	};

	

	

	
	mostrarTodos();
	
	
});