package com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto;

import com.secondtonone.jk.jiraclone.domain.project.task.enums.Priority;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.TaskType;

import java.util.UUID;

public class SubTaskViewDto {
    private UUID id;
    private String key;
    private String summary;
    private Priority priority;
    private TaskType type;
    private String loggedTime;
    private UUID assigneeId;

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(String logTime) {
        this.loggedTime = logTime;
    }

    public UUID getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(UUID assigneeId) {
        this.assigneeId = assigneeId;
    }

    public static class Builder {
        private UUID id;
        private String key;
        private String summary;
        private Priority priority;
        private TaskType type;
        private String loggedTime;
        private UUID assigneeId;

        public SubTaskViewDto build() {
            SubTaskViewDto dto = new SubTaskViewDto();
            dto.id = this.id;
            dto.key = this.key;
            dto.summary = this.summary;
            dto.priority = this.priority;
            dto.type = this.type;
            dto.loggedTime = this.loggedTime;
            dto.assigneeId = this.assigneeId;
            return dto;
        }

        public Builder withAssigneeId(UUID id) {
            this.assigneeId = id;
            return this;
        }

        public Builder withLoggedTime(String loggedTime) {
            this.loggedTime = loggedTime;
            return this;
        }

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withKey(String key) {
            this.key = key;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withPriority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder withType(TaskType type) {
            this.type = type;
            return this;
        }
    }
}
