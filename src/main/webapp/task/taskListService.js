angular.module('taskAssigner')
        .factory('taskListService', taskListService);

taskListService.$inject = [
    'HttpService'

];

function taskListService(HttpService) {
    var vm = this;
    vm.resourceURI = "task/";

    return {
        getAllUsersTask: function () {
            return HttpService.get(vm.resourceURI + 'getUser/');

        },
        getAllUsersTaskById: function (id) {
            return HttpService.get(vm.resourceURI + 'tasks/' + id);

        },
        addUser: function (user) {
        

            return HttpService.post(vm.resourceURI + 'addUser/', user);
        },
        removeUser: function (id) {
            return HttpService.delete(vm.resourceURI + 'delete/' + id);
        },
        updateUser: function (taskList, id) {
            return HttpService.put(vm.resourceURI + 'update/' + id, taskList);

        }
    }
}