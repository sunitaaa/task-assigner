<div class="col-md-6 col-md-offset-3">
    <h2>Login Form</h2>
    <form name="form" ng-submit="loginCtrl.login()" role="form">
        <div class="form-group" ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required }">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" class="form-control" ng-model="loginCtrl.loginData.user" required />
            <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
        </div>
        
        <br>
        <div class="form-group" ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control" ng-model="loginCtrl.loginData.password" required />
            <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
        </div>
        
        <div ng-if="errorMessage">{{errorMessage}}</div>
        
        
        <br>
        <div class="form-actions">
            <button type="submit" ng-disabled="form.$invalid || vm.dataLoading" class="btn btn-primary">Login</button>
            <button type="button" ng-click="loginCtrl.register()" class="btn btn-danger" >
                        Register
                    </button>          
        </div>
    </form>
</div>
