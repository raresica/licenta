package com.ron.licenta.repository;

import com.ron.licenta.model.Subject;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    @Procedure
    String[] getSubjectsHoursTeachers(Integer idYear, Integer idTeacher);


    @Procedure
    String[] getTotalHoursSubjects(Integer idYear, Integer idLoe);

}
