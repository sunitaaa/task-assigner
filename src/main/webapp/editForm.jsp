<%-- 
    Document   : editForm
    Created on : Jan 23, 2017, 11:13:56 PM
    Author     : sunita.joshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Registration Form </h1>
                <pre>{{taskctrl.taskList| json}}</pre>
        <form ng-submit="taskctrl.getAllUsersTask()" name="myForm">
            <table class="table table-striped">
                <tr>
                    <td> Name</td>
                    <td><input type="text" ng-model="taskctrl.taskList.name"  /></td>
                </tr>

                <tr>
                    <td>
                        Status:
                    </td>
                    <td>
                        <select ng-model="taskctrl.taskList.status">
                            <option value="">---------Select--------</option>
                            <option value="Y">Y</option>
                            <option value="N">N</option>

                        </select>
                    </td>

                </tr>

                <td>Task Name</td>
                <td><input type="text" ng-model="taskctrl.taskList.taskName"/></td>
                </tr>

                <tr>
                    <td>Task Code</td>
                    <td><input type="number" ng-model="taskctrl.taskList.taskCode"/></td>
                </tr>

                <tr>

                    <td>Feature ID</td>
                    <td>
                        <select ng-model="taskctrl.taskList.featureId">
                            <option value="">---------Select---------</option>
                            <option ng-repeat="feature in taskctrl.featureList" value="{{feature.id}}">{{feature.name}}</option>

                    </td>
                    </select>
                </tr>

                <tr>

                    <td> Assign To Id</td>
                    <td>
                        <select ng-model="taskctrl.taskList.assignToId">
                            <option value="">---------Select---------</option>
                            <option ng-repeat="user in taskctrl.userList" value="{{user.userinfoid}}">{{user.name}}</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" ng-model="taskctrl.taskList.description"/></td>
                </tr>
                <tr>
                    <td>Created Date</td>
                    <td><input type="date" ng-model="taskctrl.taskList.createdDate"/></td>
                </tr>
                <tr>
                    <td>Task Assign From Date</td>
                    <td><input type="date" ng-model="taskctrl.taskList.taskAssignfromdate"/></td>
                </tr>
                <tr>
                    <td>Task Assign To Date</td>
                    <td><input type="date" ng-model="taskctrl.taskList.taskAssigntodate"/></td>
                </tr>
                <tr>
                    <td>Task Completed Date</td>
                    <td><input type="date" ng-model="taskctrl.taskList.taskCompleteddate"/></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text"ng-model="taskctrl.taskList.title"/></td>
                </tr>
            </table>   
        </form>
        <div>

            <input type="submit" value="{{!regstController.userData.id ? 'Update': 'Add'}}" > 
            <input type="submit" value="cancel" >

        </div>
    </body>
</html>
