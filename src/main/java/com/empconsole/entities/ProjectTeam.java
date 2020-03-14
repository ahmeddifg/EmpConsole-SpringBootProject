package com.empconsole.entities;

import com.empconsole.entities.embedded.ProjectTeamPk;

import javax.persistence.*;

@Entity
@Table(name = "project_team")
public class ProjectTeam {
    @EmbeddedId
    private ProjectTeamPk projectTeamPk;

    @Column(name = "PROJECT_ID", insertable = false, updatable = false)
    private long projectId;
    @Column(name = "EMP_ID", insertable = false, updatable = false)
    private long empId;
    @Column(name = "ROLE")
    private String role;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
    private Project project;

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

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
