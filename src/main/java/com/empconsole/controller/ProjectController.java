package com.empconsole.controller;

import com.empconsole.entities.Project;
import com.empconsole.entities.ProjectRequirements;
import com.empconsole.entities.ProjectTypes;
import com.empconsole.services.ProjectRequirementService;
import com.empconsole.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = "*")
public class ProjectController {

    private ProjectService projectService;
    private ProjectRequirementService projectRequirementService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectRequirementService projectRequirementService) {
        this.projectService = projectService;
        this.projectRequirementService = projectRequirementService;
    }

    @GetMapping(value = "/auth/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable String projectId) {
        return ResponseEntity.ok(this.projectService.getProject(Long.parseLong(projectId)));
    }

    @PostMapping("/auth/set")
    public ResponseEntity<Project> setProject(@RequestBody Project project) {
        return ResponseEntity.ok(this.projectService.onSaveProject(project));
    }

    @GetMapping("/auth/all")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(this.projectService.getMyProjects());
    }

    @GetMapping("/auth/allAdmin")
    public ResponseEntity<List<Project>> getProjectsAdmin() {
        return ResponseEntity.ok(this.projectService.getMyProjectsAsAdminService());
    }

    @GetMapping("/auth/types")
    public ResponseEntity<List<ProjectTypes>> getProjectTypes() {
        return ResponseEntity.ok(this.projectService.getAllProjectTypes());
    }

    @GetMapping("/auth/req/{reqId}")
    public ResponseEntity<List<ProjectRequirements>> loadProjectRequirements(@PathVariable String reqId) {
        return ResponseEntity.ok(this.projectRequirementService.getProjectRequirements(Long.parseLong(reqId)));
    }

    @PostMapping("/auth/setReq")
    public ResponseEntity<ProjectRequirements> setProjectRequirement(@RequestBody ProjectRequirements projectRequirements) {
        return ResponseEntity.ok(this.projectRequirementService.setProjectRequirement(projectRequirements));
    }

    @DeleteMapping("/auth/delReq/{reqId}")
    public ResponseEntity<ProjectRequirements> deleteProjectRequirement(@PathVariable String reqId) {
        return ResponseEntity.ok(this.projectRequirementService.deleteProjectRequirement(Long.parseLong(reqId)));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ProjectRequirementService getProjectRequirementService() {
        return projectRequirementService;
    }

    public void setProjectRequirementService(ProjectRequirementService projectRequirementService) {
        this.projectRequirementService = projectRequirementService;
    }
}
