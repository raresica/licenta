package com.ron.licenta.config;

import com.ron.licenta.model.*;
import com.ron.licenta.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner commandLineRunner(YearRepository yearRepository, InstituteRepository instituteRepository, TeacherRepository teacherRepository,
                                        SubjectRepository subjectRepository, LevelOfEducationRepository levelOfEducationRepository,
                                        SchoolYearRepository schoolYearRepository){
        return args -> {
            TeacherConfig.commandLineRunnerTeacher(teacherRepository);
            InstituteConfig.commandLineRunnerInstitute(instituteRepository);
            SubjectConfig.commandLineRunnerSubject(subjectRepository);
            YearConfig.commandLineRunnerYears(yearRepository);
            LevelOfEducationConfig.commandLineRunnerEducation(levelOfEducationRepository);

            insertDataIntoSchool(instituteRepository, yearRepository, schoolYearRepository, levelOfEducationRepository, teacherRepository, subjectRepository);




//            LevelTeachers levelTeachers2 = new LevelTeachers();
//            LevelOfEducation levelOfEducation2 = levelOfEducationRepository.findById(2).get();
//            levelTeachers2.setLevelOfEducation(levelOfEducation2);
//
//            TeacherSubjects teacherSubjects = new TeacherSubjects();
//            Teacher teacher = teacherRepository.findById(1).get();
//            Teacher teacher1 = teacherRepository.findById(3).get();
//            teacherSubjects.setTeacher(teacher);
//            TeacherSubjects teacherSubjects1 = new TeacherSubjects();
//            teacherSubjects1.setTeacher(teacher1);
//            Subject subject1 = subjectRepository.findById(2).get();
//            SubjectInfo subjectInfo1 = new SubjectInfo(subject1, 20);
//            Subject subject3 = subjectRepository.findById(3).get();
//            SubjectInfo subjectInfo3 = new SubjectInfo(subject3, 20);
//            teacherSubjects1.setSubjectInfos(List.of(subjectInfo1, subjectInfo3));
//
//            TeacherSubjects teacherSubjects2 = new TeacherSubjects();
//            Teacher teacher2 = teacherRepository.findById(2).get();
//            teacherSubjects2.setTeacher(teacher2);
//
//
//            Subject subject = subjectRepository.findById(1).get();
//            SubjectInfo subjectInfo = new SubjectInfo(subject, 20);
//            teacherSubjects.setSubjectInfos(List.of(subjectInfo));
//            teacherSubjects2.setSubjectInfos(List.of(subjectInfo));
//            levelTeachers.setTeacherSubjects(List.of(teacherSubjects, teacherSubjects1));
//            levelTeachers2.setTeacherSubjects(List.of(teacherSubjects2));
//
//
//
//            YearLevels yearLevels2 = new YearLevels();
//            yearLevels2.setYear(year2);
//            yearLevels2.setLevelTeachers(List.of(levelTeachers2));

        };
    }

    private void insertDataIntoSchool(InstituteRepository instituteRepository, YearRepository yearRepository,
                                      SchoolYearRepository schoolYearRepository, LevelOfEducationRepository levelOfEducationRepository,
                                      TeacherRepository teacherRepository, SubjectRepository subjectRepository) throws Exception {
        Institute institute = instituteRepository.findById(1).get();
        Institute institute1 = instituteRepository.findById(2).get();
        SchoolYears schoolYears = new SchoolYears();
        schoolYears.setInstitute(institute);


        Year year = yearRepository.findById(1).orElseThrow(()-> new Exception("Can't find the year"));//2021-2022
        Year year2 = yearRepository.findById(2).orElseThrow(()-> new Exception("Can't find the year"));//2020-2021

        schoolYears.setYearLevels(List.of(getYearLevel2021_2022(year, levelOfEducationRepository, teacherRepository, subjectRepository),
                                        (getYearLevel2020_2021(year2, levelOfEducationRepository, teacherRepository, subjectRepository))));
        schoolYearRepository.saveAll(List.of(schoolYears));
        System.out.println(schoolYears);
    }


    private YearLevels getYearLevel2020_2021(Year year2, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                             SubjectRepository subjectRepository){
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year2);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2020_2021Primar(levelOfEducationRepository, teacherRepository, subjectRepository)));
//                getLevelTeachers2020_2021Gimnazial(levelOfEducationRepository),
//                getLevelTeachers2020_2021Liceal(levelOfEducationRepository)));

        return yearLevels;
    }
    private LevelTeachers getLevelTeachers2020_2021Primar(LevelOfEducationRepository levelOfEducationRepository,
                                                          TeacherRepository teacherRepository,
                                                          SubjectRepository subjectRepository){
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(getTeacherSubject2020_2021Primar(2, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar(3, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar(4, teacherRepository, subjectRepository)));
        return levelTeachers;
    }
    private TeacherSubjects getTeacherSubject2020_2021Primar(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository){
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        teacherSubjects.setSubjectInfos(List.of(
                new SubjectInfo(subjectRepository.findById(5).get(), 15),
                new SubjectInfo(subjectRepository.findById(6).get(), 12)
        ));
        return teacherSubjects;
    }


    private YearLevels getYearLevel2021_2022(Year year, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                             SubjectRepository subjectRepository){
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2021_2022Primar(levelOfEducationRepository, teacherRepository, subjectRepository), getLevelTeachers2021_2022Gimnazial(levelOfEducationRepository),
                getLevelTeachers2021_2022Liceal(levelOfEducationRepository)));

        return yearLevels;
    }

    private LevelTeachers getLevelTeachers2021_2022Primar(LevelOfEducationRepository levelOfEducationRepository,
                                                          TeacherRepository teacherRepository,
                                                          SubjectRepository subjectRepository){
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(getTeacherSubject2021_2022Primar(1, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar(3, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar(4, teacherRepository, subjectRepository)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Primar(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository){
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        teacherSubjects.setSubjectInfos(List.of(
                new SubjectInfo(subjectRepository.findById(1).get(), 10),
                new SubjectInfo(subjectRepository.findById(2).get(), 10)
        ));
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Gimnazial(LevelOfEducationRepository levelOfEducationRepository){
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);

        return levelTeachers;
    }

    private LevelTeachers getLevelTeachers2021_2022Liceal(LevelOfEducationRepository levelOfEducationRepository){
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        return levelTeachers;
    }
}
