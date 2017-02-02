package com.f1soft.task.assigner.dao.impl;

import com.f1soft.task.assigner.dao.TaskListDAO;
import com.f1soft.task.assigner.entity.Task;
import com.f1soft.task.assigner.repository.TaskListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sunita.joshi
 */
@Repository
public class TaskListDAOImpl implements TaskListDAO {

    @Autowired
    private TaskListRepository taskListRepository;

    @Override
    public List<Task> findAll() {
        return taskListRepository.findAll();
    }

}
