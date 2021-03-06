appWkg.controller("mainCtr", function($scope, $rootScope, $route, $location, $interval, carrinhoFactory) {
	
	$interval(function(){
		
		$scope.mostrarQuantItens=carrinhoFactory.getQuantidadeDeItens();
		console.log($scope.mostrarQuantItens);
	}, 2000);
	
	if(localStorage.getItem("userToken")==null){
		$rootScope.menuLogin="Entrar";
	}else {
		$rootScope.menuLogin="Sair";
	}
	$(document).ready(function() {
		$('.dropdown-button').dropdown();
		$('.button-collapse').sideNav();

		$('.slider').slider({
			indicators : false,
			interval : 3000

		});
		// Pause slider
		$('.slider').slider('pause');
		// Start slider
		$('.slider').slider('start');
		// Next slide
		$('.slider').slider('next');
		// Previous slide
		$('.slider').slider('prev');
		$('ul.tabs').tabs();

		$('ul.tabs').tabs('select_tab', 'tab_id');

	});

});
