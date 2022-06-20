package com.ron.licenta.service;


import com.ron.licenta.model.InstituteDTO;
import com.ron.licenta.model.InstituteTeacherDTO;
import com.ron.licenta.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InstituteService {

    private final InstituteRepository instituteRepository;

    @Autowired
    public InstituteService(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    public List<InstituteDTO> getAllInstitutes() {
        String[] resultSet = instituteRepository
                .getAllInstitutes();
        List<InstituteDTO> instituteDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            InstituteDTO instituteDTO = new InstituteDTO(tokens[0], tokens[1], tokens[2]);
            instituteDTOS.add(instituteDTO);
        });
        return instituteDTOS;
    }

    public List<InstituteDTO> getInstituteByYear(Integer idYear) {
        String[] resultSet = instituteRepository
                .getInstituteByYear(idYear);
        List<InstituteDTO> instituteDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            InstituteDTO instituteDTO = new InstituteDTO(tokens[0], tokens[1], tokens[2]);
            instituteDTOS.add(instituteDTO);

        });
        return instituteDTOS;

    }

    public List<InstituteTeacherDTO> getInstituteByTeacher(Integer idTeacher) {
        String[] resultSet = instituteRepository
                .getInstituteByTeacher(idTeacher);
        List<InstituteTeacherDTO> instituteTeacherDTOS = new ArrayList<>();
        Arrays.stream(resultSet).forEach(s -> {
            String[] tokens = s.split(",");
            InstituteTeacherDTO instituteTeacherDTO = new InstituteTeacherDTO(tokens[0], tokens[1], tokens[2],tokens[3], tokens[4], tokens[5]);
            instituteTeacherDTOS.add(instituteTeacherDTO);

        });
        return instituteTeacherDTOS;

    }
}
