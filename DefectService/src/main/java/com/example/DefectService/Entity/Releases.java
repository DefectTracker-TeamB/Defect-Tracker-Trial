package com.example.DefectService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Entity
@Data

public class Releases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private String name;
    private String project_name;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Project project;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "releases")
    private Smoke_Test smoke_test;


}
