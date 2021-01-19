package com.secondtonone.jk.jiraclone.domain.project;

import com.secondtonone.jk.jiraclone.domain.task.Task;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Audited(withModifiedFlag = true)
public class Release {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String label;

    @OneToMany(mappedBy = "release")
    private Set<Task> tasks = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    public static Release.Builder builder() {
        return new Release.Builder();
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public static class Builder {

        private UUID id;
        private String label;
        private Project project;

        public Release.Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Release.Builder withLabel(String label) {
            this.label = label;
            return this;
        }

        public Release.Builder withProject(Project project) {
            this.project = project;
            return this;
        }

        public Release build() {
            Release release = new Release();
            release.id = this.id;
            release.label = this.label;
            release.project = this.project;
            return release;
        }
    }
}
