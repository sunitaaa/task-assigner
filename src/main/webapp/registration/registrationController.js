angular
        .module('taskAssigner')
        .controller('RegistrationController', RegistrationController);

// <---INJECTION OF REQUIRED DEPENDECIES AND SERVICE @RegistrationController---->
RegistrationController.$inject = [
    'RegistrationService',
    '$route',
    '$rootScope',
    '$scope'
];
// <---INJECTION OF REQUIRED DEPENDECIES AND SERVICE @RegistrationController---->
function RegistrationController(RegistrationService, $route, $rootScope, $scope) {
    console.log("In Registration service");

    //<---INITIALIZING VALUE----->
    var vm = this;



    vm.userData = {
        firstName: '',
        lastName: '',
        mobileNumber: '',
        emailAddress: '',
        userName: '',
        password: '',
        role: ''
    };

    vm.users = [];
    vm.msg = '';
    vm.type = '';

    vm.fetchAllUsers = fetchAllUsers;
    vm.createUser = createUser;
    vm.updateUser = updateUser;
    vm.deleteUser = deleteUser;

    vm.edit = edit;
    vm.remove = remove;
    vm.submit = submit;
    vm.reset = reset;



// <---FUNCTION CALL START FROM HERE--->
    //fetching users

    function fetchAllUsers() {
        console.log("fetch all user");

        RegistrationService.fetchAllUsers()
                .then(
                        function (d) {
                             console.log(d);
                            vm.users = d;

                        },
                        function (errResponse) {
                            console.error("Error while fetching Users");
                        }
                );
    }

    //creating user

    function createUser() {
        RegistrationService.createUser(vm.userData)
                .then(
                        function (successReponse) {
                           // alert('User Added succesfully ');
                          console.log("Test for user");
                            fetchAllUsers();
                            reset();
                        },
                        function (errResponse) {
                            console.log(errResponse);
                            console.error('Error while creating User');
                        }
                );

    }

    //updating user

    function updateUser(userData, id) {
        RegistrationService.updateUser(userData, id)
                .then(
                        fetchAllUsers(),
                        function (errResponse) {
                            console.error('Error while updating User');
                        }
                );
        fetchAllUsers();
    }
    //delete user
    function  deleteUser(id) {
        RegistrationService.deleteUser(id)
                .then(
                        fetchAllUsers(),
                        function (errResponse) {
                            console.error('Error while deleting User');
                        }
                );
        fetchAllUsers();
    }

    //perform submit action
    function submit() {
        vm.createUser(vm.userData);
      
        vm.reset();
    }

    //getting the value for editing
    function  edit(id) {

        console.log('id to be edited', id);
        for (var i = 0; i < vm.users.length; i++) {
            if (vm.users[i].id === id) {
                vm.user = angular.copy(vm.users[i]);
                break;
            }
        }
    }
    
    
    
//deleting a user

    function remove(id) {
        console.log('id to be deleted', id);
        if (vm.userData.id === id) {
            reset();
        }
        deleteUser(id);
    }

    function reset() {
        vm.userData.firstName = '';
        vm.userData.lastName = '';
        vm.userData.mobileNumber = '';
        vm.userData.emailAddress = '';
        vm.userData.userName = '';
        vm.userData.password = '';
        vm.userData.role = '';
    }
}





