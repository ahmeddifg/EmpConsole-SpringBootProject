package com.empconsole.services;

import com.empconsole.entities.EmpAccount;
import com.empconsole.entities.ProjectTeam;
import com.empconsole.repositories.ProjectTeamRepository;
import com.empconsole.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTeamService {
    private ProjectTeamRepository projectTeamRepository;
    private UserRepository userRepository;

    @Autowired
    public ProjectTeamService(ProjectTeamRepository projectTeamRepository, UserRepository userRepository) {
        this.projectTeamRepository = projectTeamRepository;
        this.userRepository = userRepository;
    }


    public List<ProjectTeam> loadProjectTeamService(String projectId) {
        return this.projectTeamRepository.queryByProjectId(Long.parseLong(projectId));
    }

    public List<EmpAccount> loadUserAccountsInProjectService(String projectId) {
        List<EmpAccount> list = this.userRepository.loadUserAccountsInProject(Long.parseLong(projectId));
        return list;
    }

    public ProjectTeam seProjectTeamService(ProjectTeam projectTeam) {
        ProjectTeam projectTeam1 = this.projectTeamRepository.saveAndFlush(projectTeam);
        return projectTeam1;
    }

    public ProjectTeam deleteProjectTeamService(ProjectTeam projectTeam) {
        this.projectTeamRepository.delete(projectTeam);
        return projectTeam;
    }


    public List<EmpAccount> getProjectTeamAvailableProjectMembersService(String projectId) {
        return this.userRepository.loadAvailableAccountForProject(Long.parseLong(projectId));
    }

    public List<EmpAccount> loadUserAccountsInService() {
        return this.userRepository.findByIsActive(1);
    }


    //////////////////////////////////////////////////

    public ProjectTeamRepository getProjectTeamRepository() {
        return projectTeamRepository;
    }

    public void setProjectTeamRepository(ProjectTeamRepository projectTeamRepository) {
        this.projectTeamRepository = projectTeamRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
