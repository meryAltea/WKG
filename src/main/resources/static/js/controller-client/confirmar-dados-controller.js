appWkg.controller("confirmarDadosController", function($scope,$http, carrinhoFactory){

	$scope.produtoNoCArrinho={};
	$scope.pessoa={};
	$scope.pedido={};
	$scope.tipoDePessoa={};
	$scope.produtos=[];
	$scope.confirmarEndereco=false;
	$scope.atualizarCadastro=false;
		$http.get("/pessoa/porToken", {
			headers:{
				"token":localStorage.getItem("userToken")
				}
		}).then(function(response){
			$scope.pessoa=response.data;
			$scope.verificarTipoDePessoa();
			console.log($scope.pessoa);
		}, function(error) {
			window.alert(error.data.message);
			console.log("Erro");

	});
		$scope.verificarTipoDePessoa= function(){
			if($scope.pessoa.nome==undefined){
				$scope.tipoDePessoa="juridica";
			}else{
				$scope.tipoDePessoa="fisica";
			}
		};
	
	$scope.carrinho= carrinhoFactory.getCarrinho();
	$scope.valorDoFrete= carrinhoFactory.calcularFrete();
	
	$scope.atualizarQuantidadeDosProdutos=function(){
		for(var i=0; i<$scope.carrinho.length;i++){
			$scope.produtoNoCarrinho=$scope.carrinho[i].quantidadeDisponivel -$scope.carrinho[i].quantidadeNoCarrinho;
			$scope.produtoNoCarrinho=$scope.carrinho[i].quantidadeReservada +$scope.carrinho[i].quantidadeNoCarrinho;
			
		
			
			$http.post("/produtos", $scope.produtoNoCarrinho).then(function(response) {
								
			}, function(response) {
				window.alert("Erro ao finalizar o pedido!");
			});
			
		}
	};

	$scope.salvarPedido= function(){
		$scope.pedido.produtos=$scope.carrinho;
		$scope.pedido.pessoa=$scope.pessoa;
		$scope.pedido.status="Aguardando despacho";
		if($scope.confirmarEndereco==false){
			$scope.pedido.enderecoDeEntrega=$scope.pessoa.endereco;
		};
		$scope.atualizarQuantidadeDosProdutos();
		
		$http.post("/pedidos", $scope.pedido).then(function(response) {
			window.alert("Pedido enviado com sucesso!!");
			
			
		}, function(response) {
			window.alert("Erro ao finalizar o pedido!");
		});
	
	};
	
	

	
});