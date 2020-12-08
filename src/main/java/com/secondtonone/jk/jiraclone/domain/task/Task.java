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


    public static final class Builder {
        private String summary;
        private String description;
        private String estimatedTime;


    }

}
