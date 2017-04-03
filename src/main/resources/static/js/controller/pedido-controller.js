appUsuario.controller("pedidoController", function($http, $scope,$location, pedidoFactory){
	$scope.pedido={};
	$scope.pedidos=[];
	$scope.tipoDePessoa={};
	$scope.pessoa={};
	$scope.status=false;
	
	console.log("status"+$scope.status);
	console.log("status com negação"+!$scope.status);
	
	var mostrarTodos= function(){
		$http.get("/pedidos").then (function(response){
			
			$scope.pedidos=response.data;

			}, function(response){	
				window.alert("Erro!!");
			});	
	};
	
	$scope.mostrarPedido=function(pedidoSelecionado){
		pedidoFactory.armazenarPedido(pedidoSelecionado);
		$location.path("/pedidos/detalhes");
		
	};
	



	$scope.cadastrarPedido = function() {
//		if ($scope.frmAssociado.$valid) {
			$http.post("/pedidos", $scope.pedido).then(function(response) {
				window.alert("Alterado com Sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(response) {
				window.alert("Não foi possível alterar!!");
			});
//		} else {
//			window.alert("Dados inválidos!");
//		}
	};
	$scope.alterarPedido = function(ped) {
		$http.put("/pedidos", ped ).then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Erro ao alterar!")
		});
	};


	$scope.editarStatus = function() {
		$scope.status=true;
		alert("Editar status");
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