package com.example.DefectService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Smoke_Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private String description;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Releases releases;


}
