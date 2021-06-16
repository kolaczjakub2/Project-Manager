package com.secondtonone.jk.jiraclone.domain.project.task;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskCreationException;
import com.secondtonone.jk.jiraclone.domain.DateAudit;
import com.secondtonone.jk.jiraclone.domain.project.Release;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.CreateTaskRequestDto;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Priority;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Resolution;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.TaskType;
import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Audited(withModifiedFlag = true)
public class Task extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String key;

    private String summary;

    private String description;

    private String estimatedTime;

    private String loggedTime;

    private Date resolvedDate;

    private Status status;

    private Resolution resolution;

    private Priority priority;

    private String labels;

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
            joinColumns = {@JoinColumn(name = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "watcher_id")}
    )
    private Set<UserAccount> watchers = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Voters",
            joinColumns = {@JoinColumn(name = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "voter_id")}
    )
    private Set<UserAccount> voters = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_id")
    private Release release;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainTask_id")
    private Task mainTask;

    @OneToMany(mappedBy = "task")
    private Set<WorkLog> workLog = new HashSet<>();

    @OneToMany(mappedBy = "task")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "mainTask")
    private Set<Task> subTask;

    @OneToMany(mappedBy = "task")
    private Set<Transition> transitions;

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

    public String getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(String loggedTime) {
        this.loggedTime = loggedTime;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
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

    public UserAccount getCreator() {
        return creator;
    }

    public void setCreator(UserAccount creator) {
        this.creator = creator;
    }

    public UserAccount getAssignee() {
        return assignee;
    }

    public void setAssignee(UserAccount assignee) {
        this.assignee = assignee;
    }

    public Set<UserAccount> getWatchers() {
        return watchers;
    }

    public void setWatchers(Set<UserAccount> watchers) {
        this.watchers = watchers;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Task getMainTask() {
        return mainTask;
    }

    public void setMainTask(Task mainTask) {
        this.mainTask = mainTask;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Task> getSubTask() {
        return subTask;
    }

    public void setSubTask(Set<Task> subTask) {
        this.subTask = subTask;
    }

    public Set<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(Set<Transition> transitions) {
        this.transitions = transitions;
    }

    public CreateTaskRequestDto toDto() {
        return new CreateTaskRequestDto();
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<WorkLog> getWorkLog() {
        return workLog;
    }

    public void setWorkLog(Set<WorkLog> workLog) {
        this.workLog = workLog;
    }

    public Set<UserAccount> getVoters() {
        return voters;
    }

    public void setVoters(Set<UserAccount> voters) {
        this.voters = voters;
    }

    public static final class Builder {
        private String key;
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

        public Builder withStatus(Status status) {
            this.status = status;
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

        public Task build() {
            if (creator == null) {
                throw new TaskCreationException("Creator cannot be empty");
            }

            if (status == null) {
                throw new TaskCreationException("Status cannot be empty");
            }

//            if (!estimatedTime.matches("/^(?:\\d+d(?:\\d+h(?:\\d+m)?)|\\d+[dh]?)$/")) {
//                throw new TaskCreationException("estimatedTime should match pattern");
//            }

            Task task = new Task();
            task.summary = this.summary;
            task.description = this.description;
            task.estimatedTime = this.estimatedTime;
            task.assignee = this.assignee;
            task.creator = this.creator;
            task.release = this.release;
            task.mainTask = this.mainTask;
            task.status = this.status;
            task.resolution = this.resolution;
            task.priority = this.priority;
            task.type = this.type;
            task.key = this.key;

            return task;
        }

    }

}
