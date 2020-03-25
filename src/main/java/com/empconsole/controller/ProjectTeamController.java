package com.empconsole.controller;

import com.empconsole.entities.EmpAccount;
import com.empconsole.entities.Project;
import com.empconsole.entities.ProjectTeam;
import com.empconsole.services.ProjectTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
@CrossOrigin(origins = "*")
public class ProjectTeamController {

    private ProjectTeamService projectTeamService;

    @Autowired
    public ProjectTeamController(ProjectTeamService projectTeamService) {
        this.projectTeamService = projectTeamService;
    }

    @GetMapping("/auth/all/{projectId}")
    public ResponseEntity<List<ProjectTeam>> getProjectTeam(@PathVariable String  projectId) {
        return ResponseEntity.ok(this.projectTeamService.loadProjectTeamService(projectId));
    }


    @GetMapping("/auth/allProjectAccounts/{projectId}")
    public ResponseEntity<List<EmpAccount>> loadUserAccountsInProjectService(@PathVariable String  projectId) {
        return ResponseEntity.ok(this.projectTeamService.loadUserAccountsInProjectService(projectId));
    }
    @GetMapping("/auth/allAccounts")
    public ResponseEntity<List<EmpAccount>> loadUserAccountsService() {
        return ResponseEntity.ok(this.projectTeamService.loadUserAccountsInService());
    }

    @GetMapping("/auth/showAccountsToAdd/{projectId}")
    public ResponseEntity<List<EmpAccount>> getProjectTeamAvailableProjectMembers(@PathVariable String  projectId) {
        return ResponseEntity.ok(this.projectTeamService.getProjectTeamAvailableProjectMembersService(projectId));
    }



    @PostMapping("/auth/set")
    public ResponseEntity<ProjectTeam> setProjectTeam(@RequestBody ProjectTeam projectTeam){
        return ResponseEntity.ok(this.projectTeamService.seProjectTeamService(projectTeam));
    }

    @PostMapping("/auth/del")
    public ResponseEntity<ProjectTeam> deleteProjectTeam(@RequestBody ProjectTeam projectTeam){
        return ResponseEntity.ok(this.projectTeamService.deleteProjectTeamService(projectTeam));
    }

    public ProjectTeamService getProjectTeamService() {
        return projectTeamService;
    }

    public void setProjectTeamService(ProjectTeamService projectTeamService) {
        this.projectTeamService = projectTeamService;
    }
}
