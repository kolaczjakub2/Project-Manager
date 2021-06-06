package com.secondtonone.jk.jiraclone.domain.users;

import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.task.WorkLog;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.*;

@Entity
@Audited(withModifiedFlag = true)
public class UserAccount {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String username;
    private String firstName;
    private String lastName;
    private String avatar;

    @OneToMany(mappedBy = "creator")
    private Set<Task> createdTask = new HashSet<>();

    @OneToMany(mappedBy = "assignee")
    private Set<Task> assignee = new HashSet<>();

    @ManyToMany(mappedBy = "watchers")
    private Set<Task> watching = new HashSet<>();

    @OneToMany(mappedBy = "creator")
    private Set<WorkLog> workLog = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Teams",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<Team> teams = new ArrayList<>();

    public static UserAccount.Builder builder() {
        return new UserAccount.Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Task> getCreatedTask() {
        return createdTask;
    }

    public void setCreatedTask(Set<Task> createdTask) {
        this.createdTask = createdTask;
    }

    public Set<Task> getAssignee() {
        return assignee;
    }

    public void setAssignee(Set<Task> assignee) {
        this.assignee = assignee;
    }

    public Set<Task> getWatching() {
        return watching;
    }

    public void setWatching(Set<Task> watching) {
        this.watching = watching;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<WorkLog> getWorkLog() {
        return workLog;
    }

    public void setWorkLog(Set<WorkLog> workLog) {
        this.workLog = workLog;
    }

    public static class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private String username;


        public UserAccount.Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public UserAccount.Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserAccount.Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserAccount.Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserAccount build() {
            UserAccount userAccount = new UserAccount();
            userAccount.id = this.id;
            userAccount.firstName = this.firstName;
            userAccount.lastName = this.lastName;
            userAccount.username = this.username;
            return userAccount;
        }
    }
}
