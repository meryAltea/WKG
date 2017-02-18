appWkg.controller("carrinhoController", function($scope, carrinhoFactory) {
	$scope.totalDaCompra=0;
	$scope.carrinho = carrinhoFactory.getCarrinho();

	$scope.removerItemCarrinho = function(indiceDoProduto) {

		$scope.carrinho.splice(indiceDoProduto, 1);

	};
	$scope.calcularTotal= function(){
		for(var i=0; i<$scope.carrinho.length;i++){
			$scope.totalDaCompra+=parseFloat($scope.carrinho[i].subTotal);
			console.log($scope.totalDaCompra);
		}
	}
	$scope.calcularTotal();

});