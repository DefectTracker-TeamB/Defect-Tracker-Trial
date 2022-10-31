package com.example.DefectService.Service;

import com.example.DefectService.Dto.ReleaseDto;
import com.example.DefectService.Entity.Releases;

public interface ReleaseServices {
    void saveRelease(int project_id, ReleaseDto releaseDto);
}
