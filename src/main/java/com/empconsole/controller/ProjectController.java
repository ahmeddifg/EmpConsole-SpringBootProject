package com.empconsole.controller;

import com.empconsole.entities.Project;
import com.empconsole.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = "*")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/auth/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<Project> getProject(@PathVariable String projectId) {
        return ResponseEntity.ok(this.projectService.getProject(Long.parseLong(projectId)));
    }

    @PostMapping("/auth/set")
    public ResponseEntity<Project> setProject(@RequestBody Project project) {
        return ResponseEntity.ok(this.projectService.onSaveProject(project));
    }


    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
}
