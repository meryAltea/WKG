appUsuario.factory('pedidoFactory', function() {
	var pedido={};
	
	
	pedido.armazenarPedido=function(pedidoSelecionado){
		pedido=pedidoSelecionado;
	};
	
	pedido.getPedido=function(){
		return pedido;
	};
	
	return pedido;
});