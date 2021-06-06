package com.secondtonone.jk.jiraclone.domain.project.task;

import com.secondtonone.jk.jiraclone.domain.DateAudit;
import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Audited(withModifiedFlag = true)
public class WorkLog extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String comment;
    private LocalDate date;

    @Column(name = "time_from")
    private LocalTime from;
    @Column(name = "time_to")
    private LocalTime to;
    private String worked;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserAccount creator;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public static Builder builder() {
        return new Builder();
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

    public UserAccount getCreator() {
        return creator;
    }

    public void setCreator(UserAccount creator) {
        this.creator = creator;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public static class Builder {
        private String comment;
        private LocalDate date;
        private LocalTime from;
        private LocalTime to;
        private String worked;
        private UserAccount creator;
        private Task task;

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

        public Builder withCreator(UserAccount creator) {
            this.creator = creator;
            return this;
        }

        public Builder withTask(Task task) {
            this.task = task;
            return this;
        }


        public WorkLog build() {
            WorkLog workLog = new WorkLog();
            workLog.comment = this.comment;
            workLog.date = this.date;
            workLog.from = this.from;
            workLog.to = this.to;
            workLog.worked = this.worked;
            workLog.creator = this.creator;
            workLog.task = this.task;

            return workLog;
        }
    }
}
