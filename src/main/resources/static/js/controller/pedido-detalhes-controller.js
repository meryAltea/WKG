appUsuario.controller("pedidoDetalhesController", function($scope, pedidoFactory){
	
	
	$scope.pedido= pedidoFactory.getPedido();
	
	
	
	

});