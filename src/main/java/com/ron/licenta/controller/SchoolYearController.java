package com.ron.licenta.controller;

import com.ron.licenta.model.SchoolYears;
import com.ron.licenta.model.TeacherSubjectDTO;
import com.ron.licenta.service.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school-years")
@Transactional(readOnly = true)
public class SchoolYearController {
    private final SchoolYearService schoolYearService;

    @Autowired
    public SchoolYearController(SchoolYearService schoolYearService) {
        this.schoolYearService = schoolYearService;
    }

    @GetMapping
    public List<SchoolYears> getAll(){
        return schoolYearService.getAll();
    }


    @GetMapping("{idSchool}/{idYear}/{idLevel}/{idTeacher}")
    @Transactional
    public List<TeacherSubjectDTO> getSubjects(@PathVariable("idSchool") Integer idSchool, @PathVariable("idYear") Integer idYear, @PathVariable("idLevel") Integer idLevel,
                                               @PathVariable("idTeacher") Integer idTeacher){
        return schoolYearService
                .getSubjectsFromTeacherInLevelInYearInSchool(idSchool, idYear, idLevel, idTeacher);
    }
}

