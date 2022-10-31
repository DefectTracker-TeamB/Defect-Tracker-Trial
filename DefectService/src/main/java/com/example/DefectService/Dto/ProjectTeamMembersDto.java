package com.example.DefectService.Dto;

import com.example.DefectService.Entity.Project;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class ProjectTeamMembersDto {
    private int id;
    private String role;
    private int contribution;
}
