package com.ron.licenta.config;

import com.ron.licenta.model.Year;
import com.ron.licenta.repository.YearRepository;

import java.util.List;


public class YearConfig {

    static void commandLineRunnerYears(YearRepository yearRepository){

            yearRepository.saveAll(List.of(
                    new Year("2021-2022"),
                    new Year("2020-2021"),
                    new Year("2019-2020")
            ));

    }
}
