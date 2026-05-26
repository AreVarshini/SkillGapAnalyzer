package org.example.careerintelligence.service;

import org.example.careerintelligence.model.RoleSkill;
import org.example.careerintelligence.model.SkillGapResult;
import org.example.careerintelligence.model.UserSkill;
import org.example.careerintelligence.repository.RoleSkillRepository;
import org.example.careerintelligence.repository.UserSkillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapService {

    private final UserSkillRepository userSkillRepository;
    private final RoleSkillRepository roleSkillRepository;

    public SkillGapService(UserSkillRepository userSkillRepository,
                           RoleSkillRepository roleSkillRepository) {
        this.userSkillRepository = userSkillRepository;
        this.roleSkillRepository = roleSkillRepository;
    }

    public SkillGapResult analyzeSkillGap(Long userId, Long roleId) {

        List<UserSkill> userSkills = userSkillRepository.findByUserId(userId);
        List<RoleSkill> roleSkills = roleSkillRepository.findByJobRoleId(roleId);

        int totalSkills = roleSkills.size();
        int matchedSkills = 0;

        List<String> missingSkills = new ArrayList<>();

        for (RoleSkill roleSkill : roleSkills) {

            boolean hasSkill = userSkills.stream()
                    .anyMatch(us -> us.getSkill().getId()
                            .equals(roleSkill.getSkill().getId()));

            if (hasSkill) {
                matchedSkills++;
            } else {
                missingSkills.add(roleSkill.getSkill().getName());
            }
        }

        double readinessScore = ((double) matchedSkills / totalSkills) * 100;

        SkillGapResult result = new SkillGapResult();
        result.setReadinessScore(readinessScore);
        result.setMissingSkills(missingSkills);

        return result;
    }
}