package com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.dto;


import com.secondtonone.jk.jiraclone.domain.project.task.WorkLog;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class WorkLogDto {
    private UUID id;
    private String comment;
    private LocalDate date;
    private LocalTime from;
    private LocalTime to;
    private String worked;
    private UUID creatorId;
    private LocalDateTime createdDate;

    public static Builder builder() {
        return new Builder();
    }

    public static WorkLogDto of(WorkLog workLog) {
        return builder()
                .withId(workLog.getId())
                .withCreatorId(workLog.getCreator().getId())
                .withWorked(workLog.getWorked())
                .withComment(workLog.getComment())
                .withDate(workLog.getDate())
                .withFrom(workLog.getFrom())
                .withTo(workLog.getTo())
                .withCreatedDate(workLog.getCreatedDate())
                .build();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public String getWorked() {
        return worked;
    }

    public void setWorked(String worked) {
        this.worked = worked;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UUID creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public static class Builder {

        private UUID id;
        private String comment;
        private LocalDate date;
        private LocalTime from;
        private LocalTime to;
        private String worked;
        private UUID creatorId;
        private LocalDateTime createdDate;

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withFrom(LocalTime from) {
            this.from = from;
            return this;
        }

        public Builder withTo(LocalTime to) {
            this.to = to;
            return this;
        }

        public Builder withWorked(String worked) {
            this.worked = worked;
            return this;
        }

        public Builder withCreatorId(UUID creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public Builder withCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }


        public WorkLogDto build() {
            var dto = new WorkLogDto();
            dto.id = id;
            dto.comment = comment;
            dto.date = date;
            dto.from = from;
            dto.to = to;
            dto.worked = worked;
            dto.creatorId = creatorId;
            dto.createdDate = createdDate;
            return dto;
        }
    }
}
