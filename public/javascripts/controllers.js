var movieApp = angular.module('movieApp', []);

movieApp.controller('MovieListCtrl', ['$scope', '$http',
    function($scope, $http) {
    //$http.get('/search/' + $scope.name).success(function(data) {
    //    $scope.page = data;
    //});

    $scope.update = function(name) {
        $http.get('/search/' + name).success(function(data){
            $scope.movies = data;
        })};

        $scope.addMovie = function(movie) {
            $http({
                method: 'POST',
                url: '/addmovie',
                data: movie.id,
                headers: {
                    'Content-Type': 'text/plain'
                }}); {
            }};


    //$scope.orderProp = 'age';
}]);