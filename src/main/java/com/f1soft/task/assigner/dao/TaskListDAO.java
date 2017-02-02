
package com.f1soft.task.assigner.dao;

import com.f1soft.task.assigner.entity.Task;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
public interface TaskListDAO {
    List<Task> findAll();
    
}
