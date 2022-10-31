package com.example.DefectService.Controller;

import com.example.DefectService.Dto.DefectDto;
import com.example.DefectService.Dto.DefectStatusDto;
import com.example.DefectService.Service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/defect")
public class DefectController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DefectService defectService;
    @PostMapping("/saveDefect/{project_id}/{release_id}/{module_id}")
    public ResponseEntity<Object> saveDefect(@RequestBody DefectDto defectDto,@PathVariable("project_id") int project_id
            ,@PathVariable("release_id") int release_id,@PathVariable("module_id") int module_id){
        defectService.saveDefect(defectDto,project_id,release_id,module_id);
        ArrayList<Object> defects=new ArrayList<>();
        defects.add(defectService.getAllDefect());
        defects.add("High severity : "+ defectService.filterDefectBySeverity("high"));
        defects.add("Medium severity : "+ defectService.filterDefectBySeverity("medium"));
        defects.add("Low severity : "+ defectService.filterDefectBySeverity("low"));
        return ResponseEntity.ok(defects);
    }
    @PostMapping("/defectStatus/{defect_id}")
    public ResponseEntity<Object>changeStatus(@PathVariable("defect_id")int defect_id, @RequestBody DefectStatusDto defectStatusDto){
        defectService.editDefect(defect_id,defectStatusDto);
        return ResponseEntity.ok("status edited");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object>deleteById(@PathVariable("id") int id){
        defectService.deleteDefectById(id);
        return ResponseEntity.ok("defect deleted");
    }


}
