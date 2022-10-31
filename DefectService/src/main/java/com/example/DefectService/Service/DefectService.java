package com.example.DefectService.Service;

import com.example.DefectService.Dto.DefectDto;
import com.example.DefectService.Entity.Defect;
import com.example.DefectService.Dto.DefectStatusDto;

import java.util.List;

public interface DefectService {
    void saveDefect(DefectDto defectDto,int project_id,int release_id,int module_id);
    List<Defect> getAllDefect();
    public String filterDefectBySeverity(String severity);
    Defect editDefect(int id, DefectStatusDto defectStatusDto);
    void deleteDefectById(int id);

}
