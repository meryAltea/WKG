var appUsuario = angular.module("appUsuario", ['ngRoute','ui.materialize']);

appUsuario.config(function($routeProvider, $locationProvider){

$routeProvider


.when("/usuarios", {
	templateUrl : 'telas/usuario.html',
	controller : 'usuarioController'
}).when("/perfis", {
	templateUrl : 'telas/perfil.html',
	controller : 'perfilController'
}).when("/franqueados", {
	templateUrl : 'telas/franqueado.html',
	controller : 'franqueadoController'
}).when("/clientes", {
	templateUrl : 'telas/cliente.html',
	controller : 'clienteController'
}).when("/associados", {
	templateUrl : 'telas/associado.html',
	controller : 'associadoController'
}).when("/login", {
	templateUrl : 'telas/login.html',
	controller : 'loginController'
}).when("/produtos", {
	templateUrl : 'telas/produto.html',
	controller : 'produtoController'
}).when("/categorias", {
	templateUrl : 'telas/categoria.html',
	controller : 'categoriaController'
}).when("/upload/:produtoId", {
	templateUrl : 'telas/upload.html',
	controller : 'fileController'
}).otherwise({
	rediretTo : '/'
});		
$locationProvider.html5Mode(true);

}).run(function($rootScope, $location) {
    $rootScope.$on( "$routeChangeStart", function(event, next, current) {
        if (localStorage.getItem("userToken") == null) {
          // no logged user, redirect to /login
         
            $location.path("/login");
          
        }
      });
});

