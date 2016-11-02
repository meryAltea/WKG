appUsuario.controller("mainController", function($scope, $rootScope, $route, $location) {
	$rootScope.menuLogin="Login";
	$rootScope.$on("$routeChangeSuccess", function(event, current, previous,
			rejection) {
		$(document).ready(function() {
		 //   $('select').material_select();
		});
	});
});