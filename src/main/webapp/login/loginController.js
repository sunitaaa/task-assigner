angular.module('taskAssigner')
        .controller('LoginController', LoginController);


// <--------INJECTION OF REQUIRED DEPENDENCIES AND SERVICES @LoginController------>
LoginController.$inject = [
    'LoginService',
    '$route',
    '$rootScope',
    '$location',
    '$localStorage'
];

//<-----INJECTION OF REQUIRED DEPENDENCIES AND SERVICES @LoginController------->



// <----LOGIN CONTROLLER MAIN FUNCTION----->
function LoginController(LoginService, $route, $rootScope, $location, $localStorage) {

    // <---INITIALIZATION OF VARIABLES---->

    var vm = this;

    //<---INTIALIZATION OF LOGIN DATA------->
    vm.loginData = {
        user: '',
        password: ''
    }
//<---INITIALIZATION OF ALERT MESSAGE---->
    vm.type = '';
    vm.msg = '';

    vm.login = login;

    vm.register = register;



    // <-----FUNCTION CALL STARTS FROM HERE----->

    // <---FUNCTION THAT HANDLES THE AUTHENCATION OF LOGIN  USER LOGIN----->

    function login() {
        LoginService.login(vm.loginData)
                .then(
                        // for returning success
                                function (response) {

                                    $localStorage.userinfoid = response.userinfoid;
                                    $localStorage.name = response.name;
                                    $localStorage.userRole = response.userRole;

                                    vm.type = 'success';
                                    vm.msg = 'Login Success';
                                    $rootScope.loggedUser = true;
                                    $location.path('/home');

                                },
                                function (errResponse) {                                                                                                                                             
                                    console.log(errResponse);
                                    vm.type = 'danger';
                                    vm.msg = errResponse.data.errorMsg;


                                }
                        );
                    }                             
            function register() {

                $location.path('/addUser');
            }
        }
