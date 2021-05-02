angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/edu/api/v1';

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/lessons',
            method: 'GET',
            params: {
                min_duration: $scope.filter ? $scope.filter.min_duration : null,
                max_duration: $scope.filter ? $scope.filter.max_duration : null,
                specialisation: $scope.filter ? $scope.filter.specialisation : null,
                topic: $scope.filter ? $scope.filter.topic : null
            }
        }).then(function (response) {
            $scope.LessonsPage = response.data;
        });
    };

    $scope.fillTable();
})
;