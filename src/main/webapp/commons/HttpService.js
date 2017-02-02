
//common service for all the controller

angular.module('taskAssigner').factory('HttpService', HttpService);

HttpService.$inject = ['$http', '$q', '$location'];

function HttpService($http, $q, $location) {

    var vm = this;
    vm.url = $location.absUrl().split('#')[0];




    return {
        get: function (resourceURI) {
            return $http.get(vm.url + resourceURI)
                    .then(
                            function (resp) {
                                return resp.data;
                            },
                            function (err) {
                                return $q.reject(err);
                            }
                    );
        },
        post: function (resourceURI, data) {
        
            return $http.post(vm.url + resourceURI, data)
                    .then(
                            function (resp) {
                                return resp.data;
                            },
                            function (err) {
                                return $q.reject(err);
                            }
                    );
        },
        put: function (resourceURI, data) {
            alert(vm.url + resourceURI);
            return $http.put(vm.url + resourceURI, data)
                    .then(
                            function (resp) {
                                return resp.data;
                            },
                            function (err) {
                                return $q.reject(err);
                            }
                    );
        },
        delete: function (resourceURI) {
            return $http.delete(vm.url + resourceURI)
                    .then(
                            function (resp) {
                                return resp.data;
                            },
                            function (err) {
                                return $q.reject(err);
                            }
                    );
        }
    };

}

