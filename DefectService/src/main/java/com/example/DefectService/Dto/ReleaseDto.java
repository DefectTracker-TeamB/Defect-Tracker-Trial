package com.example.DefectService.Dto;

import com.example.DefectService.Entity.Smoke_Test;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
public class ReleaseDto {
    private int id;
    private String status;
    private String name;
}
