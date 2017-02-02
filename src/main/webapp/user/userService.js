angular.module('taskAssigner').factory('userService', userService);

userService.$inject=[
    'HttpService'
   ];
   
   function userService(HttpService){
       
       var vm=this;
       
       vm.resourceURI="userinfo/";
       
       
      return {
        fetchAllUserId: function () {
            return HttpService.get(vm.resourceURI+'/getUserId');
        }
    };
    
    
    

}