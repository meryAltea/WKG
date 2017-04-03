appWkg.factory('carrinhoFactory', function() {
	var carrinho = [];
	var quantidadeDeItens=0;
	var contemProdutoSelecionado=false;
	var totalFrete = 0;
	var totalDaCompra = 0;
	var total=0;
	
	carrinho.adicionarItem = function(produtoSelecionado) {
		contemProdutoSelecionado = false;
		
		if (carrinho.length > 0) {
			incrementaQuantidadeNoCarrinhoDo(produtoSelecionado);
			
		} 
		
		if (contemProdutoSelecionado == false) {
			produtoSelecionado.quantidade = 1;
			carrinho.push(produtoSelecionado);
			console.log("Novo item");
			
		}
	};
	
	var incrementaQuantidadeNoCarrinhoDo=function(produtoSelecionado){
		for (var i = 0; i < carrinho.length; i++) {
			if (carrinho[i].id == produtoSelecionado.id) {
				carrinho[i].quantidade = carrinho[i].quantidade + 1;
				console.log(carrinho);
				console.log("Repetida inserção");
				contemProdutoSelecionado = true;
			}
		}
	};
	
	var calcularTotalDeItensNoCarrinho= function(){
		quantidadeDeItens=0;
		for(var i=0; i<carrinho.length;i++){
		quantidadeDeItens+=carrinho[i].quantidade;
		}
		return quantidadeDeItens;
	};
	
	carrinho.calcularCompra = function() {
		totalDaCompra=0;
		for (var i = 0; i <carrinho.length; i++) {
			totalDaCompra += carrinho[i].preco
					* carrinho[i].quantidade;

		}
		return totalDaCompra.toFixed(2);
	};
	carrinho.calcularFrete=function(){
		
		totalFrete= totalDaCompra*0.1;
		return totalFrete.toFixed(2);
	};
	carrinho.calcularTotalDaCompra=function(){
		total=totalFrete+totalDaCompra;
		return total.toFixed(2);
	};
	
	

	carrinho.getCarrinho = function() {
		return carrinho;

	};
	carrinho.getQuantidadeDeItens= function(){
		return calcularTotalDeItensNoCarrinho();
	};
	return carrinho;
});
