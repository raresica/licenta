package com.ron.licenta.demo;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "demo")

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Integer id;
    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "age")
    private Integer age;
}
