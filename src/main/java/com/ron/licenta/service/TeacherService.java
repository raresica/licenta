package com.ron.licenta.service;

import com.ron.licenta.model.TeacherAllDTO;
import com.ron.licenta.model.TeacherDTO;
import com.ron.licenta.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    @Service
    public class TeacherService {
        private final TeacherRepository teacherRepository;

        @Autowired
        public TeacherService(TeacherRepository teacherRepository) {
            this.teacherRepository = teacherRepository;
        }

        public List<TeacherDTO> getAllTeachers() {
            String[] resultSet = teacherRepository
                    .getAllTeachers();
            List<TeacherDTO> teacherDTOS = new ArrayList<>();
            Arrays.stream(resultSet).forEach(s -> {
                String[] tokens = s.split(",");
                TeacherDTO teacherDTO = new TeacherDTO(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                teacherDTOS.add(teacherDTO);
            });
            return teacherDTOS;
        }

        public List<TeacherAllDTO> getAllTeachersByYear(Integer idYear) {
            String[] resultSet = teacherRepository
                    .getAllTeachersByYear(idYear);
            List<TeacherAllDTO> teacherAllDTOS = new ArrayList<>();
            Arrays.stream(resultSet).forEach(s -> {
                String[] tokens = s.split(",");
                TeacherAllDTO teacherAllDTO = new TeacherAllDTO(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);

                teacherAllDTOS.add(teacherAllDTO);

            });

            return teacherAllDTOS;
        }

        public List<TeacherAllDTO> getAllTeachersByInstitute(Integer idYear, Integer idSchool) {
            String[] resultSet = teacherRepository
                    .getAllTeachersByInstitute(idYear, idSchool);
            List<TeacherAllDTO> teacherAllDTOS = new ArrayList<>();
            Arrays.stream(resultSet).forEach(s -> {
                String[] tokens = s.split(",");
                TeacherAllDTO teacherAllDTO = new TeacherAllDTO(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],tokens[5]);

                teacherAllDTOS.add(teacherAllDTO);
            });
            return teacherAllDTOS;

        }


        public List<TeacherDTO> getTeacherById(Integer idTeacher) {
            String[] resultSet = teacherRepository
                    .getTeacherById(idTeacher);
            List<TeacherDTO> teacherDTOS = new ArrayList<>();
            Arrays.stream(resultSet).forEach(s -> {
                String[] tokens = s.split(",");
                TeacherDTO teacherDTO = new TeacherDTO(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);

                teacherDTOS.add(teacherDTO);
            });
            return teacherDTOS;

        }
    }

