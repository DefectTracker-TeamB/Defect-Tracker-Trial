package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Dto.DefectDto;
import com.example.DefectService.Dto.DefectStatusDto;
import com.example.DefectService.Entity.*;
import com.example.DefectService.Repository.*;
import com.example.DefectService.Service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectServiceImpl implements DefectService {
    @Autowired
    DefectRepo defectRepo;
    @Autowired
    ReleaseRepo releaseRepo;
    @Autowired
    ModuleRepo moduleRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    ModuleAllocationRepo moduleAllocationRepo;
    @Autowired
    ProjectTeamMemberRepo projectTeamMemberRepo;
    @Override
    public void saveDefect(DefectDto defectDto,int project_id,int release_id,int module_id) {
        Defect defect=new Defect();
        Project project=projectRepo.findById(project_id).orElse(null);
        Modules modules=moduleRepo.findById(module_id).orElse(null);
        Releases releases=releaseRepo.findById(release_id).orElse(null);
        ModuleAllocation moduleAllocation=moduleAllocationRepo.getAllocationDetails(module_id);
        ProjectTeamMembers projectTeamMembers=moduleAllocation.getProjectTeamMembers();
        defect.setDescription(defectDto.getDescription());
        defect.setStatus(defectDto.getStatus());
        defect.setPriority(defectDto.getPriority());
        defect.setSeverity(defectDto.getSeverity());
        defect.setAssigned_by(projectTeamMembers.getName());
        defect.setAssigned_to(modules.getDeveloper());
        defect.setRelated_module(modules.getModule_name());
        defect.setRelated_release(releases.getName());
        defect.setProject(project);
        defect.setModules(modules);
        defect.setReleases(releases);
        defectRepo.save(defect);
    }

    @Override
    public List<Defect> getAllDefect() {
        return defectRepo.findAll();
    }

    @Override
    public String filterDefectBySeverity(String severity) {
        return defectRepo.filterBySeverity(severity);
    }

    @Override
    public Defect editDefect(int id, DefectStatusDto defectStatusDto) {
        Defect defect=defectRepo.findById(id).orElse(new Defect());
        defect.setStatus(defectStatusDto.getStatus());
        return defectRepo.save(defect);
    }

    @Override
    public void deleteDefectById(int id) {
        defectRepo.deleteById(id);
    }
}
