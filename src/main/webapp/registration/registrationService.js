angular.module('taskAssigner').factory('RegistrationService', RegistrationService);


RegistrationService.$inject = [
    'HttpService'

];
function RegistrationService(HttpService) {

    var vm = this;

    //INITIALIZATION OF RESOURCE URI
    vm.resourceURI = "user/";
    //Return resource based on uri and http method

    return {
// <----LISTING ALL USERS----->
        fetchAllUsers: function () {
            return HttpService.get(vm.resourceURI + 'user/');
        },
        //<----CREATING THE USER----->

        createUser: function (user) {
           // console.log(JSON.stringify(user));
            return HttpService.post(vm.resourceURI + 'add/', user);
        },
        //<----UPDATING THE USER------>

        updateUser: function (user, id) {
            return HttpService.put(vm.resourceURI + id, user);

        },
        //<----DELETING HTE USER----->

        deleteUser: function (id) {
            return HttpService.delete(vm.resourceURI + id);


        }
    }

}

        