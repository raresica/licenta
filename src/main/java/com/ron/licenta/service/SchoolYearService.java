package com.ron.licenta.service;

import com.ron.licenta.model.SchoolYears;
import com.ron.licenta.model.TeacherSubjectDTO;
import com.ron.licenta.repository.SchoolYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SchoolYearService {
    private final SchoolYearRepository schoolYearRepository;

    @Autowired
    public SchoolYearService(SchoolYearRepository schoolYearRepository) {
        this.schoolYearRepository = schoolYearRepository;
    }

    public List<SchoolYears> getAll(){
        return (List<SchoolYears>) schoolYearRepository.findAll();
    }

    public List<TeacherSubjectDTO> getSubjectsFromTeacherInLevelInYearInSchool(Integer idSchool, Integer idYear, Integer idLevel, Integer idTeacher){
        String[] resultSet = schoolYearRepository
                .getSubjectsFromTeacherInLevelInYearInSchool(idSchool, idYear, idLevel, idTeacher);
        List<TeacherSubjectDTO> teacherSubjectDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            teacherSubjectDTOS.add(new TeacherSubjectDTO(tokens[0], tokens[1]));
        });

        return teacherSubjectDTOS;
    }
}
