package com.example.DefectService.Service;

import com.example.DefectService.Dto.ProjectDto;
import com.example.DefectService.Entity.Project;
import com.example.DefectService.Entity.ProjectTeamMembers;

import java.util.List;

public interface ProjectService {
    void saveProject(ProjectDto projectDto);
    void deleteProjectById(int id);
    String getProjectById(int id);
    void editProjectById(int id,ProjectDto projectDto);
    String projectNameById(int id);
    Project getById(int id);
    /*void addMembersToExistingProject(int id, ProjectTeamMembers projectTeamMembers);
    void addModulesToExistingProject(int id, ProjectTeamMembers projectTeamMembers);
    void addReleasesToProject(int id)*/


}
