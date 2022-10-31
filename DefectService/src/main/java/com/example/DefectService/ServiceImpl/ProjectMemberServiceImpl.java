package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Dto.ProjectTeamMembersDto;
import com.example.DefectService.Entity.Project;
import com.example.DefectService.Entity.ProjectTeamMembers;
import com.example.DefectService.Entity.User;
import com.example.DefectService.Repository.ModuleAllocationRepo;
import com.example.DefectService.Repository.ProjectRepo;
import com.example.DefectService.Repository.ProjectTeamMemberRepo;
import com.example.DefectService.Repository.UserRepo;
import com.example.DefectService.Service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Autowired
    ProjectTeamMemberRepo projectTeamMemberRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModuleAllocationRepo moduleAllocationRepo;

    @Override
    public int sumOfContribution(int id) {
        return projectTeamMemberRepo.contributionById(id);
    }

    @Override
    public void SaveProjectMembers(int project_id,int user_id,ProjectTeamMembersDto projectTeamMembersDto) {
        Project project=projectRepo.findById(project_id).orElse(new Project());
        User user=userRepo.findById(user_id).orElse(new User());
        user.setAvailability(user.getAvailability()-projectTeamMembersDto.getContribution());
        userRepo.save(user);
        ProjectTeamMembers projectTeamMembers=new ProjectTeamMembers();
        projectTeamMembers.setName(user.getName());
        projectTeamMembers.setRole(projectTeamMembersDto.getRole());
        projectTeamMembers.setContribution(projectTeamMembersDto.getContribution());
        projectTeamMembers.setProject(project);
        projectTeamMembers.setUser(user);
        projectTeamMemberRepo.save(projectTeamMembers);
    }

    @Override
    public void deleteProjectMembers(int id) {
        ProjectTeamMembers projectTeamMembers=projectTeamMemberRepo.findById(id).orElse(new ProjectTeamMembers());
        User user=projectTeamMembers.getUser();
        user.setAvailability(user.getAvailability()+projectTeamMembers.getContribution());
        userRepo.save(user);
        moduleAllocationRepo.deleteModuleAllocationByMemberId(projectTeamMembers.getId());
        projectTeamMemberRepo.deleteById(id);
    }
    public void editProjectMembers(int project_id,int user_id,int project_memberId,ProjectTeamMembersDto projectTeamMembersDto){
        User user=userRepo.findById(user_id).orElse(new User());
        ProjectTeamMembers projectTeamMembers=new ProjectTeamMembers();
        Project project=projectRepo.findById(project_id).orElse(new Project());
        user.setAvailability(user.getAvailability()-projectTeamMembersDto.getContribution());
        userRepo.save(user);
        projectTeamMembers.setName(user.getName());
        projectTeamMembers.setRole(projectTeamMembersDto.getRole());
        projectTeamMembers.setContribution(projectTeamMembersDto.getContribution());
        projectTeamMembers.setProject(project);
        projectTeamMembers.setUser(user);
        projectTeamMemberRepo.save(projectTeamMembers);
    }

}
