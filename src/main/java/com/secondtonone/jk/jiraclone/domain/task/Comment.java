package com.secondtonone.jk.jiraclone.domain.task;

import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Comment {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserAccount author;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Task task;
}


