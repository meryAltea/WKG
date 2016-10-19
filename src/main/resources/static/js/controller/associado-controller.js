appUsuario.controller("associadoController", function($http, $scope){
	$scope.associado={};
	$scope.associados=[];
	
	var mostrarTodos= function(){
		$http.get("/associados").then (function(response){
			$scope.associados=response.data;
			}, function(response){	
				window.alert("Erro!!");
			});	
	};
	
	$scope.salvarAssociado = function() {
		if ($scope.associado.id == undefined) {
			$scope.cadastrarAssociado();
		} else {
			$scope.alterarAssociado();
		}

	};

	$scope.cadastrarAssociado = function() {
		if ($scope.frmAssociado.$valid) {
			$http.post("/associados", $scope.associado).then(function(response) {
				window.alert("Cadastrado com Sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(response) {
				window.alert("Não foi possível cadastrar!!");
			});
		} else {
			window.alert("Dados inválidos!");
		}
	};

	$scope.prepararAlterar = function(a) {
		$scope.associado = angular.copy(a);

	};

	$scope.alterarAssociado = function() {
		$http.put("/associados").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};
	$scope.excluirAssociado= function(){
		 if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/associados/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.associado={};
		
	};
	
	mostrarTodos();

});