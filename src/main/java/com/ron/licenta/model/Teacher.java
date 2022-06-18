package com.ron.licenta.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "teacher")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstName")
    @NonNull
    private String firstName;
    @Column(name = "lastName")
    @NonNull
    private String lastName;
    @Column(name = "cnp", unique = true)
    @NonNull
    private String cnp;
    @Column(name = "telephoneNumber")
    @NonNull
    private String telephoneNumber;
    @Column(name = "emailAddress")
    @NonNull
    private String emailAddress;
}
