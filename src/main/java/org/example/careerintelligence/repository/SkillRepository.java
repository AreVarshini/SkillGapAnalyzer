package org.example.careerintelligence.repository;

import org.example.careerintelligence.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}