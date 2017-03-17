appUsuario.controller("pedidoController", function($http, $scope){
	$scope.pedido={};
	$scope.pedidos=[];
	
	var mostrarTodos= function(){
		$http.get("/admin/pedidos").then (function(response){
			$scope.pedidos=response.data;
			}, function(response){	
				window.alert("Erro!!");
			});	
	};
	
	$scope.salvarPedido = function() {
		if ($scope.pedido.id == undefined) {
			$scope.cadastrarPedido();
		} else {
			$scope.alterarPedido();
		}

	};

	$scope.cadastrarPedido = function() {
//		if ($scope.frmAssociado.$valid) {
			$http.post("/admin/pedidos", $scope.associado).then(function(response) {
				window.alert("Cadastrado com Sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(response) {
				window.alert("Não foi possível cadastrar!!");
			});
//		} else {
//			window.alert("Dados inválidos!");
//		}
	};

	$scope.prepararAlterar = function(p) {
		$scope.pedido = angular.copy(p);

	};

	$scope.alterarPedido = function() {
		$http.put("/admin/pedidos").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};
	$scope.excluirPedido= function(){
		 if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/admin/pedidos/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.pedido={};
		
	};
	
	mostrarTodos();

});