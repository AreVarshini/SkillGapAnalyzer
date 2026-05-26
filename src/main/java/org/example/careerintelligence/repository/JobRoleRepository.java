package org.example.careerintelligence.repository;

import org.example.careerintelligence.model.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
}