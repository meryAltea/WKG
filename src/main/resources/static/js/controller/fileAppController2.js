appUsuario.controller('fileController', function ($scope, $routeParams,$http) {
    $scope.partialDownloadLink = 'http://localhost:8080/admin/download?nome=';
    $scope.fileName = '';
    $scope.produtoId=$routeParams.produtoId;
    $scope.imagens=[];
    $scope.imagem={};
    
    var mostrarTodos = function() {
		$http.get("/admin/imagens").then(function(response) {
			$scope.imagens = response.data;
			console.log($scope.imagens);
		}, function(response) {
			window.alert("Não foi possível exibir os produtos!");
		});
    };
	$scope.excluirImagem= function(id){
		 if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete("/admin/imagens/"+id ).then (function(){
					window.alert("Excluído com sucesso!");

					mostrarTodos();
			}, function(){
				window.alert("Não foi possível excluir!")
			});
		 }
	};
	
    $scope.uploadFile = function() {
        $scope.processDropzone();

    };

    $scope.reset = function() {
        $scope.resetDropzone();

    };
    mostrarTodos();
});

