package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Entity.ModuleAllocation;
import com.example.DefectService.Entity.Modules;
import com.example.DefectService.Entity.ProjectTeamMembers;
import com.example.DefectService.Repository.ModuleAllocationRepo;
import com.example.DefectService.Repository.ModuleRepo;
import com.example.DefectService.Repository.ProjectTeamMemberRepo;
import com.example.DefectService.Service.ModuleAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleAllocationServiceImpl implements ModuleAllocationService {
    @Autowired
    ModuleAllocationRepo moduleAllocationRepo;
    @Autowired
    ModuleRepo moduleRepo;
    @Autowired
    ProjectTeamMemberRepo projectTeamMemberRepo;

    @Override
    public void allocateModule(int module_id, int team_memberId) {
        ModuleAllocation moduleAllocation=new ModuleAllocation();
        Modules modules=moduleRepo.findById(module_id).orElse(new Modules());
        ProjectTeamMembers projectTeamMembers=projectTeamMemberRepo.findById(team_memberId).orElse(new ProjectTeamMembers());
        moduleAllocation.setModules(modules);
        moduleAllocation.setProjectTeamMembers(projectTeamMembers);
        moduleRepo.save(modules);
        moduleAllocationRepo.save(moduleAllocation);
    }
}
