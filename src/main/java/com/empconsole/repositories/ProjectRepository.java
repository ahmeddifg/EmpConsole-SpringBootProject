package com.empconsole.repositories;

import com.empconsole.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(name = "", nativeQuery = true)
    public List<Project> loadMyProjects(String empId) ;
}
