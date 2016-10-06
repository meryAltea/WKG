var appUsuario = angular.module("appUsuario", ['ngRoute']);

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
}).when("/atendentes", {
	templateUrl : 'telas/atendente.html',
	controller : 'atendenteController'
}).when("/associados", {
	templateUrl : 'telas/associado.html',
	controller : 'associadoController'
}).otherwise({
	rediretTo : '/'
});		
$locationProvider.html5Mode(true);
});