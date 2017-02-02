angular.module('taskAssigner').factory('LoginService', LoginService);

// <----INJECTION OF REQUIRED DEPENDENCIES AND SERVICES @LoginService----->
LoginService.$inject = [
    'HttpService'
];
//<------INJECTION OF REQUIRED DEPENDENCIES AND SERVCES @LoginService------>
function LoginService(HttpService) {
    return{
        login: function (loginData) {
            //console.log(JSON.stringify(loginData));
            return HttpService.post('/login', loginData)
                    .then(
                            //for success
                                    function (response) {
                                        return response;
                                    },

                            // for error
                            function (errResponse) {
                                return $q.reject(errResponse);
                            }
                            );
                        },
            }
        }


















