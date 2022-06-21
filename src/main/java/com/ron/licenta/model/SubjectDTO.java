package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectDTO {

        private String subjectName;
        private String hours;
        private String schoolName;
        private String levelOfEducation;
       }

