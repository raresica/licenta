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
                            "Dragomir.Elena@scoala27.com"
                    ),
                    new Teacher(
                            "Onescu",
                            "Rares",
                            "19542141251512",
                            "0731338220",
                            "raresonescu@scoala27.com"
                    )
                 ,
                 new Teacher(
                         "Prenumel",
                         "Numescu",
                         "19522141254512",
                         "0731338220",
                         "raresonescu@scoala27.com"
                 )
                 ,
                 new Teacher(
                         "Cutarel",
                         "Cutare",
                         "11542141253512",
                         "0731338220",
                         "raresonescu@scoala27.com"
                 )
                 ,
                 new Teacher(
                         "Minea",
                         "Delia",
                         "19542641251512",
                         "0731338220",
                         "raresonescu@scoala27.com"
                 )
            ));
    }
}
