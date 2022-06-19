package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class TeacherDTO {

        private String teacherFirstName;
        private String teacherLastName;
        private String CNP;
        private String telephoneNo;
        private String emailAddress;


    }


