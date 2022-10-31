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
public class ProjectTeamMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;
    private int contribution;
    @ManyToOne
    @JsonManagedReference
    private Project project;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "projectTeamMembers",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ModuleAllocation> moduleAllocations;



}
