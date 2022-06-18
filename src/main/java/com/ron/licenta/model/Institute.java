package com.ron.licenta.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "institute")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "telephoneNumber")
    @NonNull
    private String telephoneNumber;
    @Column(name = "emailAddress")
    @NonNull
    private String emailAddress;
}
