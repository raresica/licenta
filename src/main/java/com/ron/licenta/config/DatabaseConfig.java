package com.ron.licenta.config;

import com.ron.licenta.model.*;
import com.ron.licenta.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ExpressionException;

import java.util.ArrayList;
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
            insertDataIntoSchool1(instituteRepository, yearRepository, schoolYearRepository, levelOfEducationRepository, teacherRepository, subjectRepository);


        };
    }
    //---------------------------------------------Insert Data----------------------------------------------------------
    //<editor-fold desc= "InsertDataIntoInstitute">
    private void insertDataIntoSchool27(InstituteRepository instituteRepository, YearRepository yearRepository,
                                      SchoolYearRepository schoolYearRepository, LevelOfEducationRepository levelOfEducationRepository,
                                      TeacherRepository teacherRepository, SubjectRepository subjectRepository) throws Exception {
        Institute institute = instituteRepository.findById(1).get();
        SchoolYears schoolYears = new SchoolYears();
        schoolYears.setInstitute(institute);


        Year year = yearRepository.findById(1).orElseThrow(() -> new Exception("Can't find the 2021-2022 year"));//2021-2022
        Year year2 = yearRepository.findById(2).orElseThrow(() -> new Exception("Can't find the 2020-2021 year"));//2020-2021
        Year year3 = yearRepository.findById(3).orElseThrow(() -> new ExpressionException("Can't find the 2019-2020 year"));//2019-2020

        schoolYears.setYearLevels(List.of(

                getYearLevel2021_2022_27(year, levelOfEducationRepository, teacherRepository, subjectRepository),
                getYearLevel2020_2021_27(year2, levelOfEducationRepository, teacherRepository, subjectRepository),
                getYearLevel2019_2020_27(year3, levelOfEducationRepository, teacherRepository, subjectRepository)));
        schoolYearRepository.saveAll(List.of(schoolYears));

    }

    private void insertDataIntoSchool22(InstituteRepository instituteRepository, YearRepository yearRepository,
                                        SchoolYearRepository schoolYearRepository, LevelOfEducationRepository levelOfEducationRepository,
                                        TeacherRepository teacherRepository, SubjectRepository subjectRepository) throws Exception {
        Institute institute22 = instituteRepository.findById(2).get();
        SchoolYears schoolYears = new SchoolYears();
        schoolYears.setInstitute(institute22);


        Year year = yearRepository.findById(1).orElseThrow(() -> new Exception("Can't find the year 2021-2022"));//2021-2022
        Year year2 = yearRepository.findById(2).orElseThrow(() -> new Exception("Can't find the year 2020-2021"));//2020-2021
        Year year3 = yearRepository.findById(2).orElseThrow(() -> new Exception("Can't find the year 2019-2020"));//2019-2020

        schoolYears.setYearLevels(List.of(
                getYearLevel2021_2022_22(year, levelOfEducationRepository, teacherRepository, subjectRepository),
                getYearLevel2020_2021_22(year2, levelOfEducationRepository, teacherRepository, subjectRepository),
                getYearLevel2019_2020_22(year3, levelOfEducationRepository, teacherRepository, subjectRepository)));
        schoolYearRepository.saveAll(List.of(schoolYears));

    }

    private void insertDataIntoSchool1(InstituteRepository instituteRepository, YearRepository yearRepository,
                                       SchoolYearRepository schoolYearRepository, LevelOfEducationRepository levelOfEducationRepository,
                                       TeacherRepository teacherRepository, SubjectRepository subjectRepository) throws Exception {
        Institute institute1 = instituteRepository.findById(3).get();
        SchoolYears schoolYears = new SchoolYears();
        schoolYears.setInstitute(institute1);


        Year year = yearRepository.findById(1).orElseThrow(() -> new Exception("Can't find the year 2021-2022"));//2021-2022
        Year year2 = yearRepository.findById(2).orElseThrow(() -> new Exception("Can't find the year 2020-2021"));//2020-2021
        Year year3 = yearRepository.findById(2).orElseThrow(() -> new Exception("Can't find the year 2019-2020"));//2019-2020

        schoolYears.setYearLevels(List.of(
                getYearLevel2021_2022_1(year, levelOfEducationRepository, teacherRepository, subjectRepository),
                getYearLevel2020_2021_1(year2, levelOfEducationRepository, teacherRepository, subjectRepository),
                getYearLevel2019_2020_1(year3, levelOfEducationRepository, teacherRepository, subjectRepository)));
        schoolYearRepository.saveAll(List.of(schoolYears));

    }
//</editor-fold>

    //---------------------------------------------Scoala 27------------------------------------------------------------
    //<editor-fold desc= "Scoala 27">
    private YearLevels getYearLevel2019_2020_27(Year year3,
                                                LevelOfEducationRepository levelOfEducationRepository,
                                                TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year3);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2019_2020Primar_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2019_2020Gimnazial_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2019_2020Liceal_27(levelOfEducationRepository, teacherRepository, subjectRepository)));
        return yearLevels;
    }

    private YearLevels getYearLevel2020_2021_27(Year year2,
                                                LevelOfEducationRepository levelOfEducationRepository,
                                                TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year2);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2020_2021Primar_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2020_2021Gimnazial_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2020_2021Liceal_27(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }

    private YearLevels getYearLevel2021_2022_27(Year year,
                                                LevelOfEducationRepository levelOfEducationRepository,
                                                TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2021_2022Primar_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Gimnazial_27(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Liceal_27(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }


    private LevelTeachers getLevelTeachers2020_2021Primar_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Primar_27(1, teacherRepository, subjectRepository, 5, 10, 3, 8),
                getTeacherSubject2020_2021Primar_27(3, teacherRepository, subjectRepository, 4, 2, 2, 9)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Primar_27(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }


    private LevelTeachers getLevelTeachers2019_2020Primar_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Primar_27(8, teacherRepository, subjectRepository, 3, 11),
                getTeacherSubject2019_2020Primar_27(9, teacherRepository, subjectRepository, 1, 2, 3, 14),
                getTeacherSubject2019_2020Primar_27(10, teacherRepository, subjectRepository, 5, 4, 6, 3)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Primar_27(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Primar_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Primar_27(5, teacherRepository, subjectRepository, 1, 4, 2, 5),
                getTeacherSubject2021_2022Primar_27(6, teacherRepository, subjectRepository, 7, 2, 4, 10),
                getTeacherSubject2021_2022Primar_27(7, teacherRepository, subjectRepository, 12, 4, 11, 30)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Primar_27(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Gimnazial_27(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Gimnazial_27(1, teacherRepository, subjectRepository, 4, 11),
                getTeacherSubject2021_2022Gimnazial_27(2, teacherRepository, subjectRepository, 2, 15),
                getTeacherSubject2021_2022Gimnazial_27(3, teacherRepository, subjectRepository, 4, 2),
                getTeacherSubject2021_2022Gimnazial_27(4, teacherRepository, subjectRepository, 5, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Gimnazial_27(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Gimnazial_27(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Gimnazial_27(7, teacherRepository, subjectRepository, 1, 11),
                getTeacherSubject2020_2021Gimnazial_27(8, teacherRepository, subjectRepository, 10, 15),
                getTeacherSubject2020_2021Gimnazial_27(9, teacherRepository, subjectRepository, 9, 2, 2, 9),
                getTeacherSubject2020_2021Gimnazial_27(3, teacherRepository, subjectRepository, 2, 2, 8, 10)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Gimnazial_27(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }


    private LevelTeachers getLevelTeachers2019_2020Gimnazial_27(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Gimnazial_27(5, teacherRepository, subjectRepository, 4, 9),
                getTeacherSubject2019_2020Gimnazial_27(6, teacherRepository, subjectRepository, 5, 15),
                getTeacherSubject2019_2020Gimnazial_27(7, teacherRepository, subjectRepository, 6, 2),
                getTeacherSubject2019_2020Gimnazial_27(10, teacherRepository, subjectRepository, 10, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Gimnazial_27(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Liceal_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Liceal_27(2, teacherRepository, subjectRepository, 3, 9, 5, 2),
                getTeacherSubject2021_2022Liceal_27(4, teacherRepository, subjectRepository, 2, 10, 6, 6),
                getTeacherSubject2021_2022Liceal_27(1, teacherRepository, subjectRepository, 1, 5, 7, 20),
                getTeacherSubject2021_2022Liceal_27(5, teacherRepository, subjectRepository, 4, 2, 8, 9)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Liceal_27(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Liceal_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Liceal_27(2, teacherRepository, subjectRepository, 5, 9),
                getTeacherSubject2020_2021Liceal_27(4, teacherRepository, subjectRepository, 10, 10),
                getTeacherSubject2020_2021Liceal_27(1, teacherRepository, subjectRepository, 5, 5),
                getTeacherSubject2020_2021Liceal_27(5, teacherRepository, subjectRepository, 8, 9)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Liceal_27(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2019_2020Liceal_27(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Liceal_27(7, teacherRepository, subjectRepository, 9, 5),
                getTeacherSubject2019_2020Liceal_27(8, teacherRepository, subjectRepository, 4, 23),
                getTeacherSubject2019_2020Liceal_27(10, teacherRepository, subjectRepository, 1, 1),
                getTeacherSubject2019_2020Liceal_27(1, teacherRepository, subjectRepository, 2, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Liceal_27(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }
    //</editor-fold>

    //---------------------------------------------Scoala 22------------------------------------------------------------
    //<editor-fold desc= "Scoala 22">

    private YearLevels getYearLevel2021_2022_22(Year year, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2021_2022Primar_22(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Gimnazial_22(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Liceal_22(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }

    private YearLevels getYearLevel2020_2021_22(Year year2, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year2);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2020_2021Primar_22(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2020_2021Gimnazial_22(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2020_2021Liceal_22(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }

    private YearLevels getYearLevel2019_2020_22(Year year3, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                                SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year3);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2019_2020Primar_22(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2019_2020Gimnazial_22(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2019_2020Liceal_22(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }

    private LevelTeachers getLevelTeachers2021_2022Primar_22(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Primar_22(7, teacherRepository, subjectRepository, 3, 2),
                getTeacherSubject2021_2022Primar_22(9, teacherRepository, subjectRepository, 2, 5),
                getTeacherSubject2021_2022Primar_22(2, teacherRepository, subjectRepository, 2, 6),
                getTeacherSubject2021_2022Primar_22(8, teacherRepository, subjectRepository, 10, 1)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Primar_22(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository, Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Primar_22(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Primar_22(7, teacherRepository, subjectRepository, 1, 2),
                getTeacherSubject2020_2021Primar_22(9, teacherRepository, subjectRepository, 3, 5),
                getTeacherSubject2020_2021Primar_22(2, teacherRepository, subjectRepository, 4, 6),
                getTeacherSubject2020_2021Primar_22(8, teacherRepository, subjectRepository, 10, 5)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Primar_22(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository, Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2019_2020Primar_22(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Primar_22(2, teacherRepository, subjectRepository, 9, 2, 4, 8),
                getTeacherSubject2019_2020Primar_22(8, teacherRepository, subjectRepository, 10, 1)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Primar_22(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository, Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Gimnazial_22(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Gimnazial_22(3, teacherRepository, subjectRepository, 4, 2),
                getTeacherSubject2021_2022Gimnazial_22(4, teacherRepository, subjectRepository, 5, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Gimnazial_22(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Gimnazial_22(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Gimnazial_22(7, teacherRepository, subjectRepository, 1, 11),
                getTeacherSubject2020_2021Gimnazial_22(8, teacherRepository, subjectRepository, 10, 15),
                getTeacherSubject2020_2021Gimnazial_22(3, teacherRepository, subjectRepository, 2, 2, 8, 10)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Gimnazial_22(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }


    private LevelTeachers getLevelTeachers2019_2020Gimnazial_22(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Gimnazial_22(5, teacherRepository, subjectRepository, 4, 9),
                getTeacherSubject2019_2020Gimnazial_22(10, teacherRepository, subjectRepository, 10, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Gimnazial_22(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Liceal_22(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Liceal_22(6, teacherRepository, subjectRepository, 3, 9, 5, 2),
                getTeacherSubject2021_2022Liceal_22(7, teacherRepository, subjectRepository, 2, 10, 6, 6),
                getTeacherSubject2021_2022Liceal_22(8, teacherRepository, subjectRepository, 1, 5, 7, 20),
                getTeacherSubject2021_2022Liceal_22(9, teacherRepository, subjectRepository, 4, 2, 8, 9)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Liceal_22(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Liceal_22(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Liceal_22(9, teacherRepository, subjectRepository, 5, 9),
                getTeacherSubject2020_2021Liceal_22(3, teacherRepository, subjectRepository, 10, 10),
                getTeacherSubject2020_2021Liceal_22(4, teacherRepository, subjectRepository, 5, 5),
                getTeacherSubject2020_2021Liceal_22(1, teacherRepository, subjectRepository, 8, 9)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Liceal_22(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2019_2020Liceal_22(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Liceal_22(2, teacherRepository, subjectRepository, 9, 5),
                getTeacherSubject2019_2020Liceal_22(4, teacherRepository, subjectRepository, 1, 23),
                getTeacherSubject2019_2020Liceal_22(1, teacherRepository, subjectRepository, 1, 1),
                getTeacherSubject2019_2020Liceal_22(9, teacherRepository, subjectRepository, 2, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Liceal_22(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }
    //</editor-fold>

    //---------------------------------------------Scoala 1-------------------------------------------------------------
    //<editor-fold desc= "Scoala 1">

    private YearLevels getYearLevel2021_2022_1(Year year, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                               SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2021_2022Primar_1(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Gimnazial_1(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2021_2022Liceal_1(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }

    private YearLevels getYearLevel2020_2021_1(Year year2, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                               SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year2);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2020_2021Primar_1(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2020_2021Gimnazial_1(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2020_2021Liceal_1(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }

    private YearLevels getYearLevel2019_2020_1(Year year3, LevelOfEducationRepository levelOfEducationRepository, TeacherRepository teacherRepository,
                                               SubjectRepository subjectRepository) {
        YearLevels yearLevels = new YearLevels();
        yearLevels.setYear(year3);
        yearLevels.setLevelTeachers(List.of(
                getLevelTeachers2019_2020Primar_1(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2019_2020Gimnazial_1(levelOfEducationRepository, teacherRepository, subjectRepository),
                getLevelTeachers2019_2020Liceal_1(levelOfEducationRepository, teacherRepository, subjectRepository)));

        return yearLevels;
    }

    private LevelTeachers getLevelTeachers2021_2022Primar_1(LevelOfEducationRepository levelOfEducationRepository,
                                                            TeacherRepository teacherRepository,
                                                            SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Primar_1(1, teacherRepository, subjectRepository, 9, 2, 4, 8),
                getTeacherSubject2021_2022Primar_1(4, teacherRepository, subjectRepository, 3, 2),
                getTeacherSubject2021_2022Primar_1(2, teacherRepository, subjectRepository, 10, 1)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Primar_1(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository, Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Primar_1(LevelOfEducationRepository levelOfEducationRepository,
                                                            TeacherRepository teacherRepository,
                                                            SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Primar_1(6, teacherRepository, subjectRepository, 9, 2, 11, 3, 2, 8, 5, 4),
                getTeacherSubject2020_2021Primar_1(7, teacherRepository, subjectRepository, 1, 2)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Primar_1(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository, Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2019_2020Primar_1(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(1).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Primar_1(3, teacherRepository, subjectRepository, 9, 2, 4, 8),
                getTeacherSubject2019_2020Primar_1(2, teacherRepository, subjectRepository, 10, 1)));
        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Primar_1(int id, TeacherRepository teacherRepository, SubjectRepository subjectRepository, Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Gimnazial_1(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2021_2022Gimnazial_1(7, teacherRepository, subjectRepository, 4, 2),
                getTeacherSubject2021_2022Gimnazial_1(10, teacherRepository, subjectRepository, 5, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Gimnazial_1(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Gimnazial_1(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Gimnazial_1(3, teacherRepository, subjectRepository, 1, 11),
                getTeacherSubject2020_2021Gimnazial_1(5, teacherRepository, subjectRepository, 10, 15),
                getTeacherSubject2020_2021Gimnazial_1(7, teacherRepository, subjectRepository, 2, 2, 8, 10)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Gimnazial_1(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }


    private LevelTeachers getLevelTeachers2019_2020Gimnazial_1(LevelOfEducationRepository levelOfEducationRepository,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(2).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Gimnazial_1(2, teacherRepository, subjectRepository, 4, 9),
                getTeacherSubject2019_2020Gimnazial_1(9, teacherRepository, subjectRepository, 10, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Gimnazial_1(int id,
                                                                   TeacherRepository teacherRepository,
                                                                   SubjectRepository subjectRepository,
                                                                   Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2021_2022Liceal_1(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                   getTeacherSubject2021_2022Liceal_1(9, teacherRepository, subjectRepository, 4, 2, 8, 9)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2021_2022Liceal_1(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2020_2021Liceal_1(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2020_2021Liceal_1(4, teacherRepository, subjectRepository, 5, 9),
                getTeacherSubject2020_2021Liceal_1(2, teacherRepository, subjectRepository, 10, 10),
                getTeacherSubject2020_2021Liceal_1(10, teacherRepository, subjectRepository, 5, 5),
                getTeacherSubject2020_2021Liceal_1(9, teacherRepository, subjectRepository, 8, 9)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2020_2021Liceal_1(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }

    private LevelTeachers getLevelTeachers2019_2020Liceal_1(LevelOfEducationRepository levelOfEducationRepository,
                                                             TeacherRepository teacherRepository,
                                                             SubjectRepository subjectRepository) {
        LevelTeachers levelTeachers = new LevelTeachers();
        LevelOfEducation levelOfEducation = levelOfEducationRepository.findById(3).get();
        levelTeachers.setLevelOfEducation(levelOfEducation);
        levelTeachers.setTeacherSubjects(List.of(
                getTeacherSubject2019_2020Liceal_1(9, teacherRepository, subjectRepository, 2, 2)));

        return levelTeachers;
    }

    private TeacherSubjects getTeacherSubject2019_2020Liceal_1(int id,
                                                                TeacherRepository teacherRepository,
                                                                SubjectRepository subjectRepository,
                                                                Integer... ids) {
        TeacherSubjects teacherSubjects = new TeacherSubjects();
        teacherSubjects.setTeacher(teacherRepository.findById(id).get());
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        for (int i = 0; i < ids.length - 1; i += 2) {
            subjectInfos.add(new SubjectInfo(subjectRepository.findById(ids[i]).get(), ids[i + 1]));
        }
        teacherSubjects.setSubjectInfos(subjectInfos);
        return teacherSubjects;
    }
    //</editor-fold>
}
