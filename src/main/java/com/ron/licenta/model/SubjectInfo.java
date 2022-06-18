package com.ron.licenta.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subjectInfo")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class SubjectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id")
    @NonNull
    private Subject subject;
    @NonNull
    @Column(name = "hours")
    private Integer hours;
}
