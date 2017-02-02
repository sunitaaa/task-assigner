<%-- 
    Document   : listUsers
    Created on : Jan 10, 2017, 9:25:59 PM
    Author     : sunita.joshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
    
    <table class="table table-striped" >
        <thead>
            <tr>
                <th>S.N.</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Email Address</th>
                <th>Mobile Number</th>
                <th>User Name</th>
                <th>Password</th>
              </tr>
        </thead>
        <tbody>
            <tr ng-repeat="u in ctrl.users.slice(((ctrl.currentPage - 1) * ctrl.itemsPerPage), ((ctrl.currentPage) * ctrl.itemsPerPage))">
                <td style="align-content: center;" >{{$index + 1}}</td>
                <td><span ng-bind="u.firstName" /></td>
                <td><span ng-bind="u.lastName" /></td>
                <td><span ng-bind="u.gender" /></td>
                <td><span ng-bind="u.emailAddress" /></td>
                <td><span ng-bind="u.mobileNumber" /></td>
                <td><span ng-bind="u.userName" /></td>
                <td><span ng-bind="u.password"/></td>
                <td><span ng-bind="u.confirmPassword"/></td>
                <td><span ng-bind="u.dob" /></td>
                <td>
                    <a uib-tooltip="Edit" ng-click="ctrl.edit(u.id)" style="cursor: pointer;margin: 0 2px;"><span class="glyphicon glyphicon-pencil" style="color:black;"></span></a>
                    <a uib-tooltip="Delete" ng-click="ctrl.deleteUser(u.id)" style="cursor: pointer;margin: 0 2px;"><span style="color:black;" class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>

                
        </tbody>
    </table>


</div>
    </body>
</html>
