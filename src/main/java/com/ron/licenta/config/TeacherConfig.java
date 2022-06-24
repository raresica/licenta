package com.ron.licenta.config;

import com.ron.licenta.model.Teacher;
import com.ron.licenta.repository.TeacherRepository;

import java.util.List;


public class TeacherConfig {

    static void commandLineRunnerTeacher(TeacherRepository teacherRepository){ //10
         teacherRepository.saveAll(List.of(
                    new Teacher(
                            "Dragomir",
                            "Elena",
                            "2134567890123",
                            "0988765542",
                            "DragomirElena@prof.com"
                    ),
                    new Teacher(
                            "Onescu",
                            "Rares",
                            "1134539000123",
                            "0731338220",
                            "raresOnescu@prof.com"
                    )
                 ,
                 new Teacher(
                         "Codrin",
                         "Chririla",
                         "1952214125451",
                         "0733338222",
                         "codrinChirila@prof.com"
                 )
                 ,
                 new Teacher(
                         "Catalin",
                         "Bunescu",
                         "1154214125351",
                         "0722338222",
                         "catalinBunescu@prof.com"
                 )
                 ,
                 new Teacher(
                         "Mierea",
                         "Adelina",
                         "2954264125151",
                         "0722033311",
                         "adelinaMierea@prof.com"
                 ),
                 new Teacher(
                         "Monescu",
                         "Vlad",
                         "123451351243",
                         "0732141244",
                         "monescuVlad@prof.com"
                 ),
                 new Teacher(
                         "Cosmin",
                         "Marian",
                         "1123451232112",
                         "0763311244",
                         "cosminMarian@prof.com"
                 ),
                 new Teacher(
                         "Constantin",
                         "Daniel",
                         "1312412412321",
                         "0235314124",
                         "constantinDaniel@prof.com"
                 ),
                 new Teacher(
                         "Ignat",
                         "Florin",
                         "1959213215125",
                         "0732141111",
                         "ignatFlorin@prof.com"
                 ),
                 new Teacher(
                         "Iuca",
                         "Maria",
                         "2354125326234",
                         "0735333333",
                         "iucaMaria@prof.com"
                 )
            ));
    }
}
