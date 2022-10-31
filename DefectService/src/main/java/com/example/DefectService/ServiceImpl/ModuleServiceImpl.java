package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Dto.ModuleDto;
import com.example.DefectService.Entity.Modules;
import com.example.DefectService.Entity.Project;
import com.example.DefectService.Entity.ProjectTeamMembers;
import com.example.DefectService.Entity.User;
import com.example.DefectService.Repository.ModuleRepo;
import com.example.DefectService.Repository.ProjectRepo;
import com.example.DefectService.Repository.ProjectTeamMemberRepo;
import com.example.DefectService.Repository.UserRepo;
import com.example.DefectService.Service.ModuleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleServices {
    @Autowired
    ModuleRepo moduleRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    UserRepo userRepo;
    @Override
    public void addModule(int project_id, int user_id, ModuleDto moduleDto) {
        Project project=projectRepo.findById(project_id).orElse(new Project());
        User user=userRepo.findById(user_id).orElse(new User());
        Modules modules=new Modules();
        modules.setModule_name(moduleDto.getModule_name());
        modules.setDescription(moduleDto.getDescription());
        modules.setDeveloper(user.getName());
        modules.setProject(project);
        moduleRepo.save(modules);
    }

    @Override
    public void deleteModule(int module_id) {
        moduleRepo.deleteById(module_id);

    }

    @Override
    public void setDeveloper(int module_id, int user_id) {
        Modules modules=moduleRepo.findById(module_id).orElse(new Modules());
        User user=userRepo.findById(user_id).orElse(new User());
        modules.setDeveloper(user.getName());
        moduleRepo.save(modules);
    }
}
