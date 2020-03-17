package com.empconsole.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private long taskId;

    @Column(name = "TASK_DESC")
    private String taskDesc;

    @Column(name = "TASK_TYPE")
    private String taskType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("empId")
    @JoinColumn(name = "ASSIGNED_BY" , referencedColumnName = "EMP_ID")
    private EmpAccount taskOwner;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "ASSIGNED_DATE")
    private Date assignedDate;

    @Column(name= "EMP_ID")
    private long assignedToId;

    @Column(name = "PROJECT_ID")
    private long projectId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "EMP_ID" , referencedColumnName = "EMP_ID", updatable = false, insertable = false)
    private EmpAccount assignedTo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID" ,insertable = false ,updatable = false)
    private Project project;

    public Task() {
    }

    public Task(long taskId, String taskDesc, String taskType, EmpAccount taskOwner, Date createdDate, Date assignedDate, long assignedToId, long projectId) {
        this.taskId = taskId;
        this.taskDesc = taskDesc;
        this.taskType = taskType;
        this.taskOwner = taskOwner;
        this.createdDate = createdDate;
        this.assignedDate = assignedDate;
        this.assignedToId = assignedToId;
        this.projectId = projectId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public EmpAccount getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(EmpAccount assignedTo) {
        this.assignedTo = assignedTo;
    }

    public EmpAccount getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(EmpAccount taskOwner) {
        this.taskOwner = taskOwner;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
