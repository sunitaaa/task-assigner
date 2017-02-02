package com.f1soft.task.assigner.service.impl;

import com.f1soft.task.assigner.dao.TaskListDAO;
import com.f1soft.task.assigner.entity.Task;
import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.repository.TaskListRepository;
import com.f1soft.task.assigner.service.TaskListService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunita.joshi
 */
@Service
@Transactional
public class TaskListServiceImpl implements TaskListService {

    @Autowired
    private TaskListDAO taskListDAO;

    @Autowired
    private TaskListRepository taskListRepository;

    @Override
    public Task findTaskListByName(String name) {
        return taskListRepository.findTaskListByName(name);
    }

    @Override
    public Task createTaskList(Task task) {
        return taskListRepository.save(task);
    }

    @Override
    public Task findTaskListByTaskName(String name) {
        return taskListRepository.findTaskListByTaskName(name);
    }

    @Override
    public List<Task> getAlluserTask() {
        return taskListRepository.findAll();
    }

    @Override
    public Task saveTaskList(Task task) {
        return taskListRepository.save(task);

    }

    @Override
    public boolean isUserExists(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo findTasklistById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> updateTaskLists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Task getTaskListById(Long id) {
        return taskListRepository.findOne(id);

    }

    @Override
    public void deleteTaskById(Long id) {
        taskListRepository.delete(id);
    }

    @Override
    public List<Task> getAlluserTaskByCreatedById(Long id) {
        return taskListRepository.findTaskByCreatedId(id);
    }

    @Override
    public List<Task> getAlluserTaskById() {
        return taskListRepository.findAll();
    }

}
