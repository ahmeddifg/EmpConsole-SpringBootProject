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

    @Column(name = "ASSIGNED_BY")
    private long taskOwnerId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ASSIGNED_BY", referencedColumnName = "EMP_ID", updatable = false, insertable = false)
    private EmpAccount taskOwner;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "ASSIGNED_DATE")
    private Date assignedDate;

    @Column(name = "EMP_ID")
    private Long assignedToId;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @Column(name = "Status")
    private long status;

    @Column(name = "COMPLETED_DATE")
    private Date completedDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID", updatable = false, insertable = false)
    private EmpAccount assignedTo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID", insertable = false, updatable = false)
    private Project project;

    public Task() {
    }

    public Task(long taskId, String taskDesc, String taskType, long taskOwnerId,
                Date createdDate, Date assignedDate,
                long assignedToId, long projectId, long status, Date completedDate) {
        this.taskId = taskId;
        this.taskDesc = taskDesc;
        this.taskType = taskType;
        this.taskOwnerId = taskOwnerId;
        this.createdDate = createdDate;
        this.assignedDate = assignedDate;
        this.assignedToId = assignedToId;
        this.projectId = projectId;
        this.status = status;
        this.completedDate = completedDate;
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


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getTaskOwnerId() {
        return taskOwnerId;
    }

    public void setTaskOwnerId(long taskOwnerId) {
        this.taskOwnerId = taskOwnerId;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }
}
