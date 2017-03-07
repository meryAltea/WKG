appWkg.controller("confirmarDadosController", function($scope,$http){
	$scope.cliente={};
	$scope.confirmarEndereco=false;
	$scope.atualizarCadastro=false;
		$http.get("/buscarPorPessoas/", {
			headers:{
				"token":localStorage.getItem("userToken")
				}
		}).then(function(response){
			
			$scope.cliente=response.data[0];
			console.log($scope.cliente);
		}, function(error) {
			window.alert(error.data.message);
			console.log("Erro");

	});
	
		
	
	
	
	
	
	
	
});