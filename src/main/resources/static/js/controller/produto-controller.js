appUsuario.controller("produtoController", function($scope, $http){
	$scope.produto={};
	$scope.produtos=[];
	
//	var valor= document.getElementById("preco");
//	var result='';
//	$scope.preco='';
//	
//	$scope.moeda=function(){
//		result=$scope.preco;
//		console.log=(result);
//	}
//	var moeda =function(valor){
//	 valor=+valor.length;
//	 resultado=valor;
//	}
	var mostrarTodos = function() {
		$http.get("/admin/produtos").then(function(response) {
			$scope.produtos = response.data;

		}, function(response) {
			window.alert("Não foi possível exibir os produtos!");
		});

	};
	$scope.salvarProduto= function(){
		if($scope.produto.id==undefined){
			cadastrarProduto();
			
		} else {
			alterarProduto();
		}
		
	};

	cadastrarProduto= function() {
		//if ($scope.frmProduto.$valid) {
			$http.post("/admin/produtos", $scope.produto).then(function(response) {

				window.alert("Produto cadastrado com sucesso!!");
				$scope.cancelar();
				 mostrarTodos();
			}, function(response) {
				window.alert("Erro ao cadastrar o produto!");
			});
	//	} else {
	//		window.alert("Dados inválidos!");
	//	}
	};

	$scope.preparaAlterar = function(f) {
		$scope.produto = angular.copy(f);

	};

	alterarProduto = function() {
		$http.put("/admin/produtos").then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Não foi possível alterar o produto!")
		});
	};
	$scope.excluirProduto= function(id){
		 if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/admin/produtos/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.produto={};
		
	};
	mostrarTodos();
	
	
});