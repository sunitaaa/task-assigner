
<head>
    <link href="//cdn.rawgit.com/cornflourblue/angular-registration-login-example/master/app-content/app.css" rel="stylesheet"/>
</head>
<!--        <pre>{{regstController.user|json}}</pre>-->
<h1>Registration Form </h1>
<form ng-submit="regstController.createUser()" name="myForm">
    <table>
        <tr>
            <td>
                First Name: 
            </td>
            <td>
                <input type="text" class="form-control" ng-model="regstController.userData.firstName"
                       id="lastName" placeholder="Enter your last name" required="required" />
                <span ng-show="myForm.regstController.userData.$touched && myForm.regstController.userData.$invalid">First Name is required.</span>
            </td>

        </tr>
        <br><br>
        <tr>
            <td>
                Last Name: 
            </td>
            <td>
                <input type="text" class="form-control" ng-model="regstController.userData.lastName"
                       id="lastName" placeholder="Enter your last name" required="required" />
                <span ng-show="myForm.regstController.userData.$touched && myForm.regstController.userData.$invalid">Last Name is required.</span>
            </td>

        </tr>
        <br><br>
        <tr>
            <td>
                Mobile Number:
            </td>
            <td>
                <input type="text" class="form-control" ng-model="regstController.userData.mobileNumber"
                       id="mobileNumber" placeholder="Enter your mobile Number" 
                       />
                <span ng-show="myForm.regstController.userData.$touched && myForm.regstController.userData.$invalid">Mobile Number is required.</span>
            </td>

        </tr>
        <br>
        <tr>
            <td>
                Role:
            </td>
            <td>
                <select ng-model="regstController.userData.role">
                    <option value="">----Select-----</option>
                    <option value="A">Admin</option>
                    <option value="U">User</option>

                </select>
            </td>

        </tr>
        <br>

        <tr>
            <td>
                Email Address:
            </td>
            <td> <input type="email" class="form-control" ng-model="regstController.userData.emailAddress"
                        id="emailAddress" placeholder="Enter your email Address" required="required" />
                <span ng-show="myForm.regstController.userData.$touched && myForm.regstController.userData.$invalid">Email Address is required.</span>
            </td>

        </tr>
        <br>
        <tr>
            <td>
                User Name:
            </td>
            <td>
                <input type="text" class="form-control" ng-model="regstController.userData.userName"
                       id="userName" placeholder="Enter your user name" required="required" />
                <span ng-show="myForm.regstController.userData.$touched && myForm.regstController.userData.$invalid">Username  is required.</span>
            </td>

        </tr>
        <br>
        <tr>
            <td>
                Password:
            </td>
            <td> 
                <input type="password" class="form-control" ng-model="regstController.userData.password"
                       id="password" placeholder="Enter your password" required="required" />
                <span ng-show="myForm.regstController.userData.$touched && myForm.regstController.userData.$invalid">Password is required.</span>
            </td>

        </tr>
    </table>

    <div>
        <input type="submit" value="{{!regstController.userData.id ? 'Add':'Update'}}" class="btn btn-success" ng-disabled="myForm.$invalid"> 


        <span></span>
        <button type="button" ng-click="regstController.reset()" class="btn btn-danger" >
            Reset Form
        </button>
        
    </div>

</form>       
