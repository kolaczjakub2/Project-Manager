package com.secondtonone.jk.jiraclone.domain.task;

import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Audited(withModifiedFlag = true)
public class Transition {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @CreatedDate
    private LocalDateTime createdDate;

    private String oldStatus;
    private String newStatus;

    private String time;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserAccount author;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Task task;

}
