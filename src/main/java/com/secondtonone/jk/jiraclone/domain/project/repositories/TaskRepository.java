package com.secondtonone.jk.jiraclone.domain.project.repositories;

import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    Set<Task> findByAssigneeIdAndStatusIn(UUID userId, Collection<Status> statuses);

    Optional<Task> findByKey(String key);

    Set<Task> findByMainTaskKey(String key);

    List<Task> findByKeyContainsAndStatusNotOrderByKeyAsc(String projectCode, Status status);
}
