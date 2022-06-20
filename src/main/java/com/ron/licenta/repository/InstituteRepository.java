package com.ron.licenta.repository;

import com.ron.licenta.model.Institute;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends CrudRepository<Institute, Integer> {
    @Procedure
    String[] getAllInstitutes();
    @Procedure
    String[] getInstituteByYear(Integer idYear);

    @Procedure
    String[] getInstituteByTeacher(Integer idTeacher);
}
