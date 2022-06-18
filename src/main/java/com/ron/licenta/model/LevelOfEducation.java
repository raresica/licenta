package com.ron.licenta.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "levelOfEducation")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class LevelOfEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "level", unique = true)
    @NonNull
    private String level;
}
