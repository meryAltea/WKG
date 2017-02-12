var appWkg = angular.module("appWkg", ['ngRoute','ui.materialize']);

appWkg.config(function($routeProvider, $locationProvider){

$routeProvider


.when("/produtos", {
	templateUrl : 'telas-site/produto.html',
	controller : 'produtoContrClient'
}).when("/detalhes/:produtoId", {
	templateUrl : 'telas-site/detalhes.html',
	controller : 'produtoContrClient'	
}).when("/login", {
	templateUrl : 'telas-site/login.html',
	controller : 'loginController'	
}).when("/carrinho", {
	templateUrl : 'telas-site/carrinho.html',
	controller : 'carrinhoController'
}).otherwise({
	rediretTo : '/'
});		
$locationProvider.html5Mode(true);
//}).run(function($rootScope, $location) {
//    $rootScope.$on( "$routeChangeStart", function(event, next, current) {
//        if (localStorage.getItem("userToken") == null) {
//          // no logged user, redirect to /login
//         
//            $location.path("/login");
//          
//        }
//      });


});

