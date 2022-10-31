package com.example.DefectService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String project_name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProjectTeamMembers> projectTeamMembers;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Modules> modules;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "project")
    @JsonBackReference
    private List<Releases> releases;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Defect> defects;
}
