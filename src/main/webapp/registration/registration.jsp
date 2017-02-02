<%-- 
    Document   : registration
    Created on : Jan 9, 2017, 7:37:33 AM
    Author     : snam joshi
--%>
<div>
    <ul>
        <li><a href="#home">Add User</a></li>
        <li><a href="#news">List Users</a></li>
    </ul>
    <h1>User Registration Form </h1>
    <form ng-submit="regstController.createUser()" name="myForm" >

        <div>
            First Name: <input type="text" ng-model="regstController.userData.firstName"
                               id="firstName" placeholder="Enter your first name" />

        </div>

        <br>
        <div>
            Last Name: <input type="text" ng-model="regstController.userData.lastName" id="lastName" placeholder="Enter your lastName">

        </div>

        <br>
        <div>
            Mobile Number:<input type="text" ng-model="regstController.userData.mobileNumber" id="mobileNumber" placeholder="Enter your mobile number" >

        </div>


        <div>
            Email Address:<input type="email"ng-model="regstController.userData.emailAddress" id="emailAddress" placeholder="Enter your email address" >

        </div>
        <br>
        <div>
            Username:<input type="text" ng-model="regstController.userData.userName" id="username" placeholder="Enter your username">
        </div>   

        <br>
        <div>
            Password: <input type="password" ng-model="regstController.userData.password" id="password" placeholder="Enter your password here">
        </div>

        <br>
        <div>
            Role: <select ng-model="regstController.userData.role">
                <option value="A">Admin</option>
                <option value="U">User</option>

            </select> 
        </div>
        <br><br>
        <input type="submit" value="submit">

    </form>

</div>