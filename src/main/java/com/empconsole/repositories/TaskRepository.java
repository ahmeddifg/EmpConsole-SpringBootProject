package com.empconsole.repositories;

import com.empconsole.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByProjectId(long projectId);

    @Query(value = "FROM Task where taskOwner.empId = ?1 ", nativeQuery = false)
    List<Task> loadMyTasks(long empId);

    @Query( value = "FROM Task where assignedToId = ?1 ",nativeQuery = false)
    List<Task> loadTaskAssignedToMe(long empId);
}
