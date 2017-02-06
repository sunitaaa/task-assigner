<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//cdn.rawgit.com/cornflourblue/angular-registration-login-example/master/app-content/app.css" rel="stylesheet">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/css/datepicker.css">
    </head>
    <body ng-app="taskAssigner">
        <!--    <pre>{{taskctrl.tasks}}</pre>-->
        <h1>Task Lists</h1>
        <!--    <pre>{{taskList}}</pre>-->
        <table class="table table-striped" border="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Status</th>      
                <!--                <th>Task Name</th>-->
                <th>Task Code</th>
                <th>Feature ID</th>

                <td>Assign To Id</td>
                <th>Description</th>          
                <th>Task Assign From Date</th>
                <th>Task Assign To Date</th>
                <th>Task Completed Date</th>
                <th>Title</th>
                <th>Actions</th>
            </tr>
            <tr data-ng-repeat="taskList in taskctrl.tasks">
                <td>{{taskList.taskid}}</td>
                <td>{{taskList.name}}</td>
                <td>{{taskList.status}}</td>                    
                <td>{{taskList.taskCode}}</td>
                <td>{{taskList.featureId}}</td>
                <td>{{taskList.assignToId}}</td>
                <td>{{taskList.description}}</td>                           
                <td>{{taskList.taskAssignfromdate|date}}</td>
                <td>{{taskList.taskAssigntodate|date}}</td>
                <td>{{taskList.taskCompleteddate|date}}</td>
                <td>{{taskList.title}}</td>          

                <td>
                    <button type="button" ng-disabled="taskctrl.isUserRole()"  ng-click="taskctrl.editData(taskList)" class="btn btn-success"  >Edit</button>   

                    <button type="button" ng-disabled="taskctrl.isUserRole()"ng-click="taskctrl.removeUser(taskList.taskid)" class="btn btn-danger" >Delete</button>
                </td>
            </tr>
        </table>

        <h2>Add/Edit User Task</h2>

        <!--            <pre>{{taskctrl.taskList|json}}</pre>-->

        <!--        <pre>{{taskctrl.userList[0]|json}}</pre>-->


        <!--             <pre>{{taskctrl.createdList[0]|json}}</pre>-->

        <form ng-submit="taskctrl.addUser()" name="myForm">
            <table>
                <tr>
                    <td>Id</td>
                    <td> 
                        <div class="col-md-12">
                            <span>{{taskctrl.taskList.id}}</span></div></td>  
                </tr>
                <tr>
                    <td> Name</td>
                    <td>
                        <div class="col-md-12">
                            <input type="text" ng-model="taskctrl.taskList.name"  /></div></td>
                </tr>
                <tr>
                    <td>
                        Status:
                    </td>
                    <td><div class="col-md-12">
                            <select ng-model="taskctrl.taskList.status">
                                <option value="">-----------Select------------</option>
                                <option value="Y">Y</option>
                                <option value="N">N</option>

                            </select></div>
                    </td>

                </tr>
                </div>              
                <tr>
                    <td>Task Code</td>
                    <td>
                        <div class="col-md-12">
                        <input type="text" ng-model="taskctrl.taskList.taskCode"/></td></div>
                </tr>

                <tr>
                    <td>Feature ID</td>
                    <td><div class="col-md-12">
                            <select ng-model="taskctrl.taskList.featureId">
                                <option value="">-----------Select----------</option>
                                <option ng-repeat="feature in taskctrl.featureList" value="{{feature.id}}">{{feature.name}}</option>

                            </select>
                    </td></div>
                </tr>
                <tr>

                    <td> Assign To Id</td>
                    <td><div class="col-md-12">
                            <select ng-model="taskctrl.taskList.assignToId">
                                <option value="">----------Select-------</option>
                                <option ng-repeat="user in taskctrl.userList" value="{{user.userinfoid}}">{{user.name}}</option>
                            </select>

                    </td></div>
                </tr>
                </div>

                <tr>
                    <td>Description</td>
                    <td>
                        <div class="col-md-12">
                            <input type="text" ng-model="taskctrl.taskList.description"/></div></td>
                </tr>

                <tr>
                    <td>Created Date</td>

                    <td>
                        <div class="col-md-12">
                            <p class="input-group">
                                <input type="text" class="form-control" uib-datepicker-popup ng-model="taskctrl.taskList.createdDate" is-open="taskctrl.isCreatedDateOpen" ng-required="true" close-text="Close" />
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default" ng-click="taskctrl.isCreatedDateOpen = !taskctrl.isCreatedDateOpen"><i class="glyphicon glyphicon-calendar"></i></button>
                                </span>
                            </p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Task Assign From Date</td>

                    <td>
                        <div class="col-md-12">
                            <p class="input-group">
                                <input type="text" class="form-control" uib-datepicker-popup ng-model="taskctrl.taskList.taskAssignfromdate" is-open="taskctrl.isAssignFromDateOpen" ng-required="true" close-text="Close" />
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default" ng-click="taskctrl.isAssignFromDateOpen = !taskctrl.isAssignFromDateOpen"><i class="glyphicon glyphicon-calendar"></i></button>
                                </span>
                            </p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Task Assign To Date</td>

                    <td>
                        <div class="col-md-12">
                            <p class="input-group">
                                <input type="text" class="form-control" uib-datepicker-popup ng-model="taskctrl.taskList.taskAssigntodate" is-open="taskctrl.isAssignToDateOpen" ng-required="true" close-text="Close" />
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default" ng-click="taskctrl.isAssignToDateOpen = !taskctrl.isAssignToDateOpen"><i class="glyphicon glyphicon-calendar"></i></button>
                                </span>
                            </p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Task Completed Date</td>
                    <td>
                        <div class="col-md-12">
                            <p class="input-group">
                                <input type="text" class="form-control" uib-datepicker-popup ng-model="taskctrl.taskList.taskCompleteddate" is-open="taskctrl.isTaskCompletedDateOpen" ng-required="true" close-text="Close" />
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default" ng-click="taskctrl.isTaskCompletedDateOpen = !taskctrl.isTaskCompletedDateOpen"><i class="glyphicon glyphicon-calendar"></i></button>
                                </span>
                            </p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><div class="col-md-12">
                            <input type="text"ng-model="taskctrl.taskList.title"/>
                        </div>
                    </td>
                </tr>
            </table>
            <br>
            <div  style="width:300%; height:100%" ng-hide="taskctrl.editClicked">
                <input type="submit" value="submit" class="btn btn-success" ng-disabled="myForm.$invalid" >
                <span></span>
                <button type="button" ng-click="taskctrl.reset()" class="btn btn-danger"  >
                    Reset
                </button>

            </div>
            <div  style="width:300%; height:100%" ng-show="taskctrl.editClicked">
                <input type="button" value="Update" class="btn btn-success"
                       ng-click="taskctrl.updateUser()"
                       ng-disabled="myForm.$invalid" >
                <span></span>
                <button type="button" ng-click="taskctrl.reset()" class="btn btn-danger"  >
                    Cancel
                </button>

            </div>

        </form>
    </body>
</html>
</body>
</html>

