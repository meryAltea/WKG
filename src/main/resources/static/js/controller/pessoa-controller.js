appUsuario.controller("pessoaController", function($http, $scope) {
	$scope.pessoa = {};
	$scope.pessoas = [];
	$scope.pessoaFisica=true;
	$scope.pessoaJuridica=true;
	
//	var mostrarTodos = function() {
//		$http.get("/pessoas").then(function(response) {
//			$scope.pessoas = response.data;
//		}, function(response) {
//			window.alert("Não foi possível buscar os clientes!!");
//		});
//	};

	$scope.salvarPessoa = function() {
		if ($scope.pessoa.id == undefined) {
			cadastrarPessoa();
		} else {
			alterarPessoa();
		}

	};

	cadastrarPessoa = function() {
		if ($scope.frmPessoa.$valid) {
			$http.post("/pessoas", $scope.pessoa).then(function(response) {
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
		$scope.pessoa = angular.copy(a);

	};

	alterarPessoa = function() {
		$http.put("/pessoas").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};
		excluirPessoa= function (id){
		if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/pessoas/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.pessoa={};
		
	};
	
//	mostrarTodos();

});