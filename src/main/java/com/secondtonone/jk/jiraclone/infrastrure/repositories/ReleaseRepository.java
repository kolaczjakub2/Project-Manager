package com.secondtonone.jk.jiraclone.infrastrure.repositories;

import com.secondtonone.jk.jiraclone.domain.project.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, UUID> {
}
