package org.example.careerintelligence.controller;

import org.example.careerintelligence.model.SkillGapResult;
import org.example.careerintelligence.service.SkillGapService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analysis")
public class SkillGapController {

    private final SkillGapService skillGapService;

    public SkillGapController(SkillGapService skillGapService) {
        this.skillGapService = skillGapService;
    }

    @PostMapping("/skill-gap")
    public SkillGapResult analyzeSkillGap(@RequestParam Long userId,
                                          @RequestParam Long roleId) {

        return skillGapService.analyzeSkillGap(userId, roleId);
    }
}