package com.ron.licenta.repository;

import com.ron.licenta.model.Year;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends CrudRepository<Year, Integer> {
}
