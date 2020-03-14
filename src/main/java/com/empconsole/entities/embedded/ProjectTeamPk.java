package com.empconsole.entities.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProjectTeamPk  implements Serializable {
    @Column(name = "PROJECT_ID")
    private long projectId;
    @Column(name = "EMP_ID")
    private long empId;

    public ProjectTeamPk() {
    }

    public ProjectTeamPk(long projectId, long empId) {
        this.projectId = projectId;
        this.empId = empId;
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
}
