package com.secondtonone.jk.jiraclone.domain.task.dto;

import com.secondtonone.jk.jiraclone.domain.task.Task;

public class CreateTaskRequestDto {
    private String summary;
    private String description;
    private String estimatedTime;
    private String assigneeId;
    private String creatorId;
    private String projectId;
    private String releaseId;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Task toTask() {
        return new Task();
    }
}
