package com.secondtonone.jk.jiraclone.infrastrure.repositories;

import com.secondtonone.jk.jiraclone.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
