package com.ron.licenta.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "year_levels")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class YearLevels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @NonNull
    @OneToOne
    @JoinColumn(name = "idYear", referencedColumnName = "id")
    private Year year;
    @NonNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "year_levels_teachers",
    joinColumns = @JoinColumn(name = "id_year_levels"),
    inverseJoinColumns = @JoinColumn(name = "id_level_teachers"))
    private List<LevelTeachers> levelTeachers = new ArrayList<>();
}
