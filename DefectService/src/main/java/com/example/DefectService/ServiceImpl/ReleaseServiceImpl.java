package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Dto.ReleaseDto;
import com.example.DefectService.Dto.SmokeDto;
import com.example.DefectService.Entity.Project;
import com.example.DefectService.Entity.Releases;
import com.example.DefectService.Entity.Smoke_Test;
import com.example.DefectService.Exception.ResourceNotFoundException;
import com.example.DefectService.Repository.ProjectRepo;
import com.example.DefectService.Repository.ReleaseRepo;
import com.example.DefectService.Service.ReleaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReleaseServiceImpl implements ReleaseServices {
    @Autowired
    ReleaseRepo releaseRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Override
    public void saveRelease(int project_id, ReleaseDto releaseDto) {
        Project project=projectRepo.findById(project_id).orElse(new Project());
        Releases releases=new Releases();
        releases.setName(releaseDto.getName());
        releases.setStatus(releaseDto.getStatus());
        releases.setProject_name(project.getProject_name());
        releases.setProject(project);
        releaseRepo.save(releases);
    }
}
