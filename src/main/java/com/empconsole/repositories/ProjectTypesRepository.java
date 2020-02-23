package com.empconsole.repositories;

import com.empconsole.entities.ProjectTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypesRepository extends JpaRepository<ProjectTypes, Long> {
}
