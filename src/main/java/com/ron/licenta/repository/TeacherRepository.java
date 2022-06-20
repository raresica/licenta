package com.ron.licenta.repository;

import com.ron.licenta.model.Teacher;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    @Procedure
    String[] getAllTeachers();

    @Procedure
    String[] getAllTeachersByYear(Integer idYear);

    @Procedure
    String[] getAllTeachersByInstitute(Integer idYear, Integer idSchool);

    @Procedure
    String[] getTeacherById(Integer idTeacher);

}
