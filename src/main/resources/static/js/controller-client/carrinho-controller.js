appWkg.controller("carrinhoController", function($scope, carrinhoFactory,
		$location) {

	$scope.carrinho = carrinhoFactory.getCarrinho();

	$scope.removerItemCarrinho = function(indiceDoProduto) {

		$scope.carrinho.splice(indiceDoProduto, 1);

	};
	$scope.calcularTotal = function() {
		$scope.totalDaCompra = 0;
		for (var i = 0; i < $scope.carrinho.length; i++) {
			$scope.totalDaCompra += $scope.carrinho[i].preco
					* $scope.carrinho[i].quantidade;

		}
	}
	$scope.verificarUsuario = function() {

		if (localStorage.getItem("userToken") != null) {
			$location.path('/confirmarDados');
		} else {
			window.alert("É necessário logar!");
			$location.path('/login');
		}
	};
	$scope.calcularTotal();

});