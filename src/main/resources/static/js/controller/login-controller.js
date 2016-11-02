appUsuario.controller("loginController", function($http, $scope, $rootScope,$location) {

	$scope.login = {};
	$scope.token = "";
	localStorage.removeItem("userToken");
	$rootScope.menuLogin="Login";
	$scope.autenticar = function() {

		$http.post("/autenticar", $scope.login).then(function(response) {
			$location.path('/')
			console.log("Sucesso" + response);
			$scope.token = response.data;
			localStorage.setItem("userToken", response.data.token);
			
			$rootScope.menuLogin="Logout";
		}, function(response) {
			console.log("Faha" + response);

		});

		// console.log("chamou autenticar" + " " + $scope.login.nome + " " +
		// $scope.login.senha);

	};

});
