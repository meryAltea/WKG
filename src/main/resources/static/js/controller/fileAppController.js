appUsuario.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);


appUsuario.controller('uploadController', ['$http', '$scope', '$routeParams', function ($http, $scope, $routeParams) {
    $scope.imagem = {};
    $scope.imagens = [];
    $scope.produto = {};

    //buscand produto selecionado para carregar fotos
    $http.get('admin/produtos/' + $routeParams.produtoId).then(function (response) {
        $scope.produto = response.data;
    });

    //faz envio da imagem
    $scope.uploadFile = function () {
        var file = $scope.myFile;

        console.log('arquivo is ');
        console.dir(file);

        var uploadUrl = "/admin/upload/" + $routeParams.produtoId;

        var fd = new FormData();
        fd.append('file', file);

        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(function (response) {

            $scope.imagens.push(response.data)

        }, function (response) {
            window.alert("falhou ");
        })

    };

    // Buscando todas as imagens de um produto especifico
    var mostrarTodos = function () {

        $http.get("/admin/imagens/" + $routeParams.produtoId).then(function (response) {
            $scope.imagens = response.data;
            console.log($scope.imagens);
        }, function (response) {
            window.alert("Não foi possível exibir os produtos!");
        });
    };

    //Exclui imagem especifica
    $scope.excluirImagem = function (imagemId) {
        if (window.confirm("Tem certeza que deseja excluir?")) {
            $http.delete("/admin/imagens/" + imagemId).then(function () {
                mostrarTodos();
                //$scope.imagens =  removerID(imagemId, $scope.imagens )
                window.alert("Excluído com sucesso!");
            }, function () {
                window.alert("Não foi possível excluir!")
            });
        }

    };

    //Transformar em utilitario depois
    //Remove um elemento do Array por id
    var removerID = function (id, arr) {
        return arr.map(function (obj) {
            if (obj.id != id) return obj;
            else return false;
        }).filter(Boolean);
    }

    mostrarTodos();

}]);