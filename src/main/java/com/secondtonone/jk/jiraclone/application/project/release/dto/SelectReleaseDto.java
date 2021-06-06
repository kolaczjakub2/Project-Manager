package com.secondtonone.jk.jiraclone.application.project.release.dto;

import java.util.UUID;

public class SelectReleaseDto {

    private UUID id;
    private String label;

    public static SelectReleaseDto.Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static class Builder {

        private UUID id;
        private String label;

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withLabel(String label) {
            this.label = label;
            return this;
        }

        public SelectReleaseDto build() {
            SelectReleaseDto dto = new SelectReleaseDto();
            dto.id = this.id;
            dto.label = this.label;
            return dto;
        }
    }
}
