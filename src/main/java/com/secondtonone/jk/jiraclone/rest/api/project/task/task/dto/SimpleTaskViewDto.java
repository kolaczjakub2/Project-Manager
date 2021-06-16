package com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto;

import com.secondtonone.jk.jiraclone.domain.project.task.enums.Priority;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.TaskType;

import java.util.UUID;

public class SimpleTaskViewDto {
    private UUID id;
    private String key;
    private String summary;
    private Priority priority;
    private TaskType type;

    public static SimpleTaskViewDto buildDto(com.secondtonone.jk.jiraclone.domain.project.task.Task task) {
        return SimpleTaskViewDto.builder()
                .withId(task.getId())
                .withKey(task.getKey())
                .withSummary(task.getSummary())
                .withPriority(task.getPriority())
                .withType(task.getType())
                .build();
    }

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

    public static class Builder {
        private UUID id;
        private String key;
        private String summary;
        private Priority priority;
        private TaskType type;

        public SimpleTaskViewDto build() {
            SimpleTaskViewDto dto = new SimpleTaskViewDto();
            dto.id = this.id;
            dto.key = this.key;
            dto.summary = this.summary;
            dto.priority = this.priority;
            dto.type = this.type;
            return dto;
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
