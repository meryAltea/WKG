appWkg.controller("carrinhoController", function($scope, carrinhoFactory,
		$location, $http) {
	$scope.produtos=[];
	var contemQuantDisponivel=false;
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
	
	$scope.verificarQuantidadeDisponivel= function(){
		for(var i=0; i<$scope.carrinho.length; i++){
			 if($scope.carrinho[i].quantidade>$scope.carrinho[i].quantidadeDisponivel){
				window.alert("Não tem a quantidade disponível do "+ $scope.carrinho[i].nome + "!");
				return;			
			 } 
		}
		
		$scope.verificarUsuario();
	};
	
	$scope.verificarUsuario = function() {
	
		
		if (localStorage.getItem("userToken") != null) {
			$location.path('/confirmarDados');
		} else {
			$location.path('/login');
		}
	};

	
});