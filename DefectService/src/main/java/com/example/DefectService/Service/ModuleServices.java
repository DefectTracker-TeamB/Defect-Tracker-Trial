package com.example.DefectService.Service;

import com.example.DefectService.Dto.ModuleDto;

public interface ModuleServices {
    void addModule(int project_id, int project_member_id, ModuleDto moduleDto);
    void deleteModule(int module_id);

    void setDeveloper(int module_id,int user_id);
}
