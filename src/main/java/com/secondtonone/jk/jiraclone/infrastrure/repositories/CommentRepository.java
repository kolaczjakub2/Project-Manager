package com.secondtonone.jk.jiraclone.infrastrure.repositories;

import com.secondtonone.jk.jiraclone.domain.task.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID> {
    List<Comment> findAllByTaskKeyOrderByCreatedDateAsc(String key);
}
