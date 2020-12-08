package com.secondtonone.jk.jiraclone.domain.users;

import com.secondtonone.jk.jiraclone.domain.task.Task;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "creator")
    private Set<Task> createdTask = new HashSet<>();

    @OneToMany(mappedBy = "assignee")
    private Set<Task> assignee = new HashSet<>();

    @ManyToMany(mappedBy = "watchers")
    private Set<Task> watching = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Teams",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<Team> teams = new ArrayList<>();

}
