package com.ron.licenta.config;

import com.ron.licenta.model.Teacher;
import com.ron.licenta.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public class TeacherConfig {

    static void commandLineRunnerTeacher(TeacherRepository teacherRepository){
         teacherRepository.saveAll(List.of(
                    new Teacher(
                            "Dragomir",
                            "Elena",
                            "1234565324234",
                            "0988765542",
                            "Dragomir.Elena@prof.com"
                    ),
                    new Teacher(
                            "Onescu",
                            "Rares",
                            "19542141251512",
                            "0731338220",
                            "raresonescu@prof.com"
                    )
                 ,
                 new Teacher(
                         "Prenumel",
                         "Numescu",
                         "19522141254512",
                         "0731338220",
                         "raresonescu@prof.com"
                 )
                 ,
                 new Teacher(
                         "Cutarel",
                         "Cutare",
                         "11542141253512",
                         "0731338220",
                         "raresonescu@prof.com"
                 )
                 ,
                 new Teacher(
                         "Minea",
                         "Delia",
                         "19542641251512",
                         "0731338220",
                         "raresonescu@prof.com"
                 ),
                 new Teacher(
                         "Monescu",
                         "Vlad",
                         "12345135124312",
                         "0732141244",
                         "monescuVlad@prof.com"
                 ),
                 new Teacher(
                         "Cosmin",
                         "Marian",
                         "123451232112",
                         "0763311244",
                         "cosminMarian@prof.com"
                 ),
                 new Teacher(
                         "Constantin",
                         "Daniel",
                         "312412412321",
                         "02353141244",
                         "constantinDaniel@prof.com"
                 ),
                 new Teacher(
                         "Ignat",
                         "Florin",
                         "9213215125",
                         "0732141111",
                         "ignatFlorin@prof.com"
                 )
            ));
    }
}
