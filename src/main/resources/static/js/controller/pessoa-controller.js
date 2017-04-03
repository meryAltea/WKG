appUsuario.controller("pessoaController", function($http, $scope) {
	$scope.pessoa = {};
	$scope.pessoas = [];
	$scope.tipoDePessoa={};
	$scope.pessoaFisica=true;
	$scope.pessoaJuridica=false;
	var url="/pessoasFisica";
	
	$scope.pf=function(){
		$scope.pessoaFisica=true;
		$scope.pessoaJuridica=false;
		$scope.tipoDePessoa=false;
		$scope.pessoa.tipoDePessoa="fisica";
		url="/pessoasFisica";
	}
	$scope.pj=function(){
		$scope.pessoaJuridica=true;
		$scope.pessoaFisica=false;
		$scope.tipoDePessoa=true;
		$scope.pessoa.tipoDePessoa="juridica";
		url="/pessoasJuridica";
	}
	var mostrarTodos = function() {
	
			$http.get("/pessoas").then(function(response) {
				$scope.pessoas = response.data;
			}, function(response) {
				window.alert("Não foi possível buscar os clientes!!");
			});
	
		
	};

	$scope.salvarPessoa = function() {
		if ($scope.pessoa.id == undefined) {
			cadastrarPessoa();
		} else {
			alterarPessoa();
		}

	};

	cadastrarPessoa = function() {
		if ($scope.frmPessoa.$valid) {
			$http.post(url, $scope.pessoa).then(function(response) {
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

	$scope.alterarPessoa = function() {
		$http.put(url).then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};
	
	$scope.excluirPessoa= function (id){
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
	
	mostrarTodos();

});