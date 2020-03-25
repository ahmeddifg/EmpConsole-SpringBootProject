package com.empconsole.services;

import com.empconsole.entities.EmpAccount;
import com.empconsole.entities.Project;
import com.empconsole.entities.ProjectTeam;
import com.empconsole.entities.ProjectTypes;
import com.empconsole.entities.embedded.ProjectTeamPk;
import com.empconsole.exceptions.exceptionTypes.ProjectNameUniqueException;
import com.empconsole.exceptions.exceptionTypes.ProjectNotFoundException;
import com.empconsole.repositories.ProjectRepository;
import com.empconsole.repositories.ProjectTeamRepository;
import com.empconsole.repositories.ProjectTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    private ProjectTypesRepository projectTypesRepository;
    private ProjectTeamRepository projectTeamRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ProjectTypesRepository projectTypesRepository, ProjectTeamRepository projectTeamRepository) {
        this.projectRepository = projectRepository;
        this.projectTypesRepository = projectTypesRepository;
        this.projectTeamRepository = projectTeamRepository;
    }

    ///////////////////////////////////////////////////////////
    public Project onSaveProject(Project project) {
        Project newProject = null;
        boolean isNew = !this.projectRepository.existsById(project.getProjectId());
        try {
            newProject = this.projectRepository.save(project);
            if (isNew) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                EmpAccount currentPrincipalName = (EmpAccount) authentication.getPrincipal();
                this.projectTeamRepository.save(
                        new ProjectTeam(new ProjectTeamPk(newProject.getProjectId(), currentPrincipalName.empId), "admin"));
            }
            return newProject;
        } catch (Exception e) {
            if (e.getMessage().contains("PROJECT_NAME_UNIQUE"))
                throw new ProjectNameUniqueException(project.getProjectName());
            else e.printStackTrace();
        }
        return newProject;
    }

    public Project getProject(long projectId) {
        Optional<Project> project = this.projectRepository.findById(projectId);
        project.orElseThrow(() -> new ProjectNotFoundException()
        );
        return project.get();
    }

    public List<ProjectTypes> getAllProjectTypes() {
        return this.projectTypesRepository.findAll();
    }

    public List<Project> getMyProjects() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EmpAccount currentPrincipalName = (EmpAccount) authentication.getPrincipal();
        return this.projectRepository.loadMyProjects(currentPrincipalName.empId);
    }

    public List<Project> getMyProjectsAsAdminService() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EmpAccount currentPrincipalName = (EmpAccount) authentication.getPrincipal();
        return this.projectRepository.loadMyProjectsAsAdmin(currentPrincipalName.empId);
    }

    /////////////////////////////////////////////////////////////
    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
