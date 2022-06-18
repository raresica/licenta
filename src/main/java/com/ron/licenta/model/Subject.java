package com.ron.licenta.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subject")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", unique = true)
    @NonNull
    private String name;
}
