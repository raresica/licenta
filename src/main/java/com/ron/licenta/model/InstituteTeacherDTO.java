package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InstituteTeacherDTO {

    private String instituteName;
    private String instituteTelephoneNumber;
    private String instituteEmailAddress;
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherId;

}
