package com.secondtonone.jk.jiraclone.domain.task.dto;

import com.secondtonone.jk.jiraclone.domain.task.Task;

import java.util.UUID;

public class CreateTaskRequestDto {
    private String summary;
    private String description;
    private String estimatedTime;
    private UUID assigneeId;
    private UUID creatorId;
    private UUID releaseId;
    private UUID mainTaskId;

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

    public UUID getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(UUID assigneeId) {
        this.assigneeId = assigneeId;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UUID creatorId) {
        this.creatorId = creatorId;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(UUID releaseId) {
        this.releaseId = releaseId;
    }

    public UUID getMainTaskId() {
        return mainTaskId;
    }

    public void setMainTaskId(UUID mainTaskId) {
        this.mainTaskId = mainTaskId;
    }
}
