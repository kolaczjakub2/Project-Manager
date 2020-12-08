package com.secondtonone.jk.jiraclone.domain.task;

import com.secondtonone.jk.jiraclone.domain.project.Release;
import com.secondtonone.jk.jiraclone.domain.task.dto.CreateTaskRequestDto;
import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class Task {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String key;

    private String summary;

    private String description;

    private String estimatedTime;

    private String loggedTime;

    private Date resolvedDate;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "resolution_id")
    private Resolution resolution;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    private String labels;

    @ManyToOne
    @JoinColumn(name = "issueType_id")
    private TaskType type;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserAccount creator;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private UserAccount assignee;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Watchers",
            joinColumns = {@JoinColumn(name = "issue_id")},
            inverseJoinColumns = {@JoinColumn(name = "watcher_id")}
    )
    private Set<UserAccount> watchers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_id")
    private Release release;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainTask_id")
    private Task mainTask;

    @OneToMany(mappedBy = "task")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "mainTask")
    private Set<Task> subTask;

    @OneToMany(mappedBy = "task")
    private Set<Change> changes;

    @OneToMany(mappedBy = "task")
    private Set<Transition> transitions;

    public CreateTaskRequestDto toDto() {
        return new CreateTaskRequestDto();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String summary;
        private String description;
        private String estimatedTime;
        private Date createdDate;
        private Date lastModifiedDate;
        private Status status;
        private Resolution resolution;
        private Priority priority;
        private String labels;
        private TaskType type;
        private UserAccount creator;
        private UserAccount assignee;
        private Set<UserAccount> watchers;
        private Release release;
        private Task mainTask;
        private Set<Comment> comments;
        private Set<Task> subTask;
        private Set<Change> changes;
        private Set<Transition> transitions;



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

        public Builder withAssignee(UserAccount assignee) {
            this.assignee = assignee;
            return this;
        }

        public Builder withCreator(UserAccount creator) {
            this.creator = creator;
            return this;
        }

        public Builder withRelease(Release release) {
            this.release = release;
            return this;
        }

        public Builder withMainTask(Task mainTask) {
            this.mainTask = mainTask;
            return this;
        }

        public Task build() {
            if (creator == null) {
                throw new IllegalStateException("Creator cannot be empty");
            }

            if (status == null) {
                throw new IllegalStateException("Status cannot be empty");
            }

            Task task = new Task();
            task.summary = this.summary;
            task.description = this.description;
            task.estimatedTime = this.estimatedTime;
            task.assignee = this.assignee;
            task.creator = this.creator;
            task.release = this.release;
            task.mainTask = this.mainTask;

            return task;
        }

    }

}
