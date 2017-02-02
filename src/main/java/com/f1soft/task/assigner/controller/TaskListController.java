package com.f1soft.task.assigner.controller;

import com.f1soft.task.assigner.entity.Feature;
import com.f1soft.task.assigner.entity.Task;
import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.exception.GenericException;
import com.f1soft.task.assigner.request.dto.ErrorResponse;
import com.f1soft.task.assigner.request.dto.TaskListRequestDTO;
import com.f1soft.task.assigner.service.FeatureService;
import com.f1soft.task.assigner.service.TaskListService;
import com.f1soft.task.assigner.service.UserInfoService;
import com.f1soft.task.assigner.utility.TaskUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunita.joshi
 */
@RestController
@RequestMapping(value = "/task")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    private Task task;
    private Feature feature;
    private UserInfo userInfo;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private TaskListService taskListService1;

    @Autowired
    private UserInfoService userInfoService;

    private TaskListRequestDTO taskListRequestDTO;

    private List<Task> listofAllTasks;

    //<----ADD USER ------->
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody TaskListRequestDTO taskListRequestDTO) {
        
        //response paunu xiaan so return type void 
        System.out.println("Called::::::::::::::");
        
        // Creating object
        task = new Task();

        task.setDescription(taskListRequestDTO.getDescription());
        task.setName(taskListRequestDTO.getName());
        task.setAssignToId(taskListRequestDTO.getAssignToId());
        task.setStatus(taskListRequestDTO.getStatus());
        task.setTaskCode(taskListRequestDTO.getTaskCode());
        task.setTaskName(taskListRequestDTO.getTaskName());
        task.setTaskAssignFromDate(taskListRequestDTO.getTaskAssignfromdate());
        task.setCreatedDate(taskListRequestDTO.getCreatedDate());
        task.setTaskCompleteDate(taskListRequestDTO.getTaskCompleteddate());
        task.setTitle(taskListRequestDTO.getTitle());
        task.setTaskAssignToDate(taskListRequestDTO.getTaskAssigntodate());

        //Feature findById = featureService.findById(1L);
//         task.setFeatureid(findById);
//         task = taskListService.createTaskList(task);
    // fetching the feature id to task table 
//         <-- START OF FETCHING ID OF ONE TABLE TO OTHER--->
        feature = featureService.findFeatureById(taskListRequestDTO.getFeatureId());
        task.setFeatureid(feature);

        //<-----END OF FETCHING ID OF ONE TABLE TO OTHER----=>>
        //<---START  OF FETCHING USERID TO TASKTABLE------>
        //userInfo=userInfoService.findUserInfoById(taskListRequestDTO.getUserInfoId());              
        userInfo = userInfoService.findUserInfoById(taskListRequestDTO.getAssignToId());

        userInfo = userInfoService.findById(taskListRequestDTO.getCreatedById());
        task.setCreatedById(userInfo);
        //<----- END OF FETCHING USERID TO TASKTABLE------>
        // for Created By Id 
        // userInfo = userInfoService.findCreatedId(taskListRequestDTO.getCreatedById());
        //saving al the information in task table
        task = taskListService.saveTaskList(task);

        if (task != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {

            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.EXPECTATION_FAILED.value(),
                            HttpStatus.EXPECTATION_FAILED,
                            "User info could not be saved.",
                            "User info could not be saved."
                    )
            );
        }
    }

    //<-------LISTS ALL THE USER TASK------>
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<List<TaskListRequestDTO>> getAlluserTask() {
        listofAllTasks = taskListService.getAlluserTask();
        if (listofAllTasks.isEmpty()) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.NOT_FOUND.value(),
                            HttpStatus.NOT_FOUND,
                            "task lists not found.",
                            "task list return empty"
                    )
            );
        } else {
            // CONVERT AND ADD TO LIST.
            List<TaskListRequestDTO> listRequestDTOs = TaskUtils.convertToTaskList(listofAllTasks);
            return new ResponseEntity<>(listRequestDTOs, HttpStatus.OK);

        }

    }

//<-------LISTS ALL THE USER TASK BY ID ------>
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<TaskListRequestDTO>> getAlluserTaskById(@PathVariable("id") Long userId) {
        listofAllTasks = taskListService.getAlluserTaskById();
        if (listofAllTasks.isEmpty()) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.NOT_FOUND.value(),
                            HttpStatus.NOT_FOUND,
                            "task lists not found.",
                            "task list return empty"
                    )
            );
        } else {

            // CONVERT AND ADD TO LIST.
            List<TaskListRequestDTO> listRequestDTOs = TaskUtils.convertToTaskList(listofAllTasks);
            return new ResponseEntity<>(listRequestDTOs, HttpStatus.OK);

        }

    }

    //Getting list of data by admin or user id( if admin he can see all the data and if user he can see only his information)
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<TaskListRequestDTO>> getAlluserTaskByCreatedById(@PathVariable("id") Long userId) {
        listofAllTasks = taskListService.getAlluserTaskByCreatedById(userId);

        List<TaskListRequestDTO> listRequestDTOs = TaskUtils.convertToTaskList(listofAllTasks);
        return new ResponseEntity<>(listRequestDTOs, HttpStatus.OK);
    }

    //<----------UPDATING TASK LISTS---------->
    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TaskListRequestDTO> updateTaskLists(@RequestBody TaskListRequestDTO taskListRequestDTO,
            @PathVariable("id") Long id
    ) {
        
        //edit ko lagi  in database and table 
        Task origianlTask = taskListService.getTaskListById(id);

        if (origianlTask == null) {

            System.out.println("TaskLists with id:::::" + id + "not found");
            return new ResponseEntity<TaskListRequestDTO>(HttpStatus.NOT_FOUND);

        } else {

            Task task = new Task();
            task.setTaskid(taskListRequestDTO.getTaskid());
            task.setName(taskListRequestDTO.getName());
            task.setStatus(taskListRequestDTO.getStatus());
            task.setAssignToId(taskListRequestDTO.getAssignToId());
            task.setTaskName(taskListRequestDTO.getTaskName());
            task.setTaskCode(taskListRequestDTO.getTaskCode());
            task.setDescription(taskListRequestDTO.getDescription());
            task.setCreatedDate(taskListRequestDTO.getCreatedDate());
            task.setTaskAssignFromDate(taskListRequestDTO.getTaskAssignfromdate());
            task.setTaskAssignToDate(taskListRequestDTO.getTaskAssigntodate());
            task.setTaskCompleteDate(taskListRequestDTO.getTaskCompleteddate());
            task.setTitle(taskListRequestDTO.getTitle());
            //created by id alwz same hunx so it is set only at one time 
            task.setCreatedById(origianlTask.getCreatedById());

            feature = featureService.findFeatureById(taskListRequestDTO.getFeatureId());
            task.setFeatureid(feature);

            task.setTaskid(id);
            task = taskListService.saveTaskList(task);

            return new ResponseEntity<>(taskListRequestDTO, HttpStatus.OK);
        }

    }

    //<-----DELETE TASK LISTS-->
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TaskListRequestDTO> deleteUser(@PathVariable("id") Long id) {

        task = taskListService.getTaskListById(id);

        if (task == null) {
            System.out.println("Unable to delete user with id" + id + " not found");

            return new ResponseEntity<TaskListRequestDTO>(HttpStatus.NOT_FOUND);
        } else {
            taskListService.deleteTaskById(id);

            return new ResponseEntity<>(taskListRequestDTO, HttpStatus.OK);

        }

    }
}
