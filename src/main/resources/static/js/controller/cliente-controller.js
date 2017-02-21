appUsuario.controller("clienteController", function($http, $scope) {
	$scope.cliente = {};
	$scope.clientes = [];

	var mostrarTodos = function() {
		$http.get("/clientes").then(function(response) {
			$scope.clientes = response.data;
		}, function(response) {
			window.alert("Não foi possível buscar os clientes!!");
		});
	};

	$scope.salvarCliente = function() {
		if ($scope.cliente.id == undefined) {
			cadastrarCliente();
		} else {
			alterarCliente();
		}

	};

	cadastrarCliente = function() {
		if ($scope.frmCliente.$valid) {
			$http.post("/clientes", $scope.cliente).then(function(response) {
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
		$scope.cliente = angular.copy(a);

	};

	alterarCliente = function() {
		$http.put("/clientes").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};
		excluirCliente= function (id){
		if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/clientes/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.cliente={};
		
	};
	
	mostrarTodos();

});