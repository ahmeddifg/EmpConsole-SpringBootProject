package com.empconsole.entities;

import com.empconsole.entities.embedded.ProjectTeamPk;
import com.sun.istack.Nullable;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project_team")
public class ProjectTeam {
    @EmbeddedId
    private ProjectTeamPk projectTeamPk;

    @Column(name = "ROLE")
    private String role;


    @ManyToOne(cascade = CascadeType.REFRESH , fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id" , referencedColumnName = "emp_id" , updatable = false, insertable = false)
    private EmpAccount empAccount;

    //////////////////////////////////////////////////////////////
    public ProjectTeam() {
    }

    public ProjectTeam(ProjectTeamPk projectTeamPk, String role) {
        this.projectTeamPk = projectTeamPk;
        this.role = role;
    }

    public ProjectTeamPk getProjectTeamPk() {
        return projectTeamPk;
    }

    public void setProjectTeamPk(ProjectTeamPk projectTeamPk) {
        this.projectTeamPk = projectTeamPk;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public EmpAccount getEmpAccount() {
        return empAccount;
    }

    public void setEmpAccount(EmpAccount empAccount) {
        this.empAccount = empAccount;
    }

}
