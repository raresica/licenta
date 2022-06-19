package com.ron.licenta.config;

import com.ron.licenta.model.Institute;
import com.ron.licenta.repository.InstituteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

public class InstituteConfig {
    static void commandLineRunnerInstitute(InstituteRepository instituteRepository){

          instituteRepository.saveAll(List.of(
                  new Institute(
                          "Scoala 27",
                          "0236754389",
                          "scoala27@gmail.com"
                  ),
                  new Institute(
                          "Scoala 22",
                          "02316754389",
                          "scoala22@gmail.com"
                  ),
                  new Institute(
                          "Scoala 1",
                          "0219314124",
                          "scoala1@gmail.com"
                  )
          ));
    }
}
