package com.empconsole.controller;

import com.empconsole.entities.Task;
import com.empconsole.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "*")
public class TaskController {
    private TaskService taskService;

    public TaskController() {
    }

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/auth/project/task/{projectId}")
    public List<Task> loadProjectTasks(@PathVariable String projectId) {
        return this.taskService.loadProjectTasksService(Long.parseLong(projectId));
    }

    @GetMapping("/auth/myTask")
    public List<Task> loadMyTasks() {
        return this.taskService.loadMyTasksService();
    }

    @GetMapping("/auth/assigned")
    public List<Task> loadTaskAssignedToMe() {
        return this.taskService.loadTaskAssignedToMeService();
    }

    @PostMapping("/auth/myTask")
    public Task addTask(@RequestBody Task task) {
        return this.taskService.addTaskService(task);
    }

    @DeleteMapping("/auth/myTask/{taskId}")
    Task deleteTask(@PathVariable String taskId) {
        return this.taskService.deleteTaskService(Long.parseLong(taskId));

    }


    //////////////////////////////////////////////////////////////////
    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
