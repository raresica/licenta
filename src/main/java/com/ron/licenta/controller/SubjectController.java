package com.ron.licenta.controller;

import com.ron.licenta.model.SubjectDTO;
import com.ron.licenta.model.SubjectsHoursDTO;
import com.ron.licenta.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subjects")
@Transactional(readOnly = true)

public class SubjectController {

    private final SubjectService subjectService;


    @Autowired
    public SubjectController(SubjectService subjectService) {

        this.subjectService = subjectService;
    }

    @GetMapping("year/{idYear}/teacher/{idTeacher}")
    @Transactional
    public List<SubjectDTO> getSubjectsHoursTeachers(@PathVariable("idYear") Integer idYear,
                                                     @PathVariable("idTeacher") Integer idTeacher) {
        return subjectService.getSubjectsHoursTeachers(idYear, idTeacher);
    }

    @GetMapping("year/{idYear}/levelOfEducation/{idLoe}")
    @Transactional
    public List<SubjectsHoursDTO> getTotalHoursSubjects(@PathVariable("idYear") Integer idYear,
                                                        @PathVariable("idLoe") Integer idLoe) {
        return subjectService.getTotalHoursSubjects(idYear, idLoe);
    }
}
