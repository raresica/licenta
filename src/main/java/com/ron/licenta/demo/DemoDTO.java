package com.ron.licenta.demo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DemoDTO {

    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
}
