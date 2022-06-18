package com.ron.licenta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacherSubject")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class TeacherSubjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idTeacher")
    @NonNull
    private Teacher teacher;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_subject_info",
    joinColumns = @JoinColumn(name = "id_teacher_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_subject_info"))
    @NonNull
    private List<SubjectInfo> subjectInfos = new ArrayList<>();
    @ManyToMany(mappedBy = "teacherSubjects")
    @ToString.Exclude
    @JsonIgnore
    private List<LevelTeachers> levelTeachers = new ArrayList<>();
}
