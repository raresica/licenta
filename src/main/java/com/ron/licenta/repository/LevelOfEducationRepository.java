package com.ron.licenta.repository;

import com.ron.licenta.model.LevelOfEducation;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelOfEducationRepository extends CrudRepository<LevelOfEducation, Integer> {

    @Procedure
    String[] getAll();
    @Procedure
    String[] getLevelOfEducation(Integer idLevel);

    @Procedure
    String[] getLevelOfEducationByYear(Integer idYear);
}
