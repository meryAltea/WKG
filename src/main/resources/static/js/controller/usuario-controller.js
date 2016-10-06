appUsuario.controller("usuarioController", function($scope, $http) {
	$scope.usuario = {};
	$scope.usuarios=[];
	
	var mostrarTodos=function(){
		$http.get("/usuarios").then (function(response){
			$scope.usuarios=response.data;	
		}, function(response){
			window.alert("Erro");
		});
	};
	$scope.salvarUsuario=function(){
		if($scope.usuario.id!=null){
			alterarUsuario();
		}else{
			cadastrarUsuario();
		}
		
	};
	var cadastrarUsuario = function() {
		if ($scope.frmUsuario.$valid){
			$http.post("/usuarios", $scope.usuario).then(function(response) {
				mostrarTodos();
				$scope.cancelar();
				$scope.frmUsuario.$setPristine(true);
			}, function(response) {
				window.alert("Erro");
	
			});
		}else {
			window.alert("Dados inválidos!");
		}
	};
	var alterarUsuario = function() {
		$http.put("/usuarios", $scope.usuario).then(function(response) {
		
		mostrarTodos();
		}, function(response) {
			window.alert("Erro");
		});

	};
	
	$scope.preparaAlterar=function(u){
		$scope.usuario=angular.copy(u);
		
		
	};
	$scope.excluirUsuario= function(){
		$http.delete("/usuarios/"+id).then(function(response){
			mostrarTodos();
			
		}, function(response){
			console.log(response.data);
			console.log(response.status);
		});
	};	
	$scope.cancelar= function(){
		$scope.usuario={};
		
	
		
	};
	mostrarTodos();

});