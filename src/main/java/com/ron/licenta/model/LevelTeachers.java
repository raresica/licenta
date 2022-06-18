package com.ron.licenta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "levelTeachers")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class LevelTeachers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_level_of_education", referencedColumnName = "id")
    @NonNull
    private LevelOfEducation levelOfEducation;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "level_teachers_subjects",
    joinColumns = @JoinColumn(name = "id_level_teachers"),
    inverseJoinColumns = @JoinColumn(name = "id_teachers_subjects"))
    @NonNull
    private List<TeacherSubjects> teacherSubjects = new ArrayList<>();
    @ManyToMany(mappedBy = "levelTeachers")
    @ToString.Exclude
    @JsonIgnore
    private List<YearLevels> yearLevels = new ArrayList<>();
}
