package com.ron.licenta.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "year")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    @NonNull
    private String year;
}
