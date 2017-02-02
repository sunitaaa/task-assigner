angular.module('taskAssigner', ['ngRoute', 'ui.bootstrap', 'ngStorage']);

angular.module('taskAssigner').config(function ($routeProvider) {
    $routeProvider
            .when('/login', {
                controller: 'LoginController as loginCtrl',
                templateUrl: 'login/login.jsp'
            })

            .when('/home', {
                controller: 'taskctrl as taskctrl',
                templateUrl: 'home.jsp'
            })
            .when('/registration', {
                controller: 'RegistrationController as regstController',
                templateUrl: 'registration/registration.jsp'
            })
            .when('/addUser', {
                controller: 'RegistrationController as regstController',
                templateUrl: 'view/addUser.jsp'
            })
            .when('/listUser', {
                controller: 'RegistrationController as regstController',
                templateUrl: 'view/listUsers.jsp'
            })
            .when('/editTask', {
                controller: 'taskctrl as taskctrl',
                templateUrl: 'editForm.jsp'
            })

            .when('/loginSecurity', {
                templateUrl: 'loginSecurity.jsp'
            })

            .otherwise({redirectTo: '/login'});
});

// for the login security authencation

  angular.module('taskAssigner')
        .run(function ($rootScope, $location) {
            $rootScope.$on("$routeChangeStart", function (event, next, current) {
                // alert($rootScope.loggedUser);
                if ($rootScope.loggedUser == true) {
                    //console.log("LOCATION :: " + $location.path());
                    if ($location.path() == '/home') {
                        $location.path('/home');
                    } else if ($location.path() == '/login') {
                        $location.path('/loginSecurity');
                    }

                }
            });

        });


//for login authencation redirecting to the unauthorized acces 



//   angular.module('taskAssigner')
//        .run(function ($rootScope, $location,loginService){
//          $rootScope.$on('routeChangeStart',function (event){
//              
//          if (!loginService.isLoggedIn()) {
//            console.log('DENY');
//            event.preventDefault();
//            $location.path('/login');
//        }
//        else {
//            console.log('ALLOW');
//            $location.path('/loginSecurity');
//        }
//    });  
//            
//});




