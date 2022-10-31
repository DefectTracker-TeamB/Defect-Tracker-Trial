package com.example.DefectService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String module_name;
    private String developer;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Project project;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "modules")
    @JsonBackReference
    private List<Defect> defects;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "modules",fetch = FetchType.LAZY)
    @JsonBackReference
    private ModuleAllocation moduleAllocation;





}
