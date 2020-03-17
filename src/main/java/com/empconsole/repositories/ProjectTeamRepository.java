package com.empconsole.repositories;

import com.empconsole.entities.ProjectTeam;
import com.empconsole.entities.embedded.ProjectTeamPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectTeamRepository extends JpaRepository<ProjectTeam, ProjectTeamPk> {
    @Query(value ="from ProjectTeam p where p.projectTeamPk.projectId = ?1" ,nativeQuery = false)
    List<ProjectTeam> queryByProjectId(long projectId);
}
