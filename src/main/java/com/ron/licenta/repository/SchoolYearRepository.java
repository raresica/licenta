package com.ron.licenta.repository;

import com.ron.licenta.model.SchoolYears;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolYearRepository extends CrudRepository <SchoolYears, Integer> {

    @Procedure
    String[] getSubjectsFromTeacherInLevelInYearInSchool(Integer idSchool, Integer idYear, Integer idLevel, Integer idTeacher);
}
