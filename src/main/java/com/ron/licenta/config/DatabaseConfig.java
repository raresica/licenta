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
                                        SchoolYearRepository schoolYearRepository) {
        return args -> {
            TeacherConfig.commandLineRunnerTeacher(teacherRepository);
            InstituteConfig.commandLineRunnerInstitute(instituteRepository);
            SubjectConfig.commandLineRunnerSubject(subjectRepository);
            YearConfig.commandLineRunnerYears(yearRepository);
            LevelOfEducationConfig.commandLineRunnerEducation(levelOfEducationRepository);

            insertDataIntoSchool27(instituteRepository, yearRepository, schoolYearRepository, levelOfEducationRepository, teacherRepository, subjectRepository);
            insertDataIntoSchool22(instituteRepository, yearRepository, schoolYearRepository, levelOfEducationRepository, teacherRepository, subjectRepository);


        };
    }

    private void insertDataIntoSchool27(InstituteRepository instituteRepository, YearRepository yearRepository,
                                      SchoolYearRepository schoolYearRepository, LevelOfEducationRepository levelOfEducationRepository,
                                      TeacherRepository teacherRepository, SubjectRepository subjectRepository) throws Exception {
        Institute institute = instituteRepository.findById(1).get();
        SchoolYears schoolYears = new SchoolYears();
        schoolYears.setInstitute(institute);


        Year year = yearRepository.findById(1).orElseThrow(() -> new Exception("Can't find the year"));//2021-2022
        Year year2 = yearRepository.findById(2).orElseThrow(() -> new Exception("Can't find the year"));//2020-2021

        schoolYears.setYearLevels(List.of(getYearLevel2021_2022_27(year, levelOfEducationRepository, teacherRepository, subjectRepository),
                (getYearLevel2020_2021_27(year2, levelOfEducationRepository, teacherRepository, subjectRepository))));
        schoolYearRepository.saveAll(List.of(schoolYears));
        System.out.println(schoolYears);
    }

    private void insertDataIntoSchool22(InstituteRepository instituteRepository, YearRepository yearRepository,
                                        SchoolYearRepository schoolYearRepository, LevelOfEducationRepository levelOfEducationRepository,
                                        TeacherRepository teacherRepository, SubjectRepository subjectRepository) throws Exception {
        Institute institute22 = instituteRepository.findById(2).get();
        SchoolYears schoolYears = new SchoolYears();
        schoolYears.setInstitute(institute22);


        Year year = yearRepository.findById(1).orElseThrow(() -> new Exception("Can't find the year"));//2021-2022
        Year year2 = yearRepository.findById(2).orElseThrow(() -> new Exception("Can't find the year"));//2020-2021

        schoolYears.setYearLevels(List.of(getYearLevel2020_2021_22(year, levelOfEducationRepository, teacherRepository, subjectRepository),
                (getYearLevel2020_2021_22(year2, levelOfEducationRepository, teacherRepository, subjectRepository))));
        schoolYearRepository.saveAll(List.of(schoolYears));
        System.out.println(schoolYears);
    }
//Scoala 22

    private YearLevels getYearLevel2020_2021_22(Year year2, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year2);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2020_2021Primar_22(levelOfEducationRepository, teacherRepository, subjectRepository)));
//                getLevelTeachers2020_2021Gimnazial(levelOfEducationRepository),
//                getLevelTeachers2020_2021Liceal(levelOfEducationRepository)));

        return yearLevels;
    }

    private LevelTeachers getLevelTeachers2020_2021Primar_22(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Primar_22(6, teacherRepository, subjectRepository),
                getTeacherSubject2020_2021Primar_22(7, teacherRepository, subjectRepository),
                getTeacherSubject2020_2021Primar_22(9, teacherRepository, subjectRepository),
                getTeacherSubject2020_2021Primar_22(2, teacherRepository, subjectRepository),
                getTeacherSubject2020_2021Primar_22(8, teacherRepository, subjectRepository)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Primar_22(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        teacherSubjects.setSubjectInfos(List.of(
                new SubjectInfo(subjectRepository.findById(9).get(), 12),
                new SubjectInfo(subjectRepository.findById(11).get(), 34),
                new SubjectInfo(subjectRepository.findById(1).get(), 6)
        ));
        return teacherSubjects;
    }

    //Scoala 27
    private YearLevels getYearLevel2020_2021_27(Year year2, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year2);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2020_2021Primar_27(levelOfEducationRepository, teacherRepository, subjectRepository)));
//                getLevelTeachers2020_2021Gimnazial(levelOfEducationRepository),
//                getLevelTeachers2020_2021Liceal(levelOfEducationRepository)));

        return yearLevels;
    }

    private LevelTeachers getLevelTeachers2020_2021Primar_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(getTeacherSubject2020_2021Primar_27(2, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar_27(3, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar_27(4, teacherRepository, subjectRepository)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Primar_27(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        teacherSubjects.setSubjectInfos(List.of(
                new SubjectInfo(subjectRepository.findById(5).get(), 15),
                new SubjectInfo(subjectRepository.findById(6).get(), 12)
        ));
        return teacherSubjects;
    }


    private YearLevels getYearLevel2021_2022_27(Year year, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2021_2022Primar_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Gimnazial_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Liceal_27(levelOfEducationRepository)));

        return yearLevels;
    }

    private LevelTeachers getLevelTeachers2021_2022Primar_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Primar_27(1, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar_27(3, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar_27(4, teacherRepository, subjectRepository)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Primar_27(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        teacherSubjects.setSubjectInfos(List.of(
                new SubjectInfo(subjectRepository.findById(1).get(), 10),
                new SubjectInfo(subjectRepository.findById(2).get(), 10)
        ));
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Gimnazial_27(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Primar_27(2, teacherRepository, subjectRepository),
                getTeacherSubject2021_2022Primar_27(5, teacherRepository, subjectRepository)));

        return levelTeachers;
    }

    private LevelTeachers getLevelTeachers2021_2022Liceal_27(LevelOfEducationRepository levelOfEducationRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        return levelTeachers;
    }
}
