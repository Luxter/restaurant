/**
 * Created by cyranl on 2015-07-13.
 */
var app = angular.module('restaurantApp', []);
app.controller('restaurantCtrl', ["$scope", "$http", "$log", function($scope, $http, $log){
    $scope.tables = [];
    tableCount = 3;
    for(var i=0; i<tableCount; i++) {
        $http.get("http://localhost:8080/gettable?id=" + (i+1))
            .success(function (response) {
                $scope.tables.push(response);
            });
    }

    $scope.payRequest = function(request){
        $log.log('PrintReceipt function');
        $http.post("http://localhost:8080/payrequest", request);
        alert("Successfully paid.")
        window.location.reload();
    }
} ] );

app.directive('svgtable', ["$http", "$log", function($http, $log){
    return{
        templateUrl: 'svg/table.html',
        link: function(scope, element, attrs){
            scope.tableClick = function($index){
                scope.tableClicked = true;
                scope.actualTableIndex = $index;
                scope.actualTableId = scope.tables[$index].id;
            }

            scope.submitSingleRequest = function(){
                tableRequests = scope.tables[scope.actualTableIndex].tableRequests;
                newRequest = [{"name": scope.mealName, "price":scope.mealPrice}];
                tableRequests.push({"type":"singleRequest", "requestItems":newRequest});
                $http.put("http://localhost:8080/addrequest", scope.tables[scope.actualTableIndex]);
                window.location.reload();
            }
        }
    }
} ] );