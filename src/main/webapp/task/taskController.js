angular
        .module('taskAssigner')
        .controller('taskctrl', taskctrl);

taskctrl.$inject = [
    'taskListService',
    '$route',
    '$rootScope',
    '$scope',
    'featureService',
    'userService',
    '$location',
    '$window',
    '$localStorage'
];

function taskctrl(taskListService, $route, $rootScope, $scope, featureService,
        userService, $location, $window, $localStorage) {

    var vm = this;

    vm.taskList = {
        id: "",
        name: "",
        status: "",
        taskCode: "",
        featureId: "",
        assignToId: "",
        createdDate: "",
        description: "",
        taskAssignfromdate: "",
        taskAssigntodate: "",
        taskCompleteddate: "",
        title: "",
        createdById: ''
    };

    vm.editClicked = false;
    vm.taskLists = [];
    vm.tasks = [];
    vm.featureList = [];
    vm.userList = [];
    vm.isCreatedDateOpen = false;
    vm.isAssignFromDateOpen = false;
    vm.isAssignToDateOpen = false;
    vm.isTaskCompletedDateOpen = false;

    vm.submitUser = submitUser;
    vm.addUser = addUser;
    vm.getAllUsersTask = getAllUsersTask;
    vm.updateUser = updateUser;
    vm.editData = editData;
    vm.removeUser = removeUser;
    vm.reset = reset;

    vm.isUserRole = isUserRole;

    vm.getAllUsersTask();
    fetchAllFeature();
    fetchAllUserId();

    //<--------SUBMITTING THE USER TASK------->
    function submitUser() {
        vm.addUser(vm.taskList);
        console.log("Form is submitted");
    }

    //<----EDITING THE  TASK lISTS------>
    function editData(tasks) {
        vm.taskList.id = tasks.taskid;
        vm.taskList.name = tasks.name;
        vm.taskList.status = tasks.status;
        vm.taskList.taskCode = tasks.taskCode;
        vm.taskList.featureId = tasks.featureId + '';
        vm.taskList.assignToId = tasks.assignToId + '';
        vm.taskList.description = tasks.description;
        vm.taskList.createdDate = tasks.createdDate;
        vm.taskList.taskAssignfromdate = tasks.taskAssignfromdate;
        vm.taskList.taskAssigntodate = tasks.taskAssigntodate;
        vm.taskList.taskCompleteddate = tasks.taskCompleteddate;
        vm.taskList.title = tasks.title;
        vm.editClicked = true;
    }

    // <--------- ADDING THE TASKLISTS---------->

    function addUser() {
        console.log(vm.taskList);
        vm.taskList.createdById = $localStorage.userinfoid;
        taskListService.addUser(vm.taskList)
                .then(
                        function (successReponse) {
                            console.log("Test for user");
                            getAllUsersTask();
                        },
                        function (errResponse) {
                            alert("Error");
                            console.log(errResponse);
                            console.error('Error while creating User');
                        }
                );
    }

    //<-------GETTING ALL THE USER TASKS BY ADMIN OR USER----->

    function getAllUsersTask() {
        if ($localStorage.userRole == 'A') {
            taskListService.getAllUsersTask()
                    .then(
                            //for success
                                    function (d) {
                                        console.log(d);
                                        vm.tasks = d;
                                    },
                                    //for error 
                                            function (errResponse) {
                                                console.error("Error while getting Users");
                                            }
                                    );
                                } else {
                            taskListService.getAllUsersTaskById($localStorage.userinfoid)
                                    .then(
                                            function (response) {

                                                vm.tasks = response;

                                                console.log("success");
                                            },
                                            function (errResponse) {
                                                console.log("Error while getting user By Id ");
                                            }

                                    );
                        }
                    }

            //<-------UPDATING THE USER------->

            function updateUser() {

                taskListService.updateUser(vm.taskList, vm.taskList.id)
                        .then(
                                function (response) {

                                    console.log("updating");
                                    getAllUsersTask();
                                    vm.editClicked = false;
                                },
                                function (errResponse) {
                                    console.error('Error while updating User');
                                }

                        );
                getAllUsersTask();
            }




            function fetchAllFeature() {
                featureService.fetchAllFeature()
                        .then(
                                function (data) {

                                    vm.featureList = data;
                                    console.log(data);
                                },
                                function (err) {
                                    console.log(err);
                                }
                        );
            }

            function fetchAllUserId() {
                userService.fetchAllUserId()
                        .then(
                                function (data) {
                                    vm.userList = data;
                                    console.log(data);
                                },
                                function (err) {
                                    console.log(err);
                                }
                        );
            }

            // <-------DELETING USER BY ID-------->

            function removeUser(id) {
                taskListService.removeUser(id)
                        .then(
                                function () {

                                    getAllUsersTask();
                                },
                                function (err) {
                                    console.log(err);
                                }
                        );
            }

            // <-------RESETING ALL THE DATA OF USER-------->
            function reset() {

                vm.taskList.id = '';
                vm.taskList.name = '';
                vm.taskList.status = '';
                vm.taskList.taskCode = '';
                vm.taskList.featureId = '';
                vm.taskList.assignToId = '';
                vm.taskList.description = '';
                vm.taskList.createdDate = '';
                vm.taskList.taskAssigntodate = '';
                vm.taskList.taskCompleteddate = '';
                vm.taskList.taskAssignfromdate = '';
                vm.taskList.title = '';
            }
   // function to disable edit and delete button  for user
            function isUserRole() {
                if ($localStorage.userRole == 'U') {
                    return true;
                }
                return false;
            }

        }