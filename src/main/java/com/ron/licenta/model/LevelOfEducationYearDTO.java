package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LevelOfEducationYearDTO {

    private String year;
    private String schoolName;
    private String levelOfEducation;
}
