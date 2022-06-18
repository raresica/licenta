package com.ron.licenta.config;

import com.ron.licenta.model.Subject;
import com.ron.licenta.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public class SubjectConfig {

    static void commandLineRunnerSubject (SubjectRepository subjectRepository)
    {

            subjectRepository.saveAll(List.of(
                    new Subject("Matematica"),
                    new Subject("Limba si literatura Romana"),
                    new Subject("Fizica")
                    )
            );
    }
}
