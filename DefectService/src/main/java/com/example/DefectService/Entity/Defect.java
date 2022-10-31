package com.example.DefectService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "defect")
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int defect_id;
    private String description;
    private String related_module;
    private String related_release;
    private String severity;
    private String priority;
    private String status;
    private String assigned_to;
    private String assigned_by;
    @ManyToOne
    @JsonIgnore
    private Releases releases;
    @ManyToOne
    @JsonIgnore
    private Modules modules;
    @ManyToOne
    @JsonIgnore
    private Project project;
}
