<%-- 
    Document   : index
    Created on : Jan 9, 2017, 6:31:35 AM
    Author     : snam joshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
        <link href="//cdn.rawgit.com/cornflourblue/angular-registration-login-example/master/app-content/app.css" rel="stylesheet" />
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/css/datepicker.css"/>     

        <!-- declaring the required js files here-->

        <script src="lib/angular.js" ></script>

        <script src="lib/angular-route.js"></script>
        <!--datepicker  library-->
        <script src="lib/ui-bootstrap-tpls-2.4.0.min.js"></script>
        <script src="lib/ngStorage.js"></script>
        <script src="app.js"></script>



        <!-- declaring js file  for login-->
        <script src="commons/HttpService.js"></script>
        <script src="login/loginService.js"></script>
        <script src="login/loginController.js"></script>

        <!-- declaring js file   for registration-->

        <script src="registration/registrationService.js"></script>
        <script src="registration/registrationController.js"></script>

        <!--  delclaring js   for task Lists-->

        <script src="task/taskController.js"></script>
        <script src="task/taskListService.js"></script>


        <!--      declaring js file for feature-->
        <script src="feature/featureService.js"></script>
        <script src="user/userService.js"></script>

    </head>
    <body ng-app ="taskAssigner">
        <div ng-view>
        </div>
    </body>
</html>
