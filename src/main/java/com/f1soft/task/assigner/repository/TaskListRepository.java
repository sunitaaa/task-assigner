package com.f1soft.task.assigner.repository;

import com.f1soft.task.assigner.entity.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author sunita.joshi
 */
public interface TaskListRepository extends JpaRepository<Task, Long> {

    Task findTaskListByName(String name);

    Task findTaskListByTaskName(String name);

    @Query("SELECT t FROM Task t where t.createdById.userinfoid=:id")
    List<Task> findTaskByCreatedId(@Param("id") Long id);

}
