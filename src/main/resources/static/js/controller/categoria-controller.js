appUsuario.controller("categoriaController", function($scope, $http){
	$scope.categoria={};
	$scope.categorias=[];
	
	var mostrarTodos = function() {
		$http.get("/admin/categorias").then(function(response) {
			$scope.categorias = response.data;

		}, function(response) {
			window.alert("Não foi possível exibir as categorias!");
		});

	};
	$scope.salvarCategoria= function(){
		if($scope.categoria.id==undefined){
			cadastrarCategoria();
			
		} else {
			alterarCategoria();
		}
		
	};

	cadastrarCategoria = function() {
		if ($scope.frmCategoria.$valid) {
			$http.post("/admin/categorias", $scope.categoria).then(function(response) {

				window.alert("Categoria cadastrada com sucesso!!");
				$scope.cancelar();
				 mostrarTodos();
			}, function(response) {
				window.alert("Erro ao cadastrar a categoria!");
			});
		} else {
			window.alert("Dados inválidos!");
		}
	};

	$scope.preparaAlterar = function(c) {
		$scope.categoria = angular.copy(c);

	};

	alterarCategoria = function() {
		$http.put("/admin/categorias", $scope.categoria).then(function(response) {
			window.alert("Alterado com sucesso!");
			mostrarTodos();
			$scope.cancelar();
		}, function(response) {
			window.alert("Não foi possível alterar a categoria!")
		});
	};
	$scope.excluirCategoria= function(id){
		 if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/admin/categorias/"+id ).then (function(){
				window.alert("Excluído com sucesso!");
				mostrarTodos();
				$scope.cancelar();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	$scope.cancelar= function(){
		$scope.categoria={};
		
	};
	mostrarTodos();
	
	
	
	
});