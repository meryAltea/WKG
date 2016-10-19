appUsuario.controller("franqueadoController", function($http, $scope) {
	$scope.franqueado = {};
	$scope.franqueados = [];
	$scope.dataTeste= "2016-01-01";


	var mostrarTodos = function() {
		$http.get("/franqueados").then(function(response) {
			$scope.franqueados = response.data;

		}, function(response) {
			window.alert("Não foi possível exibir os franqueados!");
		});

	};
	$scope.salvarFranqueado= function(){
		if($scope.franqueado.id==undefined){
			cadastrarFranqueado();
			
		} else {
			alterarFranqueado();
		}
		
	};

	cadastrarFranqueado = function() {
		if ($scope.frmFranqueado.$valid) {
			$http.post("/franqueados", $scope.franqueado).then(function(response) {

				window.alert("Franqueado cadastrados com sucesso!!");
				$scope.cancelar();
			}, function(response) {
				window.alert("Erro ao cadastrar o franqueado!");
			});
		} else {
			window.alert("Dados inválidos!");
		}
	};

	$scope.preparaAlterar = function(f) {
		$scope.franqueado = angular.copy(f);

	};

	alterarFranqueado = function() {
		$http.put("/franqueados").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Não foi possível alterar o franqueado!")
		});
	};
	$scope.excluirFranqueado= function(){
		 if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/franqueados/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.franqueado={};
		
	};
	mostrarTodos();
});