package com.empconsole.repositories;

import com.empconsole.entities.EmpAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<EmpAccount, Long> {
    List<EmpAccount> findByUserName(@Param("pUserName") String pUserName);
    List<EmpAccount> findByEmail(@Param("pEmail") String pEmail);
}
