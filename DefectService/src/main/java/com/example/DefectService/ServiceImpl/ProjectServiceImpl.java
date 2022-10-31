package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Dto.ProjectDto;
import com.example.DefectService.Entity.Project;
import com.example.DefectService.Entity.ProjectTeamMembers;
import com.example.DefectService.Entity.User;
import com.example.DefectService.Repository.*;
import com.example.DefectService.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    DefectRepo defectRepo;
    @Autowired
    ModuleRepo moduleRepo;
    @Autowired
    ProjectTeamMemberRepo projectTeamMemberRepo;
    @Autowired
    UserRepo userRepo;
    public void saveProject(ProjectDto projectDto)
    {
        Project project=new Project();
        project.setProject_name(projectDto.getProject_name());
        projectRepo.save(project);
    }

    @Override
    public void deleteProjectById(int id) {
        Project project=projectRepo.findById(id).orElse(new Project());
        List<ProjectTeamMembers> projectTeamMembers=project.getProjectTeamMembers();
        for(ProjectTeamMembers i:projectTeamMembers){
            User user=i.getUser();
            user.setAvailability(user.getAvailability()+i.getContribution());
            userRepo.save(user);
        }
        projectRepo.deleteById(id);
    }

    @Override
    public String getProjectById(int id) {
        Project project=projectRepo.findById(id).orElse(new Project());
        List<ProjectTeamMembers> projectTeamMembers=projectTeamMemberRepo.getTeamByProject(id);
        List<String> modules=moduleRepo.moduleByProject(id);
        String project_details="Project Name : "+project.getProject_name()+"\n\nTeam Members";
        for (ProjectTeamMembers i:projectTeamMembers){
            project_details+="\nuser_ id : "+i.getUser().getEmp_id()+"  "+"role : "+i.getRole();
        }
        project_details+="\n\nModules"+"\n";
        for (String i:modules){
            project_details+=i+"\n";
        }
        project_details+="\n\nTotal Defects : " +defectRepo.defectCountForProject(id)+
        "\nNew : "+defectRepo.filterByProjectStatus(id,"New")+
        "\nIn Progress : "+defectRepo.filterByProjectStatus(id,"in progress")+
        "\nRejected : "+defectRepo.filterByProjectStatus(id,"rejected")+
        "\nFixed : "+defectRepo.filterByProjectStatus(id,"fixed");
        return project_details;

    }

    @Override
    public void editProjectById(int id, ProjectDto projectDto) {
        Project project=projectRepo.findById(id).orElse(new Project());
        project.setProject_name(projectDto.getProject_name());
        projectRepo.save(project);
    }

    @Override
    public String projectNameById(int id) {
        return projectRepo.getProjectNameById(id);
    }

    @Override
    public Project getById(int id) {
        return projectRepo.findById(id).orElse(new Project());
    }


}
