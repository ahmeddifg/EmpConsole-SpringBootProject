package com.empconsole.services;

import com.empconsole.entities.EmpAccount;
import com.empconsole.entities.Task;
import com.empconsole.exceptions.exceptionTypes.TaskNotFoundException;
import com.empconsole.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
        return this.taskRepository.saveAndFlush(task);
    }

    public Task deleteTaskService(long taskId) {
        Optional<Task> task = this.taskRepository.findById(taskId);
        task.orElseThrow(() -> new TaskNotFoundException());
        this.taskRepository.delete(task.get());
        return task.get();
    }


//////////////////////////////////////////////////////////////////////

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
