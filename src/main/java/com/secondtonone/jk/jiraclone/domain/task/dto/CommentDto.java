package com.secondtonone.jk.jiraclone.domain.task.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommentDto {
    private UUID id;
    private String content;
    private UUID userId;
    private Boolean isEdited;
    private LocalDateTime createdDate;

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Boolean getEdited() {
        return isEdited;
    }

    public void setEdited(Boolean edited) {
        isEdited = edited;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public static class Builder {
        private UUID id;
        private String content;
        private UUID userId;
        private Boolean isEdited;
        private LocalDateTime createdDate;

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withContent(String content) {
            this.content = content;
            return this;
        }

        public Builder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder withIsEdited(Boolean isEdited) {
            this.isEdited = isEdited;
            return this;
        }

        public Builder withCreatedDate(LocalDateTime date) {
            this.createdDate = date;
            return this;
        }

        public CommentDto build() {
            CommentDto dto = new CommentDto();
            dto.id = this.id;
            dto.content = this.content;
            dto.userId = this.userId;
            dto.isEdited = this.isEdited;
            dto.createdDate = this.createdDate;
            return dto;
        }
    }
}
