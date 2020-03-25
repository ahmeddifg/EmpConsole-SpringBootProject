package com.empconsole.repositories;

import com.empconsole.entities.EmpAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<EmpAccount, Long> {
    List<EmpAccount> findByUserName(@Param("pUserName") String pUserName);

    List<EmpAccount> findByEmail(@Param("pEmail") String pEmail);

    // this function to load user account to be add to project team.
    @Query(value = "from EmpAccount e where e.empId not in" +
            " (select p.projectTeamPk.empId  from ProjectTeam p where p.projectTeamPk.projectId = ?1 )", nativeQuery = false)
    List<EmpAccount> loadAvailableAccountForProject(long projectId);

    // this function load project team, i used it to assign task to member!
    @Query(value = "from EmpAccount e where e.empId in" +
            " (select p.projectTeamPk.empId  from ProjectTeam p where p.projectTeamPk.projectId = ?1 )", nativeQuery = false)
    List<EmpAccount> loadUserAccountsInProject(long projectId);


    List<EmpAccount> findByIsActive(int i);
}
