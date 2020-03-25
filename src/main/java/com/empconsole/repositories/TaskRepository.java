package com.empconsole.repositories;

import com.empconsole.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    List<Task> findByProjectId(long projectId);

    @Query(value = "FROM Task where taskOwner.empId = ?1 ", nativeQuery = false)
    List<Task> loadMyTasks(long empId);

    @Query( value = "FROM Task where assignedToId = ?1 and status = 1 ",nativeQuery = false)
    List<Task> loadTaskAssignedToMe(long empId);

    @Query(value = "FROM Task t where t.taskOwner.empId = ?1 and t.status = 2 ", nativeQuery = false)
    Page<Task> loadCompletedTasks(long empId, Pageable pageable);

    @Query(value = "FROM Task t where t.taskOwner.empId = ?1 and t.status = 1 ", nativeQuery = false)
    Page<Task> loadAssignedTasks(long empId, Pageable pageable);

    @Query(value = "FROM Task t where t.taskOwner.empId = ?1 and t.status = 0 ", nativeQuery = false)
    Page<Task> loadNewTasks(long empId, Pageable pageable);


}
