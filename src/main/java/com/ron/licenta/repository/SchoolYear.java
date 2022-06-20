package com.ron.licenta.repository;

import com.ron.licenta.model.Teacher;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface SchoolYear extends CrudRepository<Teacher, Integer> {

    @Procedure
    String[] getAllInstitutes();

    @Procedure
    String[] getAllInstitutesById(Integer idSchool);
}
