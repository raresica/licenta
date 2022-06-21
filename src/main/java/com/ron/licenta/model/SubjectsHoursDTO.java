package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectsHoursDTO {

        private String subjectName;
        private String levelOfEducation;
        private String teacherNumber;
        private String totalHours;

    }

