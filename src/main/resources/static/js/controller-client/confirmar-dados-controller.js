appWkg.controller("confirmarDadosController", function($scope,$http, carrinhoFactory){

	$scope.pessoa={};
	$scope.pedido={};
	$scope.confirmarEndereco=false;
	$scope.atualizarCadastro=false;
		$http.get("/pessoas/", {
			headers:{
				"token":localStorage.getItem("userToken")
				}
		}).then(function(response){
			
			$scope.pessoa=response.data[0];
			console.log($scope.pessoa);
		}, function(error) {
			window.alert(error.data.message);
			console.log("Erro");

	});
	
	$scope.carrinho= carrinhoFactory.getCarrinho();
	$scope.valorDoFrete= carrinhoFactory.calcularFrete();

	$scope.salvarPedido= function(){
		$scope.pedido.produtos=$scope.carrinho;
		$scope.pedido.pessoa=$scope.pessoa;
		$http.post("/pedidos", $scope.pedido).then(function(response) {
			window.alert("Pedido enviado com sucesso!!");
			
			 mostrarTodos();
		}, function(response) {
			window.alert("Erro ao cadastrar o produto!");
		});
		
	};
	
	
	
	
});