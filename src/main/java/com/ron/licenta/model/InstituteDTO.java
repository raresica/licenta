package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class InstituteDTO {
    private String name;
    private String telephoneNumber;
    private String emailAddress;

}
