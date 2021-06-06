package com.secondtonone.jk.jiraclone.domain.project;

import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Audited(withModifiedFlag = true)
public class Project {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String name;
    private String code;
    private String description;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private UserAccount leader;

    @OneToMany(mappedBy = "project")
    private List<Release> releases = new ArrayList<>();

    public static Project.Builder builder() {
        return new Project.Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserAccount getLeader() {
        return leader;
    }

    public void setLeader(UserAccount owner) {
        this.leader = owner;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public static final class Builder {
        private UUID projectId;
        private String name;
        private String description;
        private String code;
        private UserAccount leader;

        public Project.Builder withProjectId(UUID projectId) {
            this.projectId = projectId;
            return this;
        }

        public Project.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Project.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Project.Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Project build() {
            Project project = new Project();
            project.id = this.projectId;
            project.name = this.name;
            project.description = this.description;
            project.code = this.code;
            project.leader=this.leader;

            return project;

        }

        public Builder withLeader(UserAccount leader) {
            this.leader = leader;
            return this;
        }
    }
}
