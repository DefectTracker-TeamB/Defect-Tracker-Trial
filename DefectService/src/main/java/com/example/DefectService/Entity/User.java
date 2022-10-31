package com.example.DefectService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String name;
    @JsonIgnore
    private String password;
    private String designation;
    private int emp_id;
    @Column(name = "availability")
    private int availability;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    @JsonManagedReference
    private List<ProjectTeamMembers> projectTeamMembers;





}
