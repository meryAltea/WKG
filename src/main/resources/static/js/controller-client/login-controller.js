appWkg.controller("loginController", function($http, $scope, $rootScope,
		$location, carrinhoFactory) {

	$scope.login = {};
	$scope.token = "";
	localStorage.removeItem("userToken");
	$rootScope.menuLogin = "Entrar";
	$scope.autenticar = function() {

		$http.post("/autenticar", $scope.login).then(function(response) {

			console.log("Sucesso" + response);
			$scope.token = response.data;
			localStorage.setItem("userToken", response.data.token);
			$rootScope.menuLogin = "Sair";
			$scope.carrinho = carrinhoFactory.getCarrinho();
			if ($scope.carrinho.length > 0) {
				$location.path('/confirmarDados');
			} else {
				$location.path('/');
			}
		}, function(response) {
			window.alert(response.data.message);

		});

		// console.log("chamou autenticar" + " " + $scope.login.nome + " " +
		// $scope.login.senha);

	};

});
