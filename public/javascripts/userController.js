var userApp = angular.module('userApp', []);

userApp.controller('UserCtrl', ['$scope', '$http','$window',
    function($scope, $http,$window) {
    //$http.get('/search/' + $scope.name).success(function(data) {
    //    $scope.page = data;
    //});
        $scope.reg = function(password,name) {
            var user = new Object();
            user.username = name;
            user.password = password;
            $http({
                method: 'POST',
                url: '/user',
                data: user,
                headers: {
                    'Content-Type': 'application/json'
                }}).then(function(response){
                $scope.message = response.data;
                }).catch(function(response){
                $scope.message = response.data;
            })};
        $scope.login = function(password,name) {
            var user = new Object();
            user.username = name;
            user.password = password;
            $http({
                method: 'POST',
                url: '/login',
                data: user,
                headers: {
                    'Content-Type': 'application/json'
                }}).then(function(response){
                $window.location.href = response.data;
            }).catch(function(response){
                $scope.message = response.data;
            })};

    //$scope.orderProp = 'age';
}]);