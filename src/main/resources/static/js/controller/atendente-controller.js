appUsuario.controller("atendenteController", function($http, $scope) {
	$scope.atendente = {};
	$scope.atendentes = [];

	var mostrarTodos = function() {
		$http.get("/atendentes").then(function(response) {
			$scope.atendentes = response.data;
		}, function(response) {
			window.alert("Não foi possível buscar os atendentes!!");
		});
	};

	$scope.salvarAtendente = function() {
		if ($scope.atendente.id == undefined) {
			cadastrarAtendente();
		} else {
			alterarAtendente();
		}

	};

	cadastrarAtendente = function() {
		if ($scope.frmAtendente.$valid) {
			$http.post("/atendentes", $scope.atendente).then(function(response) {
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
		$scope.atendente = angular.copy(a);

	};

	alterarAtendente = function() {
		$http.put("/atendentes").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};
	$scope.excluirAtendente= function(id){
		 if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/atendentes/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.atendente={};
		
	};
	
	mostrarTodos();

});