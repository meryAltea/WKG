appWkg.controller("carrinhoController", function($scope, carrinhoFactory,
		$location) {

	$scope.carrinho = carrinhoFactory.getCarrinho();

	$scope.removerItemCarrinho = function(indiceDoProduto) {

		$scope.carrinho.splice(indiceDoProduto, 1);

	};


	$scope.calcularACompra= function(){
		
		$scope.valorDaCompra=carrinhoFactory.calcularCompra();
		$scope.valorDoFrete= carrinhoFactory.calcularFrete();
		$scope.valorTotal= carrinhoFactory.calcularTotalDaCompra();
	};

	$scope.calcularACompra();
	
	$scope.verificarUsuario = function() {

		if (localStorage.getItem("userToken") != null) {
			$location.path('/confirmarDados');
		} else {
			window.alert("É necessário logar!");
			$location.path('/login');
		}
	};

	
});