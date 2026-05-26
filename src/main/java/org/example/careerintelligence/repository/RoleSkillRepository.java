package org.example.careerintelligence.repository;

import org.example.careerintelligence.model.RoleSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoleSkillRepository extends JpaRepository<RoleSkill, Long> {

    List<RoleSkill> findByJobRoleId(Long roleId);

}