appWkg.factory('carrinhoFactory', function() {
	var carrinho = [];

	carrinho.adicionarItem = function(produtoSelecionado) {
		var contemProdSelecionado = false;
		if (carrinho.length > 0) {

			for (var i = 0; i < carrinho.length; i++) {
				if (carrinho[i].id == produtoSelecionado.id) {
					carrinho[i].quantidade = carrinho[i].quantidade + 1;
					console.log(carrinho);
					console.log("Repetida inserção");
					contemProdSelecionado = true;
				}
			}
		} 
		if (contemProdSelecionado == false) {

			produtoSelecionado.quantidade = 1;
			carrinho.push(produtoSelecionado);
			console.log(carrinho);
			console.log("Novo item");
		}
	};

	carrinho.getCarrinho = function() {
		return carrinho;

	};

	return carrinho;
});
