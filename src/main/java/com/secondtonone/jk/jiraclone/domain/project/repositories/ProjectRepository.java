package com.secondtonone.jk.jiraclone.domain.project.repositories;

import com.secondtonone.jk.jiraclone.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    Optional<Project> findByCode(String projectCode);
}
