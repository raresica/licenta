package com.ron.licenta.controller;

import com.ron.licenta.model.SchoolYears;
import com.ron.licenta.model.TeacherAllDTO;
import com.ron.licenta.model.TeacherDTO;
import com.ron.licenta.model.TeacherSubjectDTO;
import com.ron.licenta.service.SchoolYearService;
import com.ron.licenta.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teachers")
@Transactional(readOnly = true)

public class TeacherController {


    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {

        this.teacherService = teacherService;
    }

    @GetMapping
    @Transactional
    public List<TeacherDTO> getAll() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("year/{idYear}")
    @Transactional
    public List<TeacherAllDTO> getTeachers(@PathVariable("idYear") Integer idYear) {
        return teacherService.getAllTeachersByYear(idYear);
    }

    @GetMapping("year/{idYear}/by-school/{idSchool}")
    @Transactional
    public List<TeacherAllDTO> getTeachersByInstitute(@PathVariable("idYear") Integer idYear,
                                                   @PathVariable("idSchool") Integer idSchool) {
        return teacherService.getAllTeachersByInstitute(idYear, idSchool);
    }

    @GetMapping("teacher/{idTeacher}")
    @Transactional
    public List<TeacherDTO> getTeacherById(@PathVariable("idTeacher") Integer idTeacher) {
        return teacherService.getTeacherById(idTeacher);

    }
}
