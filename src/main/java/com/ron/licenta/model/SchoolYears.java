package com.ron.licenta.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schoolYears")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class SchoolYears {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idInstitute")
    @NonNull
    private Institute institute;
    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "school_years_levels",
    joinColumns = @JoinColumn(name = "id_year_level"),
    inverseJoinColumns = @JoinColumn(name = "id_level_teachers"))
    @NonNull
    private List<YearLevels> yearLevels = new ArrayList<>();
}
