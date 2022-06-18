package com.ron.licenta.config;

import com.ron.licenta.model.LevelOfEducation;
import com.ron.licenta.repository.LevelOfEducationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public class LevelOfEducationConfig {

    static void commandLineRunnerEducation(LevelOfEducationRepository levelOfEducationRepository){

            levelOfEducationRepository.saveAll(List.of(
                    new LevelOfEducation("primar"),
                    new LevelOfEducation("gimnazial"),
                    new LevelOfEducation("liceal")
            ));

    }
}
