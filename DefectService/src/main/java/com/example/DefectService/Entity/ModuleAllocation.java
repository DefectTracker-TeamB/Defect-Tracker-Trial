package com.example.DefectService.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ModuleAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Modules modules;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private ProjectTeamMembers projectTeamMembers;



}
