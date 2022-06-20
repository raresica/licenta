package com.ron.licenta.controller;

import com.ron.licenta.model.*;
import com.ron.licenta.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("institute")
@Transactional(readOnly = true)

public class InstituteController {
    private final InstituteService instituteService;

    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @GetMapping
    @Transactional
    public List<InstituteDTO> getAll() {
        return instituteService.getAllInstitutes();

    }

    @GetMapping("{idYear}")
    @Transactional
    public List<InstituteDTO> getInstituteByYear(@PathVariable("idYear") Integer idYear) {
        return instituteService.getInstituteByYear(idYear);
    }

    @GetMapping("Teacher_id/{idTeacher}")
    @Transactional
    public List<InstituteTeacherDTO> getInstituteByTeacher(@PathVariable("idTeacher") Integer idTeacher) {
        return instituteService.getInstituteByTeacher(idTeacher);
    }
}

