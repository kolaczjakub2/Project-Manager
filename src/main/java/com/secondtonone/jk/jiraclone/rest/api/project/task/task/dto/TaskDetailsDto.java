package com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto;

import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Priority;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Resolution;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.TaskType;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskDetailsDto {
    private String key;
    private String summary;
    private String description;
    private String estimatedTime;
    private String loggedTime;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private Status status;
    private Resolution resolution;
    private Priority priority;
    private String labels;
    private TaskType type;
    private UUID creatorId;
    private UUID assigneeId;
    private UUID projectId;
    private UUID releaseId;
    private String mainTaskKey;
    private Integer voters;
    private Integer watchers;

    public static Builder builder() {
        return new Builder();
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
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

    public String getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(String loggedTime) {
        this.loggedTime = loggedTime;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(UUID releaseId) {
        this.releaseId = releaseId;
    }


    public String getMainTaskKey() {
        return mainTaskKey;
    }

    public void setMainTaskKey(String mainTaskKey) {
        this.mainTaskKey = mainTaskKey;
    }

    public Integer getVoters() {
        return voters;
    }

    public void setVoters(Integer voters) {
        this.voters = voters;
    }

    public Integer getWatchers() {
        return watchers;
    }

    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    public static class Builder {
        private String key;
        private String summary;
        private String description;
        private String estimatedTime;
        private String loggedTime;
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;
        private Status status;
        private Resolution resolution;
        private Priority priority;
        private TaskType type;
        private UUID creatorId;
        private UUID assigneeId;
        private UUID releaseId;
        private UUID projectId;
        private String mainTaskKey;
        private Integer voters;
        private Integer watchers;

        public Builder withVoters(Integer voters) {
            this.voters = voters;
            return this;
        }

        public Builder withLastModifiedDate(LocalDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder withCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withEstimatedTime(String estimatedTime) {
            this.estimatedTime = estimatedTime;
            return this;
        }

        public Builder withLoggedTime(String loggedTime) {
            this.loggedTime = loggedTime;
            return this;
        }

        public Builder withStatus(Status status) {
            this.status = status;
            return this;
        }


        public Builder withResolution(Resolution resolution) {
            this.resolution = resolution;
            return this;
        }

        public Builder withPriority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder withTaskType(TaskType taskType) {
            this.type = taskType;
            return this;
        }

        public Builder withKey(String key) {
            this.key = key;
            return this;
        }

        public Builder withCreatorId(UUID id) {
            this.creatorId = id;
            return this;
        }

        public Builder withAssigneeId(UUID id) {
            this.assigneeId = id;
            return this;
        }

        public Builder withProjectId(UUID id) {
            this.projectId = id;
            return this;
        }

        public Builder withReleaseId(UUID id) {
            this.releaseId = id;
            return this;
        }

        public Builder withMainTask(Task mainTask) {
            if (mainTask != null) {
                this.mainTaskKey = mainTask.getKey();
            }
            return this;
        }
        public Builder withWatchers(int watchers) {
            this.watchers = watchers;
            return this;
        }

        public TaskDetailsDto build() {
            TaskDetailsDto dto = new TaskDetailsDto();
            dto.summary = this.summary;
            dto.description = this.description;
            dto.estimatedTime = this.estimatedTime;
            dto.loggedTime = this.loggedTime;
            dto.status = this.status;
            dto.resolution = this.resolution;
            dto.priority = this.priority;
            dto.type = this.type;
            dto.key = this.key;
            dto.createdDate = this.createdDate;
            dto.lastModifiedDate = this.lastModifiedDate;
            dto.creatorId = this.creatorId;
            dto.assigneeId = this.assigneeId;
            dto.projectId = this.projectId;
            dto.releaseId = this.releaseId;
            dto.mainTaskKey = this.mainTaskKey;
            dto.voters = this.voters;
            dto.watchers = this.watchers;
            return dto;
        }



    }
}
