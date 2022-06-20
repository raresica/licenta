package com.ron.licenta.controller;

import com.ron.licenta.model.*;
import com.ron.licenta.service.LevelOfEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("levelOfEducation")
@Transactional(readOnly = true)

public class LevelOfEducationController {

    private final LevelOfEducationService levelOfEducationService;

    @Autowired
    public LevelOfEducationController(LevelOfEducationService levelOfEducationService) {
        this.levelOfEducationService = levelOfEducationService;
    }

    @GetMapping
    @Transactional
    public List<LevelOfEducationDTO> getAll() {
        return levelOfEducationService.getAll();
    }

    @GetMapping("{idLevel}")
    @Transactional
    public List<LevelOfEducationDTO> getLevelOfEducation(@PathVariable("idLevel") Integer idLevel) {
        return levelOfEducationService.getLevelOfEducation(idLevel);
    }
}
