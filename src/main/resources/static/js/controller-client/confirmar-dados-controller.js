appWkg.controller("confirmarDadosController", function($scope,$http){
	
	
		$http.get("/clientes/", {
			headers:{
				"token":localStorage.getItem("userToken")
				}
		}).then(function(response){
			
			$scope.cliente=response.data;
			console.log($scope.cliente);
		}, function(error) {
			window.alert(error.data.message);
			console.log("Erro");

	});
	
		
	
	
	
	
	
	
	
});