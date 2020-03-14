package com.empconsole.repositories;

import com.empconsole.entities.ProjectTeam;
import com.empconsole.entities.embedded.ProjectTeamPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectTeamRepository extends JpaRepository<ProjectTeam, ProjectTeamPk> {
    public List<ProjectTeam> findByProjectId(long projectId);
}
