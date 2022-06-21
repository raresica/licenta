package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherAllDTO {

    private String teacherFirstName;
    private String teacherLastName;
    private String CNP;
    private String telephoneNo;
    private String emailAddress;
    private String idTeacher;

}
