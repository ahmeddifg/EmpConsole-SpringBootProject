package com.empconsole.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "PROJECT_SHORT_DESC")
    private String projectShortDesc;
    @Column(name = "PROJECT_TYPE")
    private int projectMainType;

    @ManyToOne( cascade = CascadeType.REFRESH)
    @MapsId("typeId")
    @JoinColumn(name = "PROJECT_TYPE", referencedColumnName = "TYPE_ID")
    private ProjectTypes projectType;

    @OneToMany( cascade = CascadeType.PERSIST)
    @MapsId("projectId")
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
    private List<ProjectRequirements> projectRequirements;

    @OneToMany( cascade = CascadeType.PERSIST)
    @MapsId("projectId")
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
    private List<ProjectTeam> projectTeam;



    public Project() {
    }

    public Project(long projectId, String projectName, String projectShortDesc, int projectMainType) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectShortDesc = projectShortDesc;
        this.projectMainType = projectMainType;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectShortDesc() {
        return projectShortDesc;
    }

    public void setProjectShortDesc(String projectShortDesc) {
        this.projectShortDesc = projectShortDesc;
    }

    public ProjectTypes getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectTypes projectType) {
        this.projectType = projectType;
    }

    public int getProjectMainType() {
        return projectMainType;
    }

    public void setProjectMainType(int projectMainType) {
        this.projectMainType = projectMainType;
    }

    public List<ProjectRequirements> getProjectRequirements() {
        return projectRequirements;
    }

    public void setProjectRequirements(List<ProjectRequirements> projectRequirements) {
        this.projectRequirements = projectRequirements;
    }

    public List<ProjectTeam> getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(List<ProjectTeam> projectTeam) {
        this.projectTeam = projectTeam;
    }
}

