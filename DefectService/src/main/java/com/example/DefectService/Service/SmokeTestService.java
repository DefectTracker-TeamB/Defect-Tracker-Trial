package com.example.DefectService.Service;

import com.example.DefectService.Dto.DefectStatusDto;
import com.example.DefectService.Dto.SmokeDto;

public interface SmokeTestService {
    void saveTest(int release_id, SmokeDto smokeDto);
    void editSmokeStatus(int test_id, DefectStatusDto defectStatusDto);

}
