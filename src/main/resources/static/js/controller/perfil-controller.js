appUsuario.controller("perfilController", function($scope, $http) {
	$scope.perfil = {};
	$scope.perfis=[];
	
	 var mostrarTodos=function(){
		$http.get("perfis").then (function(response){
			$scope.perfis=response.data;	
		}, function(response){
			window.alert("Erro");
		});
	};

	$scope.salvarPerfil = function() {
		$http.post("perfis", $scope.perfil).then(function(response) {
			mostrarTodos();
			$scope.cancelar();
			$scope.frmPerfil.$setPristine(true);
		}, function(response) {
			window.alert("Erro");

		});
	};
	$scope.alterarPerfil = function() {
		$http.put("perfis", $scope.perfis).then(function(response) {
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro");
		});

	};
	
	$scope.preparaAlterar=function(u){
		$scope.perfil=angular.copy(u);
		$scope.alterarPerfil();
	};
	$scope.excluirPerfil= function(p){
		$http.delete("perfis/"+id).then(function(response){
			$scope.mostrarTodos();
			
		}, function(response){
			console.log(response.data);
			console.log(response.status);
		});
	};	
	$scope.cancelar= function(){
		$scope.perfil={};
		
	
		
	};
	mostrarTodos();

});