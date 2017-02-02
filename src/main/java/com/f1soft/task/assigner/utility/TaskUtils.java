package com.f1soft.task.assigner.utility;

import com.f1soft.task.assigner.entity.Task;
import com.f1soft.task.assigner.request.dto.TaskListRequestDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
public class TaskUtils {

    public static List<TaskListRequestDTO> convertToTaskList(List<Task> tasks) {
        List<TaskListRequestDTO> taskListRequestDTOs = new ArrayList<>();
        for (Task task : tasks) {
            TaskListRequestDTO taskListRequestDTO = new TaskListRequestDTO();
            taskListRequestDTO.setTaskid(task.getTaskid());
            taskListRequestDTO.setName(task.getName());
            taskListRequestDTO.setStatus(task.getStatus());
            taskListRequestDTO.setTaskName(task.getTaskName());
            taskListRequestDTO.setTaskCode(task.getTaskCode());
            taskListRequestDTO.setAssignToId(task.getAssignToId());
            taskListRequestDTO.setDescription(task.getDescription());
            taskListRequestDTO.setCreatedDate(task.getCreatedDate());
            taskListRequestDTO.setTaskAssignfromdate(task.getTaskAssignFromDate());
            taskListRequestDTO.setTaskAssigntodate(task.getTaskAssignToDate());  
            taskListRequestDTO.setTaskCompleteddate(task.getTaskCompleteDate());
            taskListRequestDTO.setTitle(task.getTitle());
            taskListRequestDTO.setFeatureId(task.getFeatureid().getId());
            
            taskListRequestDTOs.add(taskListRequestDTO);
        }
        return taskListRequestDTOs;
    }
    
    public static TaskListRequestDTO parseToAdminUserResponse(Task task ) {
        TaskListRequestDTO taskListRequestDTO = new TaskListRequestDTO();
        taskListRequestDTO.setTaskid(task.getTaskid());
        taskListRequestDTO.setName(task.getName());
        taskListRequestDTO.setTaskName(task.getTaskName());
        taskListRequestDTO.setTaskCode(task.getTaskCode());
        taskListRequestDTO.setAssignToId(task.getAssignToId());
        taskListRequestDTO.setDescription(task.getDescription());
        taskListRequestDTO.setCreatedDate(task.getCreatedDate());
        taskListRequestDTO.setTaskAssignfromdate(task.getTaskAssignFromDate());
        taskListRequestDTO.setTaskAssigntodate(task.getTaskAssignToDate());
        taskListRequestDTO.setTaskCompleteddate(task.getTaskCompleteDate());
        taskListRequestDTO.setTitle(task.getTitle());
        taskListRequestDTO.setFeatureId(task.getFeatureid().getId());
        return taskListRequestDTO;
    }

}
