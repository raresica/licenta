package com.ron.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InstituteDTO {
    private String name;
    private String telephoneNumber;
    private String emailAddress;
    private String id;

}
