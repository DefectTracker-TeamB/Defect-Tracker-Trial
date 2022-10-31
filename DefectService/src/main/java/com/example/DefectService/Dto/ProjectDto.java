package com.example.DefectService.Dto;

import com.example.DefectService.Entity.ProjectTeamMembers;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class ProjectDto {
    private int id;
    private String project_name;
}
