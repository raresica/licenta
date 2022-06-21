package com.ron.licenta.service;

import com.ron.licenta.model.SubjectDTO;
import com.ron.licenta.model.SubjectsHoursDTO;
import com.ron.licenta.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {

        this.subjectRepository = subjectRepository;
    }

    public List<SubjectDTO> getSubjectsHoursTeachers(Integer idYear, Integer idTeacher) {
        String[] resultSet = subjectRepository
                .getSubjectsHoursTeachers(idYear, idTeacher);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            SubjectDTO subjectDTO = new SubjectDTO(tokens[0], tokens[1], tokens[2], tokens[3]);

            subjectDTOS.add(subjectDTO);

        });
        return subjectDTOS;
    }

    public List<SubjectsHoursDTO> getTotalHoursSubjects(Integer idYear, Integer idTeacher) {
        String[] resultSet = subjectRepository
                .getTotalHoursSubjects(idYear, idTeacher);
        List<SubjectsHoursDTO> subjectsHoursDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            SubjectsHoursDTO subjectsHoursDTO = new SubjectsHoursDTO(tokens[0], tokens[1], tokens[2], tokens[3]);

            subjectsHoursDTOS.add(subjectsHoursDTO);

        });
        return subjectsHoursDTOS;
    }
}
