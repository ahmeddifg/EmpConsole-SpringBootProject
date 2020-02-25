package com.empconsole.entities;

import javax.persistence.*;

@Entity
@Table( name = "Project")
public class Project {
    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "PROJECT_SHORT_DESC")
    private String projectShortDesc;

    @ManyToOne
    @MapsId("typeId")
    @JoinColumn(name = "PROJECT_TYPE" , referencedColumnName = "TYPE_ID")
    private ProjectTypes projectType;

    public Project() {
    }

    public Project(long projectId, String projectName, String projectShortDesc, ProjectTypes projectType) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectShortDesc = projectShortDesc;
        this.projectType = projectType;
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
}
