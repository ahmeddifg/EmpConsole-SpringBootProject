package com.empconsole.repositories;

import com.empconsole.entities.Project;
import com.empconsole.entities.ProjectRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRequirementsRepository extends JpaRepository<ProjectRequirements, Long> {
    List<ProjectRequirements> findByProjectId(long projectId);
}
