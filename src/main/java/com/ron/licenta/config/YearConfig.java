package com.ron.licenta.config;

import com.ron.licenta.model.Year;
import com.ron.licenta.repository.YearRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public class YearConfig {

    static void commandLineRunnerYears(YearRepository yearRepository){

            yearRepository.saveAll(List.of(
                    new Year("2021-2022"),
                    new Year("2020-2021")
            ));

    }
}
