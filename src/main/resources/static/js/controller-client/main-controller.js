appWkg.controller("mainCtr", function($scope, $rootScope, $route, $location) {
	if(localStorage.getItem("userToken")==null){
		$rootScope.menuLogin="Login";
	}else {
		$rootScope.menuLogin="Logout";
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
