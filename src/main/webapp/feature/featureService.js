angular.module('taskAssigner')
        .factory('featureService', featureService);

featureService.$inject=[
    'HttpService'
    
    
];


function featureService(HttpService){
    
     var vm =this;
    
     vm.resourceURI = "feature/";
     
    
    return {
        
        fetchAllFeature: function () {
            return HttpService.get(vm.resourceURI+'/getfeature');
        }
    };
}