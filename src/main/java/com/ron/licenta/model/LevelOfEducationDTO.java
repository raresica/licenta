package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class LevelOfEducationDTO {

    private String firstName;
    private String lastName;
    private String CNP;
    private String year;
    private String Institute;
    private String level;
}
