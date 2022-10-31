package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Dto.DefectStatusDto;
import com.example.DefectService.Dto.SmokeDto;
import com.example.DefectService.Entity.Releases;
import com.example.DefectService.Entity.Smoke_Test;
import com.example.DefectService.Repository.ReleaseRepo;
import com.example.DefectService.Repository.SmokeTestRepo;
import com.example.DefectService.Service.SmokeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmokeTestServiceImpl implements SmokeTestService {
    @Autowired
    SmokeTestRepo smokeTestRepo;
    @Autowired
    ReleaseRepo releaseRepo;

    @Override
    public void saveTest(int release_id, SmokeDto smokeDto) {
        Releases releases=releaseRepo.findById(release_id).orElse(new Releases());
        Smoke_Test smoke_test=new Smoke_Test();
        smoke_test.setStatus("to be tested");
        smoke_test.setDescription(smokeDto.getDescription());
        smoke_test.setReleases(releases);
        smokeTestRepo.save(smoke_test);
    }

    @Override
    public void editSmokeStatus(int test_id, DefectStatusDto defectStatusDto) {
        Smoke_Test smoke_test=smokeTestRepo.findById(test_id).orElse(new Smoke_Test());
        Releases releases=smoke_test.getReleases();
        smoke_test.setStatus(defectStatusDto.getStatus());
        if(defectStatusDto.getStatus().contains("failed")){
            releases.setStatus("rejected");
        }else {
            releases.setStatus("New");
        }
        smokeTestRepo.save(smoke_test);
        releaseRepo.save(releases);
    }
}
