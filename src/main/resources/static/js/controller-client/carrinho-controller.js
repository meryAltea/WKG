appWkg.controller("carrinhoController", function($scope) {
	$scope.carrinho = [];
	
	$scope.adicionarItemAoCarrinho = function(produtoSelecionado) {
		$scope.carrinho.push(produtoSelecionado);
		console.log($scope.carrinho);
	};
	var listarItens = function() {
		$scope.carrinho.push();
		console.log($scope.carrinho);
	};
	
	listarItens();

});