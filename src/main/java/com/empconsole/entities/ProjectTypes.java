package com.empconsole.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project_types")
public class ProjectTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_ID")
    private long typeId;
    @Column(name = "PROJECT_TYPE_DESC")
    private String projectTypeDesc;

//    @OneToMany
//    @MapsId("projectType")
//    @JoinColumn(name = "TYPE_ID", referencedColumnName = "PROJECT_TYPE")
//    @Transient
//    private List<Project> projects;

    public ProjectTypes() {
    }


    public ProjectTypes(long typeId, String projectTypeDesc) {
        this.typeId = typeId;
        this.projectTypeDesc = projectTypeDesc;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }



    public String getProjectTypeDesc() {
        return projectTypeDesc;
    }

    public void setProjectTypeDesc(String projectTypeDesc) {
        this.projectTypeDesc = projectTypeDesc;
    }
}
