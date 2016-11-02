appUsuario.controller("usuarioController", function($scope, $http) {
	$scope.usuario = {};
	$scope.usuarios=[];
	
	var mostrarTodos=function(){
		token=localStorage.getItem("userToken");
		
		//$http.defaults.headers.common.Authorization = 'Bearer'+ token;
		$http.get("/admin/usuarios").then (function(response){
			$scope.usuarios=response.data;	
		}, function(response){
			window.alert("Erro");
		});
	};
	$scope.salvarUsuario=function(){
		if($scope.usuario.id==undefined){
			cadastrarUsuario();
		}else{
			
			alterarUsuario();
		}
		
	};
	var cadastrarUsuario = function() {
		if ($scope.frmUsuario.$valid){
			$http.post("/admin/usuarios", $scope.usuario).then(function(response) {
				mostrarTodos();
				$scope.cancelar();
				$scope.frmUsuario.$setPristine(true);
			}, function(response) {
				window.alert("Erro");
	
			});
		}else {
			window.alert("Dados inválidos!");
		}
	};
	var alterarUsuario = function() {
		$http.put("/admin/usuarios", $scope.usuario).then(function(response) {
		$scope.cancelar();
		mostrarTodos();
		}, function(response) {
			window.alert("Erro");
		});

	};
	
	$scope.preparaAlterar=function(u){
		$scope.usuario=angular.copy(u);
		
		
	};
	$scope.excluirUsuario= function(id){
		if(window.confirm("Tem certeza que deseja excluir?")){
		$http.delete("/admin/usuarios/"+id).then(function(response){
			mostrarTodos();
			$scope.cancelar();
		}, function(response){
			console.log(response.data);
			console.log(response.status);
		});
		}
	};	
	$scope.cancelar= function(){
		$scope.usuario={};
		
	
		
	};
	mostrarTodos();

});