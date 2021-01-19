package com.secondtonone.jk.jiraclone.application.project.dto;

import java.util.UUID;

public class SelectProjectDto {

    private UUID projectId;
    private String name;
    private String description;
    private String code;

    public static Builder builder() {
        return new Builder();
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static final class Builder {
        private UUID projectId;
        private String name;
        private String description;
        private String code;

        public SelectProjectDto.Builder withProjectId(UUID projectId) {
            this.projectId = projectId;
            return this;
        }

        public SelectProjectDto.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public SelectProjectDto.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public SelectProjectDto.Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public SelectProjectDto build() {
            SelectProjectDto dto = new SelectProjectDto();
            dto.projectId = this.projectId;
            dto.name = this.name;
            dto.description = this.description;
            dto.code = this.code;
            return dto;

        }

    }
}
