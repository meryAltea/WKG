appUsuario.controller("atendenteController", function($http, $scope) {
	$scope.atendente = {};
	$scope.atendente = [];

	var mostrarTodos = function() {
		$http.get("/atendentes").then(function(response) {
			$scope.atendentes = response.data;
		}, function(response) {
			window.alert("Não foi possível buscar os atendentes!!");
		});
	};

	$scope.salvarAtentende = function() {
		if ($scope.atendente.id != null) {
			$scope.cadastrarAtendente();
		} else {
			$scope.alterarAtendente();
		}

	};

	$scope.cadastrarAtendente = function() {
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
		$scope.atendente = copy(a);

	};

	$scope.alterarAtendente = function() {
		$http.put("/atendentes").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};
	$scope.excluirAtendente= function(){
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