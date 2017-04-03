appWkg.controller("pessoaController", function($http, $scope) {
	$scope.pessoa = {};
	$scope.pessoas = [];
	$scope.tipoDePessoa={};
	$scope.pessoaFisica=true;
	$scope.pessoaJuridica=false;
	$scope.pessoa.tipoDePessoa="fisica";
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


	$scope.salvarPessoa = function() {
		if ($scope.pessoas.id == undefined) {
			cadastrarPessoa();
		} else {
			alterarPessoa();
		}

	};

	cadastrarPessoa = function() {
		if ($scope.frmPessoa.$valid) {
			$http.post(url, $scope.pessoa).then(function(response) {
				window.alert("Cadastrado com Sucesso!");
				$scope.cancelar();
			}, function(response) {
				window.alert("Não foi possível cadastrar!!");
			});
		} else {
			window.alert("Dados inválidos!");
		}
	};


	$scope.cancelar= function(){
		$scope.pessoa={};
		
	};
	


});