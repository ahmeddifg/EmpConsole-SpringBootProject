package com.empconsole.services;

import com.empconsole.entities.ProjectRequirements;
import com.empconsole.exceptions.exceptionTypes.ProjectRequirementsNotFound;
import com.empconsole.repositories.ProjectRequirementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectRequirementService {
    private ProjectRequirementsRepository projectRequirementsRepository;

    @Autowired
    public ProjectRequirementService(ProjectRequirementsRepository projectRequirementsRepository) {
        this.projectRequirementsRepository = projectRequirementsRepository;
    }

    public List<ProjectRequirements> getProjectRequirements(long projectId) {
        return this.projectRequirementsRepository.findByProjectId(projectId);
    }

    public ProjectRequirements setProjectRequirement(ProjectRequirements projectRequirements) {
        return this.projectRequirementsRepository.save(projectRequirements);
    }

    public ProjectRequirements deleteProjectRequirement(long reqId) {
        Optional<ProjectRequirements> projectRequirements = this.projectRequirementsRepository.findById(reqId);
        projectRequirements.orElseThrow(() -> new ProjectRequirementsNotFound());
        this.projectRequirementsRepository.deleteById(reqId);
        return projectRequirements.get();
    }

    ///////////////////////////////////////////////////
    public ProjectRequirementsRepository getProjectRequirementsRepository() {
        return projectRequirementsRepository;
    }

    public void setProjectRequirementsRepository(ProjectRequirementsRepository projectRequirementsRepository) {
        this.projectRequirementsRepository = projectRequirementsRepository;
    }


}
