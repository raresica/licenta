package com.ron.licenta.config;

import com.ron.licenta.model.Subject;
import com.ron.licenta.repository.SubjectRepository;

import java.util.List;


public class SubjectConfig {

    static void commandLineRunnerSubject (SubjectRepository subjectRepository)
    {

            subjectRepository.saveAll(List.of(
                    new Subject("Matematica"),
                    new Subject("Limba si literatura Romana"),
                    new Subject("Fizica"),
                    new Subject("Chimie"),
                    new Subject("Istorie"),
                    new Subject("Geografie"),
                    new Subject("Economie"),
                    new Subject("Religie"),
                    new Subject("Educatie fizica"),
                    new Subject("TIC"),
                    new Subject("Biologie"),
                    new Subject("Educatie muzicala")
                    )
            );
    }
}
