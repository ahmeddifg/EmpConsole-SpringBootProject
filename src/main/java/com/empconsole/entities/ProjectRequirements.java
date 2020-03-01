package com.empconsole.entities;

import javax.persistence.*;

@Entity
@Table(name = "project_requirements")
public class ProjectRequirements {
    @Id
    @Column(name = "req_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reqId;
    @Column(name = "req_desc")
    private String reqDesc;
    @Column(name = "req_priority")
    private int reqPriority;
    @Column(name = "project_id")
    private long projectId;

    public ProjectRequirements() {
    }

    public ProjectRequirements(long reqId, String reqDesc, int reqPriority, long projectId) {
        this.reqId = reqId;
        this.reqDesc = reqDesc;
        this.reqPriority = reqPriority;
        this.projectId = projectId;
    }

    public long getReqId() {
        return reqId;
    }

    public void setReqId(long reqId) {
        this.reqId = reqId;
    }

    public String getReqDesc() {
        return reqDesc;
    }

    public void setReqDesc(String reqDesc) {
        this.reqDesc = reqDesc;
    }

    public int getReqPriority() {
        return reqPriority;
    }

    public void setReqPriority(int reqPriority) {
        this.reqPriority = reqPriority;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
