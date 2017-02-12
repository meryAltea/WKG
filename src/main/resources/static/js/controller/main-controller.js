appUsuario.controller("mainController", function($scope, $rootScope, $route, $location) {
	if(localStorage.getItem("userToken")==null){
		$rootScope.menuLogin="Login";
	}else {
		$rootScope.menuLogin="Logout";
	}
//	$rootScope.$on("$routeChangeSuccess", function(event, current, previous,
//			rejection) {
//		
//	$(document).ready(function() {
//		  //$('select').material_select();
//			
//		});

});