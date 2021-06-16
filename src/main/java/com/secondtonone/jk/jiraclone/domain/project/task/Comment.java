package com.secondtonone.jk.jiraclone.domain.project.task;

import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.exceptions.CommentCreateException;
import com.secondtonone.jk.jiraclone.domain.DateAudit;
import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Audited(withModifiedFlag = true)
public class Comment extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String content;
    private Boolean isEdited = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserAccount author;

    @ManyToOne
    @JoinColumn(name = "issue_id")
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserAccount getAuthor() {
        return author;
    }

    public void setAuthor(UserAccount author) {
        this.author = author;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Boolean getEdited() {
        return isEdited;
    }

    public void setEdited(Boolean edited) {
        isEdited = edited;
    }

    public static class Builder {
        private String content;
        private UserAccount author;
        private Task task;

        public Builder withContent(String content) {
            this.content = content;
            return this;
        }

        public Builder withAuthor(UserAccount author) {
            this.author = author;
            return this;
        }

        public Builder withTask(Task task) {
            this.task = task;
            return this;
        }


        public Comment build() {
            if (this.author == null) {
                throw new CommentCreateException("Comment should include author");
            }

            if (this.task == null) {
                throw new CommentCreateException("Comment should include task");
            }

            if (this.content == null) {
                throw new CommentCreateException("Comment should include content");
            }

            Comment comment = new Comment();
            comment.author = this.author;
            comment.task = this.task;
            comment.content = this.content;
            return comment;
        }
    }
}


