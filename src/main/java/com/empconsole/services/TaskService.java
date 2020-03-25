package com.empconsole.services;

import com.empconsole.entities.EmpAccount;
import com.empconsole.entities.Task;
import com.empconsole.exceptions.exceptionTypes.TaskNotFoundException;
import com.empconsole.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService() {
    }

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> loadProjectTasksService(long projectId) {
        return this.taskRepository.findByProjectId(projectId);
    }

    public List<Task> loadMyTasksService() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EmpAccount currentPrincipalName = (EmpAccount) authentication.getPrincipal();
        return this.taskRepository.loadMyTasks(currentPrincipalName.empId);
    }

    public List<Task> loadTaskAssignedToMeService() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EmpAccount currentPrincipalName = (EmpAccount) authentication.getPrincipal();
        return this.taskRepository.loadTaskAssignedToMe(currentPrincipalName.empId);
    }

    public Task addTaskService(Task task) {
        return this.taskRepository.save(task);
    }

    public Task deleteTaskService(long taskId) {
        Optional<Task> task = this.taskRepository.findById(taskId);
        task.orElseThrow(() -> new TaskNotFoundException());
        this.taskRepository.delete(task.get());
        return task.get();
    }

    public Task assignTaskService(long taskId, long empId) {
        Optional<Task> taskOp = this.taskRepository.findById(taskId);
        taskOp.orElseThrow(() -> new TaskNotFoundException());
        Task task = taskOp.get();
        task.setStatus(1);
        task.setAssignedToId(empId);
        task.setAssignedDate(new Date());
        this.taskRepository.save(task);
        return task;
    }

    public Task unAssignTaskService(long taskId) {
        Optional<Task> taskOp = this.taskRepository.findById(taskId);
        taskOp.orElseThrow(() -> new TaskNotFoundException());
        Task task = taskOp.get();
        task.setStatus(0);
        task.setAssignedToId(null);
        task.setAssignedDate(null);
        this.taskRepository.save(task);
        return task;
    }

    public Task completeThisTaskService(Task task) {
        task.setStatus(2);
        task.setCompletedDate(new Date());
        this.taskRepository.save(task);
        return task;
    }

    public Page<Task> getAllCompletedTasksServices(int page) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EmpAccount currentPrincipalName = (EmpAccount) authentication.getPrincipal();
        Pageable pageable = PageRequest.of(page, 8, Sort.by("completedDate").descending());
        return this.taskRepository.loadCompletedTasks(currentPrincipalName.empId,pageable );
    }

//////////////////////////////////////////////////////////////////////

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


}
