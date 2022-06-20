package com.ron.licenta.service;

import com.ron.licenta.model.LevelOfEducationDTO;
import com.ron.licenta.repository.LevelOfEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class LevelOfEducationService {


    private final LevelOfEducationRepository levelOfEducationRepository;

    @Autowired
    public LevelOfEducationService(LevelOfEducationRepository levelOfEducationRepository) {
        this.levelOfEducationRepository = levelOfEducationRepository;
    }

    public List<LevelOfEducationDTO> getAll() {

        String[] resultSet = levelOfEducationRepository
                .getAll();
        List<LevelOfEducationDTO> levelOfEducationDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            LevelOfEducationDTO levelOfEducationDTO = new LevelOfEducationDTO(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
            levelOfEducationDTOS.add(levelOfEducationDTO);
        });
        return levelOfEducationDTOS;
    }

    public List<LevelOfEducationDTO> getLevelOfEducation(Integer idLevel) {
        String[] resultSet = levelOfEducationRepository
                .getLevelOfEducation(idLevel);
        List<LevelOfEducationDTO> levelOfEducationDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            LevelOfEducationDTO levelOfEducationDTO = new LevelOfEducationDTO(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
            levelOfEducationDTOS.add(levelOfEducationDTO);
        });
        return levelOfEducationDTOS;
    }


}
