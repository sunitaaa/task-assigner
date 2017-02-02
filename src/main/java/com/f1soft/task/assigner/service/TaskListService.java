package com.f1soft.task.assigner.service;

import com.f1soft.task.assigner.entity.Task;
import com.f1soft.task.assigner.entity.UserInfo;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
public interface TaskListService {

    Task findTaskListByName(String name);

    Task createTaskList(Task task);

    Task findTaskListByTaskName(String name);

    List<Task> getAlluserTask();

    List<Task> getAlluserTaskByCreatedById(Long id);

    Task saveTaskList(Task task);

    boolean isUserExists(Long id);

    UserInfo findTasklistById(Long id);

    List<Task> updateTaskLists();

    Task getTaskListById(Long id);

    void deleteTaskById(Long id);

    List<Task> getAlluserTaskById();

   
}
