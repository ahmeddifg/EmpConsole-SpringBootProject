package com.empconsole.repositories;

import com.empconsole.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "FROM Project a where exists" +
            " (select (1=1) from ProjectTeam b where b.projectTeamPk.projectId = a.projectId and  b.projectTeamPk.empId = ?1  )", nativeQuery = false)
    List<Project> loadMyProjects(long empId) ;
}
